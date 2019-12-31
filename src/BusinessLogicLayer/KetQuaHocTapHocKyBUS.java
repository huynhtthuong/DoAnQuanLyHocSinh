/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogicLayer;

import DataAccessObject.KetQuaHocTapHocKiDAO;
import DataTransferObject.HocKyDTO;
import DataTransferObject.HocSinhDTO;
import DataTransferObject.KetQuaHocTapHocKiDTO;
import DataTransferObject.NamHocDTO;
import java.util.ArrayList;

/**
 *
 * @author mr932
 */
public class KetQuaHocTapHocKyBUS {

    private static ArrayList<KetQuaHocTapHocKiDTO> dskqhthk;
    //private KetQuaHocTapHocKiDAO kqhthkDao;

    public ArrayList<KetQuaHocTapHocKiDTO> getDskqhthk() {
        return dskqhthk;
    }

    public void setDskqhthk(ArrayList<KetQuaHocTapHocKiDTO> dskqhthk) {
        KetQuaHocTapHocKyBUS.dskqhthk = dskqhthk;
    }

    public KetQuaHocTapHocKyBUS() {
        //kqhthkDao = new KetQuaHocTapHocKiDAO();
    }

    public void doc(ArrayList<HocSinhDTO> dshs, ArrayList<HocKyDTO> dshk, ArrayList<NamHocDTO> dsnh) {
        KetQuaHocTapHocKiDAO kqhthkDao = new KetQuaHocTapHocKiDAO();
        if (dskqhthk == null) {
            dskqhthk = new ArrayList<KetQuaHocTapHocKiDTO>();
        }
        dskqhthk = kqhthkDao.doc(dshs, dshk, dsnh);
    }

    public void them(KetQuaHocTapHocKiDTO kqhthkDTO) throws Exception {
        if (timKiemKqhthk(kqhthkDTO) == null) {
            KetQuaHocTapHocKiDAO kqhthkDao = new KetQuaHocTapHocKiDAO();
            dskqhthk.add(kqhthkDTO);
            kqhthkDao.them(kqhthkDTO);
        }
    }

    public void sua(KetQuaHocTapHocKiDTO kqhthkCanSua) throws Exception {
        KetQuaHocTapHocKiDTO kqhthk = timKiemKqhthk(kqhthkCanSua);
        if (kqhthk != null) {
            KetQuaHocTapHocKiDAO kqhthkDao = new KetQuaHocTapHocKiDAO();
            kqhthk.setTbcHocky(kqhthkCanSua.getTbcHocky());
            kqhthk.setHanhKiem(kqhthkCanSua.getHanhKiem());
            kqhthkDao.sua(kqhthkCanSua);
        }
    }

    public void xoa(KetQuaHocTapHocKiDTO kqhthkCanXoa) throws Exception {
        KetQuaHocTapHocKiDTO trung = timKiemKqhthk(kqhthkCanXoa);
        if (trung != null) {
            KetQuaHocTapHocKiDAO kqhthkDao = new KetQuaHocTapHocKiDAO();
            dskqhthk.remove(trung);
            kqhthkDao.xoa(trung);
        }
    }

    // Các loại tìm kiếm và tính toán nằm ở đây.
    
    // Đặc biệt dùng cho hàm sửa và xóa bên trên (Hay còn gọi là hàm kiểm tra tồn tại)
    public KetQuaHocTapHocKiDTO timKiemKqhthk(KetQuaHocTapHocKiDTO kqhthkDTO) {
        for (KetQuaHocTapHocKiDTO kqhthk : dskqhthk) {
            if (kqhthk.getHocSinh().equals(kqhthkDTO.getHocSinh())
                    && kqhthk.getHocKy().equals(kqhthkDTO.getHocKy())
                    && kqhthk.getNamHoc().equals(kqhthkDTO.getNamHoc())) {
                return kqhthk;
            }
        }
        return null;
    }
    
    // Đặc biệt dùng trên GUI
    public KetQuaHocTapHocKiDTO timKiemKqhthk(String maHs, String hk, String nh) {
        for (KetQuaHocTapHocKiDTO kqhthk : dskqhthk) {
            if (kqhthk.getHocSinh().getMahs().equals(maHs)
                    && (kqhthk.getHocKy().getMahk().equals(hk) || kqhthk.getHocKy().getTenhk().equals(hk))
                    && (kqhthk.getNamHoc().getManh().equals(nh) || kqhthk.getNamHoc().getTennh().equals(nh))) {
                return kqhthk;
            }
        }
        return null;
    }
    
