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
public class QLKhachHang {

    private int makh;
    private String tenkh;
    private String cmnd;
    private String quoctich;
    private String gioitinh;
    private int tuoi;
    private String sdt;
    private int iddatphong;

    public QLKhachHang() {
    }
    
    public QLKhachHang( String tenkh, String cmnd, String quoctich, String gioitinh, int tuoi, String sdt, int iddatphong) {
        this.tenkh = tenkh;
        this.cmnd = cmnd;
        this.quoctich = quoctich;
        this.gioitinh = gioitinh;
        this.tuoi = tuoi;
        this.sdt = sdt;
        this.iddatphong = iddatphong;
    }

    public QLKhachHang(int makh, String tenkh, String cmnd, String quoctich, String gioitinh, int tuoi, String sdt, int iddatphong) {
        this.makh = makh;
        this.tenkh = tenkh;
        this.cmnd = cmnd;
        this.quoctich = quoctich;
        this.gioitinh = gioitinh;
        this.tuoi = tuoi;
        this.sdt = sdt;
        this.iddatphong = iddatphong;
    }

  

    public int getMakh() {
        return makh;
    }

    public void setMakh(int makh) {
        this.makh = makh;
    }

    public String getTenkh() {
        return tenkh;
    }

    public void setTenkh(String tenkh) {
        this.tenkh = tenkh;
    }

    public String getCmnd() {
        return cmnd;
    }

    public void setCmnd(String cmnd) {
        this.cmnd = cmnd;
    }

    public String getQuoctich() {
        return quoctich;
    }

    public void setQuoctich(String quoctich) {
        this.quoctich = quoctich;
    }

    public String getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(String gioitinh) {
        this.gioitinh = gioitinh;
    }

    public int getTuoi() {
        return tuoi;
    }

    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public int getIddatphong() {
        return iddatphong;
    }

    public void setIddatphong(int iddatphong) {
        this.iddatphong = iddatphong;
    }

    @Override
    public String toString() {
        return "QLKhachHang{" + "makh=" + makh + ", tenkh=" + tenkh + ", cmnd=" + cmnd + ", quoctich=" + quoctich + ", gioitinh=" + gioitinh + ", tuoi=" + tuoi + ", sdt=" + sdt + ", iddatphong=" + iddatphong + '}';
    }

}
