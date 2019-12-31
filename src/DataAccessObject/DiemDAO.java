/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccessObject;

import DataTransferObject.HocSinhDTO;
import DataTransferObject.MonHocDTO;
import DataTransferObject.HocKyDTO;
import DataTransferObject.NamHocDTO;
import DataTransferObject.LoaiDiemDTO;
import DataTransferObject.DiemDTO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SpringLayout;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;
public class DiemDAO {
   private SQLconnector conn;
   
   public DiemDAO(){
       conn = new SQLconnector();
   }
   
   public ArrayList docDSD(ArrayList<HocSinhDTO> dshs, ArrayList<MonHocDTO> dsmh, ArrayList<HocKyDTO> dshk, ArrayList<NamHocDTO> dsnh, ArrayList<LoaiDiemDTO> dsld) throws Exception{
       ArrayList<DiemDTO> dsd = new ArrayList<DiemDTO>();
       try{
           String qry = "select* from diem";
           ResultSet rs = conn.executeQuery(qry);
           while(rs.next()){
               DiemDTO d = new DiemDTO();
               d.setHocSinh(timHocSinh(dshs, rs.getString(1)));
               d.setMonHoc(timMonHoc(dsmh, rs.getString(2)));
               d.setHocKy(timHocKy(dshk, rs.getString(3)));
               d.setNamHoc(timNamHoc(dsnh, rs.getString(4)));
               d.setLoaiDiem(timLoaiDiem(dsld, rs.getString(5)));
               d.setDiemSo(rs.getFloat(6));
               dsd.add(d);
           }
       }catch(Exception e){
           System.out.println("Không kết nối được database DiemDAO.");
       }
       conn.Close();
       return dsd;
   }
   
   public void them(DiemDTO d) throws Exception{
       String qry = "INSERT INTO diem (`mahs`, `mamh`, `mahk`, `manh`, `maLoaiDiem`, `diemSo`) VALUE ('";
       qry += d.getHocSinh().getMahs() + "', '";
       qry += d.getMonHoc().getMamh() + "', '";
       qry += d.getHocKy().getMahk() + "', '";
       qry += d.getNamHoc().getManh() + "', '";
       qry += d.getLoaiDiem().getMaLoaiDiem() + "', '";
       qry += d.getDiemSo() + "');";
       int i = conn.executeUpdate(qry);
       conn.Close();
   }
   
   public void sua(DiemDTO d) throws Exception{
       String qry = "UPDATE `diem` SET `diemSo` = " + "'" + d.getDiemSo() + "'"
                    + " WHERE `diem`.`mahs` = '" + d.getHocSinh().getMahs() + "'" + " and "
                    + "`diem`.`mamh` = '" + d.getMonHoc().getMamh() + "'" + " and "
                    + "`diem`.`mahk` = '" + d.getHocKy().getMahk() + "'" + " and "
                    + "`diem`.`manh` = '" + d.getNamHoc().getManh() + "'" + " and "
                    + "`diem`.`maLoaiDiem` = '" + d.getLoaiDiem().getMaLoaiDiem() + "';";
       int i = conn.executeUpdate(qry);
       conn.Close();
   }
   
   public void xoa(DiemDTO d) throws Exception{
       String qry = "DELETE FROM `diem` WHERE `diem`.`mahs` = ";
       qry += "'" + d.getHocSinh().getMahs() + "'" + " and ";
       qry += "`diem`.`mamh` = " + "'" + d.getMonHoc().getMamh() + "'" + " and ";
       qry += "`diem`.`mahk` = " + "'" + d.getHocKy().getMahk() + "'" + " and ";
       qry += "`diem`.`manh` = " + "'" + d.getNamHoc().getManh() + "'" + " and ";
       qry += "`diem`.`maLoaiDiem` = " + "'" + d.getLoaiDiem().getMaLoaiDiem() + "';";
       int i = conn.executeUpdate(qry);
       conn.Close();
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
   
   public LoaiDiemDTO timLoaiDiem(ArrayList<LoaiDiemDTO> dsld, String maLoaiDiem){
       for(LoaiDiemDTO ld : dsld)
           if(ld.getMaLoaiDiem().equalsIgnoreCase(maLoaiDiem))
               return ld;
       return null;
   }
   
   public void report(){
        String link="src////report2.jrxml";
        try {            
            Class.forName("com.mysql.jdbc.Driver");
            String database="jdbc:mysql://localhost:3306/truong_hoc";
            String us="root";
            String pass="nightmare2341993";
            Connection conn=(Connection) DriverManager.getConnection(database,us,pass);
            JasperReport jr= JasperCompileManager.compileReport(link);
            JasperPrint jp= JasperFillManager.fillReport(jr, null,conn);
            JasperViewer.viewReport(jp);
        } catch (JRException ex) {
            Logger.getLogger(TKBDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(TKBDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TKBDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
