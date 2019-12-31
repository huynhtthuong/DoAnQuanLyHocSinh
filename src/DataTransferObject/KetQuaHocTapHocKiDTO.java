/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataTransferObject;

import java.util.ArrayList;

public class KetQuaHocTapHocKiDTO {
    private HocSinhDTO hocSinh;
    private HocKyDTO hocKy;
    private NamHocDTO namHoc;
    private float tbcHocky;
    private String hanhKiem;
    
    public KetQuaHocTapHocKiDTO(){}

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
    
    
    public float getTbcHocky() {
        return tbcHocky;
    }

    public void setTbcHocky(float tbcHocky) {
        this.tbcHocky = tbcHocky;
    }

    public String getHanhKiem() {
        return hanhKiem;
    }

    public void setHanhKiem(String hanhKiem) {
        this.hanhKiem = hanhKiem;
    }
    
    
    
}
