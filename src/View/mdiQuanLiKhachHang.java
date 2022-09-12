/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.QLKhachHang;
import Model.QlPhong;
import javax.swing.ButtonGroup;
import java.sql.*;
import Controller.*;
import DAO.MyConnection;
import Model.DatPhong;
import java.util.Hashtable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import CustomComponent.Country;
import javax.swing.DefaultComboBoxModel;
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
public class mdiQuanLiKhachHang extends javax.swing.JInternalFrame {
    private final String regexStr = "^[0-9]*$";
    private int ktthem;
    private String checkTk;
    ButtonGroup btg;
    Control_DatPhong qp = new Control_DatPhong();
    Control_QlKhachHang ql = new Control_QlKhachHang();
    DefaultTableModel model = new DefaultTableModel();
    int tuoi = -9999, iddatphong = -9999;

    public mdiQuanLiKhachHang() {
        initComponents();
        setComboPhong();
        settable();
        groupbtn();
        setComEnable(true);
        txtMaKH.setEnabled(false);
        switchStateComboPhong(false);
    }

    private void switchStateComboPhong(boolean b){
        txtIdDatPhong.setVisible(b);
        cbPhong.setVisible(b);
    }

    public void groupbtn() {
        btg = new ButtonGroup();
        btg.add(rdNam);
        btg.add(rdNu);
    }

    public int getPhongIndex(int idphong) {
        int i = 1;
        List<DatPhong> ds = qp.getAll();
        for (DatPhong d : ds) {
            if (d.getId() == idphong) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public void setComboPhong() {
        List<DatPhong> ds = qp.getAll();
        for (DatPhong d : ds) {
            cbPhong.addItem(String.valueOf(d.getId()));
        }
    }

    public void setComEnable(boolean b) {
        btnThem.setEnabled(b);
        btnSua.setEnabled(b);
        btnXoa.setEnabled(b);

        btnGhi.setEnabled(!b);
        btnKhong.setEnabled(!b);

        txtTenKH.setEnabled(!b);
        txtCMND.setEnabled(!b);
        cbQuocTich.setEnabled(!b);
        txtTuoi.setEnabled(!b);
        rdNam.setEnabled(!b);
        rdNu.setEnabled(!b);
        txtTuoi.setEnabled(!b);
        txtSDT.setEnabled(!b);
        cbPhong.setEnabled(!b);
        txtMaKH.setText("");
    }
    
    private boolean checkPhoneNumber(String setnum){
        return setnum.matches(regexStr);
    }

    private boolean KiemtraDK() {
        boolean check = true;
        String sdt = txtSDT.getText();
        if (txtTenKH.getText().toString().trim().length() <= 0) {
            check = false;
            JOptionPane.showMessageDialog(rootPane, "Bạn chưa nhập tên khách hàng", "Cập nhật thất bại", JOptionPane.WARNING_MESSAGE);
        } else if (txtCMND.getText().toString().trim().length() <= 0) {
            check = false;
            JOptionPane.showMessageDialog(rootPane, "Bạn chưa nhập CMND", "Cập nhật thất bại", JOptionPane.WARNING_MESSAGE);
        } else if (txtTuoi.getText().toString().trim().length() <= 0) {
            check = false;
            JOptionPane.showMessageDialog(rootPane, "Bạn chưa nhập tuổi", "Cập nhật thất bại", JOptionPane.WARNING_MESSAGE);
        } else if (sdt.toString().trim().length() <= 0 || !checkPhoneNumber(sdt)) {
            check = false;
            JOptionPane.showMessageDialog(rootPane, "Bạn chưa nhập số điện thoại", "Cập nhật thất bại", JOptionPane.WARNING_MESSAGE);
        } else if (cbPhong.getSelectedIndex() <= 0) {
            check = false;
            JOptionPane.showMessageDialog(rootPane, "Bạn chưa chọn phòng̣", "Cập nhật thất bại", JOptionPane.WARNING_MESSAGE);
        } else if (txtTuoi.getText().toString().trim().length() > 0) {
            try {
                int checkTuoi = Integer.parseInt(txtTuoi.getText());
                if (checkTuoi <= 0 || checkTuoi > 200) {
                    JOptionPane.showMessageDialog(rootPane, "Tuổi nhập sai định dạng", "Cập nhật thất bại", JOptionPane.WARNING_MESSAGE);
                    check = false;
                }
//                if(checkTuoi > 200){
//                    JOptionPane.showMessageDialog(rootPane, "Tuổi nhập sai định dạng", "Cập nhật thất bại", JOptionPane.WARNING_MESSAGE);
//                    check = false;
//                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(rootPane, "Tuổi nhập sai định dạng", "Cập nhật thất bại", JOptionPane.WARNING_MESSAGE);
                check = false;
            }
        }
        return check;
    }

    public void reset() {
        txtMaKH.setText("");
        txtTenKH.setText("");
        txtCMND.setText("");
        cbQuocTich.setSelectedIndex(0);
        rdNam.setEnabled(true);
        rdNu.setEnabled(true);
        txtTuoi.setText("");
        txtSDT.setText("");
        cbPhong.setEnabled(true);
    }

    public void settable() {
        checkTk = "";
        model.setRowCount(0);
        model = (DefaultTableModel) tbl1.getModel();
        List<QLKhachHang> ds = ql.getAll();
        for (QLKhachHang d : ds) {
            model.addRow(new Object[]{
                d.getMakh(), d.getTenkh(), d.getCmnd(),
                d.getQuoctich(), d.getGioitinh(), d.getTuoi(),
                d.getSdt(), d.getIddatphong()
            });
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl1 = new javax.swing.JTable();
        btnTimKiem = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        txtTkTenKH = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtIdDatPhong = new javax.swing.JLabel();
        txtMaKH = new javax.swing.JTextField();
        txtTenKH = new javax.swing.JTextField();
        txtCMND = new javax.swing.JTextField();
        txtTuoi = new javax.swing.JTextField();
        rdNam = new javax.swing.JRadioButton();
        rdNu = new javax.swing.JRadioButton();
        cbPhong = new javax.swing.JComboBox<>();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnGhi = new javax.swing.JButton();
        btnKhong = new javax.swing.JButton();
        btnKetThuc = new javax.swing.JButton();
        txtSDT = new javax.swing.JTextField();
        btnReset = new javax.swing.JButton();
        cbQuocTich = new javax.swing.JComboBox<>();

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Danh sách khách hàng"));

        tbl1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã KH", "Tên KH", "CMND", "Quốc tịch", "Giới tính", "Tuổi", "SDT", "Mã Phòng"
            }
        ));
        tbl1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl1);

