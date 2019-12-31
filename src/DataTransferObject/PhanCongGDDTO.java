/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataTransferObject;

import java.util.ArrayList;

/**
 *
 * @author QuyenNguyen
 */
public class PhanCongGDDTO {
    private HocKyDTO hocKy;
    private NamHocDTO namHoc;
    private LopDTO lop;
    private GiaoVienDTO giaoVien;
    private MonHocDTO monHoc;
    
    public PhanCongGDDTO(){}
    
    public NamHocDTO getNamHoc() {
        return namHoc;
    }

    public void setHocKy(HocKyDTO hocKy) {
        this.hocKy = hocKy;
    }
    
    public void setHocKy(ArrayList<HocKyDTO> dshk,String mahk) {
        for (HocKyDTO hk : dshk)
            if (hk.getMahk().equalsIgnoreCase(mahk)){
                this.hocKy = hk;
                break;
            }
    }
    
    public HocKyDTO getHocKy() {
        return hocKy;
    }

    public void setNamHoc(NamHocDTO namHoc) {
        this.namHoc = namHoc;
    }
    
    public void setNamHoc(ArrayList<NamHocDTO> dsnh,String manh) {
        for (NamHocDTO nh : dsnh)
            if (nh.getManh().equalsIgnoreCase(manh)){
                this.namHoc = nh;
                break;
            }
    }

    public LopDTO getLop() {
        return lop;
    }

    public void setLop(LopDTO lop) {
        this.lop = lop;
    }
    
    public void setLop(ArrayList<LopDTO> dslop,String malop) {
        for (LopDTO lop : dslop)
            if (lop.getMalop().equalsIgnoreCase(malop)){
                this.lop = lop;
                break;
            }
    }

    public GiaoVienDTO getGiaoVien() {
        return giaoVien;
    }

    public void setGiaoVien(GiaoVienDTO giaoVien) {
        this.giaoVien = giaoVien;
    }
    
    public void setGiaoVien(ArrayList<GiaoVienDTO> dsgv,String magv) {
        for (GiaoVienDTO gv : dsgv)
            if (gv.getMagv().equalsIgnoreCase(magv)){
                this.giaoVien = gv;
                break;
            }
    }

    public MonHocDTO getMonHoc() {
        return monHoc;
    }

    public void setMonHoc(MonHocDTO monHoc) {
        this.monHoc = monHoc;
    }
    public void setMonHoc(ArrayList<MonHocDTO> dsmh,String mamh) {
        for (MonHocDTO mh : dsmh)
            if (mh.getMamh().equalsIgnoreCase(mamh)){
                this.monHoc = mh;
                break;
            }
    }
}
