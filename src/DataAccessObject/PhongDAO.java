/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccessObject;

import DataTransferObject.PhongDTO;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author QuyenNguyen
 */
public class PhongDAO {
    private SQLconnector connect;
    public PhongDAO(){
        connect = new SQLconnector();
    }
    public ArrayList doc(){
        ArrayList dsphong = new ArrayList<PhongDTO>();
        try{
            String qry = "SELECT * FROM phong";
            ResultSet rs = connect.executeQuery(qry);
            while(rs.next()){
                PhongDTO phong = new PhongDTO();
                phong.setMaphong(rs.getString(1));
                phong.setTenphong(rs.getString(2));
                dsphong.add(phong);
            }
            connect.Close();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,"Lỗi không đọc được phòng.");
        }
        return dsphong;
    }
    public void them(PhongDTO phong){
        try{
            String qry="INSERT INTO phong VALUES ('";
            qry+=phong.getMaphong()+"','";
            qry+=phong.getTenphong()+"');";
            int st = connect.executeUpdate(qry);
            connect.Close();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,"Lỗi không thêm được.");
        }
    }
    public void xoa(String maphong){
        try{
            String qry="DELETE FROM phong WHERE maphong= '"+maphong+"';";
            int st = connect.executeUpdate(qry);
            connect.Close();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,"Lỗi.");
        }
    } 
    public void sua(PhongDTO phong){
        try{ 
            String qry = "UPDATE phong SET";
            qry+= " tenphong= '"+phong.getTenphong()+"'";
            qry+= " WHERE maphong= '"+phong.getMaphong()+"';";
            int st = connect.executeUpdate(qry);
            connect.Close();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,"Lỗi.");
        }
    }
}