        btnTimKiem.setText("TÌM KIẾM");
        btnTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemActionPerformed(evt);
            }
        });

        jLabel9.setText("TÊN KH :");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addGap(18, 18, 18)
                .addComponent(txtTkTenKH)
                .addGap(18, 18, 18)
                .addComponent(btnTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTkTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(btnTimKiem))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông tin chi tiết"));

        jLabel1.setText("Mã KH");

        jLabel2.setText("Tên KH");

        jLabel3.setText("CMND");

        jLabel4.setText("QUỐC TỊCH");

        jLabel5.setText("GIỚI TÍNH");

        jLabel6.setText("TUỔI");

        jLabel7.setText("SDT");

        txtIdDatPhong.setText("ID ĐẶT PHÒNG");

        rdNam.setText("NAM");

        rdNu.setText("NỮ");

        cbPhong.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--ID Đặt Phòng--" }));
        cbPhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbPhongActionPerformed(evt);
            }
        });

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

        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        cbQuocTich.setModel(new DefaultComboBoxModel<>(Country.createCountrylist()));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(txtIdDatPhong)
                            .addComponent(jLabel2))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(53, 53, 53)
                                .addComponent(rdNam)
                                .addGap(47, 47, 47)
                                .addComponent(rdNu)
                                .addGap(0, 79, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbQuocTich, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtMaKH)
                                    .addComponent(txtTenKH)
                                    .addComponent(txtCMND)
                                    .addComponent(txtTuoi)
                                    .addComponent(cbPhong, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtSDT)))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnThem, javax.swing.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE)
                            .addComponent(btnGhi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(btnKhong, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnKetThuc))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnReset)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtCMND, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cbQuocTich, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(rdNam)
                    .addComponent(rdNu))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtTuoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbPhong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIdDatPhong))
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                            .addComponent(btnThem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnSua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnXoa))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                            .addComponent(btnGhi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnKhong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnKetThuc)))
                    .addComponent(btnReset, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbl1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl1MouseClicked
        txtMaKH.setText(String.valueOf((int) model.getValueAt(tbl1.getSelectedRow(), 0)));
        txtTenKH.setText((String) model.getValueAt(tbl1.getSelectedRow(), 1));
        txtCMND.setText((String) model.getValueAt(tbl1.getSelectedRow(), 2));
        //txtQuocTich.setText("" + String.valueOf(model.getValueAt(tbl1.getSelectedRow(), 3)));
        String checkGT = (String) model.getValueAt(tbl1.getSelectedRow(), 4);
        if (checkGT.toUpperCase().equals("NAM")) {
            rdNam.setSelected(true);
        } else {
            rdNu.setSelected(true);
        }
        txtTuoi.setText("" + String.valueOf(model.getValueAt(tbl1.getSelectedRow(), 5)));
        txtSDT.setText((String) model.getValueAt(tbl1.getSelectedRow(), 6));
        cbPhong.setSelectedIndex(getPhongIndex((int) model.getValueAt(tbl1.getSelectedRow(), 7)));
    }//GEN-LAST:event_tbl1MouseClicked

    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
        ktthem = 3;
        setComEnable(false);
        txtMaKH.setEnabled(true);

        checkTk = txtTkTenKH.getText();
        model.setRowCount(0);
        model = (DefaultTableModel) tbl1.getModel();
        if (checkTk == "") {
            List<QLKhachHang> ds = ql.getAll();
            for (QLKhachHang d : ds) {
                model.addRow(new Object[]{
                    d.getMakh(), d.getTenkh(), d.getCmnd(),
                    d.getQuoctich(), d.getGioitinh(), d.getTuoi(),
                    d.getSdt(), d.getIddatphong()
                });
            }
        } else {
            List<QLKhachHang> ds = ql.getAll(checkTk);
            for (QLKhachHang d : ds) {
                model.addRow(new Object[]{
                    d.getMakh(), d.getTenkh(), d.getCmnd(),
                    d.getQuoctich(), d.getGioitinh(), d.getTuoi(),
                    d.getSdt(), d.getIddatphong()
                });
            }
        }
    }//GEN-LAST:event_btnTimKiemActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        ktthem = 1;
        reset();
        switchStateComboPhong(true);
        setComEnable(false);
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        if (txtMaKH.getText().length() <= 0) {
            return;
        }
        setComEnable(false);
        ktthem = 2;
        txtTenKH.requestFocus();
        txtMaKH.setEnabled(false);
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        if (txtMaKH.getText().length() <= 0) {
            return;
        }
        QLKhachHang qlk = new QLKhachHang();
        try {
            qlk.setMakh(Integer.parseInt(txtMaKH.getText().toString().trim()));
            qlk.setTenkh(txtTenKH.getText());
            int check = JOptionPane.showConfirmDialog(rootPane, "Xác nhận xóa?", "Cảnh báo", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
            if (check == 0) {
                if (ql.delete(qlk)) {
                    JOptionPane.showMessageDialog(rootPane, "Xóa khách hàng " + qlk.getTenkh() + " thành công", "Chúc mừng", JOptionPane.INFORMATION_MESSAGE);
                }
                settable();
                setComEnable(true);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Xóa thất bại", "Opps", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnGhiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGhiActionPerformed
        if (ktthem == 3) {
            String tenkh, cmnd, quoctich, gioitinh, sdt, phong;
            int makh, tuoi;
            if (txtMaKH.getText().toString().trim().equals("")) {
                makh = -9999;
            } else {
                try {
                    makh = Integer.parseInt(txtMaKH.getText().toString().trim());
                } catch (Exception e) {
                    makh = -9999;
                }
            }
            if (txtTenKH.getText().equals("")) {
                tenkh = "";
            } else {
                tenkh = txtTenKH.getText();
            }
            if (txtCMND.getText().equals("")) {
                cmnd = "";
            } else {
                cmnd = txtCMND.getText();
            }
            if (cbQuocTich.getSelectedIndex()<=0) {
                quoctich = "";
            } else {
                quoctich = cbQuocTich.getSelectedItem().toString();
            }
            if (!rdNam.isSelected() && !rdNu.isSelected()) {
                gioitinh = "";
            } else {
                gioitinh = rdNam.isSelected() ? "Nam" : "Nu";
            }
            if (txtTuoi.getText().toString().trim().equals("")) {
                tuoi = -9999;
            } else {
                try {
                    tuoi = Integer.parseInt(txtTuoi.getText().toString().trim());
                } catch (Exception e) {
                    tuoi = -9999;
                }
            }
            if (txtSDT.getText().equals("")) {
                sdt = "";
            } else {
                sdt = txtSDT.getText();
            }
            int sphong = qp.getMaPhong(cbPhong.getSelectedIndex());
            if (cbPhong.getSelectedIndex() == 0) {
                sphong = -9999;
            }

            QLKhachHang cn = new QLKhachHang(makh, tenkh, cmnd, quoctich, gioitinh, tuoi, sdt, sphong);

            model.setRowCount(0);
            model = (DefaultTableModel) tbl1.getModel();
            List<QLKhachHang> ds = ql.search(cn);
            for (QLKhachHang d : ds) {
                model.addRow(new Object[]{
                    d.getMakh(), d.getTenkh(), d.getCmnd(),
                    d.getQuoctich(), d.getGioitinh(), d.getTuoi(),
                    d.getSdt(), d.getIddatphong()
                });
            }
            return;
        }
        
         else if (ktthem == 1) {
            if (!KiemtraDK() || cbQuocTich.getSelectedIndex() <= 0) {
                if(cbQuocTich.getSelectedIndex() <= 0){
                    JOptionPane.showMessageDialog(rootPane, "Bạn chưa nhập quốc tịch", "Cập nhật thất bại", JOptionPane.WARNING_MESSAGE);
                }
                return;
            } else {
                QLKhachHang cn = new QLKhachHang( txtTenKH.getText().toString().trim(), txtCMND.getText().toString().trim(),
                        cbQuocTich.getSelectedItem().toString(), rdNam.isSelected() ? "Nam" : "Nu", Integer.parseInt(txtTuoi.getText().toString().trim()), txtSDT.getText().toString().trim(),
                        qp.getMaPhong(cbPhong.getSelectedIndex())
                );
                if (ql.insert(cn)) {
                    JOptionPane.showMessageDialog(rootPane, "Thêm khách hàng thành công", "Chúc mừng", JOptionPane.INFORMATION_MESSAGE);
                }
                switchStateComboPhong(false);
                settable();
            }
        } else if (ktthem == 2) {
            if (!KiemtraDK()) {
                return;
            } else {
                QLKhachHang cn = new QLKhachHang( Integer.parseInt(txtMaKH.getText().toString().trim()),txtTenKH.getText().toString().trim(), txtCMND.getText().toString().trim(),
                        cbQuocTich.getSelectedItem().toString(), rdNam.isSelected() ? "Nam" : "Nu", Integer.parseInt(txtTuoi.getText().toString().trim()), txtSDT.getText().toString().trim(),
                        qp.getMaPhong(cbPhong.getSelectedIndex())
                );
                if (ql.update(cn)) {
                    JOptionPane.showMessageDialog(rootPane, "Cập nhật khách hàng thành công", "Chúc mừng", JOptionPane.INFORMATION_MESSAGE);
                }
                settable();
            }
        }
        setComEnable(true);
        reset();
    }//GEN-LAST:event_btnGhiActionPerformed

    private void btnKhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKhongActionPerformed
        reset();
        setComEnable(true);
        switchStateComboPhong(false);
    }//GEN-LAST:event_btnKhongActionPerformed

    private void btnKetThucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKetThucActionPerformed
        int check = JOptionPane.showConfirmDialog(rootPane, "Xác nhận thoát", "Cảnh báo", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if (check == 0) {
            dispose();
        }
    }//GEN-LAST:event_btnKetThucActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        txtMaKH.setText("");
        txtTenKH.setText("");
        txtCMND.setText("");
        cbQuocTich.setSelectedIndex(0);
        //    rdNam.setEnabled(true);
        //    rdNu.setEnabled(true);
        txtTuoi.setText("");
        txtSDT.setText("");
        //    cbPhong.setEnabled(true);
        cbPhong.setSelectedIndex(0);
    }//GEN-LAST:event_btnResetActionPerformed

    private void cbPhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbPhongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbPhongActionPerformed
//    private boolean checkMa(String str) {
//        boolean b = false;
//        List<QLKhachHang> ds = ql.getAll();
//        for (QLKhachHang d : ds) {
//            if (d.getMakh().equals(str)) {
//                b = true;
//            }
//        }
//        return b;
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGhi;
    private javax.swing.JButton btnKetThuc;
    private javax.swing.JButton btnKhong;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JComboBox<String> cbPhong;
    private javax.swing.JComboBox<Country> cbQuocTich;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rdNam;
    private javax.swing.JRadioButton rdNu;
    private javax.swing.JTable tbl1;
    private javax.swing.JTextField txtCMND;
    private javax.swing.JLabel txtIdDatPhong;
    private javax.swing.JTextField txtMaKH;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtTenKH;
    private javax.swing.JTextField txtTkTenKH;
    private javax.swing.JTextField txtTuoi;
    // End of variables declaration//GEN-END:variables
}
