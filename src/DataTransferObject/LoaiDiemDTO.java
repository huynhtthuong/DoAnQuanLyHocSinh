/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataTransferObject;


public class LoaiDiemDTO {
    private String maLoaiDiem;
    private String tenLoaiDiem;
    private float heSo;
    
    //constructor
    public LoaiDiemDTO(){}
    public LoaiDiemDTO(String maLoaiDiem, String tenLoaiDiem, float heSo){
        this.maLoaiDiem = maLoaiDiem;
        this.tenLoaiDiem = tenLoaiDiem;
        this.heSo = heSo;
    }
    public LoaiDiemDTO(LoaiDiemDTO ld){
        maLoaiDiem = ld.maLoaiDiem;
        tenLoaiDiem = ld.tenLoaiDiem;
        heSo = ld.heSo;
    }

    public String getMaLoaiDiem() {
        return maLoaiDiem;
    }

    public void setMaLoaiDiem(String maLoaiDiem) {
        this.maLoaiDiem = maLoaiDiem;
    }

    public String getTenLoaiDiem() {
        return tenLoaiDiem;
    }

    public void setTenLoaiDiem(String tenLoaiDiem) {
        this.tenLoaiDiem = tenLoaiDiem;
    }

    public float getHeSo() {
        return heSo;
    }

    public void setHeSo(float heSo) {
        this.heSo = heSo;
    }

}
