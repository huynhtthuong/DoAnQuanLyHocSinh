/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccessObject;

import DataTransferObject.HocKyDTO;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author QuyenNguyen
 */
public class HocKyDAO {
    private SQLconnector connect;
    public HocKyDAO(){
        connect = new SQLconnector();
    }
    public ArrayList doc(){
        ArrayList dshk = new ArrayList<HocKyDTO>();
        try{
            String qry = "SELECT * FROM hoc_ki";
            ResultSet rs = connect.executeQuery(qry);
            while(rs.next()){
                HocKyDTO hk = new HocKyDTO();
                hk.setMahk(rs.getString(1));
                hk.setTenhk(rs.getString(2));
                dshk.add(hk);
            }
            connect.Close();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,"Lỗi không đọc được.");
        }
        return dshk;
    }
    public void them(HocKyDTO hk){
        try{
            String qry="INSERT INTO hoc_ki VALUES ('";
            qry+=hk.getMahk()+"','";
            qry+=hk.getTenhk()+"');";
            int st = connect.executeUpdate(qry);
            connect.Close();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,"Lỗi không thêm được.");
        }
    }
    public void xoa(String mahk){
        try{
            String qry="DELETE FROM hoc_ki WHERE mahk= '"+mahk+"';";
            int st = connect.executeUpdate(qry);
            connect.Close();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,"Lỗi.");
        }
    } 
    public void sua(HocKyDTO hk){
        try{ 
            String qry = "UPDATE hoc_ki SET";
            qry+= " tenhk= '"+hk.getTenhk()+"'";
            qry+= " WHERE mahk= '"+hk.getMahk()+"';";
            int st = connect.executeUpdate(qry);
            connect.Close();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,"Lỗi.");
        }
    }
}
