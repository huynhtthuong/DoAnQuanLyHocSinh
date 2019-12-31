/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GraphicUserInterface;

import BusinessLogicLayer.DiemBUS;
import BusinessLogicLayer.GiaoVienBUS;
import BusinessLogicLayer.HS_LopBUS;
import BusinessLogicLayer.HocKyBUS;
import BusinessLogicLayer.HocSinhBUS;
import BusinessLogicLayer.LoaiDiemBUS;
import BusinessLogicLayer.LopBUS;
import BusinessLogicLayer.MonHocBUS;
import BusinessLogicLayer.NamHocBUS;
import BusinessLogicLayer.PhongBUS;
import DataTransferObject.DiemDTO;
import DataTransferObject.HS_LopDTO;
import DataTransferObject.NamHocDTO;
import java.util.ArrayList;

/**
 *
 * @author mr932
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        HocSinhBUS hsBus = new HocSinhBUS();
        hsBus.docDSHS();
        
        MonHocBUS mhBus = new MonHocBUS();
        mhBus.docDSMH();
        
        GiaoVienBUS gvBus = new GiaoVienBUS();
        gvBus.docDSGV(mhBus.getDsmh());
        
        LoaiDiemBUS loaiDiemBus = new LoaiDiemBUS();
        loaiDiemBus.docDSLD();
        
        NamHocBUS namHocBus = new NamHocBUS();
        namHocBus.doc();
        
        HocKyBUS hocKyBus = new HocKyBUS();
        hocKyBus.doc();
        
        DiemBUS diemBus = new DiemBUS();
        diemBus.docDSD(hsBus.getDshs(), mhBus.getDsmh(), hocKyBus.getDshk(), namHocBus.getDsnh(), loaiDiemBus.getDsld());
        
        PhongBUS phongBus = new PhongBUS();
        phongBus.doc();
        
        LopBUS lopBus = new LopBUS();
        lopBus.doc(namHocBus.getDsnh(), gvBus.getDsgv(), phongBus.getDsphong());
        
        HS_LopBUS hslopBus = new HS_LopBUS();
        hslopBus.doc(hsBus.getDshs(), lopBus.getDslop(), hocKyBus.getDshk(), namHocBus.getDsnh());
        
        for (DiemDTO diem : diemBus.getDsd()){
            System.out.println(diem.getNamHoc().getTennh());
        }
        for (HS_LopDTO hsl : hslopBus.getDshsl()){
            System.out.println(hsl.getHs().getTen());
            System.out.println(hsl.getLop().getTenlop());
            System.out.println(hsl.getHk().getTenhk());
            System.out.println(hsl.getNh().getTennh());
            System.out.println("##########################");
        }
        
    }
    
}
