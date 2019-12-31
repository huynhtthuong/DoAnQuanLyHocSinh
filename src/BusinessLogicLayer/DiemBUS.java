/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogicLayer;

import DataAccessObject.DiemDAO;
import DataTransferObject.HocSinhDTO;
import DataTransferObject.MonHocDTO;
import DataTransferObject.HocKyDTO;
import DataTransferObject.NamHocDTO;
import DataTransferObject.LoaiDiemDTO;
import DataTransferObject.DiemDTO;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
public class DiemBUS {
    private static ArrayList<DiemDTO> dsd;
    
    public DiemBUS(){}
    
    public ArrayList<DiemDTO> getDsd() {
        return dsd;
    }
    
    public void setDsd(ArrayList<DiemDTO> dsd){
        this.dsd = dsd;
    }
    
    public void docDSD(ArrayList<HocSinhDTO> dshs, ArrayList<MonHocDTO> dsmh, ArrayList<HocKyDTO> dshk, ArrayList<NamHocDTO> dsnh, ArrayList<LoaiDiemDTO> dsld ) throws Exception{
        DiemDAO dataDiem = new DiemDAO();
        if(dsd == null)
            dsd = new ArrayList<DiemDTO>();
        dsd = dataDiem.docDSD(dshs, dsmh, dshk, dsnh, dsld);
    }
    
    public void them(DiemDTO diemCanThem) throws Exception{
        if (timKiemDiem(diemCanThem) == null){
            DiemDAO dataDiem = new DiemDAO();
            dsd.add(diemCanThem);
            dataDiem.them(diemCanThem);
        }
    }
    
    public void sua(DiemDTO diemCanSua) throws Exception{
        DiemDTO diemTimThay = timKiemDiem(diemCanSua);
        if (diemTimThay != null){
            DiemDAO dataDiem = new DiemDAO();
            diemTimThay.setDiemSo(diemCanSua.getDiemSo());
            dataDiem.sua(diemCanSua);
        } 
    }
    
    public void xoa(DiemDTO diemCanXoa) throws Exception{
        DiemDTO diemTimThay = timKiemDiem(diemCanXoa);
        if (diemTimThay != null){
            DiemDAO dataDiem = new DiemDAO();
            dataDiem.xoa(diemTimThay);
            dsd.remove(diemTimThay);
        }
    }
    
    // Kiem tra trung
    public DiemDTO timKiemDiem(DiemDTO diemCanKiemTra){
        for (DiemDTO d : dsd){
            if (d.getHocSinh().getMahs().equals(diemCanKiemTra.getHocSinh().getMahs()) 
                    && d.getHocKy().getMahk().equals(diemCanKiemTra.getHocKy().getMahk()) 
                    && d.getNamHoc().getManh().equals(diemCanKiemTra.getNamHoc().getManh()) 
                    && d.getMonHoc().getMamh().equals(diemCanKiemTra.getMonHoc().getMamh())
                    && d.getLoaiDiem().getMaLoaiDiem().equals(diemCanKiemTra.getLoaiDiem().getMaLoaiDiem()))
                return d;
        }
        return null;
    }
    
    // Tim kiem object DTO (Kiem tra trung)
    public DiemDTO timKiemDiem(String maHs, String hk, String nh, String mh, String ld){
        for (DiemDTO d : dsd){
            if (d.getHocSinh().getMahs().equals(maHs) 
                    && (d.getHocKy().getMahk().equals(hk) || d.getHocKy().getTenhk().equals(hk)) 
                    && (d.getNamHoc().getManh().equals(nh) || d.getNamHoc().getTennh().equals(nh)) 
                    && (d.getMonHoc().getMamh().equals(mh) || d.getMonHoc().getTenmh().equals(mh))
                    && (d.getLoaiDiem().getMaLoaiDiem().equals(ld) || d.getLoaiDiem().getTenLoaiDiem().equals(ld)))
                return d;
        }
        return null;
    }
    
    public ArrayList<DiemDTO> timKiemTheoMaHocSinh(String thongTin){
        ArrayList<DiemDTO> danhSachKqTimDuoc = new ArrayList<DiemDTO>();
        for(DiemDTO d : dsd)
            if(d.getHocSinh().getMahs().equalsIgnoreCase(thongTin))
                danhSachKqTimDuoc.add(d);
        return danhSachKqTimDuoc;
    }
    
