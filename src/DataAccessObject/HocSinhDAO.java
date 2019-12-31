/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccessObject;

import DataTransferObject.HocSinhDTO;
import java.util.ArrayList;
import java.sql.*;
import java.util.Arrays;
import java.util.Vector;

/**
 *
 * @author mr932
 */
public class HocSinhDAO {
    // Properties
    private SQLconnector conn;
    // Constructors
    public HocSinhDAO(){
        conn = new SQLconnector();
    }
    // Methods
    public ArrayList docDSHS() throws Exception{
        ArrayList<HocSinhDTO> dshs = new ArrayList<HocSinhDTO>();
       
            String qry = "select* from hoc_sinh";
            ResultSet rs = conn.executeQuery(qry);
            while (rs.next()){
                HocSinhDTO hs = new HocSinhDTO();
                hs.setMahs(rs.getString(1));
                hs.setHo(rs.getString(2));
                hs.setTen(rs.getString(3));
                hs.setPhai(rs.getString(4));
                hs.setNgaySinh(rs.getString(5));
                hs.setDiaChi(rs.getString(6));
                hs.setQueQuan(rs.getString(7));
                hs.setHinhAnh(rs.getString(8));
                dshs.add(hs);
            }
            
        conn.Close();
        return dshs;
    }
    
    public void them(HocSinhDTO hs) throws Exception{
            
            String qry = "INSERT INTO hoc_sinh (`mahs`, `ho`, `ten`, `phai`, `ngaysinh`, `diachi`, `quequan`, `hinhanh`) VALUES ('";
            qry += hs.getMahs() + "', '";
            qry += hs.getHo() + "', '";
            qry += hs.getTen() + "', '";
            qry += hs.getPhai() + "', '";
            qry += hs.getNgaySinh() + "', '";
            qry += hs.getDiaChi() + "', '";
            qry += hs.getQueQuan() + "', '";
            qry += hs.getHinhAnh() + "');";
            int i = conn.executeUpdate(qry);
            
            conn.Close();
    }
    
    public void sua(HocSinhDTO hs) throws Exception{
       String qry = "UPDATE `hoc_sinh` SET `mahs` = " + "'" + hs.getMahs() + "'"
                        + ", `ho` = " + "'" + hs.getHo() + "'"
                        + ", `ten` = " + "'" + hs.getTen() + "'"
                        + ", `phai` = " + "'" + hs.getPhai() + "'"
                        + ", `ngaysinh` = " + "'" + hs.getNgaySinh() + "'"
                        + ", `diachi` = " + "'" + hs.getDiaChi() + "'"
                        + ", `quequan` = " + "'" + hs.getQueQuan() + "'"
                        + ", `hinhanh` = " + "'" + hs.getHinhAnh() + "'"
                        + " WHERE `hoc_sinh`.`mahs` = '" + hs.getMahs() + "';";
                int i = conn.executeUpdate(qry);
                conn.Close();
    }
    
    public void xoa(String mahsCanXoa) throws Exception{
        String qry = "DELETE FROM `hoc_sinh` WHERE `hoc_sinh`.`mahs` = ";
               qry += "'" + mahsCanXoa + "'" + ";";
               int i = conn.executeUpdate(qry);
               conn.Close();
    }
    
}

