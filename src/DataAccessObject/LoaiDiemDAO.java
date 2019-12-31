/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccessObject;

import java.util.ArrayList;
import DataTransferObject.LoaiDiemDTO;
import java.sql.ResultSet;


public class LoaiDiemDAO {
    private SQLconnector conn;
    
    //constructors
    public LoaiDiemDAO(){
        conn = new SQLconnector();
    }
    
    //Methods
    public ArrayList docDSLD() throws Exception{
        ArrayList<LoaiDiemDTO> dsld = new ArrayList<LoaiDiemDTO>();
        
        String qry = "select* from loai_diem";
        ResultSet rs = conn.executeQuery(qry);
        while(rs.next()){
            LoaiDiemDTO ld = new LoaiDiemDTO();
            ld.setMaLoaiDiem(rs.getString(1));
            ld.setTenLoaiDiem(rs.getString(2));
            ld.setHeSo(rs.getFloat(3));
            dsld.add(ld);
        }
        conn.Close();
        return dsld;
    }
    public void them(LoaiDiemDTO ld) throws Exception{
        String qry = "INSERT INTO loai_diem(`maLoaiDiem`, `tenLoaiDiem`, `heSo`) VALUE ('";
        qry += ld.getMaLoaiDiem() + "', '";
        qry += ld.getTenLoaiDiem() + "', '";
        qry += ld.getHeSo() + "');";
        int i = conn.executeUpdate(qry);
        conn.Close();
    }
    
    public void sua(LoaiDiemDTO ld) throws Exception{
        String qry = "UPDATE `loai_diem` SET `maLoaiDiem` = " + "'" + ld.getMaLoaiDiem() + "'"
                        + ", `tenLoaiDiem = " + "'" + ld.getMaLoaiDiem() + "'"
                        + ", `heSo = " + "'" + ld.getHeSo() + "';"
                        + " WHERE `loai_diem`.`maLoaiDiem` = '" + ld.getMaLoaiDiem() + "';";
                int i = conn.executeUpdate(qry);
                conn.Close();
        }
    public void xoa(String maLoaiDiemCanXoa) throws Exception{
        String qry = "DELETE FROM `loai_diem` WHERE `loai_diem`.`maLoaiDiem` = ";
               qry += "'" + maLoaiDiemCanXoa + "';";
               int i = conn.executeUpdate(qry);
               conn.Close();
    }
}