    public KetQuaHocTapHocKiDTO timKiemKqhthk(HocSinhDTO hs, HocKyDTO hk, NamHocDTO nh) {
        for (KetQuaHocTapHocKiDTO kqhthk : dskqhthk) {
            if (kqhthk.getHocSinh().equals(hs)
                    && kqhthk.getHocKy().equals(hk)
                    && kqhthk.getNamHoc().equals(nh)) {
                return kqhthk;
            }
        }
        return null;
    }
    
    public ArrayList<KetQuaHocTapHocKiDTO> timKiemTheoHocSinh(KetQuaHocTapHocKiDTO kqhthkDTO){
        ArrayList<KetQuaHocTapHocKiDTO> dsKetQua = new ArrayList<KetQuaHocTapHocKiDTO>();
        for (KetQuaHocTapHocKiDTO kqhthk : dskqhthk) {
            if (kqhthk.getHocSinh().equals(kqhthkDTO.getHocSinh())){
                dsKetQua.add(kqhthk);
            }
        }
        return dsKetQua;
    }
    
    public ArrayList<KetQuaHocTapHocKiDTO> timKiemTheoHocKy(KetQuaHocTapHocKiDTO kqhthkDTO){
        ArrayList<KetQuaHocTapHocKiDTO> dsKetQua = new ArrayList<KetQuaHocTapHocKiDTO>();
        for (KetQuaHocTapHocKiDTO kqhthk : dskqhthk) {
            if (kqhthk.getHocKy().equals(kqhthkDTO.getHocKy())){
                dsKetQua.add(kqhthk);
            }
        }
        return dsKetQua;
    }
    
    public ArrayList<KetQuaHocTapHocKiDTO> timKiemTheoNamHoc(KetQuaHocTapHocKiDTO kqhthkDTO){
        ArrayList<KetQuaHocTapHocKiDTO> dsKetQua = new ArrayList<KetQuaHocTapHocKiDTO>();
        for (KetQuaHocTapHocKiDTO kqhthk : dskqhthk) {
            if (kqhthk.getNamHoc().equals(kqhthkDTO.getNamHoc())){
                dsKetQua.add(kqhthk);
            }
        }
        return dsKetQua;
    }
    
    public ArrayList<KetQuaHocTapHocKiDTO> timKiemTheoDiem(KetQuaHocTapHocKiDTO kqhthkDTO){
        ArrayList<KetQuaHocTapHocKiDTO> dsKetQua = new ArrayList<KetQuaHocTapHocKiDTO>();
        for (KetQuaHocTapHocKiDTO kqhthk : dskqhthk) {
            if (kqhthk.getTbcHocky() == kqhthkDTO.getTbcHocky()){
                dsKetQua.add(kqhthk);
            }
        }
        return dsKetQua;
    }
    
    public ArrayList<KetQuaHocTapHocKiDTO> timKiemTheoHanhKiem(KetQuaHocTapHocKiDTO kqhthkDTO){
        ArrayList<KetQuaHocTapHocKiDTO> dsKetQua = new ArrayList<KetQuaHocTapHocKiDTO>();
        for (KetQuaHocTapHocKiDTO kqhthk : dskqhthk) {
            if (kqhthk.getHanhKiem().equals(kqhthkDTO.getHanhKiem())){
                dsKetQua.add(kqhthk);
            }
        }
        return dsKetQua;
    }
    
    
    
    public ArrayList<KetQuaHocTapHocKiDTO> timKiemTheoMaHocSinh(String maHs, ArrayList<KetQuaHocTapHocKiDTO> dskqhthk){
        ArrayList<KetQuaHocTapHocKiDTO> dsKetQua = new ArrayList<KetQuaHocTapHocKiDTO>();
        for (KetQuaHocTapHocKiDTO kqhthk : dskqhthk) {
            if (kqhthk.getHocSinh().getMahs().equals(maHs)){
                dsKetQua.add(kqhthk);
            }
        }
        return dsKetQua;
    }
    
    public ArrayList<KetQuaHocTapHocKiDTO> timKiemTheoHoHocSinh(String hoHs, ArrayList<KetQuaHocTapHocKiDTO> dskqhthk){
        ArrayList<KetQuaHocTapHocKiDTO> dsKetQua = new ArrayList<KetQuaHocTapHocKiDTO>();
        for (KetQuaHocTapHocKiDTO kqhthk : dskqhthk) {
            if (kqhthk.getHocSinh().getHo().indexOf(hoHs) != -1){
                dsKetQua.add(kqhthk);
            }
        }
        return dsKetQua;
    }
    
    public ArrayList<KetQuaHocTapHocKiDTO> timKiemTheoTenHocSinh(String tenHs, ArrayList<KetQuaHocTapHocKiDTO> dskqhthk){
        ArrayList<KetQuaHocTapHocKiDTO> dsKetQua = new ArrayList<KetQuaHocTapHocKiDTO>();
        for (KetQuaHocTapHocKiDTO kqhthk : dskqhthk) {
            if (kqhthk.getHocSinh().getTen().indexOf(tenHs) != -1){
                dsKetQua.add(kqhthk);
            }
        }
        return dsKetQua;
    }
    
