/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.QLNhanVien;
import Controller.Control_QlNhanVien;
import DAO.MyConnection;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
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
public class mdiNhanVien extends javax.swing.JInternalFrame {

    ButtonGroup btg;
    private String checkTk;
    DefaultTableModel model = new DefaultTableModel();
    Controller.Control_QlNhanVien ql = new Control_QlNhanVien();
    int ktthem;

    public mdiNhanVien() {
        initComponents();
        setGroup();
        settable();
        setComEnable(true);
    }

    public void setComEnable(boolean b) {
        btnThem.setEnabled(b);
        btnSua.setEnabled(b);
        btnXoa.setEnabled(b);

        btnGhi.setEnabled(!b);
        btnKhong.setEnabled(!b);

        txtMaNV.setEnabled(!b);
        txtTenNV.setEnabled(!b);
        txtChucVu.setEnabled(!b);
        txtLuong.setEnabled(!b);
        txtDate.setEnabled(!b);
        rdNam.setEnabled(!b);
        rdNu.setEnabled(!b);
        txtChuThich.setEnabled(!b);
    }

    public void reset() {
        txtMaNV.setText("");
        txtTenNV.setText("");
        txtChucVu.setText("");
        txtLuong.setText("");
        txtDate.setDate(null);
        txtChuThich.setText("");
        btg.clearSelection();
        txtMaNV.requestFocus();
    }

    public void settable() {
        checkTk = "";
        model.setRowCount(0);
        model = (DefaultTableModel) tbl1.getModel();
        List<QLNhanVien> ds = ql.getAll();
        for (QLNhanVien d : ds) {
            model.addRow(new Object[]{
                d.getMnv(), d.getTennv(), d.getChucvu(),
                d.getLuong(), d.getNgaysinh(), d.getGioitinh(),
                d.getChuthich()
            });
        }
    }

    public void setGroup() {
        btg = new ButtonGroup();
        btg.add(rdNu);
        btg.add(rdNam);
    }

