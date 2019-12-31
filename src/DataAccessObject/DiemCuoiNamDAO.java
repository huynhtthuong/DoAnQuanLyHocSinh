/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccessObject;

import DataTransferObject.DiemCuoiNamDTO;
import DataTransferObject.DiemHocKiDTO;
import DataTransferObject.HocKyDTO;
import DataTransferObject.HocSinhDTO;
import DataTransferObject.MonHocDTO;
import DataTransferObject.NamHocDTO;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author DELL
 */
public class DiemCuoiNamDAO {
    private SQLconnector conn;
    // Constructors
    public DiemCuoiNamDAO(){
        conn = new SQLconnector();
    }
    public ArrayList doc(ArrayList<HocSinhDTO> dshs,ArrayList<MonHocDTO> dsmh,ArrayList<NamHocDTO> dsnh){
        ArrayList dsdiemcn = new ArrayList<DiemCuoiNamDTO>();
        try{
            String qry = "SELECT * FROM diem_cuoinam";
            ResultSet rs = conn.executeQuery(qry);
            while(rs.next()){
                DiemCuoiNamDTO dcn= new DiemCuoiNamDTO();
                dcn.setHocSinh(timHocSinh(dshs, rs.getString(1)));
                dcn.setMonHoc(timMonHoc(dsmh, rs.getString(1)));
                dcn.setNamHoc(timNamHoc(dsnh, rs.getString(4)));
                dsdiemcn.add(dcn);
            }    
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,"Lỗi không đọc được.");
        }
        return dsdiemcn;
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
    public MonHocDTO timMonHoc(ArrayList<MonHocDTO> dsmh, String mamh){
       for(MonHocDTO mh : dsmh)
           if(mh.getMamh().equalsIgnoreCase(mamh))
               return mh;
       return null;
   }
    
    
    public void them(DiemCuoiNamDTO d) throws Exception{
       String qry = "INSERT INTO diem_cuoinam (`mahs`, `mamh`, `manh`) VALUE ('";
       qry += d.getHocSinh().getMahs() + "', '";
       qry += d.getMonHoc().getMamh() + "', '";
       qry += d.getNamHoc().getManh() + "');";
       int i = conn.executeUpdate(qry);
       conn.Close();
    }
    public void sua(DiemCuoiNamDTO dcn) throws Exception{
       String qry = "UPDATE `diem_cuoinam` SET `mahs` = " + "'" + dcn.getHocSinh().getMahs() + "'"
                    + ", `mamh` = " + "'" + dcn.getMonHoc().getMamh() + "'"
                    + ", `manh` = " + "'" + dcn.getNamHoc().getManh() + "'"
                    + " WHERE `diem_cuoinam`.`mahs` = '" + dcn.getHocSinh().getMahs() + "';";
       int i = conn.executeUpdate(qry);
       conn.Close();       
    }
    public void xoa(DiemCuoiNamDTO dhk) throws Exception{
       String qry = "DELETE FROM `diem_cuoinam` WHERE `diem_cuoinam`.`mahs` = ";
       qry += "'" + dhk.getHocSinh().getMahs() + "'" + " and ";
       qry += "`diem_cuoinam`.`mamh` = " + "'" + dhk.getMonHoc().getMamh() + "'" + " and ";
       qry += "`diem_cuoinam`.`manh` = " + "'" + dhk.getNamHoc().getManh() + "'" + " and ";
       int i = conn.executeUpdate(qry);
       conn.Close();
   }
}
