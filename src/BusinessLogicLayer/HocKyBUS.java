 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogicLayer;

import DataAccessObject.HocKyDAO;
import DataTransferObject.HocKyDTO;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author QuyenNguyen
 */
public class HocKyBUS {
    private static ArrayList<HocKyDTO> dshk ;
    public HocKyBUS(){}
    public void doc(){
        HocKyDAO data = new HocKyDAO();
        if(dshk==null)
            dshk = new ArrayList<HocKyDTO>();
        dshk = data.doc();
    }

    public ArrayList<HocKyDTO> getDshk() {
        return dshk;
    }

    public void setDshk(ArrayList<HocKyDTO> dshk) {
        HocKyBUS.dshk = dshk;
    }
    
    public ArrayList<String> toStringList(ArrayList<HocKyDTO> danhSachObject){
        ArrayList<String> dsMa = new ArrayList<String>();
        for (HocKyDTO object : danhSachObject)
            dsMa.add(object.getMahk());
        return dsMa;
    }
    
    public void them(HocKyDTO hk){
        HocKyDAO dao=new HocKyDAO();
        dao.them(hk);
        dshk.add(hk);
    }
    
    public void sua(HocKyDTO hkCanSua, String mahk){
        HocKyDAO data=new HocKyDAO();
        for(HocKyDTO hk : dshk)
            if(hk.getMahk().equals(mahk)){
                dshk.remove(hk);
                break;
            }
        dshk.add(hkCanSua);
        data.sua(hkCanSua);
    }
    
    public void xoa(String mahk){
        HocKyDAO data =new HocKyDAO();
        data.xoa(mahk);
        for(HocKyDTO hk : dshk)
            if(hk.getMahk().equals(hk.getMahk()))
                dshk.remove(hk);
    }
    
    public HocKyDTO timKiemMahk(String ma){
        if(dshk==null) 
            dshk=new ArrayList<HocKyDTO>();
        HocKyDAO data=new HocKyDAO();
        dshk=data.doc();
        for(HocKyDTO hk:dshk)
            if(hk.getMahk().equals(ma)){
                return hk;
            }
        return null;
    }
    
    public ArrayList<HocKyDTO> timKiemTenhk(String ten){
        ArrayList<HocKyDTO> dskq =new ArrayList<HocKyDTO>();
        HocKyDAO data=new HocKyDAO();
        dshk=data.doc();
        for(HocKyDTO hk:dshk)
            if(hk.getMahk().equalsIgnoreCase(ten)){
                dskq.add(hk);
                return dskq;
            }
        return null;
    }
    
    public boolean kiemTraTrungMa(String ma){
        for (HocKyDTO gv : dshk){
            if (gv.getMahk().equals(ma)){
                return true;
            }
        }
        return false;
    }
}