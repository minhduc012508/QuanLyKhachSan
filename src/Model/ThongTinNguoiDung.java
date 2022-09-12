/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.awt.Button;

/**
 *
 * @author DELL
 */
public class ThongTinNguoiDung {

    private String HoTen;
    private String TaiKhoan;
    private String Mail;
    private String SDT;
    private String MatKhau;

    public ThongTinNguoiDung() {
    }

    public ThongTinNguoiDung(String HoTen, String TaiKhoan, String Mail, String SDT, String MatKhau) {
        this.HoTen = HoTen;
        this.TaiKhoan = TaiKhoan;
        this.Mail = Mail;
        this.SDT = SDT;
        this.MatKhau = MatKhau;
    }

    public String getHoTen() {
        return HoTen;
    }

    public void setHoTen(String HoTen) {
        this.HoTen = HoTen;
    }

    public String getMatKhau() {
        return MatKhau;
    }

    public void setMatKhau(String MatKhau) {
        this.MatKhau = MatKhau;
    }

    public String getTaiKhoan() {
        return TaiKhoan;
    }

    public void setTaiKhoan(String TaiKhoan) {
        this.TaiKhoan = TaiKhoan;
    }

    public String getMail() {
        return Mail;
    }

    public void setMail(String Mail) {
        this.Mail = Mail;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    @Override
    public String toString() {
        return "ThongTinNguoiDung{" + "HoTen=" + HoTen + ", TaiKhoan=" + TaiKhoan + ", Mail=" + Mail + ", SDT=" + SDT + ", MatKhau=" + MatKhau + '}';
    }

}
