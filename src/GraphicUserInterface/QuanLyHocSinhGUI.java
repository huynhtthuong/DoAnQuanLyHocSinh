/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GraphicUserInterface;

import BusinessLogicLayer.DiemBUS;
import BusinessLogicLayer.DiemHocKiBUS;
import BusinessLogicLayer.HS_LopBUS;
import BusinessLogicLayer.HocBaCuoiNamBUS;
import BusinessLogicLayer.HocKyBUS;
import BusinessLogicLayer.HocSinhBUS;
import BusinessLogicLayer.KetQuaHocTapHocKyBUS;
import BusinessLogicLayer.LoaiDiemBUS;
import BusinessLogicLayer.LopBUS;
import BusinessLogicLayer.MonHocBUS;
import BusinessLogicLayer.NamHocBUS;
import DataTransferObject.DiemDTO;
import DataTransferObject.DiemHocKiDTO;
import DataTransferObject.HS_LopDTO;
import DataTransferObject.HocBaCuoiNamDTO;
import DataTransferObject.HocKyDTO;
import DataTransferObject.HocSinhDTO;
import DataTransferObject.KetQuaHocTapHocKiDTO;
import DataTransferObject.LoaiDiemDTO;
import DataTransferObject.LopDTO;
import DataTransferObject.MonHocDTO;
import DataTransferObject.NamHocDTO;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author mr932
 */
public class QuanLyHocSinhGUI extends javax.swing.JInternalFrame {

    /**
     * Creates new form QuanLyHocSinhGUI
     */
    private static final int MA_LENGTH = 5;
    private static final int HO_LENGTH = 45;
    private static final int TEN_LENGTH = 45;
    private static final int DIACHI_LENGTH = 90;
    private static final String NAM_HOC_HIEN_TAI = "2019";
    private static final String HOC_KY_HIEN_TAI = "2";
    private String fileName = null;

    HocSinhBUS hsBus;
    HS_LopBUS hslopBus;
    NamHocBUS nhBus;
    LopBUS lopBus;
    DiemBUS diemBus;
    DiemHocKiBUS dhkBus;
    KetQuaHocTapHocKyBUS kqhthkBus;
    HocBaCuoiNamBUS hbcnBus;
    HocKyBUS hkBus;
    MonHocBUS mhBus;
    LoaiDiemBUS ldBus;
    ArrayList<String> tenTinhThanh;

