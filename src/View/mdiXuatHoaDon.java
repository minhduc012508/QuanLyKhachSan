/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.Control_DatPhong;
import Controller.Control_QLHoaDon;
import Controller.Control_QlDichVu;
import Controller.Control_QlKhachHang;
import Controller.Control_QlPhong;
import Model.QLHoaDon;
import Model.QLKhachHang;
import Model.QLNhanVien;
import Model.QlDichVu;
import Model.QlPhong;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DELL
 */
public class mdiXuatHoaDon extends javax.swing.JFrame {
    int xDrag,yDrag,xPress,yPress;
    int iddatphong;
    float songay,tonggia;
    float tongdichvu,tongkhachhang;
    String ngaydat,ngaytra,maphong,manv,ngayhientai;
    String ngaythuctra;
    QlPhong qlPhong;
    QLNhanVien qlnv;
    ButtonGroup gr;
    Controller.Control_QlDichVu qldv = new Control_QlDichVu();
    Controller.Control_QlPhong qlp = new Control_QlPhong();
    Controller.Control_DatPhong qldp = new Control_DatPhong();
    List<QlDichVu> ds = new ArrayList<>();
    DefaultTableModel modelDichvu = new DefaultTableModel();
    Controller.Control_QlKhachHang kh = new Control_QlKhachHang();
    List<QLKhachHang> khachHangs = new ArrayList<>();
    DefaultTableModel modelKhachang = new DefaultTableModel();
    Controller.Control_QLHoaDon hd = new Control_QLHoaDon();
    /**
     * Creates new form mdiXuatHoaDon
     */
    public mdiXuatHoaDon() {
        initComponents();
    }
    
    public mdiXuatHoaDon(int iddatphong,String ngaydat,String ngaytra,QlPhong qlPhong,QLNhanVien qlnv) {
        initComponents();
        lblMaHD.setVisible(false);
        txtMaHD.setVisible(false);
        lblWarning1.setVisible(false);
        this.ngaydat = ngaydat;
        this.ngaytra = ngaytra;
        this.qlnv = qlnv;
        this.qlPhong = qlPhong;
        this.iddatphong = iddatphong;
        getCurrentDate();
        setTableDichVu();
        setTableKhachHang();
        tonggia = tinhTongGia();
        songay = getKhoangCachNgay(ngaydat, ngaytra);
        ngaythuctra = ngaytra;
        gr = new ButtonGroup();
        gr.add(rdToanPhan);
        gr.add(rdTraTruoc);
        if(getKhoangCachNgay(ngaydat, ngayhientai)<0 || getKhoangCachNgay(ngayhientai, ngaytra)<0){
            rdTraTruoc.setVisible(false);
        }
        setData();
    }
    public mdiXuatHoaDon(int mahd,int iddatphong,String ngaydat,String ngaytra,QlPhong qlPhong,QLNhanVien qlnv,float tonggia,int songay) {
        initComponents();
        lblWarning1.setVisible(false);
        btnXacNhan.setVisible(false);
        pnHinhThucThanhToan.setVisible(false);
        lblMaHD.setVisible(true);
        txtMaHD.setVisible(true);
        this.ngaydat = ngaydat;
        this.ngaytra = ngaytra;
        this.qlnv = qlnv;
        this.qlPhong = qlPhong;
        this.iddatphong = iddatphong;
        this.songay = songay;
        this.tonggia = tonggia;
        setTableDichVu();
        setTableKhachHang();
        setData();
    }
    
    private void getCurrentDate(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        ngayhientai = sdf.format(date);
    }
    
    private float getKhoangCachNgay(String dayfrom,String dayto){
        long diff = 0;
        try{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date1 = sdf.parse(dayfrom);
        Date date2 = sdf.parse(dayto);
        diff = date2.getTime() - date1.getTime();
        }catch(Exception e){
            e.printStackTrace();
        }
            return diff / (1000 * 60 * 60* 24);
    }
    
    private void setTableDichVu(){
        modelDichvu.setRowCount(0);
        modelDichvu = (DefaultTableModel) tblDichVu.getModel();
        ds = qldv.getAllbyId(iddatphong);
        for (QlDichVu d : ds) {
            modelDichvu.addRow(new Object[]{
                d.getMadv(),d.getTendv(),d.getGiadv()
            });
            tongdichvu += d.getGiadv();
            System.out.println(tongdichvu);
        }
    }
    
