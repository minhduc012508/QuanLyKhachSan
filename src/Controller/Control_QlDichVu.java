/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.QlDichVu;
import DAO.DAO;
import DAO.MyConnection;
import java.awt.Font;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author DELL
 */
public class Control_QlDichVu implements DAO<QlDichVu> {

    MyConnection mc = MyConnection.getInstance();
    Connection con = mc.getConnect();

    @Override
    public List getAll() {
        List<QlDichVu> ds = new ArrayList<>();
        try {
            String sql_select = "select * from dichvu order by MADV DESC";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql_select);
            while (rs.next()) {
                ds.add(new QlDichVu(rs.getInt("MADV"), rs.getString("TENDV"),rs.getInt("iddatphong"), rs.getFloat("GIADV")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ds;
    }
    

    public List getAll(String tendv) {
        List<QlDichVu> ds = new ArrayList<>();
        try {
            String sql_select = "select * from dichvu where TENDV like '%" + tendv + "%'";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql_select);
            while (rs.next()) {
                ds.add(new QlDichVu(rs.getInt("MADV"), rs.getString("TENDV"),rs.getInt("iddatphong"), rs.getFloat("GIADV")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ds;
    }
    public List getAllbyId(int iddatphong) {
        List<QlDichVu> ds = new ArrayList<>();
        try {
            String sql_select = "select * from dichvu where iddatphong="+iddatphong;
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql_select);
            while (rs.next()) {
                ds.add(new QlDichVu(rs.getInt("MADV"), rs.getString("TENDV"),rs.getInt("iddatphong"), rs.getFloat("GIADV")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ds;
    }

    @Override
    public Optional get(int d) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getMadv(int d) {
        int i = 1;
        List<QlDichVu> ds = getAll();
        for (QlDichVu dv : ds) {
            if (i == d) {
                return dv.getMadv();
            }
            i++;
        }
        return -1;
    }

    @Override
    public boolean insert(QlDichVu t) {
        boolean check = false;
        try {
            String sql_insert = "insert into dichvu values(null,?,?,?)";
            PreparedStatement pstate = con.prepareStatement(sql_insert);
            pstate.setString(1, t.getTendv());
            pstate.setInt(2,t.getIddatphong());
            pstate.setFloat(3, t.getGiadv());
            pstate.execute();
            check = true;
        } catch (Exception e) {
            e.printStackTrace();
            check = false;
        }
        return check;
    }

    @Override
    public boolean update(QlDichVu t) {
        boolean check = false;
        try {
            String sql_update = "update dichvu set TENDV=?,GIADV=?,iddatphong=? where MADV=?";
            PreparedStatement pstate = con.prepareStatement(sql_update);
            pstate.setInt(4, t.getMadv());
            pstate.setString(1, t.getTendv());
            pstate.setInt(3,t.getIddatphong());
            pstate.setFloat(2, t.getGiadv());
            pstate.execute();
            check = true;
        } catch (Exception e) {
            e.printStackTrace();
            check = false;
        }
        return check;
    }

    @Override
    public boolean delete(QlDichVu t) {
        boolean check = false;
        try {
            String sql_delete = "delete from"
                    + " `dichvu` where MADV=?";
            PreparedStatement ps = con.prepareStatement(sql_delete);
            ps.setInt(1, t.getMadv());
            ps.execute();
            check = true;
        } catch (Exception e) {
            e.printStackTrace();
            check = false;
        }
        return check;
    }
    public static String replaceLast(String text, String regex, String replacement) {
        return text.replaceFirst("(?s)"+regex+"(?!.*?"+regex+")", replacement);
    }

    public List<QlDichVu> search(QlDichVu ql) {
        List<QlDichVu> ds = new ArrayList<>();
        String sql_search = "select * from `dichvu`";
        int dem = 0;
        if(!String.valueOf(ql.getMadv()).isEmpty() || !String.valueOf(ql.getIddatphong()).isEmpty() || !String.valueOf(ql.getGiadv()).isEmpty() || !String.valueOf(ql.getTendv()).isEmpty()){
            sql_search += " where";
            if(ql.getMadv()!=-9999){
                dem = 1;
                sql_search += " MADV like '%" + ql.getMadv()+ "%' and";
            }
            if(ql.getIddatphong()!=-9999){
                dem = 1;
                sql_search += " iddatphong like '%"+(int)ql.getIddatphong()+"%' and";
            }
            if(!ql.getTendv().isEmpty()){
                dem = 1;
                sql_search += " TENDV like '%"+ql.getTendv()+"%' and";
            }
            if(ql.getGiadv()!=-9999){
                dem = 1;
                sql_search += " GIADV like '%"+(int)ql.getGiadv()+"%' and";
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
                ds.add(new QlDichVu(rs.getInt("MADV"), rs.getString("TENDV"),rs.getInt("iddatphong"), rs.getFloat("GIADV")));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return ds;
    }

    @Override
    public List search(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static void main(String[] args) {
        Control_QlDichVu nc = new Control_QlDichVu();

//        nc.update(new QlDichVu("dv04", "dich vu 4", 90000));

        List<QlDichVu> ls = nc.getAll();
        for (QlDichVu l : ls) {
            System.out.println(l);
        }
    }
}
