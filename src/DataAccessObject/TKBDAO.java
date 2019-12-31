/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccessObject;

import BusinessLogicLayer.TKBBUS;
import DataTransferObject.GiaoVienDTO;
import DataTransferObject.HocKyDTO;
import DataTransferObject.LopDTO;
import DataTransferObject.MonHocDTO;
import DataTransferObject.NamHocDTO;
import DataTransferObject.TKBDTO;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;
/**
 *
 * @author QuyenNguyen
 */
public class TKBDAO {
    private SQLconnector connect;
    public TKBDAO(){
        connect = new SQLconnector();
    }
     public ArrayList doc(ArrayList<HocKyDTO> dshk,ArrayList<NamHocDTO> dsnh,ArrayList<MonHocDTO> dsmh,ArrayList<GiaoVienDTO> dsgv, ArrayList<LopDTO> dslop){
        TKBBUS tkbBus = new TKBBUS();
        ArrayList dstkb = new ArrayList<TKBDTO>();
        try{
            String qry = "SELECT * FROM thoi_khoa_bieu";
            ResultSet rs = connect.executeQuery(qry);
            while(rs.next()){
                TKBDTO tkb = new TKBDTO();
                tkb.setHocKy(tkbBus.timMahk(dshk,rs.getString(1)));
                tkb.setNamHoc(tkbBus.timMaNamHoc(dsnh,rs.getString(2)));
                tkb.setTietBD(rs.getInt(3));
                tkb.setTietKT(rs.getInt(4));
                tkb.setLop(tkbBus.timMalop(dslop,rs.getString(5)));
                tkb.setThu(rs.getString(6));
                tkb.setMonHoc(tkbBus.timMamh(dsmh,rs.getString(7)));
                tkb.setGiaoVien(tkbBus.timMagv(dsgv,rs.getString(8)));
                dstkb.add(tkb);
            }
            connect.Close();
        }
        catch(Exception e){
            //JOptionPane.showMessageDialog(null,"Lỗi không đọc được thời khóa biểu.");
        }
        return dstkb;
    }
    public void them(TKBDTO tkb){
        try{
            //INSERT INTO thoi_khoa_bieu VALUES ('1','2019','1','3','LO121','Ba','MH004','00004')
            String qry="INSERT INTO thoi_khoa_bieu VALUES ('";
            qry+=tkb.getHocKy().getMahk()+"','";
            qry+=tkb.getNamHoc().getManh()+"','";
            qry+=tkb.getTietBD()+"','";
            qry+=tkb.getTietKT()+"','";
            qry+=tkb.getLop().getMalop()+"','";
            qry+=tkb.getThu()+"','";
            qry+=tkb.getMonHoc().getMamh()+"','";
            qry+=tkb.getGiaoVien().getMagv()+"')";
            
            int st = connect.executeUpdate(qry);
            connect.Close();
        }
        catch(Exception e){
            //JOptionPane.showMessageDialog(null,"Lỗi không thêm được csdl.");
        }
    }
    public void xoa(TKBDTO tkb){
        try{
            String qry="DELETE FROM thoi_khoa_bieu WHERE thoi_khoa_bieu.mahk= '"+tkb.getHocKy().getMahk()
                    + "' AND thoi_khoa_bieu.manh= '"+tkb.getNamHoc().getManh()
                    + "' AND thoi_khoa_bieu.tietBatDau= '"+tkb.getTietBD()
                    + "' AND thoi_khoa_bieu.tietKetThuc= '"+tkb.getTietKT()
                    + "' AND thoi_khoa_bieu.thu= '"+tkb.getThu()
                    + "' AND thoi_khoa_bieu.malop= '"+tkb.getLop().getMalop()+"'";;
            int st = connect.executeUpdate(qry);
            connect.Close();
        }
        catch(Exception e){
            //JOptionPane.showMessageDialog(null,"Lỗi không xóa được.");
        }
    } 
    public void sua(TKBDTO tkb, TKBDTO tkbCu){
        try{ 
            //UPDATE thoi_khoa_bieu SET mahk= '', manh= '', tietBatDau= '', tietKetThuc= '', malop= '', magv= '', mamh= '', thu= '' WHERE malop= ''
            String qry = "UPDATE thoi_khoa_bieu SET";
            qry+= " mahk= '"+tkb.getHocKy().getMahk()+"',";
            qry+= " manh= '"+tkb.getNamHoc().getManh()+"',";
            qry+= " tietBatDau= '"+tkb.getTietBD()+"',";
            qry+= " tietKetThuc= '"+tkb.getTietKT()+"',";
            qry+= " malop= '"+tkb.getLop().getMalop()+"',";
            qry+= " magv= '"+tkb.getGiaoVien().getMagv()+"',";
            qry+= " mamh= '"+tkb.getMonHoc().getMamh()+"',";
            qry+= " thu= '"+tkb.getThu()+"'";
            qry+= " WHERE malop= '"+tkbCu.getLop().getMalop()+"'";
            qry+= " AND mahk= '"+tkbCu.getHocKy().getMahk()+"'";//AND mahk= '' AND manh= '' AND tietBatDau= '' AND tietKetThuc= '' AND thu= ''
            qry+= " AND manh= '"+tkbCu.getNamHoc().getManh()+"'";
            qry+= " AND tietBatDau= '"+tkbCu.getTietBD()+"'";
            qry+= " AND tietKetThuc= '"+tkbCu.getTietKT()+"'";
            qry+= " AND thu= '"+tkbCu.getThu()+"'";
            
            int st = connect.executeUpdate(qry);
            connect.Close();
            //JOptionPane.showMessageDialog(null,"Sửa thành công trên csdl");
        }
        catch(Exception e){
            //JOptionPane.showMessageDialog(null,"Lỗi không sửa được trên csdl.");
        }
    }
  
    public void report(){
        String link="src//QLHS//report2.jrxml";
        try {            
            Class.forName("com.mysql.jdbc.Driver");
            String database="jdbc:mysql://localhost:3306/truong_hoc";
            String us="root";
            String pass="";
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

