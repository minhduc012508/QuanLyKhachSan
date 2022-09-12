/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.Control_DatPhong;
import Model.QlDichVu;
import Controller.Control_QlDichVu;
import DAO.MyConnection;
import Model.DatPhong;
import java.sql.Connection;
import java.util.Hashtable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class mdiDichVu extends javax.swing.JInternalFrame {

    private String checkTk;
    DefaultTableModel model = new DefaultTableModel();
    Controller.Control_QlDichVu ql = new Control_QlDichVu();
    Control_DatPhong dp = new Control_DatPhong();
    int ktthem;
    int madv;

    public mdiDichVu() {
        initComponents();
        settable();
        setComboDatPhong();
        setComEnable(true);
    }

    public void setComEnable(boolean b) {
        btnThem.setEnabled(b);
        btnSua.setEnabled(b);
        btnXoa.setEnabled(b);

        btnGhi.setEnabled(!b);
        btnKhong.setEnabled(!b);

        txtTenDV.setEnabled(!b);
        txtGiaDV.setEnabled(!b);
        cbDatPhong.setEnabled(!b);
    }
    public void setComboDatPhong() {
        List<DatPhong> ds = dp.getAll();
        for (DatPhong d : ds) {
            cbDatPhong.addItem(String.valueOf(d.getId()));
        }
    }
    public int setDatPhongIndex(int idphong) {
        int i = 1;
        List<DatPhong> ds = dp.getAll();
        for (DatPhong d : ds) {
            if (d.getId() == idphong) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public void reset() {
        txtTenDV.setText("");
        txtGiaDV.setText("");
        txtTenDV.requestFocus();
    }

    private boolean KiemtraDK() {
        boolean check = true;
        if (txtTenDV.getText().length() <= 0) {
            check = false;
            JOptionPane.showMessageDialog(rootPane, "Bạn chưa nhập tên dịch vụ", "Cập nhật thất bại", JOptionPane.WARNING_MESSAGE);
        } else if (txtGiaDV.getText().length() <= 0) {
            check = false;
            JOptionPane.showMessageDialog(rootPane, "Bạn chưa nhập giá dịch vụ", "Cập nhật thất bại", JOptionPane.WARNING_MESSAGE);
        }

        return check;
    }

    public void settable() {
        checkTk = ""; model.setRowCount(0);
        model.setRowCount(0);
        model = (DefaultTableModel) tbl1.getModel();
        List<QlDichVu> ds = ql.getAll();
        for (QlDichVu d : ds) {
            model.addRow(new Object[]{
                d.getMadv(), d.getTendv(), d.getGiadv(),d.getIddatphong()
            });
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl1 = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        txtTenDv = new javax.swing.JTextField();
        btnTimKiem = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtTenDV = new javax.swing.JTextField();
        txtGiaDV = new javax.swing.JTextField();
        btnSua = new javax.swing.JButton();
        btnThem = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnGhi = new javax.swing.JButton();
        btnKhong = new javax.swing.JButton();
        btnDong = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        cbDatPhong = new javax.swing.JComboBox<>();

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Danh sách dịch vụ"));

        tbl1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã dịch vụ", "Tên dịch vụ", "Giá dịch vụ ", "ID đặt phòng"
            }
        ));
        tbl1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl1);

        jLabel4.setText("TÊN DV :");

        btnTimKiem.setText("TÌM KIẾM");
        btnTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 551, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 2, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtTenDv)
                .addGap(18, 18, 18)
                .addComponent(btnTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtTenDv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTimKiem))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông tin chi tiết"));

        jLabel2.setText("TÊN DV :");

        jLabel3.setText("GIÁ DV :");

        btnSua.setText("SỬA");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnThem.setText("THÊM");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnXoa.setText("XÓA");
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

        btnKhong.setText("KHÔNG");
        btnKhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKhongActionPerformed(evt);
            }
        });

        btnDong.setText("ĐÓNG");
        btnDong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDongActionPerformed(evt);
            }
        });

        jButton1.setText("Reset");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel5.setText("ID ĐẶT PHÒNG: ");

        cbDatPhong.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Chọn id--" }));
        cbDatPhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbDatPhongActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(btnThem))
                        .addGap(18, 18, 18)
                        .addComponent(btnSua)
                        .addGap(18, 18, 18)
                        .addComponent(btnXoa)
                        .addGap(18, 18, 18)
                        .addComponent(btnGhi, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnKhong)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnDong))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbDatPhong, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtTenDV)
                            .addComponent(txtGiaDV, javax.swing.GroupLayout.DEFAULT_SIZE, 398, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(txtTenDV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtGiaDV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbDatPhong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSua)
                    .addComponent(btnThem)
                    .addComponent(btnXoa)
                    .addComponent(btnGhi)
                    .addComponent(btnKhong)
                    .addComponent(btnDong)
                    .addComponent(jButton1))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDongActionPerformed
        int check = JOptionPane.showConfirmDialog(rootPane, "Xác nhận thoát?", "Cảnh báo", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if (check == 0) {
            dispose();
        }
    }//GEN-LAST:event_btnDongActionPerformed

    private void btnKhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKhongActionPerformed
        reset();
        setComEnable(true);
    }//GEN-LAST:event_btnKhongActionPerformed

    private void btnGhiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGhiActionPerformed
        if (ktthem == 3) {
            String madv, tendv, giadv;
            
            if (txtTenDV.getText().equals("")) {
                tendv = "";
            } else {
                tendv = txtTenDV.getText();
            }
            if (txtGiaDV.getText().equals("")) {
                giadv = "-9999";
            } else {
                giadv = txtGiaDV.getText();
            }
            QlDichVu cn = new QlDichVu(-9999
                    , tendv
                    ,dp.getMaDatPhong(cbDatPhong.getSelectedIndex()),Float.parseFloat(giadv));
            model.setRowCount(0);
            model = (DefaultTableModel) tbl1.getModel();
            List<QlDichVu> ds = ql.search(cn);
            for (QlDichVu d : ds) {
                model.addRow(new Object[]{
                    d.getMadv(), d.getTendv(), d.getGiadv()
                });
            }
            return;
        } else if (ktthem == 1) {
            if (!KiemtraDK()) {
                return;
            } else {
                QlDichVu cn = new QlDichVu(0, txtTenDV.getText(),dp.getMaDatPhong(cbDatPhong.getSelectedIndex()) , Float.parseFloat(txtGiaDV.getText()));
                if (ql.insert(cn)) {
                    JOptionPane.showMessageDialog(rootPane, "Thêm dịch vụ thành công", "Chúc mừng", JOptionPane.INFORMATION_MESSAGE);
                }
                settable();
            }
        } else if (ktthem == 2) {
            if (!KiemtraDK()) {
                return;
            } else {
                QlDichVu cn = new QlDichVu(0, txtTenDV.getText(),dp.getMaDatPhong(cbDatPhong.getSelectedIndex()) , Float.parseFloat(txtGiaDV.getText()));
                if (ql.update(cn)) {
                    JOptionPane.showMessageDialog(rootPane, "Cập nhật dịch vụ thành công", "Chúc mừng", JOptionPane.INFORMATION_MESSAGE);
                }
                settable();
            }
        }
        setComEnable(true);
        reset();
    }//GEN-LAST:event_btnGhiActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
