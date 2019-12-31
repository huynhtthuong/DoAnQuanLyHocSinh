/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccessObject;

import DataTransferObject.HS_LopDTO;
import DataTransferObject.HocKyDTO;
import DataTransferObject.HocSinhDTO;
import DataTransferObject.LopDTO;
import DataTransferObject.NamHocDTO;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author QuyenNguyen
 */
public class HS_LopDAO {
    private SQLconnector connect;
    public HS_LopDAO(){
        connect = new SQLconnector();
    }
    public ArrayList doc(ArrayList<HocSinhDTO> dshs,ArrayList<LopDTO> dslop,ArrayList<HocKyDTO> dshk,ArrayList<NamHocDTO> dsnh){
        ArrayList dshsl = new ArrayList<HS_LopDTO>();
        try{
            String qry = "SELECT * FROM hocsinh_lop";
            ResultSet rs = connect.executeQuery(qry);
            while(rs.next()){
                HS_LopDTO hsl = new HS_LopDTO();
                hsl.setHs(timMahs(dshs, rs.getString(1)));
                hsl.setLop(timMalop(dslop,rs.getString(2)));
                hsl.setHk(timMahk(dshk,rs.getString(3)));
                hsl.setNh(timNamHoc(dsnh, rs.getString(4)));
                dshsl.add(hsl);
            }
            connect.Close();
        }
        catch(Exception e){
            
        }
        return dshsl;
    }
    public void them(HS_LopDTO hsl){
        try{
            String qry="INSERT INTO hocsinh_lop VALUES ('";
            qry+=hsl.getHs().getMahs()+"','";
            qry+=hsl.getLop().getMalop()+"','";
            qry+=hsl.getHk().getMahk()+"','";
            qry+=hsl.getNh().getManh()+"');";
            int st = connect.executeUpdate(qry);
            connect.Close();
        }
        catch(Exception e){
           
        }
    }
    public void xoa(HS_LopDTO hsl){
        try{
            String qry="DELETE FROM hocsinh_lop WHERE hocsinh_lop.mahs= '"+hsl.getHs().getMahs()
                    +"' AND hocsinh_lop.malop= '"+hsl.getLop().getMalop()
                    +"' AND hocsinh_lop.manh= '"+hsl.getNh().getManh()
                    +"' AND hocsinh_lop.mahk= '"+hsl.getHk().getMahk()+"';";
            int st = connect.executeUpdate(qry);
            connect.Close();
        }
        catch(Exception e){
            
        }
    } 
    public void sua(HS_LopDTO hsl){
        try{ 
            String qry = "UPDATE hocsinh_lop SET";
            qry+= " mahk= '"+hsl.getHk().getMahk()+"',";
            qry+= " manh= '"+hsl.getNh().getManh()+"',";
            qry+= " malop= '"+hsl.getLop().getMalop()+"'";
            qry+= " mahs= '"+hsl.getHs().getMahs()+"'";
            qry+= " WHERE hocsinh_lop.mahs= '"+hsl.getHs().getMahs()
                    +"' AND hocsinh_lop.malop= '"+hsl.getLop().getMalop()
                    +"' AND hocsinh_lop.manh= '"+hsl.getNh().getManh()
                    +"' AND hocsinh_lop.mahk= '"+hsl.getHk().getMahk()+"';";
            int st = connect.executeUpdate(qry);
            connect.Close();
        }
        catch(Exception e){
            
        }
    }
    public HocSinhDTO timMahs(ArrayList<HocSinhDTO> dshs, String mahs){
        for (HocSinhDTO hs : dshs)
            if (hs.getMahs().equalsIgnoreCase(mahs))
                return hs;
        return null;
    }
    public LopDTO timMalop(ArrayList<LopDTO> dslop, String malop){
        for (LopDTO lop : dslop)
            if (lop.getMalop().equalsIgnoreCase(malop))
                return lop;
        return null;
    }
    public HocKyDTO timMahk(ArrayList<HocKyDTO> dshk, String mahk){
        for (HocKyDTO hk : dshk)
            if (hk.getMahk().equalsIgnoreCase(mahk))
                return hk;
        return null;
    }
    
    
    public NamHocDTO timNamHoc(ArrayList<NamHocDTO> dsnh, String manh){
       for(NamHocDTO nh : dsnh)
           if(nh.getManh().equalsIgnoreCase(manh))
               return nh;
       return null;
   }
}
