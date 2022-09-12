/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.QLHoaDon;
import Model.QLNhanVien;
import Model.QlPhong;
import Controller.*;
import Model.DatPhong;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DELL
 */
public class mdiHoaDon extends javax.swing.JInternalFrame {

    static Control_QlPhong qp = new Control_QlPhong();
    static Control_QlNhanVien nv = new Control_QlNhanVien();
    static Control_DatPhong dp = new Control_DatPhong();
    static Control_QLHoaDon ql = new Control_QLHoaDon();
    QlPhong qlPhong;
    QLNhanVien qlnv;
    static DefaultTableModel modelHoaDon = new DefaultTableModel();
    static DefaultTableModel modelDatPhong = new DefaultTableModel();
    static List<DatPhong> ds_datphong;
    static List<QLHoaDon> ds_hoadon;
    int iddatphong,songay,mahd;
    float thanhtien;
    String ngaydat = "", ngaytra = "", maphong = "", manv = "";
    String txtNgayDat, txtNgayTra, txtTenPhong;
    float txtThanhTien;
    int txtMaHD, txtSoNgay, txtMaDp;

    public mdiHoaDon() {
        initComponents();
        btnChiTietHoaDon.setEnabled(false);
        btnThanhToan.setEnabled(false);
        setTableDatPhong();
        settableHoaDon();
    }

