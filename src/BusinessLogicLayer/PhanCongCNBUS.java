/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogicLayer;

import DataAccessObject.PhanCongCNDAO;
import DataTransferObject.GiaoVienDTO;
import DataTransferObject.LopDTO;
import DataTransferObject.NamHocDTO;
import DataTransferObject.PhanCongCNDTO;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author QuyenNguyen
 */
public class PhanCongCNBUS {
    public static ArrayList<PhanCongCNDTO> dspc ;
    public PhanCongCNBUS(){}
    public void doc(ArrayList<NamHocDTO> dsnh,ArrayList<LopDTO> dslop,ArrayList<GiaoVienDTO> dsgv){
        PhanCongCNDAO data = new PhanCongCNDAO();
        if(dspc==null)
            dspc = new ArrayList<PhanCongCNDTO>();
        dspc = data.doc(dsnh,dslop,dsgv);
    }
    public void them(PhanCongCNDTO pc){
        PhanCongCNDAO dao=new PhanCongCNDAO();
        dao.them(pc);
        dspc.add(pc);
        JOptionPane.showMessageDialog(null,"Thêm thành công");
    }
    
    public void sua(PhanCongCNDTO pcCanSua, String malop, String magv){
       PhanCongCNDAO dao = new PhanCongCNDAO();
        for (PhanCongCNDTO pc : dspc){
            if (pc.getLop().getMalop().equals(malop)&& pc.getGiaoVien().equals(magv)){
                dspc.remove(pc);
                break;
            }
        }
        dspc.add(pcCanSua);
        dao.sua(pcCanSua);
    }
    public void xoa(String malop,String magv){
        PhanCongCNDAO data =new PhanCongCNDAO();
        data.xoa(malop,magv);
        for(PhanCongCNDTO pc : dspc){
            if (pc.getGiaoVien().getMagv().equals(magv))
                dspc.remove(pc);
        }
    }
    public ArrayList<PhanCongCNDTO> timKiemNamHoc(String manh){
        ArrayList<PhanCongCNDTO> dskq = new ArrayList<PhanCongCNDTO>();
        for (PhanCongCNDTO pc : dspc)
            if (pc.getNamHoc().getManh().equals(manh)){
                dskq.add(pc);
                return dskq;
            }
        return null;        
    }
    public ArrayList<PhanCongCNDTO> timKiemLop(String malop){
        ArrayList<PhanCongCNDTO> dskq = new ArrayList<PhanCongCNDTO>();
        for (PhanCongCNDTO pc : dspc)
            if (pc.getLop().getMalop().equals(malop)){
                dskq.add(pc);
                return dskq;
            }
        return null;        
    }
    public ArrayList<PhanCongCNDTO> timKiemGV(String magv){
        ArrayList<PhanCongCNDTO> dskq = new ArrayList<PhanCongCNDTO>();
        for (PhanCongCNDTO pc : dspc)
            if (pc.getGiaoVien().getMagv().equals(magv)){
                dskq.add(pc);
                return dskq;
            }
        return null;        
    }
    public boolean kiemTraTrungMa(String malop,String magv){
        for (PhanCongCNDTO pc : dspc){
            if (pc.getLop().getMalop().equals(malop)&& pc.getGiaoVien().getMagv().equals(magv)){
                JOptionPane.showMessageDialog(null,"Giáo viên đã được phân công chủ nhiệm của lớp");
                return true;
            }
        }
        return false;
    }
}

