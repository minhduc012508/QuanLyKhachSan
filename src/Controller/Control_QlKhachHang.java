/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.QLKhachHang;
import DAO.MyConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author DELL
 */
public class Control_QlKhachHang implements DAO.DAO<QLKhachHang> {

    MyConnection mc = MyConnection.getInstance();
    Connection con = mc.getConnect();

    @Override
    public List<QLKhachHang> getAll() {
        List<QLKhachHang> ds = new ArrayList<>();
        try {
            String sql_select = "select * from khachhang";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql_select);
            while (rs.next()) {
                ds.add(new QLKhachHang(rs.getInt("MAKH"), rs.getString("TENKH"), rs.getString("CMND"),
                        rs.getString("QUOCTICH"), rs.getString("GIOITINH"), rs.getInt("TUOI"),
                        rs.getString("SDT"), rs.getInt("iddatphong")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ds;
    }

    public List<QLKhachHang> getAll(String tenkh) {
        List<QLKhachHang> ds = new ArrayList<>();
        try {
            String sql_select = "select * from khachhang where TENKH like '%" + tenkh + "%'";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql_select);
            while (rs.next()) {
                ds.add(new QLKhachHang(rs.getInt("MAKH"), rs.getString("TENKH"), rs.getString("CMND"),
                        rs.getString("QUOCTICH"), rs.getString("GIOITINH"), rs.getInt("TUOI"),
                        rs.getString("SDT"), rs.getInt("iddatphong")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ds;
    }
    
    public List<QLKhachHang> getAllById(int id) {
        List<QLKhachHang> ds = new ArrayList<>();
        try {
            String sql_select = "select * from khachhang where iddatphong="+id;
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql_select);
            while (rs.next()) {
                ds.add(new QLKhachHang(rs.getInt("MAKH"), rs.getString("TENKH"), rs.getString("CMND"),
                        rs.getString("QUOCTICH"), rs.getString("GIOITINH"), rs.getInt("TUOI"),
                        rs.getString("SDT"), rs.getInt("iddatphong")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ds;
    }

    public int getMaKH(int d) {
        int i = 1;
        List<QLKhachHang> ds = getAll();
        for (QLKhachHang dv : ds) {
            if (i == d) {
                return dv.getMakh();
            }
            i++;
        }
        return -1;
    }

    @Override
    public Optional<QLKhachHang> get(int d) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean insert(QLKhachHang t) {
        boolean check = false;
        try {
            String sql_insert = "insert into khachhang values(null,?,?,?,?,?,?,?)";
            PreparedStatement pstate = con.prepareStatement(sql_insert);
            pstate.setString(1, t.getTenkh());
            pstate.setString(2, t.getCmnd());
            pstate.setString(3, t.getQuoctich());
            pstate.setString(4, t.getGioitinh());
            pstate.setInt(5, t.getTuoi());
            pstate.setString(6, t.getSdt());
            pstate.setInt(7, t.getIddatphong());
            pstate.execute();
            check = true;
        } catch (Exception e) {
            e.printStackTrace();
            check = false;
        }
        return check;
    }

    @Override
    public boolean update(QLKhachHang t) {
        boolean check = false;
        try {
            String sql_update = "update khachhang set TENKH=?,CMND=?,QUOCTICH=?,GIOITINH=?,TUOI=?,SDT=? where MAKH=?";
            PreparedStatement pstate = con.prepareStatement(sql_update);
            pstate.setInt(7, t.getMakh());
            pstate.setString(1, t.getTenkh());
            pstate.setString(2, t.getCmnd());
            pstate.setString(3, t.getQuoctich());
            pstate.setString(4, t.getGioitinh());
            pstate.setInt(5, t.getTuoi());
            pstate.setString(6, t.getSdt());
            pstate.execute();
            check = true;
        } catch (Exception e) {
            e.printStackTrace();
            check = false;
        }
        return check;
    }

    @Override
    public boolean delete(QLKhachHang t) {
        boolean check = false;
        try {
            String sql_delete = "delete from khachhang where MAKH=?";
            PreparedStatement ps = con.prepareStatement(sql_delete);
            ps.setInt(1, t.getMakh());
            ps.execute();
            check = true;
        } catch (Exception e) {
            e.printStackTrace();
            check = false;
        }
        return check;
    }

    @Override
    public List<QLKhachHang> search(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public static String replaceLast(String text, String regex, String replacement) {
        return text.replaceFirst("(?s)"+regex+"(?!.*?"+regex+")", replacement);
    }

    public List<QLKhachHang> search(QLKhachHang ql) {
        List<QLKhachHang> ds = new ArrayList<>();
        String sql_search = "select * from `khachhang`";
        int dem = 0;
        if(!String.valueOf(ql.getMakh()).isEmpty() || !String.valueOf(ql.getCmnd()).isEmpty() || !String.valueOf(ql.getGioitinh()).isEmpty() || !String.valueOf(ql.getIddatphong()).isEmpty()
                 || !String.valueOf(ql.getQuoctich()).isEmpty() || !String.valueOf(ql.getSdt()).isEmpty()
                || !String.valueOf(ql.getTenkh()).isEmpty() || !String.valueOf(ql.getTuoi()).isEmpty()){
            sql_search += " where";
            if(ql.getMakh()!=-9999){
                sql_search += " MAKH like '%" + ql.getMakh()+ "%' and";
                dem = 1;
            }
            if(ql.getIddatphong()!=-9999){
                dem = 1;
                sql_search += " iddatphong like '%"+(int)ql.getIddatphong()+"%' and";
            }
            if(!ql.getCmnd().isEmpty()){
                dem = 1;
                sql_search += " CMND like '%"+ql.getCmnd()+"%' and";
            }
            if(!ql.getGioitinh().isEmpty()){
                dem = 1;
                sql_search += " GIOITINH like '%"+ql.getGioitinh()+"%' and";
            }
            if(!ql.getQuoctich().isEmpty()){
                dem = 1;
                sql_search += " QUOCTICH like '%"+ql.getQuoctich()+"%' and";
            }
            if(!ql.getSdt().isEmpty()){
                dem = 1;
                sql_search += " SDT like '%"+ql.getSdt()+"%' and";
            }
            if(!ql.getTenkh().isEmpty()){
                dem = 1;
                sql_search += " TENKH like '%"+ql.getTenkh()+"%' and";
            }
            if(ql.getTuoi()!=-9999){
                dem = 1;
                sql_search += " TUOI like '%"+ql.getTuoi()+"%' and";
            }
            
            sql_search = replaceLast(sql_search,"and","");
            if(dem == 0){
                sql_search = replaceLast(sql_search,"where","");
            }
            System.out.println(sql_search);
        }
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql_search);
            while (rs.next()) {
                ds.add(new QLKhachHang(rs.getInt("MAKH"), rs.getString("TENKH"), rs.getString("CMND"),
                        rs.getString("QUOCTICH"), rs.getString("GIOITINH"), rs.getInt("TUOI"),
                        rs.getString("SDT"), rs.getInt("iddatphong")));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return ds;
    }

    public static void main(String[] args) {
        Control_QlKhachHang nc = new Control_QlKhachHang();

        //   nc.delete(new QLKhachHang("kh100","ssage","ppp","China","nu",20,"099999","ph04"));
        List<QLKhachHang> ds = nc.search(new QLKhachHang(-9999, "", "", "", "", -9999, "", -9999));
        for (QLKhachHang d : ds) {
            System.out.println(d);
        }
    }
}