    public ArrayList<DiemDTO> timKiemTheoMaHocSinh(String thongTin, ArrayList<DiemDTO> dsd){
        ArrayList<DiemDTO> danhSachKqTimDuoc = new ArrayList<DiemDTO>();
        for(DiemDTO d : dsd)
            if(d.getHocSinh().getMahs().equalsIgnoreCase(thongTin))
                danhSachKqTimDuoc.add(d);
        return danhSachKqTimDuoc;
    }
    
    public ArrayList<DiemDTO> timKiemTheoHoHocSinh(String thongTin){
        ArrayList<DiemDTO> danhSachKqTimDuoc = new ArrayList<DiemDTO>();
        for(DiemDTO d : dsd)
            if(d.getHocSinh().getHo().indexOf(thongTin) != -1)
                danhSachKqTimDuoc.add(d);
        return danhSachKqTimDuoc;
    }
    
    public ArrayList<DiemDTO> timKiemTheoHoHocSinh(String thongTin, ArrayList<DiemDTO> dsd){
        ArrayList<DiemDTO> danhSachKqTimDuoc = new ArrayList<DiemDTO>();
        for(DiemDTO d : dsd)
            if(d.getHocSinh().getHo().indexOf(thongTin) != -1)
                danhSachKqTimDuoc.add(d);
        return danhSachKqTimDuoc;
    }
    
    public ArrayList<DiemDTO> timKiemTheoTenHocSinh(String thongTin){
        ArrayList<DiemDTO> danhSachKqTimDuoc = new ArrayList<DiemDTO>();
        for(DiemDTO d : dsd)
            if(d.getHocSinh().getTen().indexOf(thongTin) != -1)
                danhSachKqTimDuoc.add(d);
        return danhSachKqTimDuoc;
    }
    
    public ArrayList<DiemDTO> timKiemTheoTenHocSinh(String thongTin, ArrayList<DiemDTO> dsd){
        ArrayList<DiemDTO> danhSachKqTimDuoc = new ArrayList<DiemDTO>();
        for(DiemDTO d : dsd)
            if(d.getHocSinh().getTen().indexOf(thongTin) != -1)
                danhSachKqTimDuoc.add(d);
        return danhSachKqTimDuoc;
    }
    
    public ArrayList<DiemDTO> timKiemTheoLoaiDiem(String thongTin){
        ArrayList<DiemDTO> danhSachKqTimDuoc = new ArrayList<DiemDTO>();
        for(DiemDTO d : dsd)
            if(d.getLoaiDiem().getMaLoaiDiem().equalsIgnoreCase(thongTin) || d.getLoaiDiem().getTenLoaiDiem().equalsIgnoreCase(thongTin))
                danhSachKqTimDuoc.add(d);
        return danhSachKqTimDuoc;
    }
    
    public ArrayList<DiemDTO> timKiemTheoLoaiDiem(String thongTin, ArrayList<DiemDTO> dsd){
        ArrayList<DiemDTO> danhSachKqTimDuoc = new ArrayList<DiemDTO>();
        for(DiemDTO d : dsd)
            if(d.getLoaiDiem().getMaLoaiDiem().equalsIgnoreCase(thongTin) || d.getLoaiDiem().getTenLoaiDiem().equalsIgnoreCase(thongTin))
                danhSachKqTimDuoc.add(d);
        return danhSachKqTimDuoc;
    }
    
    public ArrayList<DiemDTO> timKiemTheoMonHoc(String thongTin){
         ArrayList<DiemDTO> danhSachKqTimDuoc = new ArrayList<DiemDTO>();
         for(DiemDTO d : dsd)
             if(d.getMonHoc().getMamh().equalsIgnoreCase(thongTin) || d.getMonHoc().getTenmh().equalsIgnoreCase(thongTin))
               danhSachKqTimDuoc.add(d);
        return danhSachKqTimDuoc;  
    }
    
    public ArrayList<DiemDTO> timKiemTheoMonHoc(String thongTin, ArrayList<DiemDTO> dsd){
         ArrayList<DiemDTO> danhSachKqTimDuoc = new ArrayList<DiemDTO>();
         for(DiemDTO d : dsd)
             if(d.getMonHoc().getMamh().equalsIgnoreCase(thongTin) || d.getMonHoc().getTenmh().equalsIgnoreCase(thongTin))
               danhSachKqTimDuoc.add(d);
        return danhSachKqTimDuoc;  
    }
    
