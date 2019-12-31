/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogicLayer;

import DataAccessObject.MonHocDAO;
import DataTransferObject.MonHocDTO;
import java.util.ArrayList;
public class MonHocBUS {
    private static ArrayList<MonHocDTO> dsmh;
    public MonHocBUS(){}
    
    public ArrayList<String> toStringList(ArrayList<MonHocDTO> danhSachObject){
        ArrayList<String> dsMa = new ArrayList<String>();
        for (MonHocDTO object : danhSachObject)
            dsMa.add(object.getMamh());
        return dsMa;
    }
    
    public void docDSMH() throws Exception{
        MonHocDAO data = new MonHocDAO();
        if(dsmh == null)
            dsmh = new ArrayList<MonHocDTO>();
        dsmh = data.docDSMH();
    }
    public void them(MonHocDTO mhCanThem) throws Exception{
        MonHocDAO dataMH = new MonHocDAO();
        dsmh.add(mhCanThem);
        dataMH.them(mhCanThem);
    }
            
    public void sua(MonHocDTO mhCanSua, MonHocDTO mhCu) throws Exception{
       MonHocDAO dataGV = new MonHocDAO();
        // TODO sua trong arraylist
        for (MonHocDTO mh : dsmh){
            if (mh.getMamh().equals(mhCu.getMamh())){
                dsmh.remove(mh);
                break;
            }
        }
        dsmh.add(mhCanSua);
        // Cap nhat lai trong database
        dataGV.sua(mhCanSua);
    }
    public void xoa(String mamhCanXoa) throws Exception{
        MonHocDAO dataMH = new MonHocDAO();
        dataMH.xoa(mamhCanXoa);
        for(MonHocDTO mh : dsmh){
            if(mh.getMamh().equals(mamhCanXoa))
                dsmh.remove(mh);
        }
    }
    
    // Kiem tra trung
    public MonHocDTO timKiemMonHoc(String thongTin){
        for (MonHocDTO mh : dsmh)
            if (mh.getTenmh().equals(thongTin) || mh.getMamh().equals(thongTin))
                return mh;
        return null;
    }
    
    public ArrayList<MonHocDTO> timKiemTheoMa(String thongTin){
        ArrayList<MonHocDTO> dskqTimKiem = new ArrayList<MonHocDTO>();
        for(MonHocDTO mh : dsmh)
            if(mh.getMamh().equalsIgnoreCase(thongTin))
                dskqTimKiem.add(mh);
        return dskqTimKiem;
    }
    
    public ArrayList<MonHocDTO> timKiemTheoTenmh(String thongTin){
        ArrayList<MonHocDTO> dskqTimKiem = new ArrayList<MonHocDTO>();
        for(MonHocDTO mh : dsmh)
            if(mh.getTenmh().equalsIgnoreCase(thongTin))
                dskqTimKiem.add(mh);
        return dskqTimKiem;
    }
    public ArrayList<MonHocDTO> timKiemTheoHeSo(float thongTin){
        ArrayList<MonHocDTO> dskqTimKiem = new ArrayList<MonHocDTO>();
        for(MonHocDTO mh : dsmh){
            //String s = String.valueOf(mh.getHeso());
            if(mh.getHeso() == thongTin)
                dskqTimKiem.add(mh);
        }
        return dskqTimKiem;
    }
    
    public ArrayList<MonHocDTO> timKiemTheoMa(String thongTin, ArrayList<MonHocDTO> dsmh){
        ArrayList<MonHocDTO> dskqTimKiem = new ArrayList<MonHocDTO>();
        for(MonHocDTO mh : dsmh)
            if(mh.getMamh().equalsIgnoreCase(thongTin))
                dskqTimKiem.add(mh);
        return dskqTimKiem;
    }
    
    public ArrayList<MonHocDTO> timKiemTheoTenmh(String thongTin, ArrayList<MonHocDTO> dsmh){
        ArrayList<MonHocDTO> dskqTimKiem = new ArrayList<MonHocDTO>();
        for(MonHocDTO mh : dsmh)
            if(mh.getTenmh().indexOf(thongTin) != -1)
                dskqTimKiem.add(mh);
        return dskqTimKiem;
    }
    public ArrayList<MonHocDTO> timKiemTheoHeSo(float thongTin, ArrayList<MonHocDTO> dsmh){
        ArrayList<MonHocDTO> dskqTimKiem = new ArrayList<MonHocDTO>();
        for(MonHocDTO mh : dsmh){
            //String s = String.valueOf(mh.getHeso());
            if(mh.getHeso() == thongTin)
                dskqTimKiem.add(mh);
        }
        return dskqTimKiem;
    }
    
    
    public Boolean kiemTraTrungMa(String maCanKiemTra){
        for(MonHocDTO mh : dsmh)
            if(mh.getMamh().equals(maCanKiemTra))
                return true;
        return false;
    }

    public ArrayList<MonHocDTO> getDsmh() {
        return dsmh;
    }
    
    
    
    
    //public void setDsmh(ArrayList<MonHocDTO> dsmh) {
        //MonHocBUS.dsmh = dsmh;
    //}
    
}
    


