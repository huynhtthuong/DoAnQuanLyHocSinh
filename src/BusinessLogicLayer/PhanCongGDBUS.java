/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogicLayer;

import DataAccessObject.PhanCongGDDAO;
import DataTransferObject.GiaoVienDTO;
import DataTransferObject.HocKyDTO;
import DataTransferObject.LopDTO;
import DataTransferObject.MonHocDTO;
import DataTransferObject.NamHocDTO;
import DataTransferObject.PhanCongGDDTO;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author QuyenNguyen
 */
public class PhanCongGDBUS {
    public static ArrayList<PhanCongGDDTO> dspc ;
    
    public ArrayList<PhanCongGDDTO> getDspc() {
        return dspc;
    }

    public void setDspc(ArrayList<PhanCongGDDTO> dspc) {
        this.dspc = dspc;
    }
    public PhanCongGDBUS(){}
    public void doc(ArrayList<HocKyDTO> dshk,ArrayList<NamHocDTO> dsnh,ArrayList<LopDTO> dslop,ArrayList<GiaoVienDTO> dsgv,ArrayList<MonHocDTO> dsmh){
        PhanCongGDDAO data = new PhanCongGDDAO();
        if(dspc==null)
            dspc = new ArrayList<PhanCongGDDTO>();
        dspc = data.doc(dshk,dsnh,dslop,dsgv,dsmh);
    }
    public void them(PhanCongGDDTO pcCanThem){
        PhanCongGDDAO dao=new PhanCongGDDAO();
    
            dao.them(pcCanThem);
            dspc.add(pcCanThem);
            JOptionPane.showMessageDialog(null,"Thêm thành công");
    }
    
    public void sua(PhanCongGDDTO pcCanSua,PhanCongGDDTO pcCu){
        PhanCongGDDAO dao = new PhanCongGDDAO();
        for(PhanCongGDDTO pc: dspc){
            if(pc.getLop().getMalop().equals(pcCu.getLop().getMalop())
                && pc.getHocKy().getMahk().equals(pcCu.getHocKy().getMahk())
                && pc.getNamHoc().getManh().equals(pcCu.getNamHoc().getManh())
                && pc.getMonHoc().getMamh().equals(pcCu.getMonHoc().getMamh()))
                    {
                dao.sua(pcCanSua,pcCu);
            }
        }
        
        for(int i=0;i<dspc.size();++i){
            if(dspc.get(i).getLop().getMalop().equals(pcCanSua.getLop().getMalop()) 
                    && dspc.get(i).getHocKy().getMahk().equals(pcCanSua.getHocKy().getMahk())
                    && dspc.get(i).getNamHoc().getManh().equals(pcCanSua.getNamHoc().getManh())
                    && dspc.get(i).getMonHoc().getMamh().equals(pcCanSua.getMonHoc().getMamh()))
                dspc.set(i,pcCanSua);       
        }
        JOptionPane.showMessageDialog(null,"Sửa thành công");
    }
    
    public void xoa(PhanCongGDDTO pcCanXoa){
        PhanCongGDDAO dao =new PhanCongGDDAO();
        dao.xoa(pcCanXoa);
        dspc.remove(pcCanXoa);
        JOptionPane.showMessageDialog(null,"Xóa thành công");
    }
    public ArrayList<PhanCongGDDTO> timKiemNamHoc(String manh){
        ArrayList<PhanCongGDDTO> dskq = new ArrayList<PhanCongGDDTO>();
        for (PhanCongGDDTO pc : dspc)
            if (pc.getNamHoc().getManh().equals(manh)){
                dskq.add(pc);
                return dskq;
            }
        return null;        
    }
    public ArrayList<PhanCongGDDTO> timKiemLop(String malop){
        ArrayList<PhanCongGDDTO> dskq = new ArrayList<PhanCongGDDTO>();
        for (PhanCongGDDTO pc : dspc)
            if (pc.getLop().getMalop().equals(malop)){
                dskq.add(pc);
                return dskq;
            }
        return null;        
    }
    public ArrayList<PhanCongGDDTO> timKiemGV(String magv){
        ArrayList<PhanCongGDDTO> dskq = new ArrayList<PhanCongGDDTO>();
        for (PhanCongGDDTO pc : dspc)
            if (pc.getGiaoVien().getMagv().equals(magv)){
                dskq.add(pc);
                return dskq;
            }
        return null;        
    }
    public ArrayList<PhanCongGDDTO> timKiemMonhoc(String mamh){
        ArrayList<PhanCongGDDTO> dskq = new ArrayList<PhanCongGDDTO>();
        for (PhanCongGDDTO pc : dspc)
            if (pc.getMonHoc().getMamh().equals(mamh)){
                dskq.add(pc);
                return dskq;
            }
        return null;        
    }
    public ArrayList<PhanCongGDDTO> timKiemHocky(String mahk){
        ArrayList<PhanCongGDDTO> dskq = new ArrayList<PhanCongGDDTO>();
        for (PhanCongGDDTO pc : dspc)
            if (pc.getHocKy().getMahk().equals(mahk)){
                dskq.add(pc);
                return dskq;
            }
        return null;        
    }
    public ArrayList<PhanCongGDDTO> timKiemNamhoc(String manh){
        ArrayList<PhanCongGDDTO> dskq = new ArrayList<PhanCongGDDTO>();
        for (PhanCongGDDTO pc : dspc)
            if (pc.getNamHoc().getManh().equals(manh)){
                dskq.add(pc);
                return dskq;
            }
        return null;        
    }
    public boolean kiemTraTrungMa(String malop,String mamh, String manh, String mahk){
        for (PhanCongGDDTO pc : dspc){
                if(pc.getNamHoc().getManh().equals(manh) && pc.getHocKy().getMahk().equals(mahk) )
                    if (pc.getLop().getMalop().equals(malop)&& pc.getMonHoc().getMamh().equals(mamh))
                        return true;
            }
        return false;
    }

