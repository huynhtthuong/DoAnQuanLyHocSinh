/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogicLayer;

import DataAccessObject.HocBaCuoiNamDAO;
import DataTransferObject.HocBaCuoiNamDTO;
import DataTransferObject.HocSinhDTO;
import DataTransferObject.KetQuaHocTapHocKiDTO;
import DataTransferObject.NamHocDTO;
import java.util.ArrayList;

/**
 *
 * @author mr932
 */
public class HocBaCuoiNamBUS {
    private static ArrayList<HocBaCuoiNamDTO> dshbcn;
    
    public HocBaCuoiNamBUS(){}

    public ArrayList<HocBaCuoiNamDTO> getDshbcn() {
        return dshbcn;
    }

    public void setDshbcn(ArrayList<HocBaCuoiNamDTO> dshbcn) {
        HocBaCuoiNamBUS.dshbcn = dshbcn;
    }
    
    public void them(HocBaCuoiNamDTO hbcnCanThem) throws Exception{
        HocBaCuoiNamDAO hbcnDao = new HocBaCuoiNamDAO();
        hbcnDao.them(hbcnCanThem);
        dshbcn.add(hbcnCanThem);
    }
    
    public void doc(ArrayList<HocSinhDTO> dshs, ArrayList<NamHocDTO> dsnh){
        HocBaCuoiNamDAO hbcnDao = new HocBaCuoiNamDAO();
        if (dshbcn == null)
            dshbcn = new ArrayList<HocBaCuoiNamDTO>();
        dshbcn = hbcnDao.doc(dshs, dsnh);
    }
    
    public void sua(HocBaCuoiNamDTO hbcnCanSua) throws Exception{
        HocBaCuoiNamDTO trung = kiemTraTrung(hbcnCanSua);
        if (trung != null){
            HocBaCuoiNamDAO hbcnDao = new HocBaCuoiNamDAO();
            trung.setDtbCn(hbcnCanSua.getDtbCn());
            trung.setHanhKiem(hbcnCanSua.getHanhKiem());
            trung.setHocLuc(hbcnCanSua.getHocLuc());
            hbcnDao.sua(hbcnCanSua);
        }
    }
    
    public void xoa(HocBaCuoiNamDTO hbcnCanXoa) throws Exception{
        HocBaCuoiNamDTO trung = kiemTraTrung(hbcnCanXoa);
        if (trung != null){
            HocBaCuoiNamDAO hbcnDao = new HocBaCuoiNamDAO();
            dshbcn.remove(hbcnCanXoa);
            hbcnDao.xoa(hbcnCanXoa);
        }
    }
    
    public HocBaCuoiNamDTO kiemTraTrung(HocBaCuoiNamDTO hbcnCanKiem){
        for (HocBaCuoiNamDTO hbcn : dshbcn){
            if (hbcn.getHocSinh().getMahs().equals(hbcnCanKiem.getHocSinh().getMahs()) 
                    && hbcn.getNamHoc().getManh().equals(hbcnCanKiem.getNamHoc().getManh()))
                return hbcn;
        }
        return null;
    }
    
    public void tinhKetQuaHocTap() throws Exception{
        KetQuaHocTapHocKyBUS kqhthkBus = new KetQuaHocTapHocKyBUS();
        HocBaCuoiNamDAO hbcnDao = new HocBaCuoiNamDAO();
        for (HocBaCuoiNamDTO hbcn : dshbcn){
            String hocLuc = "";
            String hanhKiem = "";
            String xepLoai = "";
            int diemHocLuc = 0;
            int diemHanhKiem = 0;
            float dtbHk1 = 0;
            String hanhKiemHk1 = "";
            float dtbHk2 = 0;
            String hanhKiemHk2 = "";
            
            if (kqhthkBus.timKiemKqhthk(hbcn.getHocSinh().getMahs(), "1", hbcn.getNamHoc().getManh()) != null){
                dtbHk1 = kqhthkBus.timKiemKqhthk(hbcn.getHocSinh().getMahs(), "1", hbcn.getNamHoc().getManh()).getTbcHocky();
                hanhKiemHk1 = kqhthkBus.timKiemKqhthk(hbcn.getHocSinh().getMahs(), "1", hbcn.getNamHoc().getManh()).getHanhKiem();
            }
            
            if (kqhthkBus.timKiemKqhthk(hbcn.getHocSinh().getMahs(), "2", hbcn.getNamHoc().getManh()) != null){
                dtbHk2 = kqhthkBus.timKiemKqhthk(hbcn.getHocSinh().getMahs(), "2", hbcn.getNamHoc().getManh()).getTbcHocky();
                hanhKiemHk2 = kqhthkBus.timKiemKqhthk(hbcn.getHocSinh().getMahs(), "2", hbcn.getNamHoc().getManh()).getHanhKiem();
            }
            
            float dtbCn = (dtbHk1 + dtbHk2 * 2) / 3;
            hbcn.setDtbCn(dtbCn);
            
            if (dtbCn >= 8)
                hocLuc = "Tot";
            else if (dtbCn >= 6.5)
                hocLuc = "Kha";
            else if (dtbCn >= 5)
                hocLuc = "Trung Binh";
            else
                hocLuc = "Yeu";
            hbcn.setHocLuc(hocLuc);
            diemHocLuc = chuyenDanhGiaThanhSo(hocLuc);
            
            
            diemHanhKiem = (chuyenDanhGiaThanhSo(hanhKiemHk1) + chuyenDanhGiaThanhSo(hanhKiemHk2)) / 2;
            hanhKiem = chuyenDiemDanhGiaThanhChuoi(diemHanhKiem);
            hbcn.setHanhKiem(hanhKiem);
            
            xepLoai = chuyenDiemDanhGiaThanhChuoi((diemHocLuc + diemHanhKiem) / 2);
            hbcn.setXepLoai(xepLoai);
            
            hbcnDao.sua(hbcn);
        }
    }
    
