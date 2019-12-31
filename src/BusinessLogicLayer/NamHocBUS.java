/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogicLayer;

import DataAccessObject.NamHocDAO;
import DataTransferObject.NamHocDTO;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author QuyenNguyen
 */
public class NamHocBUS {
    public static ArrayList<NamHocDTO> dsnh ;
    public NamHocBUS(){}
    
    public ArrayList<String> toStringList(ArrayList<NamHocDTO> danhSachObject){
        ArrayList<String> dsMa = new ArrayList<String>();
        for (NamHocDTO object : danhSachObject)
            dsMa.add(object.getManh());
        return dsMa;
    }
    
    public void doc(){
        NamHocDAO data = new NamHocDAO();
        if(dsnh==null)
            dsnh = new ArrayList<NamHocDTO>();
        dsnh = data.doc();
    }

    public ArrayList<NamHocDTO> getDsnh() {
        return dsnh;
    }

    public static void setDsnh(ArrayList<NamHocDTO> dsnh) {
        NamHocBUS.dsnh = dsnh;
    }
    
    public void them(NamHocDTO nh){
        NamHocDAO dao=new NamHocDAO();
        dao.them(nh);
        dsnh.add(nh);
        
    }
    
    public void sua(NamHocDTO nhCanSua, String manh){
        NamHocDAO data=new NamHocDAO();
        for(NamHocDTO nh : dsnh)
            if(nh.getManh().equals(manh)){
                dsnh.remove(nh);
                break;
            }
        dsnh.add(nhCanSua);
        data.sua(nhCanSua);
    }
    
    public void xoa(String manh){
        NamHocDAO data =new NamHocDAO();
        data.xoa(manh);
        for(NamHocDTO nh : dsnh)
            if(nh.getManh().equals(nh.getManh()))
                dsnh.remove(nh);
    }
    
    public NamHocDTO timKiemNamHoc(String namHoc){
        for(NamHocDTO nh:dsnh)
            if(nh.getTennh().equals(namHoc) || nh.getManh().equals(namHoc)){
                return nh;
            }
        return null;
    }
    
    public ArrayList<NamHocDTO> timKiemTennh(String ten){
        ArrayList<NamHocDTO> dskq =new ArrayList<NamHocDTO>();
        NamHocDAO data=new NamHocDAO();
        dsnh=data.doc();
        for(NamHocDTO nh:dsnh)
            if(nh.getManh().equalsIgnoreCase(ten)){
                dskq.add(nh);
                return dskq;
            }
        return null;
    }
    public ArrayList<NamHocDTO> timKiem(String ten){
        ArrayList<NamHocDTO> dskq =new ArrayList<NamHocDTO>();
        NamHocDAO data=new NamHocDAO();
        dsnh=data.doc();
        for(NamHocDTO nh:dsnh)
            if(nh.getManh().equalsIgnoreCase(ten)){
                dskq.add(nh);
                return dskq;
            }
        return null;
    }
    public boolean kiemTraTrungMa(String ma){
        for (NamHocDTO gv : dsnh){
            if (gv.getManh().equals(ma)){
                return true;
            }
        }
        return false;
    }
}