    public ArrayList<DiemDTO> timKiemTheoHocKy(String thongTin){
         ArrayList<DiemDTO> danhSachKqTimDuoc = new ArrayList<DiemDTO>();
         for(DiemDTO d : dsd)
             if(d.getHocKy().getMahk().equalsIgnoreCase(thongTin) || d.getHocKy().getTenhk().equalsIgnoreCase(thongTin))
               danhSachKqTimDuoc.add(d);
        return danhSachKqTimDuoc;  
    }
    
    public ArrayList<DiemDTO> timKiemTheoHocKy(String thongTin, ArrayList<DiemDTO> dsd){
         ArrayList<DiemDTO> danhSachKqTimDuoc = new ArrayList<DiemDTO>();
         for(DiemDTO d : dsd)
             if(d.getHocKy().getMahk().equalsIgnoreCase(thongTin) || d.getHocKy().getTenhk().equalsIgnoreCase(thongTin))
               danhSachKqTimDuoc.add(d);
        return danhSachKqTimDuoc;  
    }
    
    public ArrayList<DiemDTO> timKiemTheoNamHoc(String thongTin){
         ArrayList<DiemDTO> danhSachKqTimDuoc = new ArrayList<DiemDTO>();
         for(DiemDTO d : dsd)
             if(d.getNamHoc().getManh().equalsIgnoreCase(thongTin) || d.getNamHoc().getTennh().equalsIgnoreCase(thongTin))
               danhSachKqTimDuoc.add(d);
        return danhSachKqTimDuoc;  
    }
    
    public ArrayList<DiemDTO> timKiemTheoNamHoc(String thongTin, ArrayList<DiemDTO> dsd){
         ArrayList<DiemDTO> danhSachKqTimDuoc = new ArrayList<DiemDTO>();
         for(DiemDTO d : dsd)
             if(d.getNamHoc().getManh().equalsIgnoreCase(thongTin) || d.getNamHoc().getTennh().equalsIgnoreCase(thongTin))
               danhSachKqTimDuoc.add(d);
        return danhSachKqTimDuoc;  
    }
    
    public ArrayList<DiemDTO> timKiemDiemNhoHon(float diemSo){
         ArrayList<DiemDTO> danhSachKqTimDuoc = new ArrayList<DiemDTO>();
         for(DiemDTO d : dsd)
             if(d.getDiemSo() < diemSo)
               danhSachKqTimDuoc.add(d);
        return danhSachKqTimDuoc;  
    }
    
    public ArrayList<DiemDTO> timKiemDiemNhoHon(float diemSo, ArrayList<DiemDTO> dsd){
         ArrayList<DiemDTO> danhSachKqTimDuoc = new ArrayList<DiemDTO>();
         for(DiemDTO d : dsd)
             if(d.getDiemSo() < diemSo)
               danhSachKqTimDuoc.add(d);
        return danhSachKqTimDuoc;  
    }
    
    public ArrayList<DiemDTO> timKiemDiemLonHon(float diemSo){
         ArrayList<DiemDTO> danhSachKqTimDuoc = new ArrayList<DiemDTO>();
         for(DiemDTO d : dsd)
             if(d.getDiemSo() > diemSo)
               danhSachKqTimDuoc.add(d);
        return danhSachKqTimDuoc;  
    }
    
    public ArrayList<DiemDTO> timKiemDiemLonHon(float diemSo, ArrayList<DiemDTO> dsd){
         ArrayList<DiemDTO> danhSachKqTimDuoc = new ArrayList<DiemDTO>();
         for(DiemDTO d : dsd)
             if(d.getDiemSo() > diemSo)
               danhSachKqTimDuoc.add(d);
        return danhSachKqTimDuoc;  
    }
    
    public ArrayList<DiemDTO> timKiemDiemBang(float diemSo){
         ArrayList<DiemDTO> danhSachKqTimDuoc = new ArrayList<DiemDTO>();
         for(DiemDTO d : dsd)
             if(d.getDiemSo() == diemSo)
               danhSachKqTimDuoc.add(d);
        return danhSachKqTimDuoc;  
    }
    
