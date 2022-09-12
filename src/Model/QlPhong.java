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
public class QlPhong {

    private String maphong;
    private String tenphong;
    private String loaiphong;
    private float giaphong;
    private String chuthich;
    private String tinhtrang;

    public QlPhong() {
    }

    public QlPhong(String maphong, String tenphong, String loaiphong, float giaphong, String chuthich, String tinhtrang) {
        this.maphong = maphong;
        this.tenphong = tenphong;
        this.loaiphong = loaiphong;
        this.giaphong = giaphong;
        this.chuthich = chuthich;
        this.tinhtrang = tinhtrang;
    }

    public String getMaphong() {
        return maphong;
    }

    public void setMaphong(String maphong) {
        this.maphong = maphong;
    }

    public String getTenphong() {
        return tenphong;
    }

    public void setTenphong(String tenphong) {
        this.tenphong = tenphong;
    }

    public String getLoaiphong() {
        return loaiphong;
    }

    public void setLoaiphong(String loaiphong) {
        this.loaiphong = loaiphong;
    }

    public float getGiaphong() {
        return giaphong;
    }

    public void setGiaphong(float giaphong) {
        this.giaphong = giaphong;
    }

    public String getChuthich() {
        return chuthich;
    }

    public void setChuthich(String chuthich) {
        this.chuthich = chuthich;
    }

    public String getTinhtrang() {
        return tinhtrang;
    }

    public void setTinhtrang(String tinhtrang) {
        this.tinhtrang = tinhtrang;
    }


    @Override
    public String toString() {
        return "QlPhong{" + "maphong=" + maphong + ", tenphong=" + tenphong + ", loaiphong=" + loaiphong + ", giaphong=" + giaphong + ", chuthich=" + chuthich + ", tinhtrang=" + tinhtrang + '}';
    }

}
