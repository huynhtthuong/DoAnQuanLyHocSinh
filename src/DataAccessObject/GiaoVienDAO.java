/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccessObject;

import DataTransferObject.GiaoVienDTO;
import DataTransferObject.HocSinhDTO;
import DataTransferObject.MonHocDTO;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author mr932
 */
public class GiaoVienDAO {
    private SQLconnector conn;
    // Constructors
    public GiaoVienDAO(){
        conn = new SQLconnector();
    }
    // Methods
    public ArrayList docDSGV(ArrayList<MonHocDTO> dsmh) throws Exception{
        ArrayList<GiaoVienDTO> dsgv = new ArrayList<GiaoVienDTO>();
        try{
            String qry = "select* from giao_vien";
            ResultSet rs = conn.executeQuery(qry);
            while (rs.next()){
                GiaoVienDTO gv = new GiaoVienDTO();
                gv.setMagv(rs.getString(1));
                gv.setHo(rs.getString(2));
                gv.setTen(rs.getString(3));
                gv.setMonPhuTrach(timMonPhuTrach(dsmh, rs.getString(4)));
                dsgv.add(gv);
            }
        } catch(Exception e){
            
        }
        conn.Close();
        return dsgv;
    }
    
    public void them(GiaoVienDTO gv) throws Exception{
            String qry = "INSERT INTO giao_vien (`magv`, `ho`, `ten`, `monPhuTrach`) VALUES ('";
            qry += gv.getMagv() + "', '";
            qry += gv.getHo() + "', '";
            qry += gv.getTen() + "', '";
            qry += gv.getMonPhuTrach().getMamh() + "');";
            int i = conn.executeUpdate(qry);
            conn.Close();
    }
    
    public void sua(GiaoVienDTO gv) throws Exception{
       String qry = "UPDATE `giao_vien` SET `magv` = " + "'" + gv.getMagv() + "'"
                        + ", `ho` = " + "'" + gv.getHo() + "'"
                        + ", `ten` = " + "'" + gv.getTen() + "'"
                        + ", `monPhuTrach` = " + "'" + gv.getMonPhuTrach().getMamh() + "'"
                        + " WHERE `giao_vien`.`magv` = '" + gv.getMagv() + "';";
                int i = conn.executeUpdate(qry);
                conn.Close();
        }
    
    public void xoa(String magvCanXoa) throws Exception{
        String qry = "DELETE FROM `giao_vien` WHERE `giao_vien`.`magv` = ";
               qry += "'" + magvCanXoa + "'" + ";";
               int i = conn.executeUpdate(qry);
               conn.Close();
    }
    
    public MonHocDTO timMonPhuTrach(ArrayList<MonHocDTO> dsmh, String maMonPhuTrach){
        for (MonHocDTO mh : dsmh)
            if (mh.getMamh().equalsIgnoreCase(maMonPhuTrach))
                return mh;
        return null;
    }
}
