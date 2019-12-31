/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlytruonghocver2;

import GraphicUserInterface.MainFrame;
import java.util.Scanner;
import javax.swing.JFrame;

/**
 * Muc dich: quan ly truong hoc
 * @author Le Nguyen Minh Huy
 * Version: 2.0
 */
public class QuanLyTruongHocVer2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //MainFrame f = new MainFrame();
        //f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //f.setVisible(true);
        Scanner sc = new Scanner(System.in);
        String chuoiDauVao;
        int i = 0;
        while (true){
            System.out.print("Nhập chuỗi đầu vào: ");
            chuoiDauVao = sc.nextLine();
            //chuoiDauVao = "huy  le";
            System.out.println(chuanHoa(chuoiDauVao));
            //chuanHoa(chuoiDauVao);
            if (i == 10)
                break;
            i++;
        }
        
    }
    
    public static String chuanHoa(String chuoiDauVao) {
        String chuoiBoKhoangTrang = chuoiDauVao.trim();
        String[] arr = chuoiBoKhoangTrang.split(" ");
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < arr.length; i++) {
            //System.out.println(arr[i]);
            if (arr[i].equals(""))
                continue;
            //if (!arr[i].equals("")){
                //System.out.println(arr[i]);
                sb.append(Character.toUpperCase(arr[i].charAt(0))).append(arr[i].substring(1)).append(" ");
            //}
        }
        return sb.toString().trim();
    }
    
}
