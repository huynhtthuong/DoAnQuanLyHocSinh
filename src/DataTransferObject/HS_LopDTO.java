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
public class HS_LopDTO {
    private HocSinhDTO hs;
    private LopDTO lop;
    private HocKyDTO hk;
    private NamHocDTO nh;
    
    public HS_LopDTO(){}

    public HocSinhDTO getHs() {
        return hs;
    }
    
    public LopDTO getLop() {
        return lop;
    }
    
    public void setHs(HocSinhDTO hs) {
        this.hs = hs;
    }    

    public void setLop(LopDTO lop) {
        this.lop = lop;
    }
    
   

    public HocKyDTO getHk() {
        return hk;
    }

    public void setHk(HocKyDTO hk) {
        this.hk = hk;
    }
    
    

    public NamHocDTO getNh() {
        return nh;
    }

    public void setNh(NamHocDTO nh) {
        this.nh = nh;
    }
    
    
    
}

