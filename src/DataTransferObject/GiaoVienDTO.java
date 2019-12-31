/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataTransferObject;

import java.util.ArrayList;

/**
 *
 * @author mr932
 */
public class GiaoVienDTO {
    private String magv;
    private String ho;
    private String ten;
    private MonHocDTO monPhuTrach;
    
    public GiaoVienDTO(){}

    public String getMagv() {
        return magv;
    }

    public void setMagv(String magv) {
        this.magv = magv;
    }

    public String getHo() {
        return ho;
    }

    public void setHo(String ho) {
        this.ho = ho;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public MonHocDTO getMonPhuTrach() {
        return monPhuTrach;
    }

    public void setMonPhuTrach(MonHocDTO monPhuTrach) {
        this.monPhuTrach = monPhuTrach;
    }
    
    public void setMonPhuTrach(ArrayList<MonHocDTO> dsmh, String mamh){
        for (MonHocDTO mh : dsmh)
            if (mh.getMamh().equalsIgnoreCase(mamh)){
                this.monPhuTrach = mh;
                break;
            }
    }
    public String toString(){
        return magv;
    }
    
}
