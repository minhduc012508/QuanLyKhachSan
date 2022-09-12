/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.GopY;
import java.util.List;
import java.util.Optional;
import java.sql.*;
import DAO.*;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class Control_GopY implements DAO<GopY> {

    MyConnection mc = MyConnection.getInstance();
    Connection con = mc.getConnect();

    @Override
    public List<GopY> getAll() {
        List<GopY> ds = new ArrayList<>();
        try {
            String sql_select = "select * from tbl_gopy";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql_select);
            while (rs.next()) {
                ds.add(new GopY(rs.getString("HOTEN"), rs.getString("GOPY")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ds;
    }

    @Override
    public Optional<GopY> get(int d) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean insert(GopY t) {
        boolean check = false;
        try {
            String sql_insert = "insert into tbl_gopy values(?,?)";
            PreparedStatement pstate = con.prepareStatement(sql_insert);
            pstate.setString(1, t.getHoten());
            pstate.setString(2, t.getGopy());
            pstate.execute();
            check = true;
        } catch (Exception e) {
            e.printStackTrace();
            check = false;
        }
        return check;
    }

    @Override
    public boolean update(GopY t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(GopY t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<GopY> search(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static void main(String[] args) {
        Control_GopY cg = new Control_GopY();

        List<GopY> ds = cg.getAll();
        for (GopY d : ds) {
            System.out.println(d);
        }
    }
}
