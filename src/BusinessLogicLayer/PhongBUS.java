/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogicLayer;

import DataAccessObject.PhongDAO;
import DataTransferObject.GiaoVienDTO;
import DataTransferObject.LopDTO;
import DataTransferObject.PhongDTO;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author QuyenNguyen
 */
public class PhongBUS {
    public static ArrayList<PhongDTO> dsphong ;
    public PhongBUS(){}

    public ArrayList<PhongDTO> getDsphong() {
        return dsphong;
    }

    public void setDsphong(ArrayList<PhongDTO> dsphong) {
        PhongBUS.dsphong = dsphong;
    }
    
    
    public ArrayList<String> toStringList(ArrayList<PhongDTO> danhSachObject){
        ArrayList<String> dsMa = new ArrayList<String>();
        for (PhongDTO object : danhSachObject)
            dsMa.add(object.getMaphong());
        return dsMa;
    }
    
    public void docDSP()throws Exception{
        PhongDAO dataP = new PhongDAO();
        if (dsphong == null)
            dsphong = new ArrayList<PhongDTO>();
        dsphong = dataP.doc();
    }
    
    public void doc(){
        PhongDAO data = new PhongDAO();
        if(dsphong==null)
            dsphong = new ArrayList<PhongDTO>();
        dsphong = data.doc();
    }
    public void them(PhongDTO phong){
        PhongDAO dao=new PhongDAO();
        dao.them(phong);
        dsphong.add(phong);
        JOptionPane.showMessageDialog(null,"Thêm thành công");
    }
    public void sua(PhongDTO phongCanSua, String maphong){
        PhongDAO data=new PhongDAO();
        for(PhongDTO phong : dsphong)
            if(phong.getMaphong().equals(maphong)){
                dsphong.remove(phong);
                break;
            }
        dsphong.add(phongCanSua);
        data.sua(phongCanSua);
    }
    public void xoa(String maphong){
        PhongDAO data =new PhongDAO();
        data.xoa(maphong);
        for(PhongDTO phong : dsphong)
            if(phong.getMaphong().equals(phong.getMaphong()))
                dsphong.remove(phong);
    }
    public PhongDTO timKiemPhong(String thongTin){
        if (dsphong != null){
            for(PhongDTO phong : dsphong)
                if(phong.getMaphong().equals(thongTin) || phong.getTenphong().equals(thongTin)){
                    return phong;
            }
        }
        return null;
    }
    public ArrayList<PhongDTO> timKiemTheoTenphong(String ten){
        ArrayList<PhongDTO> dskq =new ArrayList<PhongDTO>();
        PhongDAO data=new PhongDAO();
        dsphong=data.doc();
        for(PhongDTO phong:dsphong)
            if(phong.getMaphong().equalsIgnoreCase(ten)){
                dskq.add(phong);
                return dskq;
            }
        return null;
    }
    public ArrayList<PhongDTO> timKiem(String ten){
        ArrayList<PhongDTO> dskq =new ArrayList<PhongDTO>();
        PhongDAO data=new PhongDAO();
        dsphong=data.doc();
        for(PhongDTO phong:dsphong)
            if(phong.getMaphong().equalsIgnoreCase(ten)){
                dskq.add(phong);
                return dskq;
            }
        return null;
    }
    public PhongDTO timKiemTenPhong(String ten){
        if(dsphong==null) 
            dsphong=new ArrayList<PhongDTO>();
        PhongDAO data=new PhongDAO();
        dsphong=data.doc();
        for(PhongDTO phong:dsphong)
            if(phong.getTenphong().equals(ten)){
                return phong;
            }
        return null;
    }
    public boolean kiemTraTrungMa(String ma){
        for (PhongDTO gv : dsphong){
            if (gv.getMaphong().equals(ma)){
                JOptionPane.showMessageDialog(null,"Mã phòng đã tồn tại");
                return true;
            }
        }
        return false;
    }
    
    public ArrayList<PhongDTO> timKiemTheoTenPhong(String thongTin, ArrayList<PhongDTO> dsgv){
        ArrayList<PhongDTO> danhSachKqTimDuoc = new ArrayList<>();
        for (PhongDTO gv : dsgv)
            if (gv.getTenphong().indexOf(thongTin) != -1)
                danhSachKqTimDuoc.add(gv);
        return danhSachKqTimDuoc;
    }
    public ArrayList<PhongDTO> timKiemTheoMaPhong(String thongTin, ArrayList<PhongDTO> dsgv){
        ArrayList<PhongDTO> danhSachKqTimDuoc = new ArrayList<>();
        for (PhongDTO gv : dsgv)
            if (gv.getMaphong().equalsIgnoreCase(thongTin))
                danhSachKqTimDuoc.add(gv);
        return danhSachKqTimDuoc;
    }
}