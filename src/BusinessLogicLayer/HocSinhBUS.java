/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogicLayer;

import DataAccessObject.HocSinhDAO;
import DataTransferObject.HocSinhDTO;
import java.util.ArrayList;

/**
 *
 * @author mr932
 */
public class HocSinhBUS {
    // Thuộc tính
    private static ArrayList<HocSinhDTO> dshs;
    // Hàm khởi tạo
    public HocSinhBUS(){}
    
    // Phương thức get set
    public ArrayList<HocSinhDTO> getDshs() {
        return dshs;
    }

    //public void setDshs(ArrayList<HocSinhDTO> dshs) {
        //this.dshs = dshs;
    //}
    
    public ArrayList<String> toStringList(ArrayList<HocSinhDTO> danhSachObject){
        ArrayList<String> dsMa = new ArrayList<String>();
        for (HocSinhDTO object : danhSachObject)
            dsMa.add(object.getMahs());
        return dsMa;
    }
    
    // Những phương thức cần kết nối đến CSDL
    public void docDSHS() throws Exception{
        HocSinhDAO dataHS = new HocSinhDAO();
        if (dshs == null)
            dshs = new ArrayList<HocSinhDTO>();
        dshs = dataHS.docDSHS();
    }
    
    public void them(HocSinhDTO hsCanThem) throws Exception{
        HocSinhDAO dataHS = new HocSinhDAO();
        dshs.add(hsCanThem);
        dataHS.them(hsCanThem);
    }
    
    public void sua(HocSinhDTO hsCanSua) throws Exception{
        // Tao ket noi den csdl
        HocSinhDAO dataHS = new HocSinhDAO();
        // Cap nhat lai trong arraylist
        HocSinhDTO hsCu = timKiemHocSinh(hsCanSua.getMahs());
        if (hsCu != null) {
            hsCu.setHo(hsCanSua.getHo());
            hsCu.setTen(hsCanSua.getTen());
            hsCu.setPhai(hsCanSua.getPhai());
            hsCu.setNgaySinh(hsCanSua.getNgaySinh());
            hsCu.setDiaChi(hsCanSua.getDiaChi());
            hsCu.setQueQuan(hsCanSua.getQueQuan());
            hsCu.setHinhAnh(hsCanSua.getHinhAnh());
            // Cap nhat lai trong database
            dataHS.sua(hsCanSua);
        }   
    }
    
    public void xoa(String maHsCanXoa) throws Exception{
        HocSinhDAO dataHS = new HocSinhDAO();
        dataHS.xoa(maHsCanXoa);
        for (HocSinhDTO hs : dshs)
            if (hs.getMahs().equals(maHsCanXoa)){
                dshs.remove(hs);
                break;
            }
    }
    
    // Những phương thức không cần kết nối đến CSDL (truy cập trực tiếp trên Arraylist)
    public Boolean kiemTraTrungMa(String maCanKiemTra){
        for (HocSinhDTO hs : dshs){
            if (hs.getMahs().equalsIgnoreCase(maCanKiemTra))
                return true;
        }
        return false;
    }
    
    public HocSinhDTO timKiemHocSinh(String maHsCanTim){
        for (HocSinhDTO hs : dshs)
            if (hs.getMahs().equals(maHsCanTim))
                return hs;
        return null;
    }
    
    public ArrayList<HocSinhDTO> timKiemTheoMa(String thongTin){
        ArrayList<HocSinhDTO> danhSachKqTimDuoc = new ArrayList<>();
        for (HocSinhDTO hs : dshs)
            if (hs.getMahs().equalsIgnoreCase(thongTin))
                danhSachKqTimDuoc.add(hs);
        return danhSachKqTimDuoc;
    }
    
    public ArrayList<HocSinhDTO> timKiemTheoHo(String thongTin){
        ArrayList<HocSinhDTO> danhSachKqTimDuoc = new ArrayList<>();
        for (HocSinhDTO hs : dshs)
            if (hs.getHo().indexOf(thongTin) != -1)
                danhSachKqTimDuoc.add(hs);
        return danhSachKqTimDuoc;
    }
    
    public ArrayList<HocSinhDTO> timKiemTheoTen(String thongTin){
        ArrayList<HocSinhDTO> danhSachKqTimDuoc = new ArrayList<>();
        for (HocSinhDTO hs : dshs)
            if (hs.getTen().equalsIgnoreCase(thongTin))
                danhSachKqTimDuoc.add(hs);
        return danhSachKqTimDuoc;
    }
    
    public ArrayList<HocSinhDTO> timKiemTheoPhai(String thongTin){
        ArrayList<HocSinhDTO> danhSachKqTimDuoc = new ArrayList<>();
        for (HocSinhDTO hs : dshs)
            if (hs.getPhai().equalsIgnoreCase(thongTin))
                danhSachKqTimDuoc.add(hs);
        return danhSachKqTimDuoc;
    }
    
    public ArrayList<HocSinhDTO> timKiemTheoNgaySinh(String thongTin){
        ArrayList<HocSinhDTO> danhSachKqTimDuoc = new ArrayList<>();
        for (HocSinhDTO hs : dshs)
            if (hs.getNgaySinh().equalsIgnoreCase(thongTin))
                danhSachKqTimDuoc.add(hs);
        return danhSachKqTimDuoc;
    }
    
