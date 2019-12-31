
package BusinessLogicLayer;

import DataAccessObject.LopDAO;
import DataTransferObject.GiaoVienDTO;
import DataTransferObject.LopDTO;
import DataTransferObject.NamHocDTO;
import DataTransferObject.PhongDTO;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author QuyenNguyen
 */
public class LopBUS {
    private static ArrayList<LopDTO> dslop;
    
    public LopBUS(){}

    public ArrayList<LopDTO> getDslop() {
        return dslop;
    }

    public void setDslop(ArrayList<LopDTO> dslop) {
        LopBUS.dslop = dslop;
    }
    
    public ArrayList<String> toStringList(ArrayList<LopDTO> danhSachObject){
        ArrayList<String> dsMa = new ArrayList<String>();
        for (LopDTO object : danhSachObject)
            dsMa.add(object.getMalop());
        return dsMa;
    }
    
    public void doc(ArrayList<NamHocDTO> dsnh,ArrayList<GiaoVienDTO> dsgv,ArrayList<PhongDTO> dsphong){
        LopDAO data = new LopDAO();
        if(dslop==null)
            dslop = new ArrayList<LopDTO>();
        dslop = data.doc(dsnh,dsgv,dsphong);
    }
    public void them(LopDTO lop){
        LopDAO dao=new LopDAO();
        dao.them(lop);
        dslop.add(lop);
    }
    
    public void sua(LopDTO lopCanSua){
        LopDTO trung = kiemTraTrung(lopCanSua);
        if (trung != null){
                LopDAO dao = new LopDAO();
                trung.setMaGVCN(lopCanSua.getMaGVCN());
                trung.setManh(lopCanSua.getNamHoc());
                trung.setMaphong(lopCanSua.getMaphong());
                trung.setTenlop(lopCanSua.getTenlop());
                trung.setSiso(lopCanSua.getSiso());
                dao.sua(trung);
        }
    }
    public void xoa(LopDTO lopCanXoa){
        LopDTO trung = kiemTraTrung(lopCanXoa);
        if (trung != null){
                LopDAO dao = new LopDAO();
                dslop.remove(trung);
                dao.xoa(trung);
        }
    }
    
    public LopDTO kiemTraTrung(LopDTO lopCanKiemTra){
        for (LopDTO l : dslop){
            if (l.getMalop().equals(lopCanKiemTra.getMalop()))
                return l;
        }
        return null;
    }
    // Kiem tra trung
    public LopDTO timKiemMa(String ma){
        for(LopDTO lop:dslop){
            if(lop.getMalop().equals(ma)){
                return lop;
            }
        }
        return null;
    }
    
    public void tinhSiSoToanDsLop(String hocKy){
        HS_LopBUS hslopBus = new HS_LopBUS();
        LopDAO lopDao = new LopDAO();
        for (LopDTO l : dslop){
            int siSo = hslopBus.tinhSiSoLop(l.getMalop(), hocKy, l.getManh().getManh());
            l.setSiso(siSo);
            lopDao.sua(l);
        }
    }
    
    public ArrayList<LopDTO> timKiemMalop(String ma){
        ArrayList<LopDTO> dskq = new ArrayList<LopDTO>();
        for (LopDTO lop : dslop)
            if (lop.getMalop().equals(ma)){
                dskq.add(lop);
                return dskq;
            }
        return null;
    }
    
    public ArrayList<LopDTO> timKiemTen(String ten){
        ArrayList<LopDTO> dskq = new ArrayList<LopDTO>();
        for (LopDTO lop : dskq)
            if (lop.getTenlop().equalsIgnoreCase(ten)){
                dskq.add(lop);
                return dskq;
            }
        return null;        
    }
    public ArrayList<LopDTO> timKiemNamHoc(String manh){
        ArrayList<LopDTO> dskq = new ArrayList<LopDTO>();
        for (LopDTO lop : dskq)
            if (lop.getManh().equals(manh)){
                dskq.add(lop);
                return dskq;
            }
        return null;        
    }
    public ArrayList<LopDTO> timKiemGVCN(String magv){
         ArrayList<LopDTO> dskq = new ArrayList<LopDTO>();
        for (LopDTO lop : dskq)
            if (lop.getMaGVCN().equals(magv)){
                dskq.add(lop);
            }
        return dskq;        
    }
    public boolean kiemTraTrungMa(String ma){
        for (LopDTO lop : dslop){
            if (lop.getMalop().equals(ma)){
                return true;
            }
        }
        return false;
    }
    
    
    
