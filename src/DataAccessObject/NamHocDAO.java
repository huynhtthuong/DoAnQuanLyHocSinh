/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccessObject;

import DataTransferObject.NamHocDTO;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author QuyenNguyen
 */
public class NamHocDAO {
    private SQLconnector connect;
    public NamHocDAO(){
        connect = new SQLconnector();
    }
    public ArrayList doc(){
        ArrayList dsnh = new ArrayList<NamHocDTO>();
        try{
            String qry = "SELECT * FROM nam_hoc";
            ResultSet rs = connect.executeQuery(qry);
            while(rs.next()){
                NamHocDTO nh = new NamHocDTO();
                nh.setManh(rs.getString(1));
                nh.setTennh(rs.getString(2));
                dsnh.add(nh);
            }
            connect.Close();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,"Lỗi không đọc được.");
        }
        return dsnh;
    }
    public void them(NamHocDTO nh){
        try{
            String qry="INSERT INTO nam_hoc VALUES ('";
            qry+=nh.getManh()+"','";
            qry+=nh.getTennh()+"');";
            int st = connect.executeUpdate(qry);
            connect.Close();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,"Lỗi không thêm được.");
        }
    }
    public void xoa(String manh){
        try{
            String qry="DELETE FROM nam_hoc WHERE manh= '"+manh+"';";
            int st = connect.executeUpdate(qry);
            connect.Close();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,"Lỗi.");
        }
    } 
    public void sua(NamHocDTO nh){
        try{ 
            String qry = "UPDATE nam_hoc SET";
            qry+= " tennh= '"+nh.getTennh()+"'";
            qry+= " WHERE manh= '"+nh.getManh()+"';";
            int st = connect.executeUpdate(qry);
            connect.Close();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,"Lỗi.");
        }
    }
}
