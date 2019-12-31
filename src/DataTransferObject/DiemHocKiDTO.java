/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataTransferObject;

import BusinessLogicLayer.DiemBUS;
import BusinessLogicLayer.LoaiDiemBUS;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class DiemHocKiDTO {
        private HocSinhDTO hocSinh;
        private MonHocDTO monHoc;
        private HocKyDTO hocKy;
        private NamHocDTO namHoc;
        private float tbMonhk;
    public DiemHocKiDTO() {}

    public HocSinhDTO getHocSinh() {
        return hocSinh;
    }

    public void setHocSinh(HocSinhDTO hocSinh) {
        this.hocSinh = hocSinh;
    }
    
    public void setHocSinh(ArrayList<HocSinhDTO> dshs, String mahs){
        for(HocSinhDTO hs : dshs)
            if(hs.getMahs().equalsIgnoreCase(mahs)){
                this.hocSinh = hs;
                break;
         }
    }
    public MonHocDTO getMonHoc() {
        return monHoc;
    }

    public void setMonHoc(MonHocDTO monHoc) {
        this.monHoc = monHoc;
    }
    
    public void setMonHoc(ArrayList<MonHocDTO> dsmh, String mamh){
        for(MonHocDTO mh : dsmh)
            if(mh.getMamh().equalsIgnoreCase(mamh))
            {
                this.monHoc = mh;
                break;
            }
    }

    public HocKyDTO getHocKy() {
        return hocKy;
    }

    public void setHocKy(HocKyDTO hocKy) {
        this.hocKy = hocKy;
    }
    
    public void setHocKy(ArrayList<HocKyDTO> dshk, String mahk){
        for(HocKyDTO hk : dshk)
            if(hk.getMahk().equalsIgnoreCase(mahk))
            {
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
    public void setNamHoc(ArrayList<NamHocDTO> dsnh, String manh){
        for(NamHocDTO nh : dsnh)
            if(nh.getManh().equalsIgnoreCase(manh))
            {
                this.namHoc = nh;
                break;
            }
    }
    
    public float getTbMonhk() {
        return tbMonhk;
    }

    public void setTbMonhk(float tbMonhk) {
        this.tbMonhk = tbMonhk;
    }
    
}