    public ArrayList<DiemDTO> timKiemDiemBang(float diemSo, ArrayList<DiemDTO> dsd){
         ArrayList<DiemDTO> danhSachKqTimDuoc = new ArrayList<DiemDTO>();
         for(DiemDTO d : dsd)
             if(d.getDiemSo() == diemSo)
               danhSachKqTimDuoc.add(d);
        return danhSachKqTimDuoc;  
    }
    
    public ArrayList<DiemDTO> timKiemDsDiemMotHocSinh(HocSinhDTO hs, HocKyDTO hk, NamHocDTO nh){
         ArrayList<DiemDTO> danhSachKqTimDuoc = new ArrayList<DiemDTO>();
         for(DiemDTO d : dsd)
             if(d.getHocSinh().equals(hs) && d.getHocKy().equals(hk) && d.getNamHoc().equals(nh))
               danhSachKqTimDuoc.add(d);
        return danhSachKqTimDuoc;  
    }
    
    public ArrayList<DiemDTO> sapXep(){
        Collections.sort(dsd);
        return dsd;
    }
    
    public ArrayList<DiemDTO> sapXep(ArrayList<DiemDTO> dsd){
        Collections.sort(dsd);
        return dsd;
    }
    
    public float timDiemSo(HocSinhDTO hs, MonHocDTO mh, LoaiDiemDTO ld, HocKyDTO hk, NamHocDTO nh){
        for(DiemDTO diem : dsd){
            if (diem.getHocSinh().getMahs().equals(hs.getMahs())
                    && diem.getMonHoc().getMamh().equals(mh.getMamh())
                    && diem.getLoaiDiem().getMaLoaiDiem().equals(ld.getMaLoaiDiem())
                    && diem.getHocKy().getMahk().equals(hk.getMahk())
                    && diem.getNamHoc().getManh().equals(nh.getManh()))
                return diem.getDiemSo();
        }
        return 0;
    }
    
    // Dùng cho các BUS khác.
    public float tinhDtbMonCuaHs(HocSinhDTO hs, MonHocDTO mh, HocKyDTO hk, NamHocDTO nh){
        float tongCacCotDiem = 0;
        float tongHeSo = 0;
        for (DiemDTO d : dsd){
            if (d.getHocSinh().getMahs().equals(hs.getMahs()) 
                    && d.getMonHoc().getMamh().equals(mh.getMamh()) 
                    && d.getHocKy().getMahk().equals(hk.getMahk()) 
                    && d.getNamHoc().getManh().equals(nh.getManh())){
                tongCacCotDiem += d.getDiemSo() * d.getLoaiDiem().getHeSo();
                tongHeSo += d.getLoaiDiem().getHeSo();
            }
        }
        return tongCacCotDiem / tongHeSo;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public float abc(HocSinhDTO hs, MonHocDTO mh, HocKyDTO hk, NamHocDTO nh)
    {
        float tongDiem = 0;
        float tongHeSo= 0;
        
        for(DiemDTO d : dsd)
        {
            if(d.getHocSinh().getMahs().equals(hs.getMahs())
                    && d.getMonHoc().getMamh().equals(mh.getMamh())
                    && d.getHocKy().getMahk().equals(hk.getMahk())
                    && d.getNamHoc().getManh().equals(nh.getManh()))
            {
                tongDiem += d.getDiemSo()*d.getLoaiDiem().getHeSo();
                tongHeSo += d.getLoaiDiem().getHeSo();
            }
        }
        return (float)tongDiem/tongHeSo;
    }
    
    
    
    // Đặc biệt dùng trên GUI
    public float tinhDtbMonCuaHs(String mahs, String mh, String hk, String nh){
        float tongCacCotDiem = 0;
        float tongHeSo = 0;
        for (DiemDTO d : dsd){
            if (d.getHocSinh().getMahs().equals(mahs) 
                    && (d.getMonHoc().getMamh().equals(mh) || d.getMonHoc().getTenmh().equals(mh))
                    && (d.getHocKy().getMahk().equals(hk) || d.getHocKy().getTenhk().equals(hk)) 
                    && (d.getNamHoc().getManh().equals(nh) || d.getNamHoc().getTennh().equals(nh))){
                tongCacCotDiem += d.getDiemSo() * d.getLoaiDiem().getHeSo();
                tongHeSo += d.getLoaiDiem().getHeSo();
            }
        }
        return tongCacCotDiem / tongHeSo;
    }
    
    public void report() {
        DiemDAO dao=new DiemDAO();
        dao.report();
    }
}