    public ArrayList<KetQuaHocTapHocKiDTO> timKiemTheoHocKy(String hocKy, ArrayList<KetQuaHocTapHocKiDTO> dskqhthk){
        ArrayList<KetQuaHocTapHocKiDTO> dsKetQua = new ArrayList<KetQuaHocTapHocKiDTO>();
        for (KetQuaHocTapHocKiDTO kqhthk : dskqhthk) {
            if (kqhthk.getHocKy().getMahk().equals(hocKy) || kqhthk.getHocKy().getTenhk().equals(hocKy)){
                dsKetQua.add(kqhthk);
            }
        }
        return dsKetQua;
    }
    
    public ArrayList<KetQuaHocTapHocKiDTO> timKiemTheoNamHoc(String namHoc, ArrayList<KetQuaHocTapHocKiDTO> dskqhthk){
        ArrayList<KetQuaHocTapHocKiDTO> dsKetQua = new ArrayList<KetQuaHocTapHocKiDTO>();
        for (KetQuaHocTapHocKiDTO kqhthk : dskqhthk) {
            if (kqhthk.getNamHoc().getManh().equals(namHoc) || kqhthk.getNamHoc().getTennh().equals(namHoc)){
                dsKetQua.add(kqhthk);
            }
        }
        return dsKetQua;
    }
    
    public ArrayList<KetQuaHocTapHocKiDTO> timKiemDiemNhoHon(float diemTbHk, ArrayList<KetQuaHocTapHocKiDTO> dskqhthk){
        ArrayList<KetQuaHocTapHocKiDTO> dsKetQua = new ArrayList<KetQuaHocTapHocKiDTO>();
        for (KetQuaHocTapHocKiDTO kqhthk : dskqhthk) {
            if (kqhthk.getTbcHocky() < diemTbHk){
                dsKetQua.add(kqhthk);
            }
        }
        return dsKetQua;
    }
    
    public ArrayList<KetQuaHocTapHocKiDTO> timKiemDiem(float diemTbHk, ArrayList<KetQuaHocTapHocKiDTO> dskqhthk){
        ArrayList<KetQuaHocTapHocKiDTO> dsKetQua = new ArrayList<KetQuaHocTapHocKiDTO>();
        for (KetQuaHocTapHocKiDTO kqhthk : dskqhthk) {
            if (kqhthk.getTbcHocky() == diemTbHk){
                dsKetQua.add(kqhthk);
            }
        }
        return dsKetQua;
    }
    
    public ArrayList<KetQuaHocTapHocKiDTO> timKiemDiemLonHon(float diemTbHk, ArrayList<KetQuaHocTapHocKiDTO> dskqhthk){
        ArrayList<KetQuaHocTapHocKiDTO> dsKetQua = new ArrayList<KetQuaHocTapHocKiDTO>();
        for (KetQuaHocTapHocKiDTO kqhthk : dskqhthk) {
            if (kqhthk.getTbcHocky() > diemTbHk){
                dsKetQua.add(kqhthk);
            }
        }
        return dsKetQua;
    }
    
    public ArrayList<KetQuaHocTapHocKiDTO> timKiemTheoHanhKiem(String hanhKiem, ArrayList<KetQuaHocTapHocKiDTO> dskqhthk){
        ArrayList<KetQuaHocTapHocKiDTO> dsKetQua = new ArrayList<KetQuaHocTapHocKiDTO>();
        for (KetQuaHocTapHocKiDTO kqhthk : dskqhthk) {
            if (kqhthk.getHanhKiem().equals(hanhKiem)){
                dsKetQua.add(kqhthk);
            }
        }
        return dsKetQua;
    }
    
    public void tinhDtbHocKy() throws Exception{
        DiemHocKiBUS dsdhkBus = new DiemHocKiBUS();
        KetQuaHocTapHocKiDAO kqhthkDao = new KetQuaHocTapHocKiDAO();
        for (KetQuaHocTapHocKiDTO kq : dskqhthk){
            //if (kq.getTbcHocky() == 0) {
                HocSinhDTO hs = kq.getHocSinh();
                HocKyDTO hk = kq.getHocKy();
                NamHocDTO nh = kq.getNamHoc();
                float diemTbHk = dsdhkBus.tinhDiemTbHk(hs, hk, nh);
                diemTbHk = (float) Math.round(diemTbHk * 100)/100;
                kq.setTbcHocky(diemTbHk);
                kqhthkDao.sua(kq);
            //}
        }
    }
}
