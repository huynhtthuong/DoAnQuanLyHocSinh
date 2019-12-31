/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccessObject;

import DataTransferObject.DiemHocKiDTO;
import DataTransferObject.HocKyDTO;
import DataTransferObject.HocSinhDTO;
import DataTransferObject.HocBaCuoiNamDTO;
import DataTransferObject.HocBaCuoiNamDTO;
import DataTransferObject.HocBaCuoiNamDTO;
import DataTransferObject.HocBaCuoiNamDTO;
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
public class HocBaCuoiNamDAO {
    private SQLconnector conn;
    // Constructors
    public HocBaCuoiNamDAO(){
        conn = new SQLconnector();
    }
    public ArrayList doc(ArrayList<HocSinhDTO> dshs,ArrayList<NamHocDTO> dsnh){
        ArrayList dsHocBaCuoiNam = new ArrayList<HocBaCuoiNamDTO>();
        try{
            String qry = "SELECT * FROM hoc_ba_cuoi_nam";
            ResultSet rs = conn.executeQuery(qry);
            while(rs.next()){
                HocBaCuoiNamDTO d= new HocBaCuoiNamDTO();
                d.setHocSinh(timHocSinh(dshs, rs.getString(1)));
                d.setNamHoc(timNamHoc(dsnh, rs.getString(2)));
                d.setHocLuc(rs.getString(3));
                d.setHanhKiem(rs.getString(4));
                d.setXepLoai(rs.getString(5));
                d.setDtbCn(rs.getFloat(6));
                dsHocBaCuoiNam.add(d);
            }    
        }
        catch(Exception e){
            
        }
        return dsHocBaCuoiNam;
    }
    public HocSinhDTO timHocSinh(ArrayList<HocSinhDTO> dshs, String mahs){
       for(HocSinhDTO hs : dshs)
           if(hs.getMahs().equalsIgnoreCase(mahs))
               return hs;
       return null;
   }
    public NamHocDTO timNamHoc(ArrayList<NamHocDTO> dsnh, String manh){
       for(NamHocDTO nh : dsnh)
           if(nh.getManh().equalsIgnoreCase(manh))
               return nh;
       return null;
   }
    
    public void them(HocBaCuoiNamDTO d) throws Exception
    {
       String qry = "INSERT INTO hoc_ba_cuoi_nam (`mahs`, `manh`, `hocLuc`, `hanhKiem`, `xepLoai`, `dtbCn`) VALUE ('";
       qry += d.getHocSinh().getMahs() + "', '";
       qry += d.getNamHoc().getManh() + "', '";
       qry += d.getHocLuc() + "', '";
       qry += d.getHanhKiem() + "', '";
       qry += d.getXepLoai() + "', '";
       qry += d.getDtbCn() + "');";
       int i = conn.executeUpdate(qry);
       conn.Close();
    }
    
    public void sua(HocBaCuoiNamDTO d) throws Exception{
       String qry = "UPDATE `hoc_ba_cuoi_nam` SET `hanhKiem` = " + "'" + d.getHanhKiem() + "'"
                    + ", `hocLuc` = " + "'" + d.getHocLuc() + "'"
                    + ", `xepLoai` = " + "'" + d.getXepLoai()+ "'"
                    + ", `dtbCn` = " + "'" + d.getDtbCn()+ "'"
                    + " WHERE `hoc_ba_cuoi_nam`.`mahs` = '" + d.getHocSinh().getMahs() + "'" + " and "
                    +" `hoc_ba_cuoi_nam`.`manh` = " + "'" + d.getNamHoc().getManh() + "';";
       int i = conn.executeUpdate(qry);
       conn.Close();       
    }
    
     public void xoa(HocBaCuoiNamDTO d) throws Exception{
       String qry = "DELETE FROM `hoc_ba_cuoi_nam` WHERE `hoc_ba_cuoi_nam`.`mahs` = ";
       qry += "'" + d.getHocSinh().getMahs() + "'" + " and ";
       qry += "`hoc_ba_cuoi_nam`.`manh` = " + "'" + d.getNamHoc().getManh() + "';";
       int i = conn.executeUpdate(qry);
       conn.Close();
   }
}

