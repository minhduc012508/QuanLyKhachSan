/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author DELL
 */
public class QLNhanVien {

    private String mnv;
    private String tennv;
    private String chucvu;
    private float luong;
    private String ngaysinh;
    private String gioitinh;
    private String chuthich;

    public QLNhanVien() {
    }

    public QLNhanVien(String mnv, String tennv, String chucvu, float luong, String ngaysinh, String gioitinh, String chuthich) {
        this.mnv = mnv;
        this.tennv = tennv;
        this.chucvu = chucvu;
        this.luong = luong;
        this.ngaysinh = ngaysinh;
        this.gioitinh = gioitinh;
        this.chuthich = chuthich;
    }

    public String getMnv() {
        return mnv;
    }

    public void setMnv(String mnv) {
        this.mnv = mnv;
    }

    public String getTennv() {
        return tennv;
    }

    public void setTennv(String tennv) {
        this.tennv = tennv;
    }

    public String getChucvu() {
        return chucvu;
    }

    public void setChucvu(String chucvu) {
        this.chucvu = chucvu;
    }

    public float getLuong() {
        return luong;
    }

    public void setLuong(float luong) {
        this.luong = luong;
    }

    public String getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(String ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public String getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(String gioitinh) {
        this.gioitinh = gioitinh;
    }

    public String getChuthich() {
        return chuthich;
    }

    public void setChuthich(String chuthich) {
        this.chuthich = chuthich;
    }

    @Override
    public String toString() {
        return "QLNhanVien{" + "mnv=" + mnv + ", tennv=" + tennv + ", chucvu=" + chucvu + ", luong=" + luong + ", ngaysinh=" + ngaysinh + ", gioitinh=" + gioitinh + ", chuthich=" + chuthich + '}';
    }

}
