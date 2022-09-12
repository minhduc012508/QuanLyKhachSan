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
public class GopY {

    private String hoten;
    private String gopy;

    public GopY() {
    }

    public GopY(String hoten, String gopy) {
        this.hoten = hoten;
        this.gopy = gopy;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public String getGopy() {
        return gopy;
    }

    public void setGopy(String gopy) {
        this.gopy = gopy;
    }

    @Override
    public String toString() {
        return "GopY{" + "hoten=" + hoten + ", gopy=" + gopy + '}';
    }

}
