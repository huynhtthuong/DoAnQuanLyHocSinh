/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogicLayer;

import DataAccessObject.DiemDAO;
import DataAccessObject.DiemHocKiDAO;
import DataTransferObject.DiemHocKiDTO;
import DataTransferObject.DiemHocKiDTO;
import DataTransferObject.HocKyDTO;
import DataTransferObject.HocSinhDTO;
import DataTransferObject.LoaiDiemDTO;
import DataTransferObject.MonHocDTO;
import DataTransferObject.NamHocDTO;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class DiemHocKiBUS {
    private static ArrayList<DiemHocKiDTO> dsdhk;
    
    public DiemHocKiBUS(){}

    public ArrayList<DiemHocKiDTO> getDsdhk() {
        return dsdhk;
    }

    public void setDsdhk(ArrayList<DiemHocKiDTO> dsdhk1) {
        DiemHocKiBUS.dsdhk = dsdhk;
    }

    
    public void docDSDHK(ArrayList<HocSinhDTO> dshs, ArrayList<MonHocDTO> dsmh, ArrayList<HocKyDTO> dshk, ArrayList<NamHocDTO> dsnh) throws Exception{
        DiemHocKiDAO dataDiem = new DiemHocKiDAO();
        if(dsdhk == null)
            dsdhk = new ArrayList<DiemHocKiDTO>();
        dsdhk = dataDiem.doc(dshs, dsmh, dshk, dsnh);
    }
    
    public void them(DiemHocKiDTO diemCanThem) throws Exception{
        DiemHocKiDAO dataDiem = new DiemHocKiDAO();
        dsdhk.add(diemCanThem);
        dataDiem.them(diemCanThem);
    }
     
    public void sua(DiemHocKiDTO dhkCanSua) throws Exception{
        DiemHocKiDTO trung = kiemTraTrung(dhkCanSua);
        if (trung != null){
            DiemHocKiDAO dataDiemHocKi = new DiemHocKiDAO();
            trung.setTbMonhk(dhkCanSua.getTbMonhk());
            dataDiemHocKi.sua(trung);
        }
    }
    
    public void xoa(DiemHocKiDTO dhkCanXoa) throws Exception{
        DiemHocKiDTO trung = kiemTraTrung(dhkCanXoa);
        if (trung != null){
            DiemHocKiDAO dataDiemHocKi = new DiemHocKiDAO();
            dataDiemHocKi.xoa(dhkCanXoa);
            dsdhk.remove(trung);
        }
    }
    
    public DiemHocKiDTO kiemTraTrung(DiemHocKiDTO diemHkCanKiemTra){
        for (DiemHocKiDTO diemhk : dsdhk){
            if (diemhk.getHocSinh().getMahs().equals(diemHkCanKiemTra.getHocSinh().getMahs()) 
                    && diemhk.getHocKy().getMahk().equals(diemHkCanKiemTra.getHocKy().getMahk())
                    && diemhk.getNamHoc().getManh().equals(diemHkCanKiemTra.getNamHoc().getManh()) 
                    && diemhk.getMonHoc().getMamh().equals(diemHkCanKiemTra.getMonHoc().getMamh()))
                return diemhk;
        }
        return null;
    }
    public ArrayList<DiemHocKiDTO> timKiemTheoMaHocSinh(String thongTin){
        ArrayList<DiemHocKiDTO> danhSachKqTimDuoc = new ArrayList<DiemHocKiDTO>();
        for(DiemHocKiDTO d : dsdhk)
            if(d.getHocSinh().getMahs().equalsIgnoreCase(thongTin))
                danhSachKqTimDuoc.add(d);
        return danhSachKqTimDuoc;
    }
    
    public ArrayList<DiemHocKiDTO> timKiemTheoMaHocSinh(String thongTin, ArrayList<DiemHocKiDTO> dsdhk){
        ArrayList<DiemHocKiDTO> danhSachKqTimDuoc = new ArrayList<DiemHocKiDTO>();
        for(DiemHocKiDTO d : dsdhk)
            if(d.getHocSinh().getMahs().equalsIgnoreCase(thongTin))
                danhSachKqTimDuoc.add(d);
        return danhSachKqTimDuoc;
    }
    
    public ArrayList<DiemHocKiDTO> timKiemTheoHoHocSinh(String thongTin){
        ArrayList<DiemHocKiDTO> danhSachKqTimDuoc = new ArrayList<DiemHocKiDTO>();
        for(DiemHocKiDTO d : dsdhk)
            if(d.getHocSinh().getHo().indexOf(thongTin) != -1)
                danhSachKqTimDuoc.add(d);
        return danhSachKqTimDuoc;
    }
    
    public ArrayList<DiemHocKiDTO> timKiemTheoHoHocSinh(String thongTin, ArrayList<DiemHocKiDTO> dsdhk){
        ArrayList<DiemHocKiDTO> danhSachKqTimDuoc = new ArrayList<DiemHocKiDTO>();
        for(DiemHocKiDTO d : dsdhk)
            if(d.getHocSinh().getHo().indexOf(thongTin) != -1)
                danhSachKqTimDuoc.add(d);
        return danhSachKqTimDuoc;
    }
    
    public ArrayList<DiemHocKiDTO> timKiemTheoTenHocSinh(String thongTin){
        ArrayList<DiemHocKiDTO> danhSachKqTimDuoc = new ArrayList<DiemHocKiDTO>();
        for(DiemHocKiDTO d : dsdhk)
            if(d.getHocSinh().getTen().indexOf(thongTin) != -1)
                danhSachKqTimDuoc.add(d);
        return danhSachKqTimDuoc;
    }
    
    public ArrayList<DiemHocKiDTO> timKiemTheoTenHocSinh(String thongTin, ArrayList<DiemHocKiDTO> dsdhk){
        ArrayList<DiemHocKiDTO> danhSachKqTimDuoc = new ArrayList<DiemHocKiDTO>();
        for(DiemHocKiDTO d : dsdhk)
            if(d.getHocSinh().getTen().indexOf(thongTin) != -1)
                danhSachKqTimDuoc.add(d);
        return danhSachKqTimDuoc;
    }
    
    public ArrayList<DiemHocKiDTO> timKiemTheoMonHoc(String thongTin){
         ArrayList<DiemHocKiDTO> danhSachKqTimDuoc = new ArrayList<DiemHocKiDTO>();
         for(DiemHocKiDTO d : dsdhk)
             if(d.getMonHoc().getMamh().equalsIgnoreCase(thongTin) || d.getMonHoc().getTenmh().equalsIgnoreCase(thongTin))
               danhSachKqTimDuoc.add(d);
        return danhSachKqTimDuoc;  
    }
    
    public ArrayList<DiemHocKiDTO> timKiemTheoMonHoc(String thongTin, ArrayList<DiemHocKiDTO> dsdhk){
         ArrayList<DiemHocKiDTO> danhSachKqTimDuoc = new ArrayList<DiemHocKiDTO>();
         for(DiemHocKiDTO d : dsdhk)
             if(d.getMonHoc().getMamh().equalsIgnoreCase(thongTin) || d.getMonHoc().getTenmh().equalsIgnoreCase(thongTin))
               danhSachKqTimDuoc.add(d);
        return danhSachKqTimDuoc;  
    }
    
    public ArrayList<DiemHocKiDTO> timKiemTheoHocKy(String thongTin){
         ArrayList<DiemHocKiDTO> danhSachKqTimDuoc = new ArrayList<DiemHocKiDTO>();
         for(DiemHocKiDTO d : dsdhk)
             if(d.getHocKy().getMahk().equalsIgnoreCase(thongTin) || d.getHocKy().getTenhk().equalsIgnoreCase(thongTin))
               danhSachKqTimDuoc.add(d);
        return danhSachKqTimDuoc;  
    }
    
    public ArrayList<DiemHocKiDTO> timKiemTheoHocKy(String thongTin, ArrayList<DiemHocKiDTO> dsdhk){
         ArrayList<DiemHocKiDTO> danhSachKqTimDuoc = new ArrayList<DiemHocKiDTO>();
         for(DiemHocKiDTO d : dsdhk)
             if(d.getHocKy().getMahk().equalsIgnoreCase(thongTin) || d.getHocKy().getTenhk().equalsIgnoreCase(thongTin))
               danhSachKqTimDuoc.add(d);
        return danhSachKqTimDuoc;  
    }
    
    public ArrayList<DiemHocKiDTO> timKiemTheoNamHoc(String thongTin){
         ArrayList<DiemHocKiDTO> danhSachKqTimDuoc = new ArrayList<DiemHocKiDTO>();
         for(DiemHocKiDTO d : dsdhk)
             if(d.getNamHoc().getManh().equalsIgnoreCase(thongTin) || d.getNamHoc().getTennh().equalsIgnoreCase(thongTin))
               danhSachKqTimDuoc.add(d);
        return danhSachKqTimDuoc;  
    }
    
    public ArrayList<DiemHocKiDTO> timKiemTheoNamHoc(String thongTin, ArrayList<DiemHocKiDTO> dsdhk){
         ArrayList<DiemHocKiDTO> danhSachKqTimDuoc = new ArrayList<DiemHocKiDTO>();
         for(DiemHocKiDTO d : dsdhk)
             if(d.getNamHoc().getManh().equalsIgnoreCase(thongTin) || d.getNamHoc().getTennh().equalsIgnoreCase(thongTin))
               danhSachKqTimDuoc.add(d);
        return danhSachKqTimDuoc;  
    }
    
    public ArrayList<DiemHocKiDTO> timKiemDiemNhoHon(float diemSo){
         ArrayList<DiemHocKiDTO> danhSachKqTimDuoc = new ArrayList<DiemHocKiDTO>();
         for(DiemHocKiDTO d : dsdhk)
             if(d.getTbMonhk() < diemSo)
               danhSachKqTimDuoc.add(d);
        return danhSachKqTimDuoc;  
    }
    
    public ArrayList<DiemHocKiDTO> timKiemDiemNhoHon(float diemSo, ArrayList<DiemHocKiDTO> dsdhk){
         ArrayList<DiemHocKiDTO> danhSachKqTimDuoc = new ArrayList<DiemHocKiDTO>();
         for(DiemHocKiDTO d : dsdhk)
             if(d.getTbMonhk() < diemSo)
               danhSachKqTimDuoc.add(d);
        return danhSachKqTimDuoc;  
    }
    
    public ArrayList<DiemHocKiDTO> timKiemDiemLonHon(float diemSo){
         ArrayList<DiemHocKiDTO> danhSachKqTimDuoc = new ArrayList<DiemHocKiDTO>();
         for(DiemHocKiDTO d : dsdhk)
             if(d.getTbMonhk() > diemSo)
               danhSachKqTimDuoc.add(d);
        return danhSachKqTimDuoc;  
    }
    
    public ArrayList<DiemHocKiDTO> timKiemDiemLonHon(float diemSo, ArrayList<DiemHocKiDTO> dsdhk){
         ArrayList<DiemHocKiDTO> danhSachKqTimDuoc = new ArrayList<DiemHocKiDTO>();
         for(DiemHocKiDTO d : dsdhk)
             if(d.getTbMonhk() > diemSo)
               danhSachKqTimDuoc.add(d);
        return danhSachKqTimDuoc;  
    }
    
    public ArrayList<DiemHocKiDTO> timKiemDiemBang(float diemSo){
         ArrayList<DiemHocKiDTO> danhSachKqTimDuoc = new ArrayList<DiemHocKiDTO>();
         for(DiemHocKiDTO d : dsdhk)
             if(d.getTbMonhk() == diemSo)
               danhSachKqTimDuoc.add(d);
        return danhSachKqTimDuoc;  
    }
    
    public ArrayList<DiemHocKiDTO> timKiemDiemBang(float diemSo, ArrayList<DiemHocKiDTO> dsdhk){
         ArrayList<DiemHocKiDTO> danhSachKqTimDuoc = new ArrayList<DiemHocKiDTO>();
         for(DiemHocKiDTO d : dsdhk)
             if(d.getTbMonhk() == diemSo)
               danhSachKqTimDuoc.add(d);
        return danhSachKqTimDuoc;  
    }
    
    public ArrayList<DiemHocKiDTO> timKiemDsDiemMotHocSinh(HocSinhDTO hs, HocKyDTO hk, NamHocDTO nh){
         ArrayList<DiemHocKiDTO> danhSachKqTimDuoc = new ArrayList<DiemHocKiDTO>();
         for(DiemHocKiDTO d : dsdhk)
             if(d.getHocSinh().equals(hs) && d.getHocKy().equals(hk) && d.getNamHoc().equals(nh))
               danhSachKqTimDuoc.add(d);
        return danhSachKqTimDuoc;  
    }
    
    public float timDtbMonCuaHs(HocSinhDTO hs, MonHocDTO mh, HocKyDTO hk, NamHocDTO nh){
        for (DiemHocKiDTO diemHk :dsdhk){
            if (diemHk.getHocSinh().equals(hs) 
                    && diemHk.getMonHoc().equals(mh) 
                    && diemHk.getHocKy().equals(hk) 
                    && diemHk.getNamHoc().equals(nh))
            return diemHk.getTbMonhk();
        }
        return 0;
    }
    
    public float tinhDtbMonHkHs(String mahs, String mon, String hk, String nh) throws Exception{
        DiemBUS diemBus = new DiemBUS();
        DiemHocKiDAO dhkDao = new DiemHocKiDAO();
        for (DiemHocKiDTO d : dsdhk){
            if (d.getHocSinh().getMahs().equals(mahs) 
                    && (d.getMonHoc().getMamh().equals(mon) || d.getMonHoc().getTenmh().equals(mon)) 
                    && (d.getHocKy().getMahk().equals(hk) || d.getHocKy().getTenhk().equals(hk)) 
                    && (d.getNamHoc().getManh().equals(nh) || d.getNamHoc().getTennh().equals(nh))){
                float diemTbcMonHoc = diemBus.tinhDtbMonCuaHs(d.getHocSinh(), d.getMonHoc(), d.getHocKy(), d.getNamHoc());
                d.setTbMonhk(diemTbcMonHoc);
                dhkDao.sua(d);
                return diemTbcMonHoc;
            }
        }
        return 0;
    }
    
    public void tinhTbcMonHkToanDs() throws Exception
    {
        DiemBUS diemBus = new DiemBUS();
        DiemHocKiDAO dhkDao = new DiemHocKiDAO();
        for (DiemHocKiDTO d : dsdhk){
            //if (d.getTbMonhk() == 0){
                float diemTbcMonHoc = diemBus.tinhDtbMonCuaHs(d.getHocSinh(), d.getMonHoc(), d.getHocKy(), d.getNamHoc());
                diemTbcMonHoc = (float) Math.round(diemTbcMonHoc * 100)/100;
                d.setTbMonhk(diemTbcMonHoc);
                dhkDao.sua(d);
            //}
        }
    }
    
    public float tinhDiemTbHk(HocSinhDTO hs, HocKyDTO hk, NamHocDTO nh){
        float tongTbMon = 0;
        float tongHeSoMon = 0;
        for (DiemHocKiDTO diem : dsdhk){
            if (diem.getHocSinh().equals(hs) && diem.getHocKy().equals(hk) && diem.getNamHoc().equals(nh)){
                tongTbMon += diem.getTbMonhk() * diem.getMonHoc().getHeso();
                tongHeSoMon += diem.getMonHoc().getHeso();
            }
        }
        return tongTbMon / tongHeSoMon;
    }
}
