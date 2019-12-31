/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GraphicUserInterface;

import BusinessLogicLayer.DiemBUS;
import BusinessLogicLayer.GiaoVienBUS;
import BusinessLogicLayer.HocKyBUS;
import BusinessLogicLayer.HocSinhBUS;
import BusinessLogicLayer.LoaiDiemBUS;
import BusinessLogicLayer.LopBUS;
import BusinessLogicLayer.MonHocBUS;
import BusinessLogicLayer.NamHocBUS;
import BusinessLogicLayer.PhongBUS;
import DataTransferObject.DiemDTO;
import DataTransferObject.HocSinhDTO;
import DataTransferObject.LopDTO;
import DataTransferObject.MonHocDTO;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTextField;

/**
 *
 * @author mr932
 */
public class TienIch {
    public static ArrayList<DiemDTO> dsKqTruoc = new ArrayList<>();
    public static String transfer;
    HocSinhBUS hsBus = new HocSinhBUS();
    GiaoVienBUS gvBus = new GiaoVienBUS();
    LopBUS lopBus = new LopBUS();
    MonHocBUS mhBus = new MonHocBUS();
    NamHocBUS nhBus = new NamHocBUS();
    HocKyBUS hkBus = new HocKyBUS();
    LoaiDiemBUS ldBus = new LoaiDiemBUS();
    PhongBUS phongBus = new PhongBUS();
    
    
    public static void resetTextField(JTextField[] danhSachTextField) {
        for (int i = 0; i < danhSachTextField.length; i++){
            danhSachTextField[i].setText("");
        }
        danhSachTextField[0].requestFocus();
    }


    public static String kiemTraDauVao(JTextField textField,int kyTuToiDaCuaTextField) {
        String thongBao = "";
        if (textField.getText().length() > kyTuToiDaCuaTextField) {
            thongBao = "Tối đa 45 ký tự." ;
        } else if (chuanHoa(textField.getText()).equals("")) {
            thongBao = "Không được bỏ trống." ;
        } else {
            thongBao = "";
        }
        return thongBao;
    }

    public static String chuanHoa(String chuoiDauVao) {
        String chuoiBoKhoangTrang = chuoiDauVao.trim();
        String[] arr = chuoiBoKhoangTrang.split(" ");
        //StringBuffer sb = new StringBuffer();
        String outputString = "";
        for (int i = 0; i < arr.length; i++) {
            //System.out.println(arr[i]);
            if (arr[i].equals("")) {
                continue;
            }
            //if (!arr[i].equals("")){
            //System.out.println(arr[i]);
            //sb.append(Character.toUpperCase(arr[i].charAt(0))).append(arr[i].substring(1)).append(" ");
            outputString += Character.toUpperCase(arr[i].charAt(0)) + arr[i].substring(1) + " ";
            //}
        }
        return outputString.trim();
        //return sb.toString().trim();
    }
    
    public static void duaGiaTriVaoCbx(JComboBox cbx, ArrayList<String> dsThuocTinh){
        Vector dsGiaTri = new Vector();
        dsGiaTri.add("");
        for (String o : dsThuocTinh){
            dsGiaTri.add(o);
        }
        DefaultComboBoxModel cbxModel = new DefaultComboBoxModel(dsGiaTri);
        cbx.setModel(cbxModel);
    }
    
    public static boolean isStringFloat(String s)
    {
        try
        {
            Float.parseFloat(s);
            return true;
        } catch (NumberFormatException ex){
            return false;
        }
    }
    
    public static boolean isStringInt(String s)
    {
        try
        {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException ex){
            return false;
        }
    }
}
