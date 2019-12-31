/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogicLayer;

import DataAccessObject.HS_LopDAO;
import DataAccessObject.LopDAO;
import DataTransferObject.HS_LopDTO;
import DataTransferObject.HocKyDTO;
import DataTransferObject.HocSinhDTO;
import DataTransferObject.LopDTO;
import DataTransferObject.NamHocDTO;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author QuyenNguyen
 */
public class HS_LopBUS {
    public static ArrayList<HS_LopDTO> dshsl ;
    public HS_LopBUS(){}
    public void doc(ArrayList<HocSinhDTO> dshs,ArrayList<LopDTO> dslop, ArrayList<HocKyDTO> dshk, ArrayList<NamHocDTO> dsnh){
        HS_LopDAO data = new HS_LopDAO();
        if(dshsl==null)
            dshsl = new ArrayList<HS_LopDTO>();
        dshsl = data.doc(dshs,dslop,dshk,dsnh);
    }

    public ArrayList<HS_LopDTO> getDshsl() {
        return dshsl;
    }

    public void setDshsl(ArrayList<HS_LopDTO> dshsl) {
        HS_LopBUS.dshsl = dshsl;
    }
    public void them(HS_LopDTO hsl){
        dshsl.add(hsl);
        HS_LopDAO dao=new HS_LopDAO();
        
        int siSo = hsl.getLop().getSiso();
        hsl.getLop().setSiso(siSo++);
        
        LopBUS lopBus = new LopBUS();
        lopBus.sua(hsl.getLop());
        
        dao.them(hsl);
    }
    
    public void sua(HS_LopDTO hslCanSua){
        HS_LopDTO trung = kiemTraTrung(hslCanSua);
        if (trung != null){
            HS_LopDAO dao = new HS_LopDAO();
            
            int siSo = trung.getLop().getSiso();
            trung.getLop().setSiso(siSo--);
            LopBUS lopBus = new LopBUS();
            lopBus.sua(trung.getLop());
            
            trung.setLop(hslCanSua.getLop());
            
            siSo = trung.getLop().getSiso();
            trung.getLop().setSiso(siSo++);
            lopBus.sua(trung.getLop());
            
            dao.sua(hslCanSua);
        }
    }
    
    public boolean xoa(HS_LopDTO hslCanXoa){
        HS_LopDTO trung = kiemTraTrung(hslCanXoa);
        if (trung != null){
            HS_LopDAO data =new HS_LopDAO();
            dshsl.remove(trung);
            
            int siSo = trung.getLop().getSiso();
            trung.getLop().setSiso(siSo--);
            LopBUS lopBus = new LopBUS();
            lopBus.sua(trung.getLop());
            
            data.xoa(trung);
            return true;
        }
        return false;
    }
    
    public HS_LopDTO kiemTraTrung(HS_LopDTO hslCanTim){
        for (HS_LopDTO hsl : dshsl){
            if (hsl.getHs().getMahs().equals(hslCanTim.getHs().getMahs())
                    && hsl.getHk().getMahk().equals(hslCanTim.getHk().getMahk()) 
                    && hsl.getNh().getManh().equals(hslCanTim.getNh().getManh())){
                return hsl;
            }
        }
        return null;
    }
    
    // Kiem tra trung
    public HS_LopDTO timHocSinhLop(HS_LopDTO hslCanTim){
        for (HS_LopDTO hsl : dshsl)
            if (hsl.equals(hslCanTim))
                return hsl;
        return null;
    }
    
    // Kiem tra trung
    public HS_LopDTO timHocSinhLop(String mahs, String mahk, String manh){
        for (HS_LopDTO hsl : dshsl){
            if (hsl.getHs().getMahs().equals(mahs)
                    && hsl.getHk().getMahk().equals(mahk) 
                    && hsl.getNh().getManh().equals(manh)){
                return hsl;
            }
        }
        return null;
    }
    
    public HS_LopDTO timHocSinhLop(HocSinhDTO hs, HocKyDTO hk, NamHocDTO nh){
        for (HS_LopDTO hsl : dshsl){
            if (hsl.getHs().getMahs().equals(hs.getMahs())
                    && hsl.getHk().getMahk().equals(hk.getMahk()) 
                    && hsl.getNh().getManh().equals(nh.getManh())){
                return hsl;
            }
        }
        return null;
    }
    