    private void setTableKhachHang(){
        modelKhachang.setRowCount(0);
        modelKhachang = (DefaultTableModel) tblKhachhang.getModel();
        khachHangs = kh.getAllById(iddatphong);
        for (QLKhachHang d : khachHangs) {
            modelKhachang.addRow(new Object[]{
                d.getMakh(),d.getTenkh(),d.getCmnd(),d.getQuoctich(),d.getGioitinh(),d.getTuoi(),d.getSdt()
            });
            tongkhachhang++;
        }
    }
    
    private void setData(){
        txtTenPhong.setText(qlPhong.getTenphong());
        txtLoaiPhong.setText(qlPhong.getLoaiphong());
        txtGiaPhong.setText(qlPhong.getGiaphong() + "");
        txtNgayDat.setText(ngaydat);
        txtTenNV.setText(qlnv.getTennv());
        maphong = qlPhong.getMaphong();
        txtNgayTra.setText(ngaytra);
        txtSoNgay.setText(songay + "");
        txtTongGia.setText(tonggia + "");
    }
    
    private void setDateData(){
        txtNgayTra.setText(ngaythuctra);
        songay = getKhoangCachNgay(ngaydat, ngaythuctra);
        txtSoNgay.setText(songay + "");
        txtTongGia.setText(tinhTongGia() + "");
    }
    