    public void report() {
        PhanCongGDDAO dao=new PhanCongGDDAO();
        dao.report();
    }
    public String timMonHocTheoTen(String tenmh){
        String ma = null;
        MonHocBUS mhBUS = new MonHocBUS();
        for(MonHocDTO mh : mhBUS.getDsmh())
            if(mh.getTenmh().equals(tenmh))      
                ma=mh.getMamh();
        return ma;
    }
    public String timMonHocTheoMa(String mamh){
        String ten = null;
        MonHocBUS mhBUS = new MonHocBUS();
        for(MonHocDTO mh : mhBUS.getDsmh())
            if(mh.getMamh().equals(mamh))
                ten=mh.getTenmh();        
        return ten;
    }
    public String timGiaoVienTheoTen(String tengv){
        String ma = null;
        GiaoVienBUS gvBUS = new GiaoVienBUS();
        for(GiaoVienDTO gv : gvBUS.getDsgv())
            if(gv.getTen().equals(tengv))  
                ma=gv.getMagv();
        return ma;
    }
    public String timGiaoVienTheoMa(String magv){
        String ten = null;
        GiaoVienBUS gvBUS = new GiaoVienBUS();
        for(GiaoVienDTO gv : gvBUS.getDsgv())
            if(gv.getMagv().equals(magv))
               ten=gv.getTen();
        return ten;
    }
    public String timLopTheoTen(String tenlop){
        String ma = null;
        LopBUS lopBUS = new LopBUS();
        for(LopDTO lop : lopBUS.getDslop())
            if(lop.getTenlop().equals(tenlop))
                ma=lop.getMalop();
        return ma;
    }
    public String timLopTheoMa(String malop){
        String ten = null;
        LopBUS lopBUS = new LopBUS();
        for(LopDTO lop : lopBUS.getDslop())
            if(lop.getMalop().equals(malop))
                ten=lop.getTenlop();
        return ten;
    }
    public String timNamHocTheoTen(String tennh){
        String ma = null;
        NamHocBUS nhBUS = new NamHocBUS();
        for(NamHocDTO nh : nhBUS.getDsnh()){
            if(nh.getTennh().equals(tennh))
                ma=nh.getManh();       
        }
        return ma;
    }
    public String timNamHocTheoMa(String manh){
        String ten = null;
        NamHocBUS nhBUS = new NamHocBUS();
        for(NamHocDTO nh : nhBUS.getDsnh())
            if(nh.getManh().equals(manh))
                ten=nh.getTennh();       
        return ten;
    }
    public String timHocKyTheoTen(String tenhk){
        String ma = null;
        HocKyBUS hkBUS = new HocKyBUS();
        for(HocKyDTO hk : hkBUS.getDshk()){
            if(hk.getTenhk().equals(tenhk))
                ma=hk.getMahk();        
        }
        return ma;
    }
    public String timHocKyTheoMa(String mahk){
        String ten = null;
        HocKyBUS hkBUS = new HocKyBUS();
        for(HocKyDTO hk : hkBUS.getDshk())
            if(hk.getMahk().equals(mahk))
                ten=hk.getTenhk();
        return ten;
    }
    public HocKyDTO timMaHocKy(ArrayList<HocKyDTO> dshk, String mahk){
        for (HocKyDTO hk : dshk)
            if (hk.getMahk().equalsIgnoreCase(mahk))
                return hk;
        return null;
    }
    public NamHocDTO timMaNamHoc(ArrayList<NamHocDTO> dsnh, String manh){
        for (NamHocDTO nh : dsnh)
            if (nh.getManh().equalsIgnoreCase(manh))
                return nh;
        return null;
    }
    public LopDTO timMalop(ArrayList<LopDTO> dslop, String malop){
        for (LopDTO lop : dslop)
            if (lop.getMalop().equalsIgnoreCase(malop))
                return lop;
        return null;
    }
    public GiaoVienDTO timMagv(ArrayList<GiaoVienDTO> dsgv, String magv){
        for (GiaoVienDTO gv : dsgv)
            if (gv.getMagv().equalsIgnoreCase(magv))
                return gv;
        return null;
    }
    public MonHocDTO timMamh(ArrayList<MonHocDTO> dsmh, String mamh){
        for (MonHocDTO mh : dsmh)
            if (mh.getMamh().equalsIgnoreCase(mamh))
                return mh;
        return null;
    }

}

