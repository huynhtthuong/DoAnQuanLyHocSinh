/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataTransferObject;

import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class HocBaCuoiNamDTO {
    private HocSinhDTO hocSinh;
    private NamHocDTO namHoc;
    private float dtbCn;
    private String xepLoai;
    private String hocLuc;
    private String hanhKiem;
    
    public HocBaCuoiNamDTO() {}

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


    public String getXepLoai() {
        return xepLoai;
    }

    public void setXepLoai(String xepLoai) {
        this.xepLoai = xepLoai;
    }

    public String getHocLuc() {
        return hocLuc;
    }

    public void setHocLuc(String hocLuc) {
        this.hocLuc = hocLuc;
    }

    public String getHanhKiem() {
        return hanhKiem;
    }

    public void setHanhKiem(String hanhKiem) {
        this.hanhKiem = hanhKiem;
    }

    public float getDtbCn() {
        return dtbCn;
    }

    public void setDtbCn(float dtbCn) {
        this.dtbCn = dtbCn;
    }
    
}
