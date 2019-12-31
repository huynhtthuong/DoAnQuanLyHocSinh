/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogicLayer;


import DataAccessObject.GiaoVienDAO;
import DataTransferObject.GiaoVienDTO;
import DataTransferObject.MonHocDTO;
import java.util.ArrayList;

/**
 *
 * @author mr932
 */
public class GiaoVienBUS {
    private static ArrayList<GiaoVienDTO> dsgv;
    
    public GiaoVienBUS(){}
    
    public ArrayList<GiaoVienDTO> getDsgv() {
        return dsgv;
    }

    public void setDsgv(ArrayList<GiaoVienDTO> dshs) {
        this.dsgv = dshs;
    }
    
    public void docDSGV(ArrayList<MonHocDTO> dsmh) throws Exception{
       GiaoVienDAO dataGV = new GiaoVienDAO();
        if (dsgv == null)
            dsgv = new ArrayList<GiaoVienDTO>();
        dsgv = dataGV.docDSGV(dsmh);
    }
    
    public void them(GiaoVienDTO gvCanThem) throws Exception{
        if (timGiaoVienTheoMa(gvCanThem.getMagv()) == null){
            GiaoVienDAO dataGV = new GiaoVienDAO();
            dsgv.add(gvCanThem);
            dataGV.them(gvCanThem);
        }
    }
    
    public void sua(GiaoVienDTO gvCanSua) throws Exception{
       
        // TODO sua trong arraylist
        for (GiaoVienDTO gv : dsgv){
            if (gv.getMagv().equals(gvCanSua.getMagv())){
                
                GiaoVienDAO dataGV = new GiaoVienDAO();
                gv.setHo(gvCanSua.getHo());
                gv.setTen(gvCanSua.getTen());
                gv.setMonPhuTrach(gvCanSua.getMonPhuTrach());
                // Cap nhat lai trong database
                dataGV.sua(gvCanSua);
                break;
                
            }
        }
        
    }
    
    public void xoa(String maHsCanXoa) throws Exception{
        for (GiaoVienDTO gv : dsgv)
            if (gv.getMagv().equals(maHsCanXoa)){
                GiaoVienDAO dataGV = new GiaoVienDAO();
                dsgv.remove(gv);
                dataGV.xoa(maHsCanXoa);
                break;
            }
    }
    
    // Kiểm tra trùng
    public GiaoVienDTO timGiaoVienTheoMa(String maGv){
        for (GiaoVienDTO gv : dsgv){
            if (gv.getMagv().equals(maGv))
                return gv;
        }
        return null;
    }
    
    public ArrayList<GiaoVienDTO> timKiemTheoMa(String thongTin){
        ArrayList<GiaoVienDTO> danhSachKqTimDuoc = new ArrayList<GiaoVienDTO>();
        for (GiaoVienDTO gv : dsgv)
            if (gv.getMagv().equalsIgnoreCase(thongTin))
                danhSachKqTimDuoc.add(gv);
        return danhSachKqTimDuoc;
    }
    
    public ArrayList<GiaoVienDTO> timKiemTheoHo(String thongTin){
        ArrayList<GiaoVienDTO> danhSachKqTimDuoc = new ArrayList<GiaoVienDTO>();
        for (GiaoVienDTO gv : dsgv)
            if (gv.getHo().indexOf(thongTin) != -1)
                danhSachKqTimDuoc.add(gv);
        return danhSachKqTimDuoc;
    }
    
    public ArrayList<GiaoVienDTO> timKiemTheoTen(String thongTin){
        ArrayList<GiaoVienDTO> danhSachKqTimDuoc = new ArrayList<GiaoVienDTO>();
        for (GiaoVienDTO gv : dsgv)
            if (gv.getTen().indexOf(thongTin) != -1)
                danhSachKqTimDuoc.add(gv);
        return danhSachKqTimDuoc;
    }
    
    public ArrayList<GiaoVienDTO> timKiemTheoMon(String thongTin){
        ArrayList<GiaoVienDTO> danhSachKqTimDuoc = new ArrayList<GiaoVienDTO>();
        for (GiaoVienDTO gv : dsgv)
            if (gv.getMonPhuTrach().getMamh().equalsIgnoreCase(thongTin) || gv.getMonPhuTrach().getTenmh().equalsIgnoreCase(thongTin))
                danhSachKqTimDuoc.add(gv);
        return danhSachKqTimDuoc;
    }

    public ArrayList<GiaoVienDTO> timKiemTheoMa(String thongTin, ArrayList<GiaoVienDTO> dsgv){
        ArrayList<GiaoVienDTO> danhSachKqTimDuoc = new ArrayList<>();
        for (GiaoVienDTO gv : dsgv)
            if (gv.getMagv().equalsIgnoreCase(thongTin))
                danhSachKqTimDuoc.add(gv);
        return danhSachKqTimDuoc;
    }
    
    public ArrayList<GiaoVienDTO> timKiemTheoHo(String thongTin, ArrayList<GiaoVienDTO> dshs){
        ArrayList<GiaoVienDTO> danhSachKqTimDuoc = new ArrayList<>();
        for (GiaoVienDTO gv : dsgv)
            if (gv.getHo().indexOf(thongTin) != -1)
                danhSachKqTimDuoc.add(gv);
        return danhSachKqTimDuoc;
    }
    
    public ArrayList<GiaoVienDTO> timKiemTheoTen(String thongTin, ArrayList<GiaoVienDTO> dsgv){
        ArrayList<GiaoVienDTO> danhSachKqTimDuoc = new ArrayList<>();
        for (GiaoVienDTO gv : dsgv)
            if (gv.getTen().indexOf(thongTin) != -1)
                danhSachKqTimDuoc.add(gv);
        return danhSachKqTimDuoc;
    }
    
    public ArrayList<GiaoVienDTO> timKiemTheoMon(String thongTin, ArrayList<GiaoVienDTO> dsgv){
        ArrayList<GiaoVienDTO> danhSachKqTimDuoc = new ArrayList<>();
        for (GiaoVienDTO gv : dsgv)
            if (gv.getMonPhuTrach().getMamh().equalsIgnoreCase(thongTin))
                danhSachKqTimDuoc.add(gv);
        return danhSachKqTimDuoc;
    }
    
    public ArrayList<String> toStringList(ArrayList<GiaoVienDTO> dsgv){
        ArrayList<String> dsMaGv = new ArrayList<String>();
        for (GiaoVienDTO gv : dsgv)
            dsMaGv.add(gv.getMagv());
        return dsMaGv;
    }
    
}
