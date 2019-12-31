/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccessObject;

import DataTransferObject.MonHocDTO;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class MonHocDAO {
    private SQLconnector conn;
    
    public MonHocDAO(){
        conn = new SQLconnector();
    }
    public ArrayList docDSMH() throws Exception{
        ArrayList dsmh = new ArrayList<MonHocDTO>();
        try{
            String qry = "SELECT * FROM mon_hoc";
            ResultSet rs = conn.executeQuery(qry);
            while(rs.next()){
                MonHocDTO mh = new MonHocDTO();
                mh.setMamh(rs.getString(1));
                mh.setTenmh(rs.getString(2));
                mh.setHeso(rs.getFloat(3));
                dsmh.add(mh);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Không kết nối được Database!");
        }
        conn.Close();
        return dsmh;
    }
    public void them(MonHocDTO mh) throws Exception{
            String qry = "INSERT INTO mon_hoc (`mamh`, `tenmh`, `heSo`) VALUES('";
            qry = qry + mh.getMamh() + "','";
            qry = qry + mh.getTenmh() + "','";
            qry = qry + mh.getHeso() + "');";
            int i = conn.executeUpdate(qry);
            conn.Close();
    }
    public void sua(MonHocDTO mh) throws Exception{
            String qry = "UPDATE `mon_hoc` SET `mamh` = " + "'" + mh.getMamh() + ","
                        + ", `tenmh` = " + "'" + mh.getTenmh() + "'"
                        + ", `heSo` = " + "'" + mh.getHeso() + "'"
                        + "WHERE `mon_hoc`.`mamh` = '" + mh.getMamh() + "';";
                int i = conn.executeUpdate(qry);
                conn.Close();
    }
    
    public void xoa(String mamhCanXoa) throws Exception{
            String qry = "DELETE FROM `mon_hoc` WHERE `mon_hoc`.`mamh` = ";
                   qry += "'" + mamhCanXoa + "'" + ";";
                   int i = conn.executeUpdate(qry);
            conn.Close();
        
    }
}

