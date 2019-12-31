/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogicLayer;

import DataAccessObject.DiemCuoiNamDAO;
import DataTransferObject.DiemCuoiNamDTO;
import DataTransferObject.HocSinhDTO;
import DataTransferObject.MonHocDTO;
import DataTransferObject.NamHocDTO;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class DiemCuoiNamBUS {
    private static ArrayList<DiemCuoiNamDTO> dsdcn;
    
    public DiemCuoiNamBUS(){};

    public static ArrayList<DiemCuoiNamDTO> getDsdcn() {
        return dsdcn;
    }

    public static void setDsdcn(ArrayList<DiemCuoiNamDTO> dsdcn) {
        DiemCuoiNamBUS.dsdcn = dsdcn;
    }
    
    public void doc(ArrayList<HocSinhDTO> dshs,ArrayList<MonHocDTO> dsmh, ArrayList<NamHocDTO> dsnh) throws Exception{
        DiemCuoiNamDAO dataDiem = new DiemCuoiNamDAO();
        if(dsdcn == null)
            dsdcn = new ArrayList<DiemCuoiNamDTO>();
        dsdcn = dataDiem.doc(dshs, dsmh, dsnh);
    }
    
    public void them(DiemCuoiNamDTO diemCanThem) throws Exception{
        DiemCuoiNamDAO dataDiem = new DiemCuoiNamDAO();
        dsdcn.add(diemCanThem);
        dataDiem.them(diemCanThem);
    }
     
    public void sua(DiemCuoiNamDTO dcnCanSua, String mahs, String mamh,String manh) throws Exception{
        DiemCuoiNamDAO dataDiemCuoiNam = new DiemCuoiNamDAO();
        for(DiemCuoiNamDTO dcn : dsdcn)
            if((dcn.getHocSinh().getMahs().equals(mahs)) && (dcn.getMonHoc().getMamh().equals(mamh)) && (dcn.getNamHoc().getManh().equals(manh)))
            {
                dsdcn.remove(dcn);
                break;
            }
        dsdcn.add(dcnCanSua);
        dataDiemCuoiNam.sua(dcnCanSua);
    }
    
    public void xoa(DiemCuoiNamDTO dcnCanSua, String mahs, String mamh, String mahk, String manh) throws Exception{
        DiemCuoiNamDAO dataDiemCuoiNam = new DiemCuoiNamDAO();
        dataDiemCuoiNam.xoa(dcnCanSua);
        for(DiemCuoiNamDTO dcn : dsdcn)
            if((dcn.getHocSinh().getMahs().equals(mahs)) && (dcn.getMonHoc().getMamh().equals(mamh)) && (dcn.getNamHoc().getManh().equals(manh)))
                dsdcn.remove(dcn);
    }
    
    public ArrayList<DiemCuoiNamDTO> timKiemTheoNamHoc(String thongTin){
         ArrayList<DiemCuoiNamDTO> danhSachKqTimDuoc = new ArrayList<DiemCuoiNamDTO>();
         for(DiemCuoiNamDTO d : dsdcn)
             if(d.getNamHoc().getManh().equalsIgnoreCase(thongTin))
               danhSachKqTimDuoc.add(d);
        return danhSachKqTimDuoc;  
    }
    
    public ArrayList<DiemCuoiNamDTO> timKiemTheoMaHocSinh(String thongTin){
         ArrayList<DiemCuoiNamDTO> danhSachKqTimDuoc = new ArrayList<DiemCuoiNamDTO>();
         for(DiemCuoiNamDTO d : dsdcn)
             if(d.getHocSinh().getMahs().equalsIgnoreCase(thongTin))
               danhSachKqTimDuoc.add(d);
        return danhSachKqTimDuoc;  
    }
        public ArrayList<DiemCuoiNamDTO> timKiemTheoMonHoc(String thongTin){
         ArrayList<DiemCuoiNamDTO> danhSachKqTimDuoc = new ArrayList<DiemCuoiNamDTO>();
         for(DiemCuoiNamDTO d : dsdcn)
             if(d.getMonHoc().getMamh().equalsIgnoreCase(thongTin))
               danhSachKqTimDuoc.add(d);
        return danhSachKqTimDuoc;  
    }
    
}