    private boolean KiemtraDK() {
        boolean check = true;
        if (txtTenNV.getText().toString().trim().length() <= 0) {
            check = false;
            JOptionPane.showMessageDialog(rootPane, "Bạn chưa nhập tên nhân viên", "Cập nhật thất bại", JOptionPane.WARNING_MESSAGE);
        } else if (txtChucVu.getText().toString().trim().length() <= 0) {
            check = false;
            JOptionPane.showMessageDialog(rootPane, "Bạn chưa nhập chức vụ", "Cập nhật thất bại", JOptionPane.WARNING_MESSAGE);
        } else if (txtLuong.getText().toString().trim().length() > 0) {
            try {
                Float.parseFloat(txtLuong.getText().toString().trim());
            } catch (Exception e) {
                check = false;
                JOptionPane.showMessageDialog(rootPane, "Lương nhập sai định dạng", "Cập nhật thất bại", JOptionPane.WARNING_MESSAGE);
            }
        } else if (txtLuong.getText().toString().trim().length() <= 0) {
            check = false;
            JOptionPane.showMessageDialog(rootPane, "Bạn chưa nhập lương", "Cập nhật thất bại", JOptionPane.WARNING_MESSAGE);
        } else if (txtLuong.getText().toString().trim().length() > 0) {
            try {
                int checkLuong = Integer.parseInt(txtLuong.getText());
                if (checkLuong <= 0) {
                    check = false;
                    JOptionPane.showMessageDialog(rootPane, "Lương nhập sai định dạng", "Cập nhật thất bại", JOptionPane.WARNING_MESSAGE);
                }
            } catch (Exception e) {
                check = false;
                JOptionPane.showMessageDialog(rootPane, "Lương nhập sai định dạng", "Cập nhật thất bại", JOptionPane.WARNING_MESSAGE);
            }
        }
        try {
            new SimpleDateFormat("yyyy-MM-dd").format(txtDate.getDate());
        } catch (Exception e) {
            check = false;
            JOptionPane.showMessageDialog(rootPane, "Chọn sai định dạng ngày", "Lỗi", JOptionPane.INFORMATION_MESSAGE);
        }
        if(!rdNam.isSelected() && !rdNu.isSelected()){
            JOptionPane.showMessageDialog(rootPane, "Chưa chọn giới tính", "Cập nhật thất bại", JOptionPane.WARNING_MESSAGE);
            check = false;
        }
//        if(rdNam.isSelected()){
//            System.out.println("nam");
//        }
//        else if(rdNu.isSelected()){
//            System.out.println("nu");
//        }

        return check;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl1 = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtMaNV = new javax.swing.JTextField();
        txtTenNV = new javax.swing.JTextField();
        txtChucVu = new javax.swing.JTextField();
        txtLuong = new javax.swing.JTextField();
        rdNam = new javax.swing.JRadioButton();
        rdNu = new javax.swing.JRadioButton();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnGhi = new javax.swing.JButton();
        btnKhong = new javax.swing.JButton();
        btnKetthuc = new javax.swing.JButton();
        txtChuThich = new javax.swing.JTextField();
        txtDate = new com.toedter.calendar.JDateChooser();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtTKnv = new javax.swing.JTextField();
        btnTimKiem = new javax.swing.JButton();
        btnIn = new javax.swing.JButton();

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Danh sách nhân viên"));

        tbl1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "MÃ NV", "TÊN NV", "CHỨC VỤ", "LƯƠNG", "NGÀY SINH", "GIỚI TÍNH", "CHÚ THÍCH"
            }
        ));
        tbl1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl1);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông tin chi tiết"));

        jLabel9.setText("MÃ NV");

        jLabel10.setText("TÊN NV");

        jLabel11.setText("CHỨC VỤ");

        jLabel12.setText("LƯƠNG");

        jLabel13.setText("NGÀY SINH");

        jLabel14.setText("GIỚI TÍNH");

        jLabel15.setText("CHÚ THÍCH");

        rdNam.setText("NAM");

        rdNu.setText("NỮ");

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

        btnKetthuc.setText("Kết thúc");
        btnKetthuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKetthucActionPerformed(evt);
            }
        });

        jButton1.setText("Reset");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12)
                            .addComponent(jLabel13)
                            .addComponent(jLabel14)
                            .addComponent(jLabel15)
                            .addComponent(jLabel10))
                        .addGap(24, 24, 24)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtMaNV)
                            .addComponent(txtTenNV)
                            .addComponent(txtChucVu)
                            .addComponent(txtLuong)
                            .addComponent(txtChuThich)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(43, 43, 43)
                                .addComponent(rdNam)
                                .addGap(42, 42, 42)
                                .addComponent(rdNu)
                                .addGap(0, 32, Short.MAX_VALUE))
                            .addComponent(txtDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnThem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnGhi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnKhong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnXoa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnKetthuc, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnSua, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtTenNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(rdNam)
                    .addComponent(rdNu))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(txtChuThich, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnKhong, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGhi, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnKetthuc, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel1.setText("TÊN NHÂN VIÊN");

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
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 623, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(txtTKnv, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(btnIn, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtTKnv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTimKiem)
                    .addComponent(btnIn))
                .addGap(19, 19, 19)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 413, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

        txtMaNV.setEnabled(true);
        txtTenNV.setEnabled(true);
        txtChucVu.setEnabled(true);
        txtLuong.setEnabled(true);
        txtChuThich.setEnabled(true);
        txtDate.setEnabled(true);
        rdNu.setEnabled(true);
        rdNam.setEnabled(true);

        checkTk = txtTKnv.getText();
        model.setRowCount(0);
        model = (DefaultTableModel) tbl1.getModel();
        if (checkTk == "") {
            List<QLNhanVien> ds = ql.getAll();
            for (QLNhanVien d : ds) {
                model.addRow(new Object[]{
                    d.getMnv(), d.getTennv(), d.getChucvu(),
                    d.getLuong(), d.getNgaysinh(), d.getGioitinh(),
                    d.getChuthich()
                });
            }
        } else {
            List<QLNhanVien> ds = ql.getAll(checkTk);
            for (QLNhanVien d : ds) {
                model.addRow(new Object[]{
                    d.getMnv(), d.getTennv(), d.getChucvu(),
                    d.getLuong(), d.getNgaysinh(), d.getGioitinh(),
                    d.getChuthich()
                });
            }
        }
    }//GEN-LAST:event_btnTimKiemActionPerformed

    private void tbl1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl1MouseClicked
        txtMaNV.setText((String) model.getValueAt(tbl1.getSelectedRow(), 0));
        txtTenNV.setText((String) model.getValueAt(tbl1.getSelectedRow(), 1));
        txtChucVu.setText((String) model.getValueAt(tbl1.getSelectedRow(), 2));
        txtLuong.setText("" + String.valueOf(model.getValueAt(tbl1.getSelectedRow(), 3)));
        try {
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse((String) model.getValueAt(tbl1.getSelectedRow(), 4));
            txtDate.setDate(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String checkGT = (String) model.getValueAt(tbl1.getSelectedRow(), 5);
        System.out.println(checkGT);
        if (checkGT.toUpperCase().equals("NAM")) {
            rdNam.setSelected(true);
        } else {
            rdNu.setSelected(true);
        }
        txtChuThich.setText((String) model.getValueAt(tbl1.getSelectedRow(), 6));
        setComEnable(true);
    }//GEN-LAST:event_tbl1MouseClicked

    private void btnKetthucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKetthucActionPerformed
        int check = JOptionPane.showConfirmDialog(rootPane, "Xác nhận thoát?", "Cảnh báo", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if (check == 0) {
            dispose();
        }
    }//GEN-LAST:event_btnKetthucActionPerformed

    private void btnKhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKhongActionPerformed
        reset();
        setComEnable(true);
    }//GEN-LAST:event_btnKhongActionPerformed

    private void btnGhiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGhiActionPerformed
        if (ktthem == 3) {
            String manv, tennv, chucvu, luong, gioitinh, chuthich, ns;
            if (txtMaNV.getText().toString().trim().equals("")) {
                manv = "";
            } else {
                manv = txtMaNV.getText().toString().trim();
            }
            if (txtTenNV.getText().toString().trim().equals("")) {
                tennv = "";
            } else {
                tennv = txtTenNV.getText().toString().trim();
            }
            if (txtChucVu.getText().toString().trim().equals("")) {
                chucvu = "";
            } else {
                chucvu = txtChucVu.getText().toString().trim();
            }
            if (txtLuong.getText().toString().trim().equals("")) {
                luong = "-9999";
            } else {
                luong = txtLuong.getText().toString().trim();
            }
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            try {
                ns = sdf.format(txtDate.getDate());
            } catch (Exception e) {
                ns = "";
            }
            if (!rdNam.isSelected() && !rdNu.isSelected()) {
                gioitinh = "";
            } else {
                gioitinh = rdNam.isSelected() ? "nam" : "nu";
            }
            if (txtChuThich.getText().toString().trim().equals("")) {
                chuthich = "";
            } else {
                chuthich = txtMaNV.getText().toString().trim();
            }
            QLNhanVien cn = new QLNhanVien(manv, tennv, chucvu, Float.parseFloat(luong), ns,
                    gioitinh, chuthich
            );
            model.setRowCount(0);
            model = (DefaultTableModel) tbl1.getModel();
            List<QLNhanVien> ds = ql.search(cn);
            for (QLNhanVien d : ds) {
                model.addRow(new Object[]{
                    d.getMnv(), d.getTennv(), d.getChucvu(), d.getLuong(), d.getNgaysinh(), d.getGioitinh(), d.getChuthich()
                });
            }
            return;
        } else if (txtMaNV.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Bạn chưa nhập mã nhân viên", "Ghi thất bại", JOptionPane.WARNING_MESSAGE);
            reset();
        } else if (ktthem == 1 && checkMa(txtMaNV.getText())) {
            JOptionPane.showMessageDialog(rootPane, "Mã nhân viên đã tồn tại", "Ghi thất bại", JOptionPane.WARNING_MESSAGE);
            reset();
        } else if (ktthem == 1) {
            if (KiemtraDK()) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                String date = sdf.format(txtDate.getDate());
                QLNhanVien cn = new QLNhanVien(txtMaNV.getText().toString().trim(), txtTenNV.getText().toString().trim(), txtChucVu.getText().toString().trim(), Float.parseFloat(txtLuong.getText().toString().trim()), date,
                        rdNam.isSelected() ? "Nam" : "Nu", txtChuThich.getText().toString().trim()
                );
                if (ql.insert(cn)) {
                    JOptionPane.showMessageDialog(rootPane, "Thêm nhân viên thành công", "Chúc mừng", JOptionPane.INFORMATION_MESSAGE);
                }
                settable();
            }
        } else if (ktthem == 2) {
            if (!KiemtraDK()) {
                return;
            } else {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                String date = sdf.format(txtDate.getDate());
                QLNhanVien cn = new QLNhanVien(txtMaNV.getText().toString().trim(), txtTenNV.getText().toString().trim(), txtChucVu.getText().toString().trim(), Float.parseFloat(txtLuong.getText().toString().trim()), date,
                        rdNam.isSelected() ? "Nam" : "Nu", txtChuThich.getText().toString().trim()
                );
                if (ql.update(cn)) {
                    JOptionPane.showMessageDialog(rootPane, "Cập nhật nhân viêṇ thành công", "Chúc mừng", JOptionPane.INFORMATION_MESSAGE);
                }
                settable();
            }
        }
        setComEnable(true);
        reset();
    }//GEN-LAST:event_btnGhiActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        if (txtMaNV.getText().length() <= 0) {
            return;
        }
        QLNhanVien dv = new QLNhanVien();
        dv.setMnv(txtMaNV.getText());
        dv.setTennv(txtTenNV.getText());
        int check = JOptionPane.showConfirmDialog(rootPane, "Xác nhận xóa?", "Cảnh báo", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if (check == 0) {
            if (ql.delete(dv)) {
                JOptionPane.showMessageDialog(rootPane, "Xóa nhân viên " + dv.getTennv() + " thành công", "Chúc mừng", JOptionPane.INFORMATION_MESSAGE);
            }
            else{
                JOptionPane.showMessageDialog(rootPane, "Xóa thất bại " + dv.getTennv() + " Opps", "Chúc mừng", JOptionPane.INFORMATION_MESSAGE);
            }
            settable();
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        if (txtMaNV.getText().length() <= 0) {
            return;
        }
        setComEnable(false);
        ktthem = 2;
        txtTenNV.requestFocus();
        txtMaNV.setEnabled(false);
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        ktthem = 1;
        reset();
       // rdNam.setSelected(true);
        setComEnable(false);
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInActionPerformed
        if (txtMaNV.getText().length() <= 0) {
            try {
                Hashtable map = new Hashtable();
                JasperReport js = JasperCompileManager.compileReport("src/Reports/rptNhanVien1.jrxml");
                map.put("sMANV", txtMaNV.getText());
                MyConnection mc = MyConnection.getInstance();
                Connection conn = mc.getConnect();
                JasperPrint p = JasperFillManager.fillReport(js, map, conn);
                JasperViewer.viewReport(p, false);
            } catch (JRException ej) {
                Logger.getLogger(mdiPhong.class.getName()).log(Level.SEVERE, null, ej);
            }
        } else {
            try {
                Hashtable map = new Hashtable();
                JasperReport js = JasperCompileManager.compileReport("src/Reports/rptNhanVien2.jrxml");
                map.put("sMANV", txtMaNV.getText());
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
        txtMaNV.setText("");
        txtTenNV.setText("");
        txtChucVu.setText("");
        txtLuong.setText("");
        //   txtDate.setEnabled(true);
        txtDate.setDate(null);
        txtChuThich.setText("");
        txtMaNV.requestFocus();
        btg.clearSelection();
    }//GEN-LAST:event_jButton1ActionPerformed
    private boolean checkMa(String str) {
        boolean b = false;
        List<QLNhanVien> ds = ql.getAll();
        for (QLNhanVien d : ds) {
            if (d.getMnv().equals(str)) {
                b = true;
            }
        }
        return b;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGhi;
    private javax.swing.JButton btnIn;
    private javax.swing.JButton btnKetthuc;
    private javax.swing.JButton btnKhong;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rdNam;
    private javax.swing.JRadioButton rdNu;
    private javax.swing.JTable tbl1;
    private javax.swing.JTextField txtChuThich;
    private javax.swing.JTextField txtChucVu;
    private com.toedter.calendar.JDateChooser txtDate;
    private javax.swing.JTextField txtLuong;
    private javax.swing.JTextField txtMaNV;
    private javax.swing.JTextField txtTKnv;
    private javax.swing.JTextField txtTenNV;
    // End of variables declaration//GEN-END:variables
}
