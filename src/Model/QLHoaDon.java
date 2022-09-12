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
public class QLHoaDon {
    private int mahd;
    private float songay;
    private float thanhtien;
    private int madp;

    public QLHoaDon() {
    }

    public QLHoaDon(int mahd, float songay, float thanhtien, int madp) {
        this.mahd = mahd;
        this.songay = songay;
        this.thanhtien = thanhtien;
        this.madp = madp;
    }

    public int getMahd() {
        return mahd;
    }

    public void setMahd(int mahd) {
        this.mahd = mahd;
    }

    public float getSongay() {
        return songay;
    }

    public void setSongay(float songay) {
        this.songay = songay;
    }

    public float getThanhtien() {
        return thanhtien;
    }

    public void setThanhtien(float thanhtien) {
        this.thanhtien = thanhtien;
    }

    public int getMadp() {
        return madp;
    }

    public void setMadp(int madp) {
        this.madp = madp;
    }

    @Override
    public String toString() {
        return "QLHoaDon{" + "mahd=" + mahd + ", songay=" + songay + ", thanhtien=" + thanhtien + ", madp=" + madp + '}';
    }
    
}