    public int getPhongIndex(String maphong) {
        int i = 0;
        List<QlPhong> ds = qp.getAll();
        for (QlPhong d : ds) {
            if (d.getMaphong().trim().equals(maphong)) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public static void setTableDatPhong() {
        modelDatPhong.setRowCount(0);
        modelDatPhong = (DefaultTableModel) tblChuaThanhToan.getModel();
        ds_datphong = dp.getAll();
        for (DatPhong d : ds_datphong) {
            modelDatPhong.addRow(new Object[]{
                d.getId(), d.getNgaydat(),
                d.getNgaytra(), qp.getPhongByMaPhong(d.getMaphong()).getTenphong(), nv.getNhanVienByMaNV(d.getManv()).getTennv()
            });
        }
    }
    
    public static void settableHoaDon() {
        modelHoaDon.setRowCount(0);
        modelHoaDon = (DefaultTableModel) tbl1.getModel();
        ds_hoadon = ql.getAll();
        for (QLHoaDon d : ds_hoadon) {
            modelHoaDon.addRow(new Object[]{
                d.getMahd(),
                dp.getDpByMaDp(d.getMadp()).getNgaydat(),
                dp.getDpByMaDp(d.getMadp()).getNgaytra(),
                (int) d.getSongay(),
                d.getThanhtien(),
                d.getMadp(),
                qp.getPhongByMaPhong(dp.getDpByMaDp(d.getMadp()).getMaphong()).getTenphong()
            });
        }

    }

    public void setComEnable(boolean b) {
        btnThanhToan.setEnabled(b);
        btnChiTietHoaDon.setEnabled(!b);
    }
    
    public void searchtableHoaDon() {
        modelHoaDon.setRowCount(0);
        modelHoaDon = (DefaultTableModel) tbl1.getModel();
        for (QLHoaDon d : ds_hoadon) {
            modelHoaDon.addRow(new Object[]{
                d.getMahd(),
                dp.getDpByMaDp(d.getMadp()).getNgaydat(),
                dp.getDpByMaDp(d.getMadp()).getNgaytra(),
                (int) d.getSongay(),
                d.getThanhtien(),
                d.getMadp(),
                qp.getPhongByMaPhong(dp.getDpByMaDp(d.getMadp()).getMaphong()).getTenphong()
            });
        }

    }


//    private float getKhoangCachNgay(String dayfrom, String dayto) {
//        long diff = 0;
//        try {
//            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//            Date date1 = sdf.parse(dayfrom);
//            Date date2 = sdf.parse(dayto);
//            diff = date2.getTime() - date1.getTime();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return diff / (1000 * 60 * 60 * 24);
//    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tbl1 = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        btnThanhToan = new javax.swing.JButton();
        btnChiTietHoaDon = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        btnTimKiemChiTiet = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        btnDong = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        edtSoNgay = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        edtThanhTien = new javax.swing.JTextField();
        edtMaDp = new javax.swing.JTextField();
        edtTenPhong = new javax.swing.JTextField();
        edtMaHD = new javax.swing.JTextField();
        jdateNgaydat = new com.toedter.calendar.JDateChooser();
        jdateNgayTra = new com.toedter.calendar.JDateChooser();
        jPanel1 = new javax.swing.JPanel();
        btnTimKiem = new javax.swing.JButton();
        txtTimKiem = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblChuaThanhToan = new javax.swing.JTable();

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Danh sách hóa đơn"));

        tbl1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "MÃ HD", "NGÀY ĐẶT", "NGÀY TRẢ", "SỐ NGÀY", "THÀNH TIỀN", "MÃ ĐP", "TÊN PHÒNG"
            }
        ));
        tbl1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl1MouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tbl1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Thao tác"));

        btnThanhToan.setText("Thanh Toán");
        btnThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThanhToanActionPerformed(evt);
            }
        });

        btnChiTietHoaDon.setText("Xuất chi tiết hóa đơn");
        btnChiTietHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChiTietHoaDonActionPerformed(evt);
            }
        });

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Tìm kiếm hóa đơn"));

        btnTimKiemChiTiet.setText("Tìm kiếm");
        btnTimKiemChiTiet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemChiTietActionPerformed(evt);
            }
        });

        jButton1.setText("Reset");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnDong.setText("Đóng");
        btnDong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDongActionPerformed(evt);
            }
        });

        jLabel1.setText("MÃ HD: ");

        jLabel2.setText("NGÀY ĐẶT: ");

        jLabel3.setText("NGÀY TRẢ: ");

        jLabel4.setText("SỐ NGÀY: ");

        jLabel5.setText("THÀNH TIỀN: ");

        jLabel7.setText("MÃ ĐP: ");

        jLabel8.setText("TÊN PHÒNG: ");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnTimKiemChiTiet, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(edtTenPhong))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel7)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(edtSoNgay)
                            .addComponent(edtThanhTien)
                            .addComponent(edtMaDp)
                            .addComponent(edtMaHD)
                            .addComponent(jdateNgaydat, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
                            .addComponent(jdateNgayTra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(edtMaHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jdateNgaydat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jdateNgayTra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(edtThanhTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(edtMaDp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(edtTenPhong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(edtSoNgay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnTimKiemChiTiet)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnDong)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnThanhToan, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnChiTietHoaDon, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnThanhToan)
                .addGap(18, 18, 18)
                .addComponent(btnChiTietHoaDon)
                .addGap(18, 18, 18)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Tác vụ"));

        btnTimKiem.setText("Tìm kiếm");
        btnTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemActionPerformed(evt);
            }
        });

        txtTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTimKiemActionPerformed(evt);
            }
        });

        jLabel6.setText("MÃ HÓA ĐƠN :");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnTimKiem)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTimKiem)
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder("Phòng chưa thanh toán")));

        tblChuaThanhToan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "NGÀY ĐẶT", "NGÀY TRẢ", "TÊN PHÒNG", "TÊN NHÂN VIÊN"
            }
        ));
        tblChuaThanhToan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblChuaThanhToanMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(tblChuaThanhToan);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 530, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbl1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl1MouseClicked
        ngaydat = (String) modelHoaDon.getValueAt(tbl1.getSelectedRow(), 1);
        ngaytra = (String) modelHoaDon.getValueAt(tbl1.getSelectedRow(), 2);
        iddatphong = (int) modelHoaDon.getValueAt(tbl1.getSelectedRow(), 5);
        maphong = dp.getDpByMaDp(ds_hoadon.get(tbl1.getSelectedRow()).getMadp()).getMaphong();
        manv = dp.getDpByMaDp(ds_hoadon.get(tbl1.getSelectedRow()).getMadp()).getManv();
        songay = (int) modelHoaDon.getValueAt(tbl1.getSelectedRow(), 3);
        thanhtien = (float) modelHoaDon.getValueAt(tbl1.getSelectedRow(), 4);
        mahd = (int) modelHoaDon.getValueAt(tbl1.getSelectedRow(), 0);
        System.out.println(maphong + " - " + manv + " - " + songay + " - " + mahd);
        setComEnable(false);
    }//GEN-LAST:event_tbl1MouseClicked

    private void txtTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimKiemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTimKiemActionPerformed

    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
        int mahd = -9999;
        if (txtTimKiem.getText().toString().trim().equals("")) {
            settableHoaDon();
        } else {
            try {
                mahd = Integer.parseInt(txtTimKiem.getText().toString().trim());
            } catch (Exception e) {
                JOptionPane.showMessageDialog(rootPane, "Mã hóa đơn sai định dạng", "Lỗi", JOptionPane.INFORMATION_MESSAGE);
            }
            ds_hoadon = ql.search(new QLHoaDon(mahd, -9999, -9999, -9999));
            searchtableHoaDon();
        }

    }//GEN-LAST:event_btnTimKiemActionPerformed

    private void tblChuaThanhToanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblChuaThanhToanMouseClicked
        ngaydat = (String) modelDatPhong.getValueAt(tblChuaThanhToan.getSelectedRow(), 1);
        ngaytra = (String) modelDatPhong.getValueAt(tblChuaThanhToan.getSelectedRow(), 2);
        iddatphong = (int) modelDatPhong.getValueAt(tblChuaThanhToan.getSelectedRow(), 0);
        maphong = ds_datphong.get(tblChuaThanhToan.getSelectedRow()).getMaphong();
        manv = ds_datphong.get(tblChuaThanhToan.getSelectedRow()).getManv();
        setComEnable(true);
    }//GEN-LAST:event_tblChuaThanhToanMouseClicked

    private void btnThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThanhToanActionPerformed
        //JOptionPane.showMessageDialog(rootPane,iddatphong + " " + ngaydat + " " + ngaytra + " " + maphong + " " + manv, "Chúc mừng", JOptionPane.WARNING_MESSAGE);
        
            qlPhong = qp.getPhongByMaPhong(maphong);
            qlnv = nv.getNhanVienByMaNV(manv);
            mdiXuatHoaDon mDon = new mdiXuatHoaDon(iddatphong, ngaydat, ngaytra, qlPhong, qlnv);
            mDon.setLocationRelativeTo(null);
            mDon.setVisible(true);
            mDon.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//            mdiHoaDon.this.dispose();
        
    }//GEN-LAST:event_btnThanhToanActionPerformed

    private void btnChiTietHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChiTietHoaDonActionPerformed
        if (mahd <= 0) {
            JOptionPane.showMessageDialog(rootPane, "Chưa chọn hóa đơn để xuất!", "Lỗi", JOptionPane.WARNING_MESSAGE);
        } else {
            qlPhong = qp.getPhongByMaPhong(maphong);
            qlnv = nv.getNhanVienByMaNV(manv);
            mdiXuatHoaDon mDon = new mdiXuatHoaDon(mahd, iddatphong, ngaydat, ngaytra, qlPhong, qlnv, thanhtien, songay);
            mDon.setLocationRelativeTo(null);
            mDon.setVisible(true);
            mDon.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            //mdiHoaDon.this.dispose();
        }
    }//GEN-LAST:event_btnChiTietHoaDonActionPerformed

    private void btnTimKiemChiTietActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemChiTietActionPerformed
        if (checkData()) {
            ds_hoadon = ql.search(new QLHoaDon(txtMaHD, txtSoNgay, txtThanhTien, txtMaDp), txtNgayDat, txtNgayTra, edtTenPhong.getText().toString().trim());
            searchtableHoaDon();
        }
    }//GEN-LAST:event_btnTimKiemChiTietActionPerformed

    private void btnDongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDongActionPerformed
        int check = JOptionPane.showConfirmDialog(rootPane, "Xác nhận thoát?", "Cảnh báo", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if (check == 0) {
            dispose();
        }
    }//GEN-LAST:event_btnDongActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        reset();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void reset(){
        edtMaDp.setText("");
        edtMaHD.setText("");
        edtSoNgay.setText("");
        edtTenPhong.setText("");
        edtThanhTien.setText("");
        jdateNgayTra.setCalendar(null);
        jdateNgaydat.setCalendar(null);
    }
    
    private boolean checkData() {
        if (edtMaHD.getText().toString().trim().isEmpty()) {
            txtMaHD = -9999;
        } else {
            try {
                txtMaHD = Integer.parseInt(edtMaHD.getText().toString().trim());
            } catch (Exception e) {
                txtMaHD = -9999;
                JOptionPane.showMessageDialog(rootPane, "Mã hóa đơn nhập sai định dạng", "Lỗi", JOptionPane.WARNING_MESSAGE);
                return false;
            }
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        try {
            txtNgayDat = sdf.format(jdateNgaydat.getDate());
        } catch (Exception e) {
            txtNgayDat = "";
            //System.out.println("ngaydat = " + txtNgayDat);
        }
        try {
            txtNgayTra = sdf.format(jdateNgayTra.getDate());
        } catch (Exception e) {
            txtNgayTra = "";
        }
        if(edtSoNgay.getText().toString().trim().isEmpty()){
            txtSoNgay = -9999;
        }
        else{
        try {
            txtSoNgay = Integer.parseInt(edtSoNgay.getText().toString().trim());
        } catch (Exception e) {
            txtSoNgay = -9999;
            JOptionPane.showMessageDialog(rootPane, "Số ngày nhập sai định dạng", "Lỗi", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        }
        if (edtMaDp.getText().toString().trim().isEmpty()) {
            txtMaDp = -9999;
        } else {
            try {
                txtMaDp = Integer.parseInt(edtMaDp.getText().toString().trim());
            } catch (Exception e) {
                txtMaDp = -9999;
                JOptionPane.showMessageDialog(rootPane, "Mã đặt phòng nhập sai định dạng", "Lỗi", JOptionPane.WARNING_MESSAGE);
                return false;
            }
        }
        if (edtThanhTien.getText().toString().trim().isEmpty()) {
            txtThanhTien = -9999;
        } else {
            try {
                txtThanhTien = Integer.parseInt(edtThanhTien.getText().toString().trim());
            } catch (Exception e) {
                txtThanhTien = -9999;
                JOptionPane.showMessageDialog(rootPane, "Tổng thành tiền nhập sai định dạng", "Lỗi", JOptionPane.WARNING_MESSAGE);
                return false;
            }
        }
        
        return true;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChiTietHoaDon;
    private javax.swing.JButton btnDong;
    private javax.swing.JButton btnThanhToan;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JButton btnTimKiemChiTiet;
    private javax.swing.JTextField edtMaDp;
    private javax.swing.JTextField edtMaHD;
    private javax.swing.JTextField edtSoNgay;
    private javax.swing.JTextField edtTenPhong;
    private javax.swing.JTextField edtThanhTien;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private com.toedter.calendar.JDateChooser jdateNgayTra;
    private com.toedter.calendar.JDateChooser jdateNgaydat;
    private static javax.swing.JTable tbl1;
    private static javax.swing.JTable tblChuaThanhToan;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
}