    public ArrayList<HS_LopDTO> timTheoHs(String mahs){
        ArrayList<HS_LopDTO> dskq = new ArrayList<HS_LopDTO>();
        for (HS_LopDTO hsl : dshsl)
            if (hsl.getHs().getMahs().equals(mahs))
                dskq.add(hsl);
        return dskq;      
    }
    public ArrayList<HS_LopDTO> timTheoHs(String mahs, ArrayList<HS_LopDTO> dshsl){
        ArrayList<HS_LopDTO> dskq = new ArrayList<HS_LopDTO>();
        for (HS_LopDTO hsl : dshsl)
            if (hsl.getHs().getMahs().equals(mahs))
                dskq.add(hsl);
        return dskq; 
    }
    
    public ArrayList<HS_LopDTO> timTheoLop(String lop){
        ArrayList<HS_LopDTO> dskq = new ArrayList<HS_LopDTO>();
        for (HS_LopDTO hsl : dshsl)
            if (hsl.getLop().getMalop().equals(lop) || hsl.getLop().getTenlop().equals(lop)){
                dskq.add(hsl);
            }
        return dskq;      
    }
    public ArrayList<HS_LopDTO> timTheoLop(String malop, ArrayList<HS_LopDTO> dshsl){
        ArrayList<HS_LopDTO> dskq = new ArrayList<HS_LopDTO>();
        for (HS_LopDTO hsl : dshsl)
            if (hsl.getLop().getMalop().equals(malop)){
                dskq.add(hsl);
            }
        return dskq;        
    }
    
    public ArrayList<HS_LopDTO> timTheoHocKy(String mahk){
        ArrayList<HS_LopDTO> dskq = new ArrayList<HS_LopDTO>();
        for (HS_LopDTO hsl : dshsl)
            if (hsl.getHk().getMahk().equals(mahk)){
                dskq.add(hsl);
                return dskq;
            }
        return null;        
    }
    public ArrayList<HS_LopDTO> timTheoHocKy(String mahk, ArrayList<HS_LopDTO> dshsl){
        ArrayList<HS_LopDTO> dskq = new ArrayList<HS_LopDTO>();
        for (HS_LopDTO hsl : dshsl)
            if (hsl.getHk().getMahk().equals(mahk)){
                dskq.add(hsl);
                return dskq;
            }
        return null;      
    }
    
    public ArrayList<HS_LopDTO> timTheoNamHoc(String manh){
        ArrayList<HS_LopDTO> dskq = new ArrayList<HS_LopDTO>();
        for (HS_LopDTO hsl : dshsl)
            if (hsl.getNh().getManh().equals(manh)){
                dskq.add(hsl);
                return dskq;
            }
        return null;        
    }
    public ArrayList<HS_LopDTO> timTheoNamHoc(String manh, ArrayList<HS_LopDTO> dshsl){
        ArrayList<HS_LopDTO> dskq = new ArrayList<HS_LopDTO>();
        for (HS_LopDTO hsl : dshsl)
            if (hsl.getNh().getManh().equals(manh)){
                dskq.add(hsl);
                return dskq;
            }
        return null;         
    }
    
    public boolean kiemTraTrungHsLop(HS_LopDTO hslCanKiemTra){
        for (HS_LopDTO hsl : dshsl)
            if (hsl.equals(hslCanKiemTra))
                return true;
        return false;
    }
    
    public int tinhSiSoLop(String maLop, String hocKy, String namHoc){
        int siSo = 0;
        for (HS_LopDTO hslop : dshsl){
            if (hslop.getLop().getMalop().equals(maLop) 
                    && (hslop.getNh().getManh().equals(namHoc) || hslop.getNh().getTennh().equals(namHoc))
                    && (hslop.getHk().getMahk().equals(hocKy) || hslop.getHk().getTenhk().equals(hocKy))){
                siSo++;
            }
        }
        return siSo;
    }
    
    public Boolean hsNayCoDuocPhanLopChua(String maHs, String namHoc){
        for (HS_LopDTO hslop : dshsl){
            if (hslop.getHs().getMahs().equals(maHs) 
                    && (hslop.getNh().getManh().equals(namHoc) || hslop.getNh().getTennh().equals(namHoc))){
                return true;
            }
        }
        return false;
    }
}
