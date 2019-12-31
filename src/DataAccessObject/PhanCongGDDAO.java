/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccessObject;

import BusinessLogicLayer.PhanCongGDBUS;
import DataTransferObject.GiaoVienDTO;
import DataTransferObject.HocKyDTO;
import DataTransferObject.LopDTO;
import DataTransferObject.MonHocDTO;
import DataTransferObject.NamHocDTO;
import DataTransferObject.PhanCongGDDTO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
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
public class PhanCongGDDAO {
    private SQLconnector connect;
    public PhanCongGDDAO(){
        connect = new SQLconnector();
    }
    public ArrayList doc(ArrayList<HocKyDTO> dshk,ArrayList<NamHocDTO> dsnh,ArrayList<LopDTO> dslop,ArrayList<GiaoVienDTO> dsgv,ArrayList<MonHocDTO> dsmh){
        PhanCongGDBUS pcBus = new PhanCongGDBUS();
        ArrayList dspc = new ArrayList<PhanCongGDDTO>();
        try{
            String qry = "SELECT * FROM phan_cong_giang_day";
            ResultSet rs = connect.executeQuery(qry);
            while(rs.next()){
                PhanCongGDDTO pc = new PhanCongGDDTO();
                pc.setNamHoc(pcBus.timMaNamHoc(dsnh,rs.getString(1)));
                pc.setLop(pcBus.timMalop(dslop,rs.getString(2)));
                pc.setMonHoc(pcBus.timMamh(dsmh,rs.getString(3)));
                pc.setHocKy(pcBus.timMaHocKy(dshk,rs.getString(4)));
                pc.setGiaoVien(pcBus.timMagv(dsgv,rs.getString(5)));
                dspc.add(pc);
            }
            connect.Close();
        }
        catch(Exception e){
            //JOptionPane.showMessageDialog(null,"Lỗi không đọc được.");
        }
        return dspc;
    }
    public void them(PhanCongGDDTO pc){
        try{
            //INSERT INTO phan_cong_giang_day VALUES ('2019','LO102','MH001','1','00001')
            String qry="INSERT INTO phan_cong_giang_day VALUES ('";
            qry+=pc.getNamHoc().getManh()+"','";
            qry+=pc.getLop().getMalop()+"','";
            qry+=pc.getMonHoc().getMamh()+"','";
            qry+=pc.getHocKy().getMahk()+"','";
            qry+=pc.getGiaoVien().getMagv()+"')";
            int st = connect.executeUpdate(qry);
            connect.Close();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,"Lỗi không thêm được vào csdl.");
        }
    }
    public void xoa(PhanCongGDDTO pc){
        try{
            //DELETE FROM phan_cong_giang_day WHERE phan_cong_giang_day.malop= 'LO102' AND phan_cong_giang_day.mahk= '1' AND phan_cong_giang_day.manh= '2019' AND phan_cong_giang_day.magv= '00001'
            String qry= "DELETE FROM phan_cong_giang_day "
                    + " WHERE phan_cong_giang_day.malop= '"+pc.getLop().getMalop()
                    + "' AND phan_cong_giang_day.mahk= '"+pc.getHocKy().getMahk()
                    + "' AND phan_cong_giang_day.manh= '"+pc.getNamHoc().getManh()
                    + "' AND phan_cong_giang_day.mamh= '"+pc.getMonHoc().getMamh()+"'";
            int st = connect.executeUpdate(qry);
            connect.Close();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,"Lỗi không xóa được trên csdl.");
        }
    } 
    public void sua(PhanCongGDDTO pc,PhanCongGDDTO pcCu){
        try{ 
            //UPDATE phan_cong_giang_day SET malop= 'LO111', magv= '00004', mamh= 'MH004', mahk= '1',manh= '2019' WHERE phan_cong_giang_day.malop= 'LO102'  AND phan_cong_giang_day.mamh= 'MH001' AND phan_cong_giang_day.mahk= '1' AND phan_cong_giang_day.manh= '2019'
            String qry = "UPDATE phan_cong_giang_day SET";
            qry+= " malop= '"+pc.getLop().getMalop()+"',";
            qry+= " magv= '"+pc.getGiaoVien().getMagv()+"',";
            qry+= " mamh= '"+pc.getMonHoc().getMamh()+"',";
            qry+= " mahk= '"+pc.getHocKy().getMahk()+"',";
            qry+= " manh= '"+pc.getNamHoc().getManh()+"'";
            qry+= " WHERE phan_cong_giang_day.malop= '"+pcCu.getLop().getMalop()+"'";
            qry+= " AND phan_cong_giang_day.mamh= '"+pcCu.getMonHoc().getMamh()+"'";
            qry+= " AND phan_cong_giang_day.mahk= '"+pcCu.getHocKy().getMahk()+"'";
            qry+= " AND phan_cong_giang_day.manh= '"+pcCu.getNamHoc().getManh()+"'";
            int st = connect.executeUpdate(qry);
            connect.Close();
            JOptionPane.showMessageDialog(null,"Sửa được trên csdl.");
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,"Lỗi không sửa được trên csdl.");
        }
    }
    
    public void report() {
        String link="src//GraphicUserInterface//report3.jrxml";
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
            Logger.getLogger(PhanCongGDDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(PhanCongGDDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PhanCongGDDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

