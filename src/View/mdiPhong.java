/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.QLNhanVien;
import Model.QlDichVu;
import Model.QlPhong;
import Controller.*;
import DAO.MyConnection;
import java.sql.Connection;
import java.util.Hashtable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author DELL
 */
public class mdiPhong extends javax.swing.JInternalFrame {

    private int ktthem;
    private String checkTk;
    ButtonGroup btg;
    Control_QlPhong ql = new Control_QlPhong();
    Control_QlDichVu dv = new Control_QlDichVu();
    Control_QlNhanVien nv = new Control_QlNhanVien();
    DefaultTableModel model = new DefaultTableModel();

    /**
     * Creates new form FrmPhong
     */
    public void groupbtn() {
        btg = new ButtonGroup();
        btg.add(rdCon);
        btg.add(rdKhong);
    }

    


    public mdiPhong() {
        initComponents();
        groupbtn();
        settable();
        setComEnable(true);
    }

  

    

    public void setComEnable(boolean b) {
        btnThem.setEnabled(b);
        btnSua.setEnabled(b);
        btnXoa.setEnabled(b);

        btnGhi.setEnabled(!b);
        btnKhong.setEnabled(!b);

        txtMaPhong.setEnabled(!b);
        txtTenPhong.setEnabled(!b);
        txtLoaiPhong.setEnabled(!b);
        txtGiaPhong.setEnabled(!b);
        txtChuThich.setEnabled(!b);
        rdCon.setEnabled(!b);
        rdKhong.setEnabled(!b);
        txtChuThich.setEnabled(!b);
    }

    public void reset() {
        txtMaPhong.setText("");
        txtTenPhong.setText("");
        txtLoaiPhong.setText("");
        txtGiaPhong.setText("");
        txtChuThich.setText("");
//        rdCon.setEnabled(true);
//        rdKhong.setEnabled(true);
//        cbDichVu.setEnabled(true);
//        cbNhanVien.setEnabled(true);
        txtMaPhong.requestFocus();
    }

    public void settable() {
        checkTk = "";
        model.setRowCount(0);
        model = (DefaultTableModel) tbl1.getModel();
        List<QlPhong> ds = ql.getAll();
        for (QlPhong d : ds) {
            model.addRow(new Object[]{
                d.getMaphong(), d.getTenphong(), d.getLoaiphong(),
                d.getGiaphong(), d.getChuthich(), d.getTinhtrang(),
            });
        }
    }