    @SuppressWarnings("empty-statement")
    public QuanLyHocSinhGUI() {
        initComponents();

        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        BasicInternalFrameUI bi = (BasicInternalFrameUI) this.getUI();
        bi.setNorthPane(null);

        hsBus = new HocSinhBUS();
        hslopBus = new HS_LopBUS();
        nhBus = new NamHocBUS();
        lopBus = new LopBUS();
        diemBus = new DiemBUS();
        dhkBus = new DiemHocKiBUS();
        kqhthkBus = new KetQuaHocTapHocKyBUS();
        hbcnBus = new HocBaCuoiNamBUS();
        hkBus = new HocKyBUS();
        mhBus = new MonHocBUS();
        ldBus = new LoaiDiemBUS();
        tenTinhThanh = new ArrayList<>();
        TienIch.duaGiaTriVaoCbx(cbxNamHoc, nhBus.toStringList(nhBus.getDsnh()));
        TienIch.duaGiaTriVaoCbx(cbxLopHoc, lopBus.toStringList(lopBus.getDslop()));
        tenTinhThanh.add("An Giang");
        tenTinhThanh.add("Bà Rịa - Vũng Tàu");
        tenTinhThanh.add("Bắc Giang");
        tenTinhThanh.add("Bắc Kạn");
        tenTinhThanh.add("Bạc Liêu");
        tenTinhThanh.add("Bắc Ninh");
        tenTinhThanh.add("Bến Tre");
        tenTinhThanh.add("Bình Định");
        tenTinhThanh.add("Bình Dương");
        tenTinhThanh.add("Bình Phước");
        tenTinhThanh.add("Bình Thuận");
        tenTinhThanh.add("Cà Mau");
        tenTinhThanh.add("Cao Bằng");
        tenTinhThanh.add("Đắk Lắk");
        tenTinhThanh.add("Đắk Nông");
        tenTinhThanh.add("Điện Biên");
        tenTinhThanh.add("Đồng Nai");
        tenTinhThanh.add("Đồng Tháp");
        tenTinhThanh.add("Gia Lai");
        tenTinhThanh.add("Hà Giang");
        tenTinhThanh.add("Hà Nam");
        tenTinhThanh.add("Hà Tĩnh");
        tenTinhThanh.add("Hải Dương");
        tenTinhThanh.add("Hậu Giang");
        tenTinhThanh.add("Hòa Bình");
        tenTinhThanh.add("Hưng Yên");
        tenTinhThanh.add("Khánh Hòa");
        tenTinhThanh.add("Kiên Giang");
        tenTinhThanh.add("Kon Tum");
        tenTinhThanh.add("Lai Châu");
        tenTinhThanh.add("Lâm Đồng");
        tenTinhThanh.add("Lạng Sơn");
        tenTinhThanh.add("Lào Cai");
        tenTinhThanh.add("Long An");
        tenTinhThanh.add("Nam Định");
        tenTinhThanh.add("Nghệ An");
        tenTinhThanh.add("Ninh Bình");
        tenTinhThanh.add("Ninh Thuận");
        tenTinhThanh.add("Phú Thọ");
        tenTinhThanh.add("Quảng Bình");
        tenTinhThanh.add("Quảng Nam");
        tenTinhThanh.add("Quảng Ngãi");
        tenTinhThanh.add("Quảng Ninh");
        tenTinhThanh.add("Quảng Trị");
        tenTinhThanh.add("Sóc Trăng");
        tenTinhThanh.add("Sơn La");
        tenTinhThanh.add("Tây Ninh");
        tenTinhThanh.add("Thái Bình");
        tenTinhThanh.add("Thái Nguyên");
        tenTinhThanh.add("Thanh Hóa");
        tenTinhThanh.add("Thừa Thiên Huế");
        tenTinhThanh.add("Tiền Giang");
        tenTinhThanh.add("Trà Vinh");
        tenTinhThanh.add("Tuyên Quang");
        tenTinhThanh.add("Vĩnh Long");
        tenTinhThanh.add("Vĩnh Phúc");
        tenTinhThanh.add("Yên Bái");
        tenTinhThanh.add("Phú Yên");
        tenTinhThanh.add("Cần Thơ");
        tenTinhThanh.add("Đà Nẵng");
        tenTinhThanh.add("Hải Phòng");
        tenTinhThanh.add("Hà Nội");
        tenTinhThanh.add("TP HCM");
        
        TienIch.duaGiaTriVaoCbx(cbxQueQuan, tenTinhThanh);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btgPhai = new javax.swing.ButtonGroup();
        mainPanel = new javax.swing.JPanel();
        headerPanel = new javax.swing.JPanel();
        headerLabel = new javax.swing.JLabel();
        functionPanel = new javax.swing.JPanel();
        panelInput = new javax.swing.JPanel();
        txMa = new javax.swing.JTextField();
        btnXoa = new javax.swing.JButton();
        txTen = new javax.swing.JTextField();
        txHo = new javax.swing.JTextField();
        lbMa = new javax.swing.JLabel();
        lbHo = new javax.swing.JLabel();
        lbTen = new javax.swing.JLabel();
        lbPhai = new javax.swing.JLabel();
        btnThem = new javax.swing.JButton();
        btnDocDS = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnTimKiem = new javax.swing.JButton();
        lbNgaySinh = new javax.swing.JLabel();
        lbDiaChi = new javax.swing.JLabel();
        lbQueQuan = new javax.swing.JLabel();
        radNam = new javax.swing.JRadioButton();
        radNu = new javax.swing.JRadioButton();
        scrollPaneDiaChi = new javax.swing.JScrollPane();
        textAreaDiaChi = new javax.swing.JTextArea();
        lbHinhHocSinh = new javax.swing.JLabel();
        btnUpload = new javax.swing.JButton();
        lbHinhAnh = new javax.swing.JLabel();
        btnNhapLai = new javax.swing.JButton();
        cbxQueQuan = new javax.swing.JComboBox<>();
        jDateChooserNgSinh = new com.toedter.calendar.JDateChooser();
        scrollPaneDanhSachHocSinh = new javax.swing.JScrollPane();
        tbDanhSachHocSinh = new javax.swing.JTable();
        lbSoKetQuaTimThay = new javax.swing.JLabel();
        cbxNamHoc = new javax.swing.JComboBox<>();
        cbxLopHoc = new javax.swing.JComboBox<>();
        btnPhanLop = new javax.swing.JButton();
        btnDsHsChuaPhanLop = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        headerPanel.setBackground(new java.awt.Color(255, 255, 255));
        headerPanel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 102), 1, true));

        headerLabel.setFont(new java.awt.Font("Helvetica", 0, 24)); // NOI18N
        headerLabel.setForeground(new java.awt.Color(23, 35, 51));
        headerLabel.setText("Quản Lý Học Sinh");

        javax.swing.GroupLayout headerPanelLayout = new javax.swing.GroupLayout(headerPanel);
        headerPanel.setLayout(headerPanelLayout);
        headerPanelLayout.setHorizontalGroup(
            headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerPanelLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(headerLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        headerPanelLayout.setVerticalGroup(
            headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(headerLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                .addContainerGap())
        );

        panelInput.setBackground(new java.awt.Color(255, 255, 255));
        panelInput.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 102), 1, true));
        panelInput.setForeground(new java.awt.Color(102, 102, 102));

        txMa.setFont(new java.awt.Font("Helvetica", 0, 12)); // NOI18N
        txMa.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));
        txMa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txMaKeyPressed(evt);
            }
        });

        btnXoa.setBackground(new java.awt.Color(23, 35, 51));
        btnXoa.setFont(new java.awt.Font("Helvetica", 0, 12)); // NOI18N
        btnXoa.setForeground(new java.awt.Color(255, 255, 255));
        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });
        btnXoa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnXoaKeyPressed(evt);
            }
        });

        txTen.setFont(new java.awt.Font("Helvetica", 0, 12)); // NOI18N
        txTen.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));
        txTen.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txTenKeyPressed(evt);
            }
        });

        txHo.setFont(new java.awt.Font("Helvetica", 0, 12)); // NOI18N
        txHo.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));
        txHo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txHoKeyPressed(evt);
            }
        });

        lbMa.setFont(new java.awt.Font("Helvetica", 0, 12)); // NOI18N
        lbMa.setForeground(new java.awt.Color(23, 35, 51));
        lbMa.setText("Mã");

        lbHo.setFont(new java.awt.Font("Helvetica", 0, 12)); // NOI18N
        lbHo.setForeground(new java.awt.Color(23, 35, 51));
        lbHo.setText("Họ");

        lbTen.setFont(new java.awt.Font("Helvetica", 0, 12)); // NOI18N
        lbTen.setForeground(new java.awt.Color(23, 35, 51));
        lbTen.setText("Tên");

        lbPhai.setFont(new java.awt.Font("Helvetica", 0, 12)); // NOI18N
        lbPhai.setForeground(new java.awt.Color(23, 35, 51));
        lbPhai.setText("Phái");

        btnThem.setBackground(new java.awt.Color(23, 35, 51));
        btnThem.setFont(new java.awt.Font("Helvetica", 0, 12)); // NOI18N
        btnThem.setForeground(new java.awt.Color(255, 255, 255));
        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });
        btnThem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnThemKeyPressed(evt);
            }
        });

        btnDocDS.setBackground(new java.awt.Color(120, 168, 252));
        btnDocDS.setFont(new java.awt.Font("Helvetica", 0, 12)); // NOI18N
        btnDocDS.setForeground(new java.awt.Color(255, 255, 255));
        btnDocDS.setText("Đọc DS");
        btnDocDS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDocDSMouseClicked(evt);
            }
        });
        btnDocDS.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnDocDSKeyPressed(evt);
            }
        });

        btnSua.setBackground(new java.awt.Color(23, 35, 51));
        btnSua.setFont(new java.awt.Font("Helvetica", 0, 12)); // NOI18N
        btnSua.setForeground(new java.awt.Color(255, 255, 255));
        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });
        btnSua.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnSuaKeyPressed(evt);
            }
        });

        btnTimKiem.setBackground(new java.awt.Color(23, 35, 51));
        btnTimKiem.setFont(new java.awt.Font("Helvetica", 0, 12)); // NOI18N
        btnTimKiem.setForeground(new java.awt.Color(255, 255, 255));
        btnTimKiem.setText("Tìm kiếm");
        btnTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemActionPerformed(evt);
            }
        });
        btnTimKiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnTimKiemKeyPressed(evt);
            }
        });

        lbNgaySinh.setFont(new java.awt.Font("Helvetica", 0, 12)); // NOI18N
        lbNgaySinh.setForeground(new java.awt.Color(23, 35, 51));
        lbNgaySinh.setText("Ngày sinh");

        lbDiaChi.setFont(new java.awt.Font("Helvetica", 0, 12)); // NOI18N
        lbDiaChi.setForeground(new java.awt.Color(23, 35, 51));
        lbDiaChi.setText("Địa chỉ");

        lbQueQuan.setFont(new java.awt.Font("Helvetica", 0, 12)); // NOI18N
        lbQueQuan.setForeground(new java.awt.Color(23, 35, 51));
        lbQueQuan.setText("Quê quán");

        btgPhai.add(radNam);
        radNam.setFont(new java.awt.Font("Helvetica", 0, 12)); // NOI18N
        radNam.setText("Nam");
        radNam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radNamActionPerformed(evt);
            }
        });
        radNam.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                radNamKeyPressed(evt);
            }
        });

        btgPhai.add(radNu);
        radNu.setFont(new java.awt.Font("Helvetica", 0, 12)); // NOI18N
        radNu.setText("Nữ");
        radNu.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                radNuKeyPressed(evt);
            }
        });

        textAreaDiaChi.setColumns(20);
        textAreaDiaChi.setRows(5);
        textAreaDiaChi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                textAreaDiaChiKeyPressed(evt);
            }
        });
        scrollPaneDiaChi.setViewportView(textAreaDiaChi);

        lbHinhHocSinh.setFont(new java.awt.Font("Helvetica", 0, 12)); // NOI18N
        lbHinhHocSinh.setText("Hình Học Sinh");

        btnUpload.setFont(new java.awt.Font("Helvetica", 0, 12)); // NOI18N
        btnUpload.setText("Upload");
        btnUpload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUploadActionPerformed(evt);
            }
        });
        btnUpload.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnUploadKeyPressed(evt);
            }
        });

        lbHinhAnh.setFont(new java.awt.Font("Helvetica", 0, 12)); // NOI18N
        lbHinhAnh.setText("Hình Ảnh");
        lbHinhAnh.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 102), 1, true));
        lbHinhAnh.setMaximumSize(new java.awt.Dimension(134, 184));
        lbHinhAnh.setMinimumSize(new java.awt.Dimension(134, 184));
        lbHinhAnh.setPreferredSize(new java.awt.Dimension(134, 184));

        btnNhapLai.setBackground(new java.awt.Color(23, 35, 51));
        btnNhapLai.setFont(new java.awt.Font("Helvetica", 0, 12)); // NOI18N
        btnNhapLai.setForeground(new java.awt.Color(255, 255, 255));
        btnNhapLai.setText("Nhập lại");
        btnNhapLai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNhapLaiActionPerformed(evt);
            }
        });
        btnNhapLai.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnNhapLaiKeyPressed(evt);
            }
        });

        cbxQueQuan.setFont(new java.awt.Font("Helvetica", 0, 12)); // NOI18N
        cbxQueQuan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout panelInputLayout = new javax.swing.GroupLayout(panelInput);
        panelInput.setLayout(panelInputLayout);
        panelInputLayout.setHorizontalGroup(
            panelInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInputLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(panelInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelInputLayout.createSequentialGroup()
                        .addGroup(panelInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelInputLayout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addGroup(panelInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbTen)
                                    .addComponent(txTen, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)))
                            .addComponent(lbMa)
                            .addComponent(txMa)
                            .addComponent(lbNgaySinh)
                            .addGroup(panelInputLayout.createSequentialGroup()
                                .addComponent(radNam)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(radNu))
                            .addComponent(lbPhai)
                            .addGroup(panelInputLayout.createSequentialGroup()
                                .addComponent(txHo)
                                .addGap(1, 1, 1))
                            .addComponent(lbHo))
                        .addGap(52, 52, 52))
                    .addGroup(panelInputLayout.createSequentialGroup()
                        .addComponent(jDateChooserNgSinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(panelInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelInputLayout.createSequentialGroup()
                        .addGroup(panelInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelInputLayout.createSequentialGroup()
                                .addGroup(panelInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelInputLayout.createSequentialGroup()
                                        .addGroup(panelInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lbQueQuan)
                                            .addComponent(lbDiaChi))
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(panelInputLayout.createSequentialGroup()
                                        .addComponent(scrollPaneDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                        .addGap(14, 14, 14)))
                                .addGap(28, 28, 28))
                            .addGroup(panelInputLayout.createSequentialGroup()
                                .addComponent(cbxQueQuan, 0, 116, Short.MAX_VALUE)
                                .addGap(46, 46, 46)))
                        .addGroup(panelInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbHinhAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbHinhHocSinh))
                        .addGap(33, 33, 33))
                    .addGroup(panelInputLayout.createSequentialGroup()
                        .addComponent(btnNhapLai, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnUpload)
                        .addGap(67, 67, 67)))
                .addGroup(panelInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnDocDS, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnThem, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnSua, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTimKiem, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35))
        );
        panelInputLayout.setVerticalGroup(
            panelInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInputLayout.createSequentialGroup()
                .addGroup(panelInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelInputLayout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(panelInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelInputLayout.createSequentialGroup()
                                .addComponent(lbMa)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txMa, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lbHo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txHo, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lbTen)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txTen, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lbNgaySinh)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jDateChooserNgSinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(11, 11, 11)
                                .addComponent(lbPhai)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(radNam)
                                    .addComponent(radNu)))
                            .addGroup(panelInputLayout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(lbHinhHocSinh)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbHinhAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(panelInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnUpload)
                                    .addComponent(btnNhapLai))
                                .addGap(3, 3, 3))))
                    .addGroup(panelInputLayout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(panelInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panelInputLayout.createSequentialGroup()
                                .addComponent(btnDocDS)
                                .addGap(29, 29, 29)
                                .addComponent(btnThem)
                                .addGap(29, 29, 29)
                                .addComponent(btnXoa)
                                .addGap(29, 29, 29)
                                .addComponent(btnSua)
                                .addGap(29, 29, 29)
                                .addComponent(btnTimKiem)
                                .addGap(9, 9, 9))
                            .addGroup(panelInputLayout.createSequentialGroup()
                                .addComponent(lbQueQuan)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbxQueQuan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(72, 72, 72)
                                .addComponent(lbDiaChi)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(scrollPaneDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addGap(60, 60, 60)))))
                .addGap(14, 14, 14))
        );

        scrollPaneDanhSachHocSinh.setToolTipText("");
        scrollPaneDanhSachHocSinh.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N

        tbDanhSachHocSinh.setFont(new java.awt.Font("Helvetica", 0, 12)); // NOI18N
        tbDanhSachHocSinh.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã", "Họ", "Tên", "Phái", "Ngày sinh", "Địa chỉ", "Quê quán", "Hình ảnh"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbDanhSachHocSinh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbDanhSachHocSinhMouseClicked(evt);
            }
        });
        tbDanhSachHocSinh.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tbDanhSachHocSinhKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tbDanhSachHocSinhKeyReleased(evt);
            }
        });
        scrollPaneDanhSachHocSinh.setViewportView(tbDanhSachHocSinh);

        lbSoKetQuaTimThay.setFont(new java.awt.Font("Helvetica", 0, 12)); // NOI18N
        lbSoKetQuaTimThay.setText("Số kết quả tìm thấy");

        cbxNamHoc.setFont(new java.awt.Font("Helvetica", 0, 12)); // NOI18N
        cbxNamHoc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbxLopHoc.setFont(new java.awt.Font("Helvetica", 0, 12)); // NOI18N
        cbxLopHoc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnPhanLop.setFont(new java.awt.Font("Helvetica", 0, 12)); // NOI18N
        btnPhanLop.setText("Phân lớp");
        btnPhanLop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPhanLopActionPerformed(evt);
            }
        });

        btnDsHsChuaPhanLop.setFont(new java.awt.Font("Helvetica", 0, 12)); // NOI18N
        btnDsHsChuaPhanLop.setText("DS chưa phân lớp");
        btnDsHsChuaPhanLop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDsHsChuaPhanLopActionPerformed(evt);
            }
        });

        jLabel1.setText("Năm học");

        jLabel2.setText("Lớp học");

        javax.swing.GroupLayout functionPanelLayout = new javax.swing.GroupLayout(functionPanel);
        functionPanel.setLayout(functionPanelLayout);
        functionPanelLayout.setHorizontalGroup(
            functionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, functionPanelLayout.createSequentialGroup()
                .addGroup(functionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(functionPanelLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbxNamHoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbxLopHoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addComponent(btnPhanLop)
                        .addGap(53, 53, 53)
                        .addComponent(btnDsHsChuaPhanLop))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, functionPanelLayout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addGroup(functionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(panelInput, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(scrollPaneDanhSachHocSinh))))
                .addGap(47, 47, 47))
            .addGroup(functionPanelLayout.createSequentialGroup()
                .addGap(91, 91, 91)
                .addComponent(lbSoKetQuaTimThay)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        functionPanelLayout.setVerticalGroup(
            functionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, functionPanelLayout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(panelInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(functionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxNamHoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxLopHoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPhanLop)
                    .addComponent(btnDsHsChuaPhanLop)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(7, 7, 7)
                .addComponent(scrollPaneDanhSachHocSinh, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(lbSoKetQuaTimThay)
                .addGap(80, 80, 80))
        );

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(headerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(functionPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addComponent(headerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(functionPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void radNamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radNamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radNamActionPerformed

    // Nút up hình dành riêng cho lớp học sinh
    private void btnUploadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUploadActionPerformed
        // TODO add your handling code here:
        upLoad();
    }//GEN-LAST:event_btnUploadActionPerformed

    private void tbDanhSachHocSinhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbDanhSachHocSinhMouseClicked
        // TODO add your handling code here:
        chonHocSinh();
    }//GEN-LAST:event_tbDanhSachHocSinhMouseClicked

    private void btnDocDSMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDocDSMouseClicked
        // TODO add your handling code here:
        doc();
    }//GEN-LAST:event_btnDocDSMouseClicked

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
        them();
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        try {
            // TODO add your handling code here:
            xoa();
        } catch (Exception ex) {
            Logger.getLogger(QuanLyHocSinhGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:
        sua();
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
        // TODO add your handling code here:
        timKiem();
    }//GEN-LAST:event_btnTimKiemActionPerformed

    private void btnDocDSKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnDocDSKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            doc();
        }
    }//GEN-LAST:event_btnDocDSKeyPressed

    private void btnThemKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnThemKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            them();
        }
        if (evt.getKeyCode() == KeyEvent.VK_DOWN) {
            btnXoa.requestFocus();
        }
        if (evt.getKeyCode() == KeyEvent.VK_UP) {
            btnUpload.requestFocus();
        }
    }//GEN-LAST:event_btnThemKeyPressed

    private void btnXoaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnXoaKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            try {
                xoa();
            } catch (Exception ex) {
                Logger.getLogger(QuanLyHocSinhGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (evt.getKeyCode() == KeyEvent.VK_DOWN) {
            btnSua.requestFocus();
        }
        if (evt.getKeyCode() == KeyEvent.VK_UP) {
            btnThem.requestFocus();
        }
    }//GEN-LAST:event_btnXoaKeyPressed

    private void btnSuaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnSuaKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            sua();
        }
        if (evt.getKeyCode() == KeyEvent.VK_DOWN) {
            btnTimKiem.requestFocus();
        }
        if (evt.getKeyCode() == KeyEvent.VK_UP) {
            btnXoa.requestFocus();
        }
    }//GEN-LAST:event_btnSuaKeyPressed

    private void btnTimKiemKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnTimKiemKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            timKiem();
        }
        if (evt.getKeyCode() == KeyEvent.VK_DOWN) {
            btnNhapLai.requestFocus();
        }
        if (evt.getKeyCode() == KeyEvent.VK_UP) {
            btnSua.requestFocus();
        }
    }//GEN-LAST:event_btnTimKiemKeyPressed

    private void btnUploadKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnUploadKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            upLoad();
        }
        if (evt.getKeyCode() == KeyEvent.VK_DOWN) {
            btnThem.requestFocus();
        }
    }//GEN-LAST:event_btnUploadKeyPressed

    private void tbDanhSachHocSinhKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbDanhSachHocSinhKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_UP || evt.getKeyCode() == KeyEvent.VK_DOWN || evt.getKeyCode() == KeyEvent.VK_ENTER) {
            chonHocSinh();
        }
    }//GEN-LAST:event_tbDanhSachHocSinhKeyPressed

    private void btnNhapLaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNhapLaiActionPerformed
        // TODO add your handling code here:
        resetAllField();
    }//GEN-LAST:event_btnNhapLaiActionPerformed

    private void btnNhapLaiKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnNhapLaiKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            resetAllField();
        }
    }//GEN-LAST:event_btnNhapLaiKeyPressed

    private void txMaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txMaKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_DOWN) {
            txHo.requestFocus();
        }
        if (evt.getKeyCode() == KeyEvent.VK_UP) {
            btnDocDS.requestFocus();
        }
    }//GEN-LAST:event_txMaKeyPressed

    private void txHoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txHoKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_DOWN) {
            txTen.requestFocus();
        }
        if (evt.getKeyCode() == KeyEvent.VK_UP) {
            txMa.requestFocus();
        }
    }//GEN-LAST:event_txHoKeyPressed

    private void txTenKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txTenKeyPressed
        // TODO add your handling code here:

        if (evt.getKeyCode() == KeyEvent.VK_UP) {
            txHo.requestFocus();
        }
    }//GEN-LAST:event_txTenKeyPressed

    private void radNamKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_radNamKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_DOWN) {
            cbxQueQuan.requestFocus();
        }
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            radNam.setSelected(true);
        }
        if (evt.getKeyCode() == KeyEvent.VK_RIGHT) {
            radNu.requestFocus();
        }
    }//GEN-LAST:event_radNamKeyPressed

    private void radNuKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_radNuKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_DOWN) {
            cbxQueQuan.requestFocus();
        }
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            radNu.setSelected(true);
        }
        if (evt.getKeyCode() == KeyEvent.VK_LEFT) {
            radNam.requestFocus();
        }
    }//GEN-LAST:event_radNuKeyPressed

    private void textAreaDiaChiKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textAreaDiaChiKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_DOWN) {
            btnUpload.requestFocus();
        }
        if (evt.getKeyCode() == KeyEvent.VK_UP) {
            cbxQueQuan.requestFocus();
        }
    }//GEN-LAST:event_textAreaDiaChiKeyPressed

    private void tbDanhSachHocSinhKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbDanhSachHocSinhKeyReleased
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_UP || evt.getKeyCode() == KeyEvent.VK_DOWN || evt.getKeyCode() == KeyEvent.VK_ENTER) {
            chonHocSinh();
        }
    }//GEN-LAST:event_tbDanhSachHocSinhKeyReleased

    private void btnDsHsChuaPhanLopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDsHsChuaPhanLopActionPerformed
        // TODO add your handling code here:
        String namHoc = (String) cbxNamHoc.getSelectedItem();
        showTable(hsBus.timDsHsChuaPhanLop(namHoc));
    }//GEN-LAST:event_btnDsHsChuaPhanLopActionPerformed

    private void btnPhanLopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPhanLopActionPerformed
        // TODO add your handling code here:
        int row = tbDanhSachHocSinh.getSelectedRow();
        String maLop = cbxLopHoc.getSelectedItem().toString();
        String namHoc = (String) cbxNamHoc.getSelectedItem();
        if (maLop.equals(""))
            JOptionPane.showMessageDialog(null, "Hãy chọn lớp trước khi phân lớp.");
        if (namHoc.equals(""))
            JOptionPane.showMessageDialog(null, "Hãy chọn năm trước khi phân lớp.");
        if (row >= 0 && !namHoc.equals("") && !maLop.equals("")) {
            HocSinhDTO hs = hsBus.timKiemHocSinh((String) tbDanhSachHocSinh.getModel().getValueAt(row, 1));
            NamHocDTO nh = nhBus.timKiemNamHoc((String) cbxNamHoc.getSelectedItem());
            LopDTO lop = lopBus.timKiemMa((String) cbxLopHoc.getSelectedItem());
            
            //HS_LopDTO hslop = new HS_LopDTO();
            //hslop.setNh(nh);
            //hslop.setHs(hs);
            //hslop.setLop(lop);
            //HocKyDTO hk = hkBus.timKiemMahk("1");
            //hslop.setHk(hk);
            //System.out.println("Hoc sinh lop truoc: " + hslopBus.getDshsl().size());
            //hslopBus.them(hslop);
            //hk = hkBus.timKiemMahk("2");
            //hslop.setHk(hk);

            System.out.println("Hoc sinh lop sau: " + hslopBus.getDshsl().size());
            
            System.out.println("diem bus truoc: " + diemBus.getDsd().size());
            System.out.println("diem hoc ki truoc: " + dhkBus.getDsdhk().size());
            System.out.println("ket qua hoc tap truoc: " + kqhthkBus.getDskqhthk().size());
            for (HocKyDTO hkDto : hkBus.getDshk()) {
                KetQuaHocTapHocKiDTO kqhthk = new KetQuaHocTapHocKiDTO();
                HS_LopDTO hslop = new HS_LopDTO();
                
                for (MonHocDTO mh : mhBus.getDsmh()) {
                    DiemHocKiDTO diemHk = new DiemHocKiDTO();

                    for (LoaiDiemDTO ld : ldBus.getDsld()) {
                        DiemDTO diem = new DiemDTO();
                        diem.setHocSinh(hs);
                        diem.setHocKy(hkDto);
                        diem.setNamHoc(nh);
                        diem.setLoaiDiem(ld);
                        diem.setMonHoc(mh);
                        diem.setDiemSo(0);
                        try {
                            diemBus.them(diem);
                        } catch (Exception ex) {
                            Logger.getLogger(QuanLyHocSinhGUI.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }

                    diemHk.setHocKy(hkDto);
                    diemHk.setHocSinh(hs);
                    diemHk.setNamHoc(nh);
                    diemHk.setMonHoc(mh);
                    diemHk.setTbMonhk(0);
                    try {
                        dhkBus.them(diemHk);
                        
                    } catch (Exception ex) {
                        Logger.getLogger(QuanLyHocSinhGUI.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

                kqhthk.setHanhKiem("");
                kqhthk.setHocKy(hkDto);
                kqhthk.setNamHoc(nh);
                kqhthk.setHocSinh(hs);
                kqhthk.setTbcHocky(0);
                
                hslop.setHs(hs);
                hslop.setNh(nh);
                hslop.setHk(hkDto);
                hslop.setLop(lop);
                hslopBus.them(hslop);
                try {
                    kqhthkBus.them(kqhthk);
                } catch (Exception ex) {
                    Logger.getLogger(QuanLyHocSinhGUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            HocBaCuoiNamDTO hbcn = new HocBaCuoiNamDTO();
            hbcn.setHocSinh(hs);
            hbcn.setNamHoc(nh);
            hbcn.setDtbCn(0);
            hbcn.setHanhKiem("");
            hbcn.setXepLoai("");
            try {
                hbcnBus.them(hbcn);
            } catch (Exception ex) {
                Logger.getLogger(QuanLyHocSinhGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("Hoc ba sau: " + hbcnBus.getDshbcn().size());
        }
        showTable(hsBus.timDsHsChuaPhanLop(namHoc));
    }//GEN-LAST:event_btnPhanLopActionPerformed

    private void chonHocSinh() {
        int i = tbDanhSachHocSinh.getSelectedRow();
        if (i >= 0) {
            txMa.setText(tbDanhSachHocSinh.getModel().getValueAt(i, 1).toString());
            txHo.setText(tbDanhSachHocSinh.getModel().getValueAt(i, 2).toString());
            txTen.setText(tbDanhSachHocSinh.getModel().getValueAt(i, 3).toString());
            if (tbDanhSachHocSinh.getModel().getValueAt(i, 4).toString().equals("Nam")) {
                radNam.setSelected(true);
            }
            if (tbDanhSachHocSinh.getModel().getValueAt(i, 4).toString().equals("Nu")) {
                radNu.setSelected(true);
            }

            String ngaySinh = tbDanhSachHocSinh.getModel().getValueAt(i, 5).toString();
            try {
                Date date = new SimpleDateFormat("yyyy-MM-dd").parse(ngaySinh);
                jDateChooserNgSinh.setDate(date);
            } catch (ParseException ex) {
                Logger.getLogger(QuanLyHocSinhGUI.class.getName()).log(Level.SEVERE, null, ex);
            }

            textAreaDiaChi.setText(tbDanhSachHocSinh.getModel().getValueAt(i, 6).toString());
            cbxQueQuan.setSelectedItem(tbDanhSachHocSinh.getModel().getValueAt(i, 7).toString());

            // Hiển thị hình ảnh học sinh lên giao diện (Những giao diện khác không cần cái này)
            String hinhHs = hsBus.timKiemHocSinh(txMa.getText()).getHinhAnh();
            ImageIcon imageIcon = new ImageIcon(new ImageIcon(hinhHs).getImage()
                    .getScaledInstance(lbHinhAnh.getWidth(), lbHinhAnh.getHeight(), Image.SCALE_SMOOTH));
            lbHinhAnh.setText("");
            lbHinhAnh.setIcon(imageIcon);
            //lbLinkHinh.setText(imageIcon.toString());
        }
    }

    private void upLoad() {
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        File f = chooser.getSelectedFile();
        fileName = f.getAbsolutePath();
        ImageIcon imageIcon = new ImageIcon(new ImageIcon(fileName).getImage()
                .getScaledInstance(lbHinhAnh.getWidth(), lbHinhAnh.getHeight(), Image.SCALE_SMOOTH));
        lbHinhAnh.setText("");
        lbHinhAnh.setIcon(imageIcon);
        //lbLinkHinh.setText(fileName);
    }

    private void doc() {
        if (hsBus.getDshs() == null) {
            try {
                hsBus.docDSHS();
            } catch (Exception ex) {
                Logger.getLogger(QuanLyHocSinhGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        tbDanhSachHocSinh.requestFocus();
        showTable(hsBus.getDshs());
    }

    private void timKiem() {
        ArrayList<HocSinhDTO> danhSachHocSinhTimThay = hsBus.getDshs();

        String maCanTim = chuanHoa(txMa.getText());
        if (!maCanTim.equals("")) {
            danhSachHocSinhTimThay = hsBus.timKiemTheoMa(maCanTim, danhSachHocSinhTimThay);
        }

        String hoCanTim = chuanHoa(txHo.getText());
        if (!hoCanTim.equals("")) {
            danhSachHocSinhTimThay = hsBus.timKiemTheoHo(hoCanTim, danhSachHocSinhTimThay);
        }

        String tenCanTim = chuanHoa(txTen.getText());
        if (!tenCanTim.equals("")) {
            danhSachHocSinhTimThay = hsBus.timKiemTheoHoTen(tenCanTim, danhSachHocSinhTimThay);
        }

        if (radNam.isSelected() == true) {
            danhSachHocSinhTimThay = hsBus.timKiemTheoPhai("Nam", danhSachHocSinhTimThay);
        }
        if (radNu.isSelected() == true) {
            danhSachHocSinhTimThay = hsBus.timKiemTheoPhai("Nu", danhSachHocSinhTimThay);
        }

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String ngaySinhCanTim = sdf.format(jDateChooserNgSinh.getDate());
        if (!ngaySinhCanTim.equals("")) {
            danhSachHocSinhTimThay = hsBus.timKiemTheoNgaySinh(ngaySinhCanTim, danhSachHocSinhTimThay);
        }

        String diaChiCanTim = chuanHoa(textAreaDiaChi.getText());
        if (!diaChiCanTim.equals("")) {
            danhSachHocSinhTimThay = hsBus.timKiemTheoDiaChi(diaChiCanTim, danhSachHocSinhTimThay);
        }

        String queQuanCanTim = (String) cbxQueQuan.getSelectedItem();
        if (!queQuanCanTim.equals("")) {
            danhSachHocSinhTimThay = hsBus.timKiemTheoQueQuan(queQuanCanTim, danhSachHocSinhTimThay);
        }

        showTable(danhSachHocSinhTimThay);
    }

    private void them() {
        Boolean dauVao = kiemTraDauVao();
        Boolean trungMa = hsBus.kiemTraTrungMa(chuanHoa(txMa.getText().toUpperCase()));

        if (trungMa) {
            JOptionPane.showMessageDialog(null, "Mã học sinh bị trùng. Hãy đổi mã học sinh khác.");
        }

        if (dauVao && !trungMa) {
            HocSinhDTO hsMoi = new HocSinhDTO();
            hsMoi.setMahs(chuanHoa(txMa.getText().toUpperCase()));
            hsMoi.setHo(chuanHoa(txHo.getText()));
            hsMoi.setTen(chuanHoa(txTen.getText()));
            if (radNam.isSelected()) {
                hsMoi.setPhai("Nam");
            } else {
                hsMoi.setPhai("Nu");
            }
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String date = sdf.format(jDateChooserNgSinh.getDate());
            hsMoi.setNgaySinh(date);
            hsMoi.setDiaChi(chuanHoa(textAreaDiaChi.getText()));
            hsMoi.setQueQuan((String) cbxQueQuan.getSelectedItem());
            hsMoi.setHinhAnh(fileName);
            DefaultTableModel model = (DefaultTableModel) tbDanhSachHocSinh.getModel();

            Vector row = new Vector();
            row.add(model.getRowCount() + 1);
            row.add(hsMoi.getMahs());
            row.add(hsMoi.getHo());
            row.add(hsMoi.getTen());
            row.add(hsMoi.getPhai());
            row.add(hsMoi.getNgaySinh());
            row.add(hsMoi.getDiaChi());
            row.add(hsMoi.getQueQuan());
            row.add(hsMoi.getHinhAnh());
            model.addRow(row);

            tbDanhSachHocSinh.setModel(model);
            lbSoKetQuaTimThay.setText("Tìm thấy " + model.getRowCount() + " kết quả.");
            resetAllField();

            try {
                hsBus.them(hsMoi);
            } catch (Exception ex) {
                Logger.getLogger(QuanLyHocSinhGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void sua() {
        int row = tbDanhSachHocSinh.getSelectedRow();

        Boolean dauVao = kiemTraDauVao();
        DefaultTableModel model = (DefaultTableModel) tbDanhSachHocSinh.getModel();
        String maHsCu = (String) model.getValueAt(row, 1);

        if (row >= 0 && dauVao) {
            // Bien trung gian chuyen du lieu xuong BUS
            HocSinhDTO hsCanSua = new HocSinhDTO();
            // Chuan hoa thong tin can sua
            //String ma = maHsCu;
            String ho = chuanHoa(txHo.getText());
            String ten = chuanHoa(txTen.getText());
            String phai = new String();
            if (radNam.isSelected() == true) {
                phai = "Nam";
            }
            if (radNu.isSelected() == true) {
                phai = "Nu";
            }
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String ngaysinh = sdf.format(jDateChooserNgSinh.getDate());
            String diachi = chuanHoa(textAreaDiaChi.getText());
            String quequan = (String) cbxQueQuan.getSelectedItem();

            // Dua du lieu chuan vao bien trung gian
            hsCanSua.setMahs(maHsCu);
            hsCanSua.setHo(ho);
            hsCanSua.setTen(ten);
            hsCanSua.setPhai(phai);
            hsCanSua.setNgaySinh(ngaysinh);
            hsCanSua.setDiaChi(diachi);
            hsCanSua.setQueQuan(quequan);
            hsCanSua.setHinhAnh(fileName);

            // The hien tren giao dien
            model.setValueAt(maHsCu, row, 1);
            model.setValueAt(ho, row, 2);
            model.setValueAt(ten, row, 3);
            model.setValueAt(phai, row, 4);
            model.setValueAt(ngaysinh, row, 5);
            model.setValueAt(diachi, row, 6);
            model.setValueAt(quequan, row, 7);
            model.setValueAt(fileName, row, 8);
            tbDanhSachHocSinh.setModel(model);

            // Chuyen du lieu xuong lop BUS
            try {
                hsBus.sua(hsCanSua);
            } catch (Exception ex) {
                Logger.getLogger(QuanLyHocSinhGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
            resetAllField();
        } else if (row < 0) {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn học sinh cần sửa.");
        }
    }

    private void xoa() throws Exception {
        int row = tbDanhSachHocSinh.getSelectedRow();
        if (row >= 0) {
            // Cap nhat cac o text field
            String maHsCanXoa = tbDanhSachHocSinh.getModel().getValueAt(row, 1).toString();
            DefaultTableModel model = (DefaultTableModel) tbDanhSachHocSinh.getModel();
            HocSinhDTO hs = hsBus.timKiemHocSinh(maHsCanXoa);
            NamHocDTO nh = nhBus.timKiemNamHoc(NAM_HOC_HIEN_TAI);
            HS_LopDTO hslop = hslopBus.timHocSinhLop(hs.getMahs(), "1", nh.getManh());
            hslop = hslopBus.timHocSinhLop(hs.getMahs(), "2", nh.getManh());
            if (hslop == null){
                model.removeRow(row);
                tbDanhSachHocSinh.setModel(model);
                hsBus.xoa(maHsCanXoa);
            }
            else {
                JOptionPane.showMessageDialog(null, "Phải chuyển học sinh ra khỏi lớp đang học trước khi xóa");
            }
            //lbSoKetQuaTimThay.setText("Tìm thấy " + model.getRowCount() + " kết quả.");
        }
        resetAllField();
    }

    private void showTable(ArrayList<HocSinhDTO> danhSachHocSinh) {
        Vector header = new Vector();
        header.add("STT");
        header.add("Mã");
        header.add("Họ");
        header.add("Tên");
        header.add("Phái");
        header.add("Ngày sinh");
        header.add("Địa chỉ");
        header.add("Quê quán");
        header.add("Hình ảnh");
        DefaultTableModel model = new DefaultTableModel(header, 0);
        int stt = 1;
        for (HocSinhDTO hs : danhSachHocSinh) {
            Vector row = new Vector();
            row.add(stt);
            row.add(hs.getMahs());
            row.add(hs.getHo());
            row.add(hs.getTen());
            row.add(hs.getPhai());
            row.add(hs.getNgaySinh());
            row.add(hs.getDiaChi());
            row.add(hs.getQueQuan());
            row.add(hs.getHinhAnh());
            model.addRow(row);
            stt++;
        }
        tbDanhSachHocSinh.setModel(model);
        lbSoKetQuaTimThay.setText("Tìm thấy " + model.getRowCount() + " kết quả.");
    }

    private void resetAllField() {
        txMa.setText("");
        txHo.setText("");
        txTen.setText("");
        radNam.setSelected(false);
        radNu.setSelected(false);
        textAreaDiaChi.setText("");
        cbxQueQuan.setSelectedItem("");
        lbHinhAnh.setIcon(null);
        radNam.setSelected(false);
        radNu.setSelected(false);
        txMa.requestFocus();
    }

    private Boolean kiemTraDauVao() {
        Boolean dauVao = true;
        String thongBao = "";
        int sttThongBao = 1;

        if (txMa.getText().length() != MA_LENGTH) {
            dauVao = false;
            thongBao += sttThongBao + ".Mã học sinh phải có 5 ký tự.\n";
            sttThongBao++;
        }

        if (txHo.getText().length() > HO_LENGTH) {
            dauVao = false;
            thongBao += sttThongBao + ". Tối đa 45 ký tự.\n";
            sttThongBao++;
        } else if (chuanHoa(txHo.getText()).equals("")) {
            dauVao = false;
            thongBao += sttThongBao + ". Họ không được bỏ trống.\n";
            sttThongBao++;
        }

        if (txTen.getText().length() > TEN_LENGTH) {
            dauVao = false;
            thongBao += sttThongBao + ". Tên tối đa 45 ký tự.\n";
            sttThongBao++;
        } else if (chuanHoa(txTen.getText()).equals("")) {
            dauVao = false;
            thongBao += sttThongBao + ". Tên không được bỏ trống.\n";
            sttThongBao++;
        }

        if (radNam.isSelected() == false && radNu.isSelected() == false) {
            thongBao += sttThongBao + ". Vui lòng chọn phái cho học sinh.\n";
            sttThongBao++;
        }

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String date = sdf.format(jDateChooserNgSinh.getDate());
        if (date.equals("")) {
            dauVao = false;
            thongBao += sttThongBao + ". Ngày Sinh không được bỏ trống.\n";
            sttThongBao++;
        }

        if (textAreaDiaChi.getText().length() > DIACHI_LENGTH) {
            dauVao = false;
            thongBao += sttThongBao + ". Địa chỉ tối đa 90 ký tự.\n";
            sttThongBao++;
        } else if (chuanHoa(textAreaDiaChi.getText()).equals("")) {
            dauVao = false;
            thongBao += sttThongBao + ". Địa chỉ không được bỏ trống.\n";
            sttThongBao++;
        }

        
        if (cbxQueQuan.getSelectedItem().equals("")) {
            dauVao = false;
            thongBao += sttThongBao + ". Quê quán không được bỏ trống.\n";
            sttThongBao++;
        }

        if (!thongBao.equals("")) {
            JOptionPane.showMessageDialog(null, thongBao);
        }
        return dauVao;
    }

    private String chuanHoa(String chuoiDauVao) {
        String chuoiBoKhoangTrang = chuoiDauVao.trim();
        String[] arr = chuoiBoKhoangTrang.split(" ");
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < arr.length; i++) {
            //System.out.println(arr[i]);
            if (arr[i].equals("")) {
                continue;
            }
            //if (!arr[i].equals("")){
            //System.out.println(arr[i]);
            sb.append(Character.toUpperCase(arr[i].charAt(0))).append(arr[i].substring(1)).append(" ");
            //}
        }
        return sb.toString().trim();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup btgPhai;
    private javax.swing.JButton btnDocDS;
    private javax.swing.JButton btnDsHsChuaPhanLop;
    private javax.swing.JButton btnNhapLai;
    private javax.swing.JButton btnPhanLop;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JButton btnUpload;
    private javax.swing.JButton btnXoa;
    private javax.swing.JComboBox<String> cbxLopHoc;
    private javax.swing.JComboBox<String> cbxNamHoc;
    private javax.swing.JComboBox<String> cbxQueQuan;
    private javax.swing.JPanel functionPanel;
    private javax.swing.JLabel headerLabel;
    private javax.swing.JPanel headerPanel;
    private com.toedter.calendar.JDateChooser jDateChooserNgSinh;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lbDiaChi;
    private javax.swing.JLabel lbHinhAnh;
    private javax.swing.JLabel lbHinhHocSinh;
    private javax.swing.JLabel lbHo;
    private javax.swing.JLabel lbMa;
    private javax.swing.JLabel lbNgaySinh;
    private javax.swing.JLabel lbPhai;
    private javax.swing.JLabel lbQueQuan;
    private javax.swing.JLabel lbSoKetQuaTimThay;
    private javax.swing.JLabel lbTen;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JPanel panelInput;
    private javax.swing.JRadioButton radNam;
    private javax.swing.JRadioButton radNu;
    private javax.swing.JScrollPane scrollPaneDanhSachHocSinh;
    private javax.swing.JScrollPane scrollPaneDiaChi;
    private javax.swing.JTable tbDanhSachHocSinh;
    private javax.swing.JTextArea textAreaDiaChi;
    private javax.swing.JTextField txHo;
    private javax.swing.JTextField txMa;
    private javax.swing.JTextField txTen;
    // End of variables declaration//GEN-END:variables
}
