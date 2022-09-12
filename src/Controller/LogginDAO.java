/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Loggin;
import java.util.List;
import java.util.Optional;
import java.sql.*;
import DAO.MyConnection;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class LogginDAO implements DAO.DAO {

    public static final String TABLE_NAME = "loggin";
    MyConnection mc = MyConnection.getInstance();
    Connection con = mc.getConnect();

    @Override
    public List getAll() {
        List<Loggin> ds = new ArrayList<>();
        try {
            String sql_select = "select * from " + TABLE_NAME;
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql_select);
            while (rs.next()) {
                ds.add(new Loggin(rs.getString("TaiKhoan"), rs.getString("MatKhau")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ds;
    }

    @Override
    public Optional get(int d) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean get(String tk, String mk) {
        boolean check = false;
        Loggin lg = new Loggin();
        try {
            String sql_select = "select MatKhau from " + TABLE_NAME + " where TaiKhoan = '" + tk + "'";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql_select);
            while (rs.next()) {
                if (mk.equals(rs.getString("MatKhau"))) {
                    check = true;
                }
            }
        } catch (Exception e) {
            System.out.println("111");
            e.printStackTrace();
        }
        return check;
    }

    public Loggin get(String tk) {
        Loggin lg = new Loggin();
        try {
            String sql_select = "select * from " + TABLE_NAME + " where TaiKhoan = '" + tk + "'";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql_select);
            while (rs.next()) {
                lg = new Loggin(rs.getString("TaiKhoan"), rs.getString("MatKhau"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lg;
    }

    @Override
    public boolean insert(Object t) {
        boolean check = false;
        Loggin lg = (Loggin) t;
        try {
            String sql_insert = "insert into " + TABLE_NAME + " values('" + lg.getTaikhoan() + "',"
                    + "'" + lg.getMatkhau() + "')";
            Statement st = con.createStatement();
            int rs = st.executeUpdate(sql_insert);
            check = true;
        } catch (Exception e) {
            System.out.println("Thêm tài khoản thất bại!");
            check = false;
        }
        return check;
    }

    @Override
    public boolean update(Object t) {
        boolean check = false;
        Loggin lg = (Loggin) t;
        try {
            String sql_update = "update " + TABLE_NAME + " set MatKhau='" + lg.getMatkhau() + "' where TaiKhoan='" + lg.getTaikhoan() + "'";
            Statement st = con.createStatement();
            int rs = st.executeUpdate(sql_update);
            check = true;
        } catch (Exception e) {
            e.printStackTrace();
            check = false;
        }
        return check;
    }

    @Override
    public boolean delete(Object t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List search(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static void main(String[] args) {
        LogginDAO lgd = new LogginDAO();

    }
}
