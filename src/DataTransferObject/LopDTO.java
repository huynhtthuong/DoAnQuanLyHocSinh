/*
 * To change this license header, choteose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataTransferObject;

import java.util.ArrayList;

/**
 *
 * @author QuyenNguyen
 */
public class LopDTO {
    private String malop;
    private String tenlop;
    private NamHocDTO manh;
    private GiaoVienDTO maGVCN;
    private int siso;
    private PhongDTO maphong;
    
    public LopDTO(){}

    public String getMalop() {
        return malop;
    }

    public void setMalop(String malop) {
        this.malop = malop;
    }

    public String getTenlop() {
        return tenlop;
    }

    public void setTenlop(String tenlop) {
        this.tenlop = tenlop;
    }

    public NamHocDTO getManh() {
        return manh;
    }

    public void setManh(NamHocDTO manh) {
        this.manh = manh;
    }
    
    public void setManh(ArrayList<NamHocDTO> dsnh,String manh) {
        for (NamHocDTO nh : dsnh)
            if (nh.getManh().equalsIgnoreCase(manh)){
                this.manh = nh;
                break;
            }
    }

    public GiaoVienDTO getMaGVCN() {
        return maGVCN;
    }

    public void setMaGVCN(GiaoVienDTO maGVCN) {
        this.maGVCN = maGVCN;
    }
    
    public void setMaGVCN(ArrayList<GiaoVienDTO> dsgv,String magv) {
        for (GiaoVienDTO gv : dsgv)
            if (gv.getMagv().equalsIgnoreCase(magv)){
                this.maGVCN = gv;
                break;
            }
    }
        
    public int getSiso() {
        return siso;
    }

    public void setSiso(int siso) {
        this.siso = siso;
    }

    public PhongDTO getMaphong() {
        return maphong;
    }

    public void setMaphong(PhongDTO maphong) {
        this.maphong = maphong;
    }
    
    public void setMaPhong(ArrayList<PhongDTO> dsphong,String maphong) {
        for (PhongDTO phong : dsphong)
            if (phong.getMaphong().equalsIgnoreCase(maphong)){
                this.maphong = phong;
                break;
            }
    }
    
    public void setNamHoc(NamHocDTO manh){
        this.manh = manh;
    }
    
    public NamHocDTO getNamHoc(){
        return manh;
    }
}
