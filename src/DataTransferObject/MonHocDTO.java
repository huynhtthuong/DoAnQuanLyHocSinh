/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataTransferObject;


public class MonHocDTO {
    
private String mamh;
    private String tenmh;
    private float heso;
    public MonHocDTO(){}
    public MonHocDTO(String mamh, String tenmh, float heso){
        this.mamh = mamh;
        this.tenmh = tenmh;
        this.heso = heso;
            
    }
    public MonHocDTO(MonHocDTO mh){
        mamh = mh.mamh;
        tenmh = mh.tenmh;
        heso = mh.heso;
        
    }

    public String getMamh() {
        return mamh;
    }

    public void setMamh(String mamh) {
        this.mamh = mamh;
    }

    public String getTenmh() {
        return tenmh;
    }

    public void setTenmh(String tenmh) {
        this.tenmh = tenmh;
    }

    public float getHeso() {
        return heso;
    }

    public void setHeso(float heso) {
        this.heso = heso;
    }
    
}