    private boolean KiemtraDK() {
        boolean check = true;
        if (txtMaPhong.getText().length() <= 0) {
            check = false;
            JOptionPane.showMessageDialog(rootPane, "Bạn chưa nhập mã phòng", "Cập nhật thất bại", JOptionPane.WARNING_MESSAGE);
        } else if (txtTenPhong.getText().length() <= 0) {
            check = false;
            JOptionPane.showMessageDialog(rootPane, "Bạn chưa nhập tên phòng", "Cập nhật thất bại", JOptionPane.WARNING_MESSAGE);
        } else if (txtLoaiPhong.getText().length() <= 0) {
            check = false;
            JOptionPane.showMessageDialog(rootPane, "Bạn chưa nhập loại phòng", "Cập nhật thất bại", JOptionPane.WARNING_MESSAGE);
        } else if (txtGiaPhong.getText().length() > 0) {
            try {
                float checkGia = Float.parseFloat(txtGiaPhong.getText());
            } catch (Exception e) {
                JOptionPane.showMessageDialog(rootPane, "Gía phòng nhập sai định dạng", "Cập nhật thất bại", JOptionPane.WARNING_MESSAGE);
            }
        } else if (txtGiaPhong.getText().length() <= 0) {
            check = false;
            JOptionPane.showMessageDialog(rootPane, "Bạn chưa nhập giá phòng", "Cập nhật thất bại", JOptionPane.WARNING_MESSAGE);
        }
        return check;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl1 = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        txtTkTenPhong = new javax.swing.JTextField();
        btnTimKiem = new javax.swing.JButton();
        btnIn = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtMaPhong = new javax.swing.JTextField();
        txtTenPhong = new javax.swing.JTextField();
        txtLoaiPhong = new javax.swing.JTextField();
        txtGiaPhong = new javax.swing.JTextField();
        txtChuThich = new javax.swing.JTextField();
        rdCon = new javax.swing.JRadioButton();
        rdKhong = new javax.swing.JRadioButton();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnGhi = new javax.swing.JButton();
        btnKhong = new javax.swing.JButton();
        btnKetThuc = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        btnDatPhong = new javax.swing.JButton();

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Danh sách phòng"));

        tbl1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "MÃ PHÒNG", "TÊN PHÒNG", "LOẠI PHÒNG", "GIÁ PHÒNG", "CHÚ THÍCH", "TÌNH TRẠNG"
            }
        ));
        tbl1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl1);

        jLabel9.setText("TÊN PHÒNG :");

        btnTimKiem.setText("TÌM KIẾM");
        btnTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemActionPerformed(evt);
            }
        });

        btnIn.setText("In");
        btnIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 623, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addGap(18, 18, 18)
                .addComponent(txtTkTenPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnTimKiem)
                .addGap(18, 18, 18)
                .addComponent(btnIn, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtTkTenPhong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTimKiem)
                    .addComponent(btnIn))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông tin chi tiết"));

        jLabel1.setText("MÃ PHÒNG");

        jLabel2.setText("TÊN PHÒNG");

        jLabel3.setText("LOẠI PHÒNG");

        jLabel4.setText("GIÁ PHÒNG");

        jLabel5.setText("CHÚ THÍCH");

        jLabel6.setText("TÌNH TRẠNG");

        rdCon.setText("Còn");

        rdKhong.setText("Hết");

        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnGhi.setText("Ok");
        btnGhi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGhiActionPerformed(evt);
            }
        });

        btnKhong.setText("Không");
        btnKhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKhongActionPerformed(evt);
            }
        });

        btnKetThuc.setText("Kết thúc");
        btnKetThuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKetThucActionPerformed(evt);
            }
        });

        jButton1.setText("Reset");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnDatPhong.setText("Đặt Phòng");
        btnDatPhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDatPhongActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel2))
                        .addGap(14, 14, 14)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtMaPhong)
                            .addComponent(txtTenPhong)
                            .addComponent(txtLoaiPhong)
                            .addComponent(txtGiaPhong)
                            .addComponent(txtChuThich)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(43, 43, 43)
                                .addComponent(rdCon)
                                .addGap(42, 42, 42)
                                .addComponent(rdKhong)
                                .addGap(0, 34, Short.MAX_VALUE))))
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnThem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnGhi, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnKhong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(45, 45, 45)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnXoa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnKetThuc)))
                    .addComponent(btnDatPhong, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtMaPhong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtTenPhong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtLoaiPhong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtGiaPhong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtChuThich, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(rdCon)
                    .addComponent(rdKhong))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnKhong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnGhi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnKetThuc, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(8, 8, 8)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnDatPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
        ktthem = 3;
        btnThem.setEnabled(false);
        btnSua.setEnabled(false);
        btnXoa.setEnabled(false);
        btnGhi.setEnabled(true);
        btnKhong.setEnabled(true);

        txtMaPhong.setEnabled(true);
        txtTenPhong.setEnabled(true);
        txtLoaiPhong.setEnabled(true);
        txtGiaPhong.setEnabled(true);
        txtChuThich.setEnabled(true);
        rdCon.setEnabled(true);
        rdKhong.setEnabled(true);

        checkTk = txtTkTenPhong.getText();
        model.setRowCount(0);
        model = (DefaultTableModel) tbl1.getModel();
        if (checkTk == "") {
            List<QlPhong> ds = ql.getAll();
            for (QlPhong d : ds) {
                model.addRow(new Object[]{
                    d.getMaphong(), d.getTenphong(), d.getLoaiphong(),
                    d.getGiaphong(), d.getChuthich(), d.getTinhtrang(),
                });
            }
        } else {
            List<QlPhong> ds = ql.getAll(checkTk);
            for (QlPhong d : ds) {
                model.addRow(new Object[]{
                    d.getMaphong(), d.getTenphong(), d.getLoaiphong(),
                    d.getGiaphong(), d.getChuthich(), d.getTinhtrang(),
                });
            }
        }
    }//GEN-LAST:event_btnTimKiemActionPerformed

    private void tbl1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl1MouseClicked
        txtMaPhong.setText((String) model.getValueAt(tbl1.getSelectedRow(), 0));
        txtTenPhong.setText((String) model.getValueAt(tbl1.getSelectedRow(), 1));
        txtLoaiPhong.setText((String) model.getValueAt(tbl1.getSelectedRow(), 2));
        txtGiaPhong.setText("" + String.valueOf(model.getValueAt(tbl1.getSelectedRow(), 3)));
        txtChuThich.setText((String) model.getValueAt(tbl1.getSelectedRow(), 4));
        String checkTT = (String) model.getValueAt(tbl1.getSelectedRow(), 5);
        if (checkTT.toUpperCase().equals("CON")) {
            rdCon.setSelected(true);
        } else {
            rdKhong.setSelected(true);
        }


    }//GEN-LAST:event_tbl1MouseClicked

    private void btnInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInActionPerformed
        if (txtMaPhong.getText().length() <= 0) {
            try {
                Hashtable map = new Hashtable();
                JasperReport js = JasperCompileManager.compileReport("src/Reports/rptPhong1.jrxml");
           //     map.put("sMAPHONG", txtMaPhong.getText());
                MyConnection mc = MyConnection.getInstance();
                Connection conn = mc.getConnect();
                JasperPrint p = JasperFillManager.fillReport(js, map, conn);
                JasperViewer.viewReport(p, false); //is xml file false
            } catch (JRException ej) {
                Logger.getLogger(mdiPhong.class.getName()).log(Level.SEVERE, null, ej);
            }
        } else {
            try {
                Hashtable map = new Hashtable();
                JasperReport js = JasperCompileManager.compileReport("src/Reports/rptPhong2.jrxml");
                map.put("sMAPHONG", txtMaPhong.getText());
                MyConnection mc = MyConnection.getInstance();
                Connection conn = mc.getConnect();
                JasperPrint p = JasperFillManager.fillReport(js, map, conn);
                JasperViewer.viewReport(p, false);
            } catch (JRException ej) {
                Logger.getLogger(mdiPhong.class.getName()).log(Level.SEVERE, null, ej);
            }
        }
    }//GEN-LAST:event_btnInActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        txtMaPhong.setText("");
        txtTenPhong.setText("");
        txtLoaiPhong.setText("");
        txtGiaPhong.setText("");
        txtChuThich.setText("");
        //        rdCon.setEnabled(true);
        //        rdKhong.setEnabled(true);
        //        cbDichVu.setEnabled(true);
        //        cbNhanVien.setEnabled(true);

        txtMaPhong.requestFocus();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnKetThucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKetThucActionPerformed
        int check = JOptionPane.showConfirmDialog(rootPane, "Xác nhận thoát?", "Cảnh báo", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if (check == 0) {
            dispose();
        }
    }//GEN-LAST:event_btnKetThucActionPerformed

    private void btnKhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKhongActionPerformed
        reset();
        setComEnable(true);
    }//GEN-LAST:event_btnKhongActionPerformed

    private void btnGhiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGhiActionPerformed
        if(ktthem == 3){
            String maphong,tenphong,loaiphong,chuthich,tinhtrang = "";
            tenphong = txtTenPhong.getText().toString();
            maphong = txtMaPhong.getText().toString();
            loaiphong = txtLoaiPhong.getText().toString();
            chuthich = txtChuThich.getText().toString();
            if(rdCon.isSelected()){
                tinhtrang = "con";
            }
            else if(rdKhong.isSelected()){
                tinhtrang = "het";
            }
            int giaphong;
            if(txtGiaPhong.getText().toString().equals("")){
                giaphong = -9999;
            }
            else{
                giaphong = Integer.parseInt(txtGiaPhong.getText().toString());
            }
            QlPhong qlPhong = new QlPhong(maphong, tenphong, loaiphong, giaphong, chuthich, tinhtrang);
            model.setRowCount(0);
            model = (DefaultTableModel) tbl1.getModel();
            List<QlPhong> ds = ql.search(qlPhong);
            for(QlPhong q : ds){
                model.addRow(new Object[]{
                    q.getMaphong(),q.getTenphong(),q.getLoaiphong(),q.getGiaphong(),q.getChuthich(),q.getTinhtrang()
                });
            }
        }
        else if (ktthem == 1 && checkMa(txtMaPhong.getText())) {
            JOptionPane.showMessageDialog(rootPane, "Mã phòng đã tồn tại", "Ghi thất bại", JOptionPane.WARNING_MESSAGE);
            reset();
        } else if (ktthem == 1) {
            if (!KiemtraDK()) {
                return;
            } else {
                QlPhong cn = new QlPhong(txtMaPhong.getText(), txtTenPhong.getText(), txtLoaiPhong.getText(),
                    Float.parseFloat(txtGiaPhong.getText()), txtChuThich.getText(),
                    rdCon.isSelected() ? "con" : "het"
                );
                if (ql.insert(cn)) {
                    JOptionPane.showMessageDialog(rootPane, "Thêm phòng thành công", "Chúc mừng", JOptionPane.INFORMATION_MESSAGE);
                }
                settable();
            }
        } else if (ktthem == 2) {
            if (!KiemtraDK()) {
                return;
            } else {
                QlPhong cn = new QlPhong(txtMaPhong.getText(), txtTenPhong.getText(), txtLoaiPhong.getText(),
                    Float.parseFloat(txtGiaPhong.getText()), txtChuThich.getText(),
                    rdCon.isSelected() ? "con" : "het"
                );
                if (ql.update(cn)) {
                    JOptionPane.showMessageDialog(rootPane, "Cập nhật phòng thành công", "Chúc mừng", JOptionPane.INFORMATION_MESSAGE);
                }
                settable();
            }
        }
        setComEnable(true);
        reset();
    }//GEN-LAST:event_btnGhiActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        if (txtMaPhong.getText().length() <= 0) {
            return;
        }
        QlPhong qlp = new QlPhong();
        qlp.setMaphong(txtMaPhong.getText());
        qlp.setTenphong(txtTenPhong.getText());
        int check = JOptionPane.showConfirmDialog(rootPane, "Xác nhận xóa?", "Cảnh báo", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if (check == 0) {
            if (ql.delete(qlp)) {
                JOptionPane.showMessageDialog(rootPane, "Xóa phòng " + qlp.getTenphong() + " thành công", "Chúc mừng", JOptionPane.INFORMATION_MESSAGE);
            }
            settable();
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        if (txtMaPhong.getText().length() <= 0) {
            return;
        }
        setComEnable(false);
        ktthem = 2;
        txtTenPhong.requestFocus();
        txtMaPhong.setEnabled(false);
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        ktthem = 1;
        reset();
        setComEnable(false);
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnDatPhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDatPhongActionPerformed
            mdiDatPhong mDatPhong = new mdiDatPhong();
            mDatPhong.setLocationRelativeTo(this);
            mDatPhong.setVisible(true);
            mDatPhong.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            mdiPhong.this.dispose();
    }//GEN-LAST:event_btnDatPhongActionPerformed
    private boolean checkMa(String str) {
        boolean b = false;
        List<QlPhong> ds = ql.getAll();
        for (QlPhong d : ds) {
            if (d.getMaphong().equals(str)) {
                b = true;
            }
        }
        return b;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDatPhong;
    private javax.swing.JButton btnGhi;
    private javax.swing.JButton btnIn;
    private javax.swing.JButton btnKetThuc;
    private javax.swing.JButton btnKhong;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rdCon;
    private javax.swing.JRadioButton rdKhong;
    private javax.swing.JTable tbl1;
    private javax.swing.JTextField txtChuThich;
    private javax.swing.JTextField txtGiaPhong;
    private javax.swing.JTextField txtLoaiPhong;
    private javax.swing.JTextField txtMaPhong;
    private javax.swing.JTextField txtTenPhong;
    private javax.swing.JTextField txtTkTenPhong;
    // End of variables declaration//GEN-END:variables
}
