/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogicLayer;

import DataTransferObject.LoaiDiemDTO;
import DataAccessObject.LoaiDiemDAO;
import java.util.ArrayList;

public class LoaiDiemBUS {
    // properties
    private static ArrayList<LoaiDiemDTO> dsld;
    
    //Constructors
    public LoaiDiemBUS(){}
    
    //get methods
    public ArrayList<LoaiDiemDTO> getDsld(){
        return dsld;
    }
    
    public ArrayList<String> toStringList(ArrayList<LoaiDiemDTO> danhSachObject){
        ArrayList<String> dsMa = new ArrayList<String>();
        for (LoaiDiemDTO object : danhSachObject)
            dsMa.add(object.getMaLoaiDiem());
        return dsMa;
    }
    
    // methods need to connect DB
    public void docDSLD() throws Exception{
        LoaiDiemDAO dataLD = new LoaiDiemDAO();
        if(dsld == null)
            dsld = new ArrayList<LoaiDiemDTO>();
        dsld = dataLD.docDSLD();
    }
    
    public void them(LoaiDiemDTO ldCanThem) throws Exception{
        LoaiDiemDAO dataLD = new LoaiDiemDAO();
        dataLD.them(ldCanThem);
        dsld.add(ldCanThem);
    }
    
    public void sua(LoaiDiemDTO ldCanSua, LoaiDiemDTO ldCu) throws Exception{
        LoaiDiemDAO dataLD = new LoaiDiemDAO();
        dsld.remove(ldCu);
        dsld.add(ldCanSua);
        
        dataLD.sua(ldCanSua);
    }
    
    public void xoa(String maLdCanXoa) throws Exception{
        LoaiDiemDAO dataLD = new LoaiDiemDAO();
        dataLD.xoa(maLdCanXoa);
        for(LoaiDiemDTO ld : dsld)
            if(ld.getMaLoaiDiem().equals(maLdCanXoa)){
                dsld.remove(ld);
                break;
            }
    }
    
    // Kiem tra trung
    public LoaiDiemDTO timKiemMaHoacTenLoaiDiem(String thongTin){
        for (LoaiDiemDTO ld : dsld){
            if (ld.getMaLoaiDiem().equals(thongTin) || ld.getTenLoaiDiem().equals(thongTin)){
                return ld;
            }
        }
        return null;
    }
    
    public ArrayList<LoaiDiemDTO> timKiemTheoMa(String thongTin){
        ArrayList<LoaiDiemDTO> danhSachKqTimDuoc = new ArrayList<LoaiDiemDTO>();
        for(LoaiDiemDTO ld : dsld)
            if(ld.getMaLoaiDiem().equalsIgnoreCase(thongTin))
                danhSachKqTimDuoc.add(ld);
        return danhSachKqTimDuoc;
    }
    
    public ArrayList<LoaiDiemDTO> timKiemTheoTen(String thongTin){
        ArrayList<LoaiDiemDTO> danhSachKqTimDuoc = new ArrayList<LoaiDiemDTO>();
        for(LoaiDiemDTO ld : dsld)
            if(ld.getTenLoaiDiem().equals(thongTin))
                danhSachKqTimDuoc.add(ld);
        return danhSachKqTimDuoc;
    }
    
    public ArrayList<LoaiDiemDTO> timKiemTheoHeSo(float thongtin){
        ArrayList<LoaiDiemDTO> danhSachKqTimDuoc = new ArrayList<LoaiDiemDTO>();
        for(LoaiDiemDTO ld : dsld)
            if(ld.getHeSo() == thongtin)
                danhSachKqTimDuoc.add(ld);
        return danhSachKqTimDuoc;
    }
    
    public Boolean kiemTraTrungMa(String maCanKiemTra){
        for (LoaiDiemDTO ld : dsld){
            if (ld.getMaLoaiDiem().equalsIgnoreCase(maCanKiemTra))
                return true;
        }
        return false;
    }
}
