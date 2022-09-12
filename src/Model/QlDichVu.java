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
public class QlDichVu {

    private int madv;
    private String tendv;
    private int iddatphong;
    private float giadv;

    public QlDichVu() {
    }

    public QlDichVu(int madv, String tendv,int iddatphong, float giadv) {
        this.madv = madv;
        this.tendv = tendv;
        this.iddatphong = iddatphong;
        this.giadv = giadv;
    }

    public void setMadv(int madv) {
        this.madv = madv;
    }

    public void setTendv(String tendv) {
        this.tendv = tendv;
    }

    public void setGiadv(float giadv) {
        this.giadv = giadv;
    }

    public int getMadv() {
        return madv;
    }

    public int getIddatphong() {
        return iddatphong;
    }

    public void setIddatphong(int iddatphong) {
        this.iddatphong = iddatphong;
    }
    
    

    public String getTendv() {
        return tendv;
    }

    public float getGiadv() {
        return giadv;
    }

    @Override
    public String toString() {
        return "QlDichVu{" + "madv=" + madv + ", tendv=" + tendv + ", iddatphong=" + iddatphong + ", giadv=" + giadv + '}';
    }

}