    public ArrayList<LopDTO> timKiemTheoMa(String thongTin, ArrayList<LopDTO> dsl){
        ArrayList<LopDTO> danhSachKqTimDuoc = new ArrayList<>();
        for (LopDTO lop : dsl)
            if (lop.getMalop().equalsIgnoreCase(thongTin))
                danhSachKqTimDuoc.add(lop);
        return danhSachKqTimDuoc;
    }
    
    public ArrayList<LopDTO> timKiemTheoTenLop(String thongTin, ArrayList<LopDTO> dsl){
        ArrayList<LopDTO> danhSachKqTimDuoc = new ArrayList<>();
        for (LopDTO lop : dsl)
            if (lop.getTenlop().equalsIgnoreCase(thongTin))
                danhSachKqTimDuoc.add(lop);
        return danhSachKqTimDuoc;
    }
    
    public ArrayList<LopDTO> timKiemTheoPhong(String thongTin, ArrayList<LopDTO> dsl){
        ArrayList<LopDTO> danhSachKqTimDuoc = new ArrayList<>();
        for (LopDTO lop : dsl)
            if (lop.getMaphong().getMaphong().equalsIgnoreCase(thongTin) || lop.getMaphong().getTenphong().equalsIgnoreCase(thongTin))
                danhSachKqTimDuoc.add(lop);
        return danhSachKqTimDuoc;
    }
    
    public ArrayList<LopDTO> timKiemTheoNamHoc(String thongTin, ArrayList<LopDTO> dsl){
        ArrayList<LopDTO> danhSachKqTimDuoc = new ArrayList<>();
        for (LopDTO lop : dsl)
            if (lop.getManh().getManh().equalsIgnoreCase(thongTin))
                danhSachKqTimDuoc.add(lop);
        return danhSachKqTimDuoc;
    }
    
    public ArrayList<LopDTO> timKiemTheoGVCN(String thongTin, ArrayList<LopDTO> dsl){
        ArrayList<LopDTO> danhSachKqTimDuoc = new ArrayList<>();
        for (LopDTO lop : dsl)
            if (lop.getMaGVCN().getMagv().equalsIgnoreCase(thongTin))
                danhSachKqTimDuoc.add(lop);
        return danhSachKqTimDuoc;
    }
    
     public ArrayList<LopDTO> timKiemSiSoBeHon(int thongTin, ArrayList<LopDTO> dsl){
        ArrayList<LopDTO> danhSachKqTimDuoc = new ArrayList<>();
        for (LopDTO lop : dsl)
            if (lop.getSiso() < thongTin)
                danhSachKqTimDuoc.add(lop);
        return danhSachKqTimDuoc;
    }
    
     public ArrayList<LopDTO> timKiemSiSoLonHon(int thongTin, ArrayList<LopDTO> dsl){
        ArrayList<LopDTO> danhSachKqTimDuoc = new ArrayList<>();
        for (LopDTO lop : dsl)
            if (lop.getSiso() > thongTin)
                danhSachKqTimDuoc.add(lop);
        return danhSachKqTimDuoc;
    }
     
    public ArrayList<LopDTO> timKiemSiSoBangHon(int thongTin, ArrayList<LopDTO> dsl){
        ArrayList<LopDTO> danhSachKqTimDuoc = new ArrayList<>();
        for (LopDTO lop : dsl)
            if (lop.getSiso() == thongTin)
                danhSachKqTimDuoc.add(lop);
        return danhSachKqTimDuoc;
    }
}
