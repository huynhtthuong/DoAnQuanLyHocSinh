/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataTransferObject;


import BusinessLogicLayer.LoaiDiemBUS;
import java.util.ArrayList;

public class DiemDTO implements Comparable<DiemDTO>{
    private HocSinhDTO hocSinh;
    private MonHocDTO monHoc;
    private HocKyDTO hocKy;
    private NamHocDTO namHoc;
    private LoaiDiemDTO loaiDiem;
    private float diemSo;
    
    //constuctors
    public DiemDTO(){}
    public DiemDTO(HocSinhDTO hocSinh, MonHocDTO monHoc, HocKyDTO hocKy, NamHocDTO namHoc, float diemSo){
        this.hocSinh = hocSinh;
        this.monHoc = monHoc;
        this.namHoc = namHoc;
        this.hocKy = hocKy;
        this.loaiDiem = loaiDiem;
        this.diemSo = diemSo;
    }
    
    public DiemDTO(DiemDTO d){
        hocSinh = d.hocSinh;
        monHoc = d.monHoc;
        namHoc = d.namHoc;
        hocKy = d.hocKy;
        loaiDiem = d.loaiDiem;
        diemSo = d.diemSo;
    }

    public HocSinhDTO getHocSinh() {
        return hocSinh;
    }

    public void setHocSinh(HocSinhDTO hocSinh) {
        this.hocSinh = hocSinh;
    }

    public MonHocDTO getMonHoc() {
        return monHoc;
    }

    public void setMonHoc(MonHocDTO monHoc) {
        this.monHoc = monHoc;
    }

    public NamHocDTO getNamHoc() {
        return namHoc;
    }

    public void setNamHoc(NamHocDTO namHoc) {
        this.namHoc = namHoc;
    }

    public HocKyDTO getHocKy() {
        return hocKy;
    }

    public void setHocKy(HocKyDTO hocKy) {
        this.hocKy = hocKy;
    }

    public LoaiDiemDTO getLoaiDiem() {
        return loaiDiem;
    }

    public void setLoaiDiem(LoaiDiemDTO loaiDiem) {
        this.loaiDiem = loaiDiem;
    }

    public float getDiemSo() {
        return diemSo;
    }

    public void setDiemSo(float diemSo) {
        this.diemSo = diemSo;
    }
    
    public void setHocSinh(ArrayList<HocSinhDTO> dshs, String mahs){
        for(HocSinhDTO hs : dshs)
            if(hs.getMahs().equalsIgnoreCase(mahs)){
                this.hocSinh = hs;
                break;
         }
    }
    
    public String toStringHS(){
        return hocSinh.getTen();
    }
    
    public void setMonHoc(ArrayList<MonHocDTO> dsmh, String mamh){
        for(MonHocDTO mh : dsmh)
            if(mh.getMamh().equalsIgnoreCase(mamh))
            {
                this.monHoc = mh;
                break;
            }
    }
    
    public String toStringMH(){
        return monHoc.getTenmh();
    }
    
    public void setNamHoc(ArrayList<NamHocDTO> dsnh, String manh){
        for(NamHocDTO nh : dsnh)
            if(nh.getManh().equalsIgnoreCase(manh))
            {
                this.namHoc = nh;
                break;
            }
    }
    
    public String toStringNH(){
        return namHoc.getTennh();
    }
    
    public void getHocKy(ArrayList<HocKyDTO> dshk, String mahk){
        for(HocKyDTO hk : dshk)
            if(hk.getMahk().equalsIgnoreCase(mahk))
            {
                this.hocKy = hk;
                break;
            }
        }
    
    public String toStringHK(){
        return hocKy.getTenhk();
    }
    
    public void getLoaiDiem(ArrayList<LoaiDiemDTO> dsld, String maLoaiDiem){
        for(LoaiDiemDTO ld : dsld)
            if(ld.getMaLoaiDiem().equalsIgnoreCase(maLoaiDiem))
            {
                this.loaiDiem = ld;
                break;
            }
    }
    
    public String toStringLD(){
        return loaiDiem.getTenLoaiDiem();
    }

    @Override
    public int compareTo(DiemDTO diem) {
        return (this.getDiemSo() > diem.getDiemSo() ? -1 : 
            (this.getDiemSo() == diem.getDiemSo() ? 0 : 1));
    }
    
    
}