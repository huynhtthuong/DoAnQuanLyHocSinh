/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GraphicUserInterface;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author mr932
 */
public class DangNhapGUI extends javax.swing.JFrame {

    /**
     * Creates new form DangNhapGUI
     */
    public DangNhapGUI() {
        initComponents();
        this.setResizable(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnLogo = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        lbHeader = new javax.swing.JLabel();
        lbFooter = new javax.swing.JLabel();
        pnDangNhap = new javax.swing.JPanel();
        lbDangNhap = new javax.swing.JLabel();
        lbTenTaiKhoan = new javax.swing.JLabel();
        lbMatKhau = new javax.swing.JLabel();
        btDangNhap = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        pssMatKhau = new javax.swing.JPasswordField();
        txTenTaiKhoan = new javax.swing.JTextField();
        btThoat = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnLogo.setBackground(new java.awt.Color(120, 168, 252));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/iconfinder_Education-Filled_1_3672901.png"))); // NOI18N

        lbHeader.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        lbHeader.setText("Trường THPT ABC");

        lbFooter.setText("Phát triển bởi MHTQ Software");

        javax.swing.GroupLayout pnLogoLayout = new javax.swing.GroupLayout(pnLogo);
        pnLogo.setLayout(pnLogoLayout);
        pnLogoLayout.setHorizontalGroup(
            pnLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnLogoLayout.createSequentialGroup()
                .addGroup(pnLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnLogoLayout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(pnLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnLogoLayout.createSequentialGroup()
                                .addComponent(lbHeader, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(8, 8, 8))))
                    .addGroup(pnLogoLayout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(lbFooter)))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        pnLogoLayout.setVerticalGroup(
            pnLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnLogoLayout.createSequentialGroup()
                .addContainerGap(48, Short.MAX_VALUE)
                .addComponent(lbHeader, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(lbFooter)
                .addGap(13, 13, 13))
        );

        getContentPane().add(pnLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 330, 400));

        pnDangNhap.setBackground(new java.awt.Color(23, 35, 51));

        lbDangNhap.setForeground(new java.awt.Color(255, 255, 255));
        lbDangNhap.setText("Đăng nhập");

        lbTenTaiKhoan.setForeground(new java.awt.Color(255, 255, 255));
        lbTenTaiKhoan.setText("TÊN TÀI KHOẢN");

        lbMatKhau.setForeground(new java.awt.Color(255, 255, 255));
        lbMatKhau.setText("MẬT KHẨU");

        btDangNhap.setText("Đăng Nhập");
        btDangNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDangNhapActionPerformed(evt);
            }
        });

        pssMatKhau.setBackground(new java.awt.Color(23, 35, 51));
        pssMatKhau.setForeground(new java.awt.Color(255, 255, 255));
        pssMatKhau.setText("jPasswordField1");

        txTenTaiKhoan.setBackground(new java.awt.Color(23, 35, 51));
        txTenTaiKhoan.setForeground(new java.awt.Color(255, 255, 255));
        txTenTaiKhoan.setText("admin");
        txTenTaiKhoan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txTenTaiKhoanActionPerformed(evt);
            }
        });

        btThoat.setText("Thoát");
        btThoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btThoatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnDangNhapLayout = new javax.swing.GroupLayout(pnDangNhap);
        pnDangNhap.setLayout(pnDangNhapLayout);
        pnDangNhapLayout.setHorizontalGroup(
            pnDangNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnDangNhapLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(pnDangNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbMatKhau)
                    .addComponent(lbTenTaiKhoan)
                    .addComponent(lbDangNhap)
                    .addComponent(pssMatKhau, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txTenTaiKhoan)
                    .addGroup(pnDangNhapLayout.createSequentialGroup()
                        .addComponent(btDangNhap)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btThoat, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSeparator3)
                    .addComponent(jSeparator1))
                .addContainerGap(51, Short.MAX_VALUE))
        );
        pnDangNhapLayout.setVerticalGroup(
            pnDangNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnDangNhapLayout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(lbDangNhap)
                .addGap(42, 42, 42)
                .addComponent(lbTenTaiKhoan)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txTenTaiKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbMatKhau)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pssMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(pnDangNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btDangNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btThoat, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(59, Short.MAX_VALUE))
        );

        getContentPane().add(pnDangNhap, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 0, 330, 400));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txTenTaiKhoanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txTenTaiKhoanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txTenTaiKhoanActionPerformed

    private void btDangNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDangNhapActionPerformed
        // TODO add your handling code here:
        if (txTenTaiKhoan.getText().equals("admin") && pssMatKhau.getText().equals("admin")){
            MainFrame f = null;
            try {
                f = new MainFrame();
            } catch (Exception ex) {
                Logger.getLogger(DangNhapGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
            f.setVisible(true);
            this.setVisible(false);
        }
        else
            JOptionPane.showMessageDialog(null, "Tên tài khoản và mật khẩu không đúng.");
    }//GEN-LAST:event_btDangNhapActionPerformed

    private void btThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btThoatActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_btThoatActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DangNhapGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DangNhapGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DangNhapGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DangNhapGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DangNhapGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btDangNhap;
    private javax.swing.JButton btThoat;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel lbDangNhap;
    private javax.swing.JLabel lbFooter;
    private javax.swing.JLabel lbHeader;
    private javax.swing.JLabel lbMatKhau;
    private javax.swing.JLabel lbTenTaiKhoan;
    private javax.swing.JPanel pnDangNhap;
    private javax.swing.JPanel pnLogo;
    private javax.swing.JPasswordField pssMatKhau;
    private javax.swing.JTextField txTenTaiKhoan;
    // End of variables declaration//GEN-END:variables
}
