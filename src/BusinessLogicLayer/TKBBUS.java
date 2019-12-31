/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogicLayer;

import DataAccessObject.TKBDAO;
import DataTransferObject.GiaoVienDTO;
import DataTransferObject.HocKyDTO;
import DataTransferObject.LopDTO;
import DataTransferObject.MonHocDTO;
import DataTransferObject.NamHocDTO;
import DataTransferObject.PhanCongGDDTO;
import DataTransferObject.TKBDTO;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author QuyenNguyen
 */
public class TKBBUS {
    public static ArrayList<TKBDTO> dstkb ;
    public TKBBUS(){}
    
    public ArrayList<TKBDTO> getDstkb() {
        return dstkb;
    }

    public void setDstkb(ArrayList<TKBDTO> dstkb) {
        this.dstkb = dstkb;
    }
    
    public void doc(ArrayList<HocKyDTO> dshk,ArrayList<NamHocDTO> dsnh,ArrayList<MonHocDTO> dsmh,ArrayList<GiaoVienDTO> dsgv, ArrayList<LopDTO> dslop){
        TKBDAO data = new TKBDAO();
        if(dstkb==null)
            dstkb = new ArrayList<TKBDTO>();
        dstkb = data.doc(dshk,dsnh,dsmh,dsgv,dslop);
    }
    public void them(TKBDTO tkb){
        TKBDAO dao=new TKBDAO();
        dao.them(tkb);
        dstkb.add(tkb);
        JOptionPane.showMessageDialog(null,"Thêm thành công");
    }
    
    public void sua(TKBDTO tkbCanSua, TKBDTO tkbCu){
        TKBDAO dao = new TKBDAO();
        for(TKBDTO tkb: dstkb){
            if(tkb.getLop().getMalop().equals(tkbCu.getLop().getMalop())
                && tkb.getHocKy().getMahk().equals(tkbCu.getHocKy().getMahk())
                && tkb.getNamHoc().getManh().equals(tkbCu.getNamHoc().getManh())
                && tkb.getThu().equals(tkbCu.getThu())
                && tkb.getTietBD()== tkbCu.getTietBD()
                && tkb.getTietKT()== tkbCu.getTietKT())
                    {
                dao.sua(tkbCanSua,tkbCu);
            }
        }
        
        for(int i=0;i<dstkb.size();++i){
            if(dstkb.get(i).getLop().getMalop().equals(tkbCanSua.getLop().getMalop()) 
                    && dstkb.get(i).getHocKy().getMahk().equals(tkbCanSua.getHocKy().getMahk())
                    && dstkb.get(i).getNamHoc().getManh().equals(tkbCanSua.getNamHoc().getManh())
                    && dstkb.get(i).getTietBD()== tkbCanSua.getTietBD()
                    && dstkb.get(i).getTietKT()== tkbCanSua.getTietKT()
                    && dstkb.get(i).getThu()== tkbCanSua.getThu())
                dstkb.set(i,tkbCanSua);       
        }
        JOptionPane.showMessageDialog(null,"Sửa thành công");
    }
    