    private int chuyenDanhGiaThanhSo(String danhGia){
        int diemDanhGia = 0;
        switch (danhGia){
            case "Tot":
                diemDanhGia = 4;
                break;
            case "Kha":
                diemDanhGia = 3;
                break;
            case "Trung Binh":
                diemDanhGia = 2;
                break;
            case "Yeu":
                diemDanhGia = 1;
                break;
            default:
                diemDanhGia = 0;
                break;
        }
        return diemDanhGia;
    }
    
    private String chuyenDiemDanhGiaThanhChuoi(int diemDanhGia){
        String danhGia = "";
        switch (diemDanhGia){
            case 4:
                danhGia = "Tot";
                break;
            case 3:
                danhGia = "Kha";
                break;
            case 2:
                danhGia = "Trung Binh";
                break;
            case 1:
                danhGia = "Yeu";
                break;
            default:
                danhGia = "chưa có đánh giá";
                break;
        }
        return danhGia;
    }
    
    public ArrayList<HocBaCuoiNamDTO> timKiemHocLuc(String hocLuc){
        ArrayList<HocBaCuoiNamDTO> dskq = new ArrayList();
        for (HocBaCuoiNamDTO hbcn : dshbcn){
            if (hbcn.getHocLuc().equals(hocLuc))
                dskq.add(hbcn);
        }
        return dskq;
    }
    
    public ArrayList<HocBaCuoiNamDTO> timKiemHocLuc(String hocLuc, ArrayList<HocBaCuoiNamDTO> dshbcn){
        ArrayList<HocBaCuoiNamDTO> dskq = new ArrayList();
        for (HocBaCuoiNamDTO hbcn : dshbcn){
            if (hbcn.getHocLuc().equals(hocLuc))
                dskq.add(hbcn);
        }
        return dskq;
    }
    
    public ArrayList<HocBaCuoiNamDTO> timKiemHanhKiem(String hanhKiem){
        ArrayList<HocBaCuoiNamDTO> dskq = new ArrayList();
        for (HocBaCuoiNamDTO hbcn : dshbcn){
            if (hbcn.getHanhKiem().equals(hanhKiem))
                dskq.add(hbcn);
        }
        return dskq;
    }
    
    public ArrayList<HocBaCuoiNamDTO> timKiemHanhKiem(String hanhKiem, ArrayList<HocBaCuoiNamDTO> dshbcn){
        ArrayList<HocBaCuoiNamDTO> dskq = new ArrayList();
        for (HocBaCuoiNamDTO hbcn : dshbcn){
            if (hbcn.getHanhKiem().equals(hanhKiem))
                dskq.add(hbcn);
        }
        return dskq;
    }
    
    public ArrayList<HocBaCuoiNamDTO> timKiemXepLoai(String xepLoai){
        ArrayList<HocBaCuoiNamDTO> dskq = new ArrayList();
        for (HocBaCuoiNamDTO hbcn : dshbcn){
            if (hbcn.getXepLoai().equals(xepLoai))
                dskq.add(hbcn);
        }
        return dskq;
    }
    
    public ArrayList<HocBaCuoiNamDTO> timKiemXepLoai(String xepLoai, ArrayList<HocBaCuoiNamDTO> dshbcn){
        ArrayList<HocBaCuoiNamDTO> dskq = new ArrayList();
        for (HocBaCuoiNamDTO hbcn : dshbcn){
            if (hbcn.getXepLoai().equals(xepLoai))
                dskq.add(hbcn);
        }
        return dskq;
    }
}