    private float tinhTongGia(){
        float tong;
        float songaytong = getKhoangCachNgay(ngaydat, ngaytra);
        float ngaythua = songaytong - songay;
        float giaphong = (float) ((qlPhong.getGiaphong() * songaytong) - (qlPhong.getGiaphong() * ngaythua * 0.9));
        tong = giaphong + tongdichvu;
        System.out.println(tong + " - " + giaphong + " - " + tongdichvu);
        return tong;
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        tblKhachhang = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtNgayTra = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtGiaPhong = new javax.swing.JLabel();
        txtSoNgay = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDichVu = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        txtLoaiPhong = new javax.swing.JLabel();
        txtTongGia = new javax.swing.JLabel();
        btnhuy = new javax.swing.JButton();
        btnXacNhan = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtTenNV = new javax.swing.JLabel();
        txtNgayDat = new javax.swing.JLabel();
        txtTenPhong = new javax.swing.JLabel();
        pnHinhThucThanhToan = new javax.swing.JPanel();
        rdTraTruoc = new javax.swing.JRadioButton();
        rdToanPhan = new javax.swing.JRadioButton();
        lblWarning1 = new javax.swing.JLabel();
        lblMaHD = new javax.swing.JLabel();
        txtMaHD = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setUndecorated(true);
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                formMouseMoved(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setForeground(new java.awt.Color(0, 0, 0));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 0, 51));
        jLabel5.setText("TỔNG GIÁ: ");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 412, -1, -1));

        jPanel9.setBackground(new java.awt.Color(0, 0, 0));
        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh sách khách hàng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N

        tblKhachhang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã KH", "Tên KH", "CMND", "Quốc Tịch", "Giới Tính", "Tuổi", "Số Điện Thoại"
            }
        ));
        jScrollPane8.setViewportView(tblKhachhang);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 453, Short.MAX_VALUE)
            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 453, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 148, Short.MAX_VALUE)
            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE))
        );

        jPanel3.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 340, -1, 170));

        jLabel10.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("GIÁ PHÒNG: ");
        jPanel3.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 221, -1, -1));

        jLabel4.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("NGÀY TRẢ: ");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 295, -1, -1));

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("NGÀY ĐẶT: ");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 256, -1, -1));

        jLabel7.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("SỐ NGÀY: ");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 372, -1, -1));

        txtNgayTra.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtNgayTra.setForeground(new java.awt.Color(0, 0, 0));
        txtNgayTra.setText("NGÀY TRẢ");
        jPanel3.add(txtNgayTra, new org.netbeans.lib.awtextra.AbsoluteConstraints(128, 295, -1, -1));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("CHI TIẾT HÓA ĐƠN");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 30, -1, -1));

        txtGiaPhong.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtGiaPhong.setForeground(new java.awt.Color(0, 0, 0));
        txtGiaPhong.setText("110000");
        jPanel3.add(txtGiaPhong, new org.netbeans.lib.awtextra.AbsoluteConstraints(128, 221, -1, -1));

        txtSoNgay.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtSoNgay.setForeground(new java.awt.Color(0, 0, 0));
        txtSoNgay.setText("NUMBER");
        jPanel3.add(txtSoNgay, new org.netbeans.lib.awtextra.AbsoluteConstraints(128, 372, -1, -1));

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh sách dịch vụ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N

        tblDichVu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã dịch vụ", "Tên dịch vụ", "Giá dịch vụ"
            }
        ));
        jScrollPane1.setViewportView(tblDichVu);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 453, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 453, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 138, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE))
        );

        jPanel3.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 140, -1, 160));

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("PHÒNG: ");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 148, -1, -1));

        txtLoaiPhong.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtLoaiPhong.setForeground(new java.awt.Color(0, 0, 0));
        txtLoaiPhong.setText("Loại Phòng");
        jPanel3.add(txtLoaiPhong, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 185, -1, -1));

        txtTongGia.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtTongGia.setForeground(new java.awt.Color(255, 0, 0));
        txtTongGia.setText("NUMBER");
        jPanel3.add(txtTongGia, new org.netbeans.lib.awtextra.AbsoluteConstraints(128, 412, -1, -1));

        btnhuy.setBackground(new java.awt.Color(0, 0, 0));
        btnhuy.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btnhuy.setForeground(new java.awt.Color(255, 255, 255));
        btnhuy.setText("HỦY");
        btnhuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnhuyActionPerformed(evt);
            }
        });
        jPanel3.add(btnhuy, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 600, 700, 34));

        btnXacNhan.setBackground(new java.awt.Color(0, 0, 0));
        btnXacNhan.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btnXacNhan.setForeground(new java.awt.Color(255, 255, 255));
        btnXacNhan.setText("XÁC NHẬN THANH TOÁN");
        btnXacNhan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXacNhanActionPerformed(evt);
            }
        });
        jPanel3.add(btnXacNhan, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 550, 700, 35));

        jLabel6.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("NHÂN VIÊN: ");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 334, -1, -1));

        jLabel8.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("LOẠI PHÒNG: ");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 185, -1, -1));

        txtTenNV.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtTenNV.setForeground(new java.awt.Color(0, 0, 0));
        txtTenNV.setText("TÊN NV");
        jPanel3.add(txtTenNV, new org.netbeans.lib.awtextra.AbsoluteConstraints(128, 334, -1, -1));

        txtNgayDat.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtNgayDat.setForeground(new java.awt.Color(0, 0, 0));
        txtNgayDat.setText("NGÀY ĐẶT");
        jPanel3.add(txtNgayDat, new org.netbeans.lib.awtextra.AbsoluteConstraints(128, 256, -1, -1));

        txtTenPhong.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtTenPhong.setForeground(new java.awt.Color(0, 0, 0));
        txtTenPhong.setText("TÊN PHÒNG");
        jPanel3.add(txtTenPhong, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 148, -1, -1));

        pnHinhThucThanhToan.setBackground(new java.awt.Color(255, 255, 255));
        pnHinhThucThanhToan.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Hình thức thanh toán", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 11), new java.awt.Color(0, 0, 0))); // NOI18N

        rdTraTruoc.setBackground(new java.awt.Color(255, 255, 255));
        rdTraTruoc.setForeground(new java.awt.Color(0, 0, 0));
        rdTraTruoc.setText("Trả trước");
        rdTraTruoc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rdTraTruocMouseClicked(evt);
            }
        });

        rdToanPhan.setBackground(new java.awt.Color(255, 255, 255));
        rdToanPhan.setForeground(new java.awt.Color(0, 0, 0));
        rdToanPhan.setSelected(true);
        rdToanPhan.setText("Toàn phần");
        rdToanPhan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rdToanPhanMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnHinhThucThanhToanLayout = new javax.swing.GroupLayout(pnHinhThucThanhToan);
        pnHinhThucThanhToan.setLayout(pnHinhThucThanhToanLayout);
        pnHinhThucThanhToanLayout.setHorizontalGroup(
            pnHinhThucThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnHinhThucThanhToanLayout.createSequentialGroup()
                .addComponent(rdTraTruoc)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addComponent(rdToanPhan))
        );
        pnHinhThucThanhToanLayout.setVerticalGroup(
            pnHinhThucThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnHinhThucThanhToanLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnHinhThucThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdTraTruoc)
                    .addComponent(rdToanPhan))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jPanel3.add(pnHinhThucThanhToan, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 470, 200, 70));

        lblWarning1.setForeground(new java.awt.Color(255, 0, 0));
        lblWarning1.setText("Đã bao gồm thêm 10% giá phòng (*)");
        jPanel3.add(lblWarning1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 440, -1, -1));

        lblMaHD.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        lblMaHD.setForeground(new java.awt.Color(0, 0, 0));
        lblMaHD.setText("MÃ HĐ: ");
        jPanel3.add(lblMaHD, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 115, -1, -1));

        txtMaHD.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        txtMaHD.setForeground(new java.awt.Color(0, 0, 0));
        txtMaHD.setText("HD12345");
        jPanel3.add(txtMaHD, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 115, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 735, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 651, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
         xDrag = evt.getX();
         yDrag = evt.getY();
        JFrame jFrame = (JFrame) evt.getSource();
        mdiXuatHoaDon.this.setLocation(jFrame.getLocation().x+xDrag-xPress,jFrame.getLocation().y+yDrag-yPress);
    }//GEN-LAST:event_formMouseDragged

    private void formMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseMoved
        xPress = evt.getX();
        yPress = evt.getY();
    }//GEN-LAST:event_formMouseMoved

    private void btnhuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnhuyActionPerformed
        mdiXuatHoaDon.this.dispose();
    }//GEN-LAST:event_btnhuyActionPerformed

    private void btnXacNhanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXacNhanActionPerformed
        QLHoaDon qlhd = new QLHoaDon(0,songay,tinhTongGia(),iddatphong);
        if(hd.insert(qlhd) && qlp.resetTT(maphong) && qldp.resetTT(iddatphong,ngaythuctra)){
            JOptionPane.showMessageDialog(rootPane, "Thanh toán thành công", "Chúc mừng", JOptionPane.INFORMATION_MESSAGE);
            mdiHoaDon.setTableDatPhong();
            mdiHoaDon.settableHoaDon();
            mdiXuatHoaDon.this.dispose();
        }
        else{
            JOptionPane.showMessageDialog(rootPane, "Thanh toán thất bại", "Lỗi", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnXacNhanActionPerformed

    private void rdTraTruocMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdTraTruocMouseClicked
        ngaythuctra = ngayhientai;
        if(getKhoangCachNgay(ngaydat, ngaythuctra)<0){
            ngaythuctra = ngaytra;
        }
        setDateData();
        lblWarning1.setVisible(true);
    }//GEN-LAST:event_rdTraTruocMouseClicked

    private void rdToanPhanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdToanPhanMouseClicked
        ngaythuctra = ngaytra;        
        setDateData();
        lblWarning1.setVisible(false);
    }//GEN-LAST:event_rdToanPhanMouseClicked

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
            java.util.logging.Logger.getLogger(mdiXuatHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(mdiXuatHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(mdiXuatHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(mdiXuatHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new mdiXuatHoaDon().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnXacNhan;
    private javax.swing.JButton btnhuy;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JLabel lblMaHD;
    private javax.swing.JLabel lblWarning1;
    private javax.swing.JPanel pnHinhThucThanhToan;
    private javax.swing.JRadioButton rdToanPhan;
    private javax.swing.JRadioButton rdTraTruoc;
    private javax.swing.JTable tblDichVu;
    private javax.swing.JTable tblKhachhang;
    private javax.swing.JLabel txtGiaPhong;
    private javax.swing.JLabel txtLoaiPhong;
    private javax.swing.JLabel txtMaHD;
    private javax.swing.JLabel txtNgayDat;
    private javax.swing.JLabel txtNgayTra;
    private javax.swing.JLabel txtSoNgay;
    private javax.swing.JLabel txtTenNV;
    private javax.swing.JLabel txtTenPhong;
    private javax.swing.JLabel txtTongGia;
    // End of variables declaration//GEN-END:variables

}
