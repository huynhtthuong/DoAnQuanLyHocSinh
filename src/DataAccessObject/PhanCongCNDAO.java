/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccessObject;

import DataTransferObject.GiaoVienDTO;
import DataTransferObject.LopDTO;
import DataTransferObject.NamHocDTO;
import DataTransferObject.PhanCongCNDTO;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author QuyenNguyen
 */
public class PhanCongCNDAO {
    private SQLconnector connect;
    public PhanCongCNDAO(){
        connect = new SQLconnector();
    }
    public ArrayList doc(ArrayList<NamHocDTO> dsnh,ArrayList<LopDTO> dslop,ArrayList<GiaoVienDTO> dsgv){
        ArrayList dspc = new ArrayList<PhanCongCNDTO>();
        try{
            String qry = "SELECT * FROM phan_cong_chu_nhiem";
            ResultSet rs = connect.executeQuery(qry);
            while(rs.next()){
                PhanCongCNDTO pc = new PhanCongCNDTO();
                pc.setNamHoc(timMaNamHoc(dsnh,rs.getString(1)));
                pc.setLop(timMalop(dslop,rs.getString(2)));
                pc.setGiaoVien(timMagv(dsgv,rs.getString(3)));
                dspc.add(pc);
            }
            connect.Close();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,"Lỗi không đọc được.");
        }
        return dspc;
    }
    public void them(PhanCongCNDTO pc){
        try{
            String qry="INSERT INTO phan_cong_chu_nhiem VALUES ('";
            qry+=pc.getNamHoc().getManh()+"','";
            qry+=pc.getLop().getMalop()+"','";
            qry+=pc.getGiaoVien().getMagv()+"');";
            int st = connect.executeUpdate(qry);
            connect.Close();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,"Lỗi không thêm được.");
        }
    }
    public void xoa(String malop,String magv){
        try{
            String qry="DELETE FROM phan_cong_chu_nhiem WHERE malop= '"+malop+"' AND phancong_cn.magv= '"+magv+"';";
            int st = connect.executeUpdate(qry);
            connect.Close();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,"Lỗi.");
        }
    } 
    public void sua(PhanCongCNDTO pc){
        try{ 
            String qry = "UPDATE phan_cong_chu_nhiem SET";
            qry+= " manh= '"+pc.getNamHoc().getManh()+"',";
            qry+= " magv= '"+pc.getGiaoVien().getMagv()+"'";
            qry+= " WHERE phan_cong_chu_nhiem.malop= '"+pc.getLop().getMalop()+"';";
            int st = connect.executeUpdate(qry);
            connect.Close();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,"Lỗi không sửa được.");
        }
    }
    public LopDTO timMalop(ArrayList<LopDTO> dslop, String malop){
        for (LopDTO lop : dslop)
            if (lop.getMalop().equalsIgnoreCase(malop))
                return lop;
        return null;
    }
    public NamHocDTO timMaNamHoc(ArrayList<NamHocDTO> dsnh, String manh){
        for (NamHocDTO nh : dsnh)
            if (nh.getManh().equalsIgnoreCase(manh))
                return nh;
        return null;
    }
    public GiaoVienDTO timMagv(ArrayList<GiaoVienDTO> dsgv, String magv){
        for (GiaoVienDTO gv : dsgv)
            if (gv.getMagv().equalsIgnoreCase(magv))
                return gv;
        return null;
    }
}
