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


public class QLNhoMatKhau {

    private int id;
    private String tinhtrang;
    private String taikhoan;
    private String matkhau;

    public QLNhoMatKhau() {
    }

    public QLNhoMatKhau(int id, String tinhtrang, String taikhoan, String matkhau) {
        this.id = id;
        this.tinhtrang = tinhtrang;
        this.taikhoan = taikhoan;
        this.matkhau = matkhau;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTinhtrang() {
        return tinhtrang;
    }

    public void setTinhtrang(String tinhtrang) {
        this.tinhtrang = tinhtrang;
    }

    public String getTaikhoan() {
        return taikhoan;
    }

    public void setTaikhoan(String taikhoan) {
        this.taikhoan = taikhoan;
    }

    public String getMatkhau() {
        return matkhau;
    }

    public void setMatkhau(String matkhau) {
        this.matkhau = matkhau;
    }

    @Override
    public String toString() {
        return "QLNhoMatKhau{" + "id=" + id + ", tinhtrang=" + tinhtrang + ", taikhoan=" + taikhoan + ", matkhau=" + matkhau + '}';
    }

}
