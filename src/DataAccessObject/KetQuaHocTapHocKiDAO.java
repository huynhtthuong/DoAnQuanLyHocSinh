/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccessObject;

import DataTransferObject.DiemHocKiDTO;
import DataTransferObject.HocKyDTO;
import DataTransferObject.HocSinhDTO;
import DataTransferObject.KetQuaHocTapHocKiDTO;
import DataTransferObject.MonHocDTO;
import DataTransferObject.NamHocDTO;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author DELL
 */
public class KetQuaHocTapHocKiDAO {
    private SQLconnector conn;
    // Constructors
    public KetQuaHocTapHocKiDAO(){
        conn = new SQLconnector();
    }
    public ArrayList doc(ArrayList<HocSinhDTO> dshs,ArrayList<HocKyDTO> dshk,ArrayList<NamHocDTO> dsnh){
        ArrayList dsketquahk = new ArrayList<KetQuaHocTapHocKiDTO>();
        try{
            String qry = "SELECT * FROM ketqua_hoctap_hocki";
            ResultSet rs = conn.executeQuery(qry);
            while(rs.next()){
                KetQuaHocTapHocKiDTO d= new KetQuaHocTapHocKiDTO();
                d.setHocSinh(timHocSinh(dshs, rs.getString(1)));
                d.setHocKy(timHocKy(dshk, rs.getString(2)));
                d.setNamHoc(timNamHoc(dsnh, rs.getString(3)));
                d.setHanhKiem(rs.getString(4));
                d.setTbcHocky(rs.getFloat(5));
                dsketquahk.add(d);
            }    
        }
        catch(Exception e){
            
        }
        return dsketquahk;
    }
    
    public HocSinhDTO timHocSinh(ArrayList<HocSinhDTO> dshs, String mahs){
       for(HocSinhDTO hs : dshs)
           if(hs.getMahs().equalsIgnoreCase(mahs))
               return hs;
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
   
    public void them(KetQuaHocTapHocKiDTO d) throws Exception
    {
       String qry = "INSERT INTO ketqua_hoctap_hocki (`mahs`, `mahk`, `manh`, `hanhKiem`, `tbchk`) VALUE ('";
       qry += d.getHocSinh().getMahs() + "', '";
       qry += d.getHocKy().getMahk() + "', '";
       qry += d.getNamHoc().getManh() + "', '";
       qry += d.getHanhKiem() + "', '";
       qry += d.getTbcHocky() + "');";
       int i = conn.executeUpdate(qry);
       conn.Close();
    }
    
    public void sua(KetQuaHocTapHocKiDTO d) throws Exception{
       String qry = "UPDATE `ketqua_hoctap_hocki` SET `hanhkiem` = " + "'" + d.getHanhKiem() + "'"
                    + ", `tbchk` = " + "'" + d.getTbcHocky() + "'"
                    + " WHERE `ketqua_hoctap_hocki`.`mahs` = '" + d.getHocSinh().getMahs() + "'" + " and "
                    + "`ketqua_hoctap_hocki`.`mahk` = " + "'" + d.getHocKy().getMahk() + "'" + " and "
                    +" `ketqua_hoctap_hocki`.`manh` = " + "'" + d.getNamHoc().getManh() + "';";
       int i = conn.executeUpdate(qry);
       conn.Close();       
    }
    public void xoa(KetQuaHocTapHocKiDTO d) throws Exception{
       String qry = "DELETE FROM `ketqua_hoctap_hocki` WHERE `ketqua_hoctap_hocki`.`mahs` = ";
       qry += "'" + d.getHocSinh().getMahs() + "'" + " and ";
       qry += "`ketqua_hoctap_hocki`.`mahk` = " + "'" + d.getHocKy().getMahk() + "'" + " and ";
       qry += "`ketqua_hoctap_hocki`.`manh` = " + "'" + d.getNamHoc().getManh() + "';";
       int i = conn.executeUpdate(qry);
       conn.Close();
   }
   
}