//        if (txtMadv.getText().length() <= 0) {
//            return;
//        }
        QlDichVu dv = new QlDichVu();
        dv.setMadv(madv);
        int check = JOptionPane.showConfirmDialog(rootPane, "Xác nhận xóa?", "Cảnh báo", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if (check == 0) {
            if (ql.delete(dv)) {
                JOptionPane.showMessageDialog(rootPane, "Xóa thành công", "Chúc mừng", JOptionPane.INFORMATION_MESSAGE);
            }
            settable();
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        ktthem = 1;
        reset();
        setComEnable(false);
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
      
        setComEnable(false);
        ktthem = 2;
        txtTenDV.requestFocus();
        
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
        ktthem = 3;
        btnThem.setEnabled(false);
        btnSua.setEnabled(false);
        btnXoa.setEnabled(false);
        btnGhi.setEnabled(true);
        btnKhong.setEnabled(true);
        cbDatPhong.setEnabled(true);

        txtGiaDV.setEnabled(true);
        txtTenDV.setEnabled(true);

        checkTk = txtTenDv.getText();
        model.setRowCount(0);
        model = (DefaultTableModel) tbl1.getModel();
        if (checkTk == "") {
            List<QlDichVu> ds = ql.getAll();
            for (QlDichVu d : ds) {
                model.addRow(new Object[]{
                    d.getMadv(), d.getTendv(), d.getGiadv(),d.getIddatphong()
                });
            }
        } else {
            List<QlDichVu> ds = ql.getAll(checkTk);
            for (QlDichVu d : ds) {
                model.addRow(new Object[]{
                    d.getMadv(), d.getTendv(), d.getGiadv(),d.getIddatphong()
                });
            }
        }
    }//GEN-LAST:event_btnTimKiemActionPerformed

    private void tbl1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl1MouseClicked
        txtTenDV.setText((String) model.getValueAt(tbl1.getSelectedRow(), 1));
        txtGiaDV.setText("" + String.valueOf(model.getValueAt(tbl1.getSelectedRow(), 2)));
        cbDatPhong.setSelectedIndex(getDatPhongIndex((int) model.getValueAt(tbl1.getSelectedRow(), 3)));
        madv = (int)model.getValueAt(tbl1.getSelectedRow(),0);
    }//GEN-LAST:event_tbl1MouseClicked

    public int getDatPhongIndex(int id) {
        int i = 1;
        List<DatPhong> ds = dp.getAll();
        for (DatPhong d : ds) {
            if (d.getId()==id) {
                return i;
            }
            i++;
        }
        return -1;
    }
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
//        txtMadv.setText("");
        txtTenDV.setText("");
        txtGiaDV.setText("");
        txtTenDV.requestFocus();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void cbDatPhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbDatPhongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbDatPhongActionPerformed
    private boolean checkMa(int id) {
        boolean b = false;
        List<QlDichVu> ds = ql.getAll();
        for (QlDichVu d : ds) {
            if (d.getMadv()==id) {
                b = true;
            }
        }
        return b;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDong;
    private javax.swing.JButton btnGhi;
    private javax.swing.JButton btnKhong;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JComboBox<String> cbDatPhong;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl1;
    private javax.swing.JTextField txtGiaDV;
    private javax.swing.JTextField txtTenDV;
    private javax.swing.JTextField txtTenDv;
    // End of variables declaration//GEN-END:variables
}
