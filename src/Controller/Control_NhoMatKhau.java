/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.QLNhoMatKhau;
import DAO.*;
import java.io.FileReader;
import java.util.List;
import java.util.Optional;
import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;

/**
 *
 * @author DELL
 */
public class Control_NhoMatKhau implements DAO<QLNhoMatKhau> {
    

    MyConnection mc = MyConnection.getInstance();
    Connection con = mc.getConnect();

    
    
    @Override
    public List<QLNhoMatKhau> getAll() {
        List<QLNhoMatKhau> ds = new ArrayList<>();
        try {
            String sql_select = "select * from nhomatkhau";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql_select);
            while (rs.next()) {
                ds.add(new QLNhoMatKhau(rs.getInt("id"), rs.getString("tinhtrang"), rs.getString("taikhoan"), rs.getString("matkhau")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ds;

    }

    @Override
    public Optional<QLNhoMatKhau> get(int d) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean insert(QLNhoMatKhau t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(QLNhoMatKhau t) {
        boolean check = false;
        try {
            String sql_update = "update nhomatkhau set taikhoan=?,matkhau=?,tinhtrang=? where id=?";
            PreparedStatement pstate = con.prepareStatement(sql_update);
            pstate.setInt(4, 1);
            pstate.setString(1, t.getTaikhoan());
            pstate.setString(2, t.getMatkhau());
            pstate.setString(3, t.getTinhtrang());
            pstate.execute();
            check = true;
        } catch (Exception e) {
            e.printStackTrace();
            check = false;
        }
        return check;
    }

    @Override
    public boolean delete(QLNhoMatKhau t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<QLNhoMatKhau> search(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static void main(String[] args) {
        
    }
}
