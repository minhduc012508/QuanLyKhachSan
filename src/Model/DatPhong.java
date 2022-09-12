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
public class DatPhong {
    private int id;
    private String ngaydat;
    private String ngaytra;
    private String maphong;
    private String manv;

    public DatPhong(int id, String ngaydat, String ngaytra, String maphong, String manv) {
        this.id = id;
        this.ngaydat = ngaydat;
        this.ngaytra = ngaytra;
        this.maphong = maphong;
        this.manv = manv;
    }

    public DatPhong() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNgaydat() {
        return ngaydat;
    }

    public void setNgaydat(String ngaydat) {
        this.ngaydat = ngaydat;
    }

    public String getNgaytra() {
        return ngaytra;
    }

    public void setNgaytra(String ngaytra) {
        this.ngaytra = ngaytra;
    }

    public String getMaphong() {
        return maphong;
    }

    public void setMaphong(String maphong) {
        this.maphong = maphong;
    }

    public String getManv() {
        return manv;
    }

    public void setManv(String manv) {
        this.manv = manv;
    }

    @Override
    public String toString() {
        return id + "\t" + ngaydat + "\t" + ngaytra + "\t" + maphong + "\t" + manv;
    }
    
    
}
