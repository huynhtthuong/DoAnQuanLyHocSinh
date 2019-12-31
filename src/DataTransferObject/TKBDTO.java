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
public class TKBDTO {
    private HocKyDTO hocKy;
    private NamHocDTO namHoc;
    private MonHocDTO monHoc;
    private GiaoVienDTO giaoVien;
    private int tietBD;
    private int tietKT;
    private LopDTO lop;
    private String thu;
    
    public TKBDTO(){}

    public HocKyDTO getHocKy() {
        return hocKy;
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

    public NamHocDTO getNamHoc() {
        return namHoc;
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

    public int getTietBD() {
        return tietBD;
    }

    public void setTietBD(int tietBD) {
        this.tietBD = tietBD;
    }

    public int getTietKT() {
        return tietKT;
    }

    public void setTietKT(int tietKT) {
        this.tietKT = tietKT;
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

    public String getThu() {
        return thu;
    }

    public void setThu(String thu) {
        this.thu = thu;
    }
    
}
