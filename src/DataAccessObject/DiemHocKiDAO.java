/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccessObject;

import DataTransferObject.DiemDTO;
import DataTransferObject.DiemHocKiDTO;
import DataTransferObject.HS_LopDTO;
import DataTransferObject.HocKyDTO;
import DataTransferObject.HocSinhDTO;
import DataTransferObject.LopDTO;
import DataTransferObject.MonHocDTO;
import DataTransferObject.NamHocDTO;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author DELL
 */
public class DiemHocKiDAO {
    private SQLconnector conn;
    // Constructors
    public DiemHocKiDAO(){
        conn = new SQLconnector();
    }
    public ArrayList doc(ArrayList<HocSinhDTO> dshs,ArrayList<MonHocDTO> dsmh,ArrayList<HocKyDTO> dshk,ArrayList<NamHocDTO> dsnh){
        ArrayList dsdiemhk = new ArrayList<DiemHocKiDTO>();
        try{
            String qry = "SELECT * FROM diem_hocki";
            ResultSet rs = conn.executeQuery(qry);
            while(rs.next()){
                DiemHocKiDTO dhk= new DiemHocKiDTO();
                dhk.setHocSinh(timHocSinh(dshs, rs.getString(1)));
                dhk.setMonHoc(timMonHoc(dsmh, rs.getString(2)));
                dhk.setHocKy(timHocKy(dshk, rs.getString(3)));
                dhk.setNamHoc(timNamHoc(dsnh, rs.getString(4)));
                dhk.setTbMonhk(rs.getFloat(5));
                dsdiemhk.add(dhk);
            }    
        }
        catch(Exception e){
            
        }
        return dsdiemhk;
    }
    public HocSinhDTO timHocSinh(ArrayList<HocSinhDTO> dshs, String mahs){
       for(HocSinhDTO hs : dshs)
           if(hs.getMahs().equalsIgnoreCase(mahs))
               return hs;
       return null;
   }
    public MonHocDTO timMonHoc(ArrayList<MonHocDTO> dsmh, String mamh){
       for(MonHocDTO mh : dsmh)
           if(mh.getMamh().equalsIgnoreCase(mamh))
               return mh;
       return null;
   }
    public HocKyDTO timHocKy(ArrayList<HocKyDTO> dshk, String mahk){
       for(HocKyDTO hk : dshk)
           if(hk.getMahk().equalsIgnoreCase(mahk))
               return hk;
       return null;
   }
   
    public NamHocDTO timNamHoc(ArrayList<NamHocDTO> dsnh, String manh){
       for(NamHocDTO nh : dsnh)
           if(nh.getManh().equalsIgnoreCase(manh))
               return nh;
       return null;
   }
    public void them(DiemHocKiDTO d) throws Exception{
       String qry = "INSERT INTO diem_hocki (`mahs`, `mamh`, `mahk`, `manh`, `tbmonhk`) VALUE ('";
       qry += d.getHocSinh().getMahs() + "', '";
       qry += d.getMonHoc().getMamh() + "', '";
       qry += d.getHocKy().getMahk() + "', '";
       qry += d.getNamHoc().getManh() + "', '";
       qry += d.getTbMonhk() + "');";
       int i = conn.executeUpdate(qry);
       conn.Close();
    }
    public void sua(DiemHocKiDTO dhk) throws Exception{
       String qry = "UPDATE `diem_hocki` SET `tbmonhk` = " + "'" + dhk.getTbMonhk() + "'"
                    + " WHERE `diem_hocki`.`mahs` = '" + dhk.getHocSinh().getMahs() + "'" + " and "
                    + "`diem_hocki`.`mamh` = " + "'" + dhk.getMonHoc().getMamh() + "'" + " and "
                    + "`diem_hocki`.`mahk` = " + "'" + dhk.getHocKy().getMahk() + "'" + " and "
                    + "`diem_hocki`.`manh` = " + "'" + dhk.getNamHoc().getManh() + "';";
       int i = conn.executeUpdate(qry);
       conn.Close();       
    }
    public void xoa(DiemHocKiDTO dhk) throws Exception{
       String qry = "DELETE FROM `diem_hocki` WHERE `diem_hocki`.`mahs` = ";
       qry += "'" + dhk.getHocSinh().getMahs() + "'" + " and ";
       qry += "`diem_hocki`.`mamh` = " + "'" + dhk.getMonHoc().getMamh() + "'" + " and ";
       qry += "`diem_hocki`.`mahk` = " + "'" + dhk.getHocKy().getMahk() + "'" + " and ";
       qry += "`diem_hocki`.`manh` = " + "'" + dhk.getNamHoc().getManh() + "';";
       int i = conn.executeUpdate(qry);
       conn.Close();
   }
}