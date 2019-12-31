/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccessObject;

import DataTransferObject.GiaoVienDTO;
import DataTransferObject.LopDTO;
import DataTransferObject.NamHocDTO;
import DataTransferObject.PhongDTO;
import DataAccessObject.SQLconnector;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author QuyenNguyen
 */
public class LopDAO {
    private SQLconnector connect;
    // Constructors
    public LopDAO(){
        connect = new SQLconnector();
    }
    public ArrayList doc(ArrayList<NamHocDTO> dsnh,ArrayList<GiaoVienDTO> dsgv,ArrayList<PhongDTO> dsphong){
        ArrayList dslop = new ArrayList<LopDTO>();
        try{
            String qry = "SELECT * FROM lop";
            ResultSet rs = connect.executeQuery(qry);
            while(rs.next()){
                LopDTO lop = new LopDTO();
                lop.setMalop(rs.getString(1));
                lop.setTenlop(rs.getString(2));
                lop.setManh(timMaNamHoc(dsnh,rs.getString(3)));
                lop.setMaGVCN(timMaGVCN(dsgv,rs.getString(4)));
                lop.setSiso(rs.getInt(5));
                lop.setMaphong(timMaPhong(dsphong,rs.getString(6)));
                dslop.add(lop);
            }
            connect.Close();
        }
        catch(Exception e){
            
        }
        return dslop;
    }
    public void them(LopDTO lop){
        try{
            String qry="INSERT INTO lop VALUES ('";
            qry+=lop.getMalop()+"','";
            qry+=lop.getTenlop()+"','";
            qry+=lop.getManh()+"','";
            qry+=lop.getMaGVCN()+"','";
            qry+=lop.getSiso()+"','";
            qry+=lop.getMaphong()+"');";
            int st = connect.executeUpdate(qry);
            connect.Close();
        }
        catch(Exception e){
            
        }
    }
    public void sua(LopDTO lop){
        try{ 
            String qry = "UPDATE lop SET";
            qry+= " tenLop= '"+lop.getTenlop()+"',";
            qry+= " manh= '"+lop.getManh().getManh()+"',";
            qry+= " maGVCN= '"+lop.getMaGVCN().getMagv()+"',";
            qry+= " siSo= '"+lop.getSiso()+"',";
            qry+= " maphong= '"+lop.getMaphong().getMaphong()+"'";
            qry+= " WHERE maLop= '"+lop.getMalop()+"';";
            int st = connect.executeUpdate(qry);
            connect.Close();
        }
        catch(Exception e){
            
        }
    }
    public void xoa(LopDTO lop){
        try{
            String qry="DELETE FROM lop WHERE malop= '"+lop.getMalop()+"';";
            int st = connect.executeUpdate(qry);
            connect.Close();
        }
        catch(Exception e){
            
        }
    }
    public NamHocDTO timMaNamHoc(ArrayList<NamHocDTO> dsnh, String manh){
        for (NamHocDTO nh : dsnh)
            if (nh.getManh().equalsIgnoreCase(manh))
                return nh;
        return null;
    }
    public GiaoVienDTO timMaGVCN(ArrayList<GiaoVienDTO> dsgv, String magv){
        for (GiaoVienDTO gv : dsgv)
            if (gv.getMagv().equalsIgnoreCase(magv))
                return gv;
        return null;
    }
    public PhongDTO timMaPhong(ArrayList<PhongDTO> dsphong, String maphong){
        for (PhongDTO phong : dsphong)
            if (phong.getMaphong().equalsIgnoreCase(maphong))
                return phong;
        return null;
    }
}