    public void xoa(TKBDTO tkbCanXoa){
        TKBDAO data =new TKBDAO();
        data.xoa(tkbCanXoa);
        JOptionPane.showMessageDialog(null,"Xóa thành công");
    }
    public ArrayList<TKBDTO> timKiemNamHoc(String manh){
        ArrayList dskq=new ArrayList();
        for(TKBDTO tkb:dstkb)
        {
            if(tkb.getNamHoc().getManh().equals(manh)) 
                    dskq.add(tkb);
     
        }
        return dskq;      
    }
    public ArrayList<TKBDTO> timKiemHocky(String mahk){
        ArrayList dskq=new ArrayList();
        for(TKBDTO tkb:dstkb)
        {
            if(tkb.getHocKy().getMahk().equals(mahk) ) 
                    dskq.add(tkb);
     
        }
        return dskq;      
    }
    public ArrayList<TKBDTO> timKiemLop(String malop){
        ArrayList dskq=new ArrayList();
        for(TKBDTO tkb:dstkb)
        {
            if(tkb.getLop().getMalop().equals(malop)) 
                    dskq.add(tkb);
     
        }
        return dskq;       
    }
    public ArrayList<TKBDTO> timKiemMonHoc(String mamh){
        ArrayList dskq=new ArrayList();
        for(TKBDTO tkb:dstkb)
        {
            if(tkb.getMonHoc().getMamh().equals(mamh)) 
                    dskq.add(tkb);
     
        }
        return dskq;       
    }
    public ArrayList<TKBDTO> timKiemGV(String magv){
        ArrayList dskq=new ArrayList();
        for(TKBDTO tkb:dstkb)
        {
            if(tkb.getGiaoVien().getMagv().equals(magv)) 
                    dskq.add(tkb);
     
        }
        return dskq;       
    }
    public ArrayList<TKBDTO> timKiemThu(String thu){
        ArrayList dskq=new ArrayList();
        for(TKBDTO tkb:dstkb)
        {
            if(tkb.getThu().toUpperCase().equals(thu.toUpperCase())) 
                    dskq.add(tkb);
     
        }
        return dskq;      
    }
    public ArrayList<TKBDTO> timKiemTietBD(String tietBD){
        ArrayList dskq=new ArrayList();
        for(TKBDTO tkb:dstkb)
        {
            if(Integer.toString(tkb.getTietBD()).equals(tietBD)) 
                    dskq.add(tkb);
     
        }
        return dskq;        
    }
    public ArrayList<TKBDTO> timKiemTietKT(String tietKT){
        ArrayList dskq=new ArrayList();
        for(TKBDTO tkb:dstkb)
        {
            if(Integer.toString(tkb.getTietKT()).equals(tietKT)) 
                    dskq.add(tkb);
     
        }
        return dskq;      
    }
    public ArrayList<TKBDTO> timKiemNamHoc(String manh,ArrayList<TKBDTO> dstkb){
        ArrayList dskq=new ArrayList();
        for(TKBDTO tkb:dstkb)
        {
            if(tkb.getNamHoc().getManh().equals(manh)) 
                    dskq.add(tkb);
     
        }
        return dskq;            
    }
    public ArrayList<TKBDTO> timKiemHocky(String mahk,ArrayList<TKBDTO> dstkb){    
        ArrayList dskq=new ArrayList();
        for(TKBDTO tkb:dstkb)
        {
            if(tkb.getHocKy().getMahk().equals(mahk) ) 
                    dskq.add(tkb);
     
        }
        return dskq;
    }
    public ArrayList<TKBDTO> timKiemLop(String malop,ArrayList<TKBDTO> dstkb){
        ArrayList dskq=new ArrayList();
        for(TKBDTO tkb:dstkb)
        {
            if(tkb.getLop().getMalop().equals(malop)) 
                    dskq.add(tkb);
     
        }
        return dskq;    
    }
    public ArrayList<TKBDTO> timKiemGV(String magv,ArrayList<TKBDTO> dstkb){
        ArrayList dskq=new ArrayList();
        for(TKBDTO tkb:dstkb)
        {
            if(tkb.getGiaoVien().getMagv().equals(magv)) 
                    dskq.add(tkb);
     
        }
        return dskq;        
    }
    public ArrayList<TKBDTO> timKiemThu(String thu, ArrayList<TKBDTO> dstkb){
        ArrayList dskq=new ArrayList();
        for(TKBDTO tkb:dstkb)
        {
            if(tkb.getThu().toUpperCase().equals(thu.toUpperCase())) 
                    dskq.add(tkb);
     
        }
        return dskq;        
    }
    public ArrayList<TKBDTO> timKiemTietBD(String tietBD,ArrayList<TKBDTO> dstkb){
        ArrayList dskq=new ArrayList();
        for(TKBDTO tkb:dstkb)
        {
            if(Integer.toString(tkb.getTietBD()).equals(tietBD)) 
                    dskq.add(tkb);
     
        }
        return dskq;            
    }
    public ArrayList<TKBDTO> timKiemMonHoc(String mamh,ArrayList<TKBDTO> dstkb){
        ArrayList dskq=new ArrayList();
        for(TKBDTO tkb:dstkb)
        {
            if(tkb.getMonHoc().getMamh().equals(mamh)) 
                    dskq.add(tkb);
     
        }
        return dskq;        
    }
    public ArrayList<TKBDTO> timKiemTietKT(String tietKT,ArrayList<TKBDTO> dstkb){
        ArrayList dskq=new ArrayList();
        for(TKBDTO tkb:dstkb)
        {
            if(Integer.toString(tkb.getTietKT()).equals(tietKT)) 
                    dskq.add(tkb);
     
        }
        return dskq;
    }
    public ArrayList<TKBDTO> timKiemThu(String thu,String mahk,String manh,String malop,ArrayList<TKBDTO> dskq){
        for (TKBDTO tkb : dstkb)
            if (tkb.getHocKy().getMahk().equals(mahk)&&tkb.getNamHoc().getManh().equals(manh)&&
                    tkb.getThu().equalsIgnoreCase(thu)&&tkb.getLop().getMalop().equals(malop)){
                dskq.add(tkb);
                return dskq;
            }
        return null;
    }
    public ArrayList<TKBDTO> timKiemTietBD(int tietBD,String mahk,String manh,String malop,ArrayList<TKBDTO> dskq){
        for (TKBDTO tkb : dstkb)
            if (tkb.getTietBD()== tietBD&&tkb.getHocKy().getMahk().equals(mahk)&&
                    tkb.getNamHoc().getManh().equals(manh)&&tkb.getLop().getMalop().equals(malop)){
                dskq.add(tkb);
                return dskq;
            }
        return null;
    }
    public ArrayList<TKBDTO> timKiemTietKT(int tietKT,String mahk,String manh,String malop,ArrayList<TKBDTO> dskq){
        for (TKBDTO tkb : dstkb)
            if (tkb.getTietKT()== tietKT&&tkb.getHocKy().getMahk().equals(mahk)&&
                    tkb.getNamHoc().getManh().equals(manh)&&tkb.getLop().getMalop().equals(malop)){
                dskq.add(tkb);
                return dskq;
            }
        return null;
    }
    public ArrayList<TKBDTO> timKiemGV(String magv,String mahk,String manh,String malop,ArrayList<TKBDTO> dskq){
        for (TKBDTO tkb : dstkb)
            if (tkb.getGiaoVien().getMagv().equals(magv)&&tkb.getHocKy().getMahk().equals(mahk)&&
                    tkb.getNamHoc().getManh().equals(manh)&&tkb.getLop().getMalop().equals(malop)){
                dskq.add(tkb);
                return dskq;
            }
        return null;        
    }
    public ArrayList<TKBDTO> timKiemMonhoc(String mamh,String mahk,String manh,String malop,ArrayList<TKBDTO> dskq){
        for (TKBDTO tkb : dstkb)
            if (tkb.getMonHoc().getMamh().equals(mamh)&&tkb.getHocKy().getMahk().equals(mahk)&&
                    tkb.getNamHoc().getManh().equals(manh)&&tkb.getLop().getMalop().equals(malop)){
                dskq.add(tkb);
                return dskq;
            }
        return null;        
    }
    public ArrayList TimKiem(String mahk,String manh,String thu,String mamh,String magv,String malop,String tietbd,String tietkt){
        ArrayList dskq=new ArrayList();
        for(TKBDTO tkb:dstkb)
        {
            if(tkb.getHocKy().getMahk().equals(mahk) && tkb.getNamHoc().getManh().equals(manh) 
                && tkb.getThu().toUpperCase().equals(thu.toUpperCase()) && tkb.getMonHoc().getMamh().equals(mamh)
                && tkb.getGiaoVien().getMagv().indexOf(magv)!=-1 && tkb.getGiaoVien().getMagv().equals(magv)
                && tkb.getTietBD()== Integer.parseInt(tietbd) && tkb.getTietKT()== Integer.parseInt(tietkt) 
                    && tkb.getLop().getMalop().equals(malop)) 
                    dskq.add(tkb);
     
        }
        return dskq;
        
    }
    public boolean kiemTraTrungTiet(String mahk, String manh, String malop, String magv, String thu, int tietBD, int tietKT){
        for (TKBDTO tkb : dstkb){
            if((tietBD <= tietKT)&& tkb.getHocKy().getMahk().equals(mahk) && tkb.getNamHoc().getManh().equals(manh)){
                if((tkb.getGiaoVien().getMagv().equals(magv) && tkb.getThu().equals(thu)) || 
                        (tkb.getLop().getMalop().equals(malop) && tkb.getThu().equals(thu)))
                    if((tietBD >= tkb.getTietBD() && tietBD <= tkb.getTietKT()) || (tietKT >= tkb.getTietBD() && tietKT <= tkb.getTietKT()) )
                    return true;
            }
        }
        return false;
    }


    public void report() {
        TKBDAO dao=new TKBDAO();
        dao.report();
    }
    public String timLopTheoTen(String tenlop){
        String ma = null;
        LopBUS lopBUS = new LopBUS();
        for(LopDTO lop : lopBUS.getDslop())
            if(lop.getTenlop().equals(tenlop))
                ma=lop.getMalop();
        return ma;
    }
    public HocKyDTO timMahk(ArrayList<HocKyDTO> dshk, String mahk){
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