    public ArrayList<HocSinhDTO> timKiemTheoDiaChi(String thongTin){
        ArrayList<HocSinhDTO> danhSachKqTimDuoc = new ArrayList<>();
        for (HocSinhDTO hs : dshs)
            if (hs.getDiaChi().indexOf(thongTin) != -1)
                danhSachKqTimDuoc.add(hs);
        return danhSachKqTimDuoc;
    }
    
    public ArrayList<HocSinhDTO> timKiemTheoQueQuan(String thongTin){
        ArrayList<HocSinhDTO> danhSachKqTimDuoc = new ArrayList<>();
        for (HocSinhDTO hs : dshs)
            if (hs.getQueQuan().indexOf(thongTin) != -1)
                danhSachKqTimDuoc.add(hs);
        return danhSachKqTimDuoc;
    }
    
    public ArrayList<HocSinhDTO> timKiemTheoHoTen(String thongTin){
        ArrayList<HocSinhDTO> danhSachKqTimDuoc = new ArrayList<>();
        for (HocSinhDTO hs : dshs){
            String hoTenHs = hs.getHo() + " " + hs.getTen();
            if (hoTenHs.indexOf(thongTin) != -1)
                danhSachKqTimDuoc.add(hs);
        }
        return danhSachKqTimDuoc;
    }
    
    public ArrayList<HocSinhDTO> timKiemTheoMa(String thongTin, ArrayList<HocSinhDTO> dshs){
        ArrayList<HocSinhDTO> danhSachKqTimDuoc = new ArrayList<>();
        for (HocSinhDTO hs : dshs)
            if (hs.getMahs().equalsIgnoreCase(thongTin))
                danhSachKqTimDuoc.add(hs);
        return danhSachKqTimDuoc;
    }
    
    public ArrayList<HocSinhDTO> timKiemTheoHo(String thongTin, ArrayList<HocSinhDTO> dshs){
        ArrayList<HocSinhDTO> danhSachKqTimDuoc = new ArrayList<>();
        for (HocSinhDTO hs : dshs)
            if (hs.getHo().indexOf(thongTin) != -1)
                danhSachKqTimDuoc.add(hs);
        return danhSachKqTimDuoc;
    }
    
    public ArrayList<HocSinhDTO> timKiemTheoTen(String thongTin, ArrayList<HocSinhDTO> dshs){
        ArrayList<HocSinhDTO> danhSachKqTimDuoc = new ArrayList<>();
        for (HocSinhDTO hs : dshs)
            if (hs.getTen().indexOf(thongTin) != -1)
                danhSachKqTimDuoc.add(hs);
        return danhSachKqTimDuoc;
    }
    
    public ArrayList<HocSinhDTO> timKiemTheoPhai(String thongTin, ArrayList<HocSinhDTO> dshs){
        ArrayList<HocSinhDTO> danhSachKqTimDuoc = new ArrayList<>();
        for (HocSinhDTO hs : dshs)
            if (hs.getPhai().equalsIgnoreCase(thongTin))
                danhSachKqTimDuoc.add(hs);
        return danhSachKqTimDuoc;
    }
    
    public ArrayList<HocSinhDTO> timKiemTheoNgaySinh(String thongTin, ArrayList<HocSinhDTO> dshs){
        ArrayList<HocSinhDTO> danhSachKqTimDuoc = new ArrayList<>();
        for (HocSinhDTO hs : dshs)
            if (hs.getNgaySinh().equalsIgnoreCase(thongTin))
                danhSachKqTimDuoc.add(hs);
        return danhSachKqTimDuoc;
    }
    
    public ArrayList<HocSinhDTO> timKiemTheoDiaChi(String thongTin, ArrayList<HocSinhDTO> dshs){
        ArrayList<HocSinhDTO> danhSachKqTimDuoc = new ArrayList<>();
        for (HocSinhDTO hs : dshs)
            if (hs.getDiaChi().indexOf(thongTin) != -1)
                danhSachKqTimDuoc.add(hs);
        return danhSachKqTimDuoc;
    }
    
    public ArrayList<HocSinhDTO> timKiemTheoQueQuan(String thongTin, ArrayList<HocSinhDTO> dshs){
        ArrayList<HocSinhDTO> danhSachKqTimDuoc = new ArrayList<>();
        for (HocSinhDTO hs : dshs)
            if (hs.getQueQuan().indexOf(thongTin) != -1)
                danhSachKqTimDuoc.add(hs);
        return danhSachKqTimDuoc;
    }
    
    public ArrayList<HocSinhDTO> timKiemTheoHoTen(String thongTin, ArrayList<HocSinhDTO> dshs){
        ArrayList<HocSinhDTO> danhSachKqTimDuoc = new ArrayList<>();
        for (HocSinhDTO hs : dshs){
            String hoTenHs = hs.getHo() + " " + hs.getTen();
            if (hoTenHs.indexOf(thongTin) != -1)
                danhSachKqTimDuoc.add(hs);
        }
        return danhSachKqTimDuoc;
    }
    
    public ArrayList<HocSinhDTO> timDsHsChuaPhanLop (String namHoc){
        HS_LopBUS hslopBus = new HS_LopBUS();
        ArrayList<HocSinhDTO> dsHsChuaPhanLop = new ArrayList<>();
        for (HocSinhDTO hs : dshs){
            if (!hslopBus.hsNayCoDuocPhanLopChua(hs.getMahs(), namHoc)){
                dsHsChuaPhanLop.add(hs);
            }
        }
        return dsHsChuaPhanLop;
    }
}
