/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.QLHoaDon;
import DAO.MyConnection;
import com.mysql.cj.MysqlConnection;
import java.util.List;
import java.util.Optional;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DELL
 */
public class Control_QLHoaDon implements DAO.DAO<QLHoaDon> {

    MyConnection mc = MyConnection.getInstance();
    Connection con = mc.getConnect();

//    public float getGIAHD(String maphong, String manv) {
//        float kq = 0;
//        try {
//            String sql_select = "select GIAPHONG "
//                    + "from phong "
//                    + "where MAPHONG='" + maphong
//                    + "' and MANV='" + manv + "'";
//            Statement st = con.createStatement();
//            ResultSet rs = st.executeQuery(sql_select);
//            while (rs.next()) {
//                kq = rs.getFloat("GIAPHONG");
//            }
//        } catch (Exception e) {
//
//        }
//        return kq;
//    }

    public QLHoaDon getData(QLHoaDon ql2) {
        QLHoaDon ql1 = new QLHoaDon();
        ql1 = ql2;
        return ql1;
    }

    @Override
    public List<QLHoaDon> getAll() {
        List<QLHoaDon> ds = new ArrayList<>();
        try {

            String sql_select = "select * from hoadon";

            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql_select);
            while (rs.next()) {
                ds.add(new QLHoaDon(rs.getInt("mahd"), rs.getFloat("songay"), rs.getInt("thanhtien"), rs.getInt("madp")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ds;
    }

//    public List<QLHoaDon> getAll(int mahd) {
//        List<QLHoaDon> ds = new ArrayList<>();
//        try {
//            String sql_select = "select * from hoadon where mahd like '%" + mahd + "%'";
//            Statement st = con.createStatement();
//            ResultSet rs = st.executeQuery(sql_select);
//            while (rs.next()) {
//                ds.add(new QLHoaDon(rs.getInt("mahd"), rs.getFloat("songay"), rs.getInt("thanhtien"), rs.getInt("madp")));
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return ds;
//    }

    @Override
    public Optional<QLHoaDon> get(int d) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean insert(QLHoaDon t) {
        boolean check = false;
        try {
            String sql_insert = "insert into hoadon values(null,?,?,?)";
            PreparedStatement pstate = con.prepareStatement(sql_insert);
            pstate.setFloat(1, t.getSongay());
            pstate.setFloat(2, t.getThanhtien());
            pstate.setInt(3, t.getMadp());
            pstate.execute();
            check = true;
        } catch (Exception e) {
            e.printStackTrace();
            check = false;
        }
        return check;
    }

    @Override
    public boolean update(QLHoaDon t) {
        boolean check = false;
        try {
            String sql_update = "update hoadon set songay=?,thanhtien=?,madp=? where mahd=?";
            PreparedStatement pstate = con.prepareStatement(sql_update);
            pstate.setInt(4, t.getMahd());
            pstate.setFloat(1, t.getSongay());
            pstate.setFloat(2, t.getThanhtien());
            pstate.setInt(3, t.getMadp());
            pstate.execute();
            check = true;
        } catch (Exception e) {
            e.printStackTrace();
            check = false;
        }
        return check;
    }

    @Override
    public boolean delete(QLHoaDon t) {
        boolean check = false;
        try {
            String sql_delete = "delete hoadon where mahd=?";
            PreparedStatement ps = con.prepareStatement(sql_delete);
            ps.setInt(1, t.getMahd());
            ps.execute();
            check = true;
        } catch (Exception e) {
            e.printStackTrace();
            check = false;
        }
        return check;
    }

    @Override
    public List<QLHoaDon> search(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public static String replaceLast(String text, String regex, String replacement) {
        return text.replaceFirst("(?s)"+regex+"(?!.*?"+regex+")", replacement);
    }
    
    public List<QLHoaDon> search(QLHoaDon ql) {
        List<QLHoaDon> ds = new ArrayList<>();
        String sql_search = "SELECT hoadon.*\n" +
                            "FROM `datphong`,`phong`,`hoadon`" +
                            "WHERE hoadon.madp = datphong.id and phong.MAPHONG = datphong.maphong";
        if(!String.valueOf(ql.getMahd()).isEmpty() || !String.valueOf(ql.getSongay()).isEmpty() || !String.valueOf(ql.getMadp()).isEmpty() || !String.valueOf(ql.getThanhtien()).isEmpty()){
            sql_search += " and";
            if(ql.getMahd()!=-9999){
                sql_search += " mahd like '%" + ql.getMahd() + "%' and";
          
            }
            if(ql.getSongay() !=-9999){
                sql_search += " songay like '%"+(int)ql.getSongay()+"%' and";
              
            }
            if(ql.getThanhtien()!=-9999){
                sql_search += " thanhtien like '%"+ql.getThanhtien()+"%' and";
             
            }
            if(ql.getMadp()!=-9999){
                sql_search += " madp like '%"+ql.getMadp()+"%' and";
               
            }
            sql_search = replaceLast(sql_search,"and","");
            System.out.println(sql_search);
        }
        try {
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql_search);
            while (rs.next()) {
                ds.add(new QLHoaDon(rs.getInt("mahd"), rs.getFloat("songay"), rs.getInt("thanhtien"), rs.getInt("madp")));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return ds;
    }

    public List<QLHoaDon> search(QLHoaDon ql,String ngaydat,String ngaytra,String tenphong) {
        List<QLHoaDon> ds = new ArrayList<>();
        String sql_search = "SELECT hoadon.*\n" +
                            "FROM `datphong`,`phong`,`hoadon`" +
                            "WHERE hoadon.madp = datphong.id and phong.MAPHONG = datphong.maphong";
        int dem = 0;
        if(!String.valueOf(ql.getMahd()).isEmpty() || !String.valueOf(ql.getSongay()).isEmpty() || !String.valueOf(ql.getMadp()).isEmpty() || !String.valueOf(ql.getThanhtien()).isEmpty()
                || !ngaydat.isEmpty() || !ngaytra.isEmpty() || !tenphong.isEmpty()){
            sql_search += " and";
            if(ql.getMahd()!=-9999){
                sql_search += " hoadon.mahd like '%" + ql.getMahd() + "%' and";
                dem = 1;
            }
            if(ql.getSongay() !=-9999){
                sql_search += " hoadon.songay like '%"+(int)ql.getSongay()+"%' and";
                dem = 1;
            }
            if(ql.getThanhtien()!=-9999){
                sql_search += " hoadon.thanhtien like '%"+Math.round(ql.getThanhtien())+"%' and";
                dem = 1;
            }
            if(ql.getMadp()!=-9999){
                sql_search += " hoadon.madp like '%"+ql.getMadp()+"%' and";
                dem = 1;
            }
            if(!ngaydat.isEmpty()){
                sql_search += " datphong.ngaydat like '%"+ngaydat+"%' and";
                dem = 1;
            }
            if(!ngaytra.isEmpty()){
                sql_search += " datphong.ngaytra like '%"+ngaytra+"%' and";
                dem = 1;
            }
            if(!tenphong.isEmpty()){
                sql_search += " phong.TENPHONG like '%"+tenphong+"%' and";
                dem = 1;
            }
            sql_search = replaceLast(sql_search,"and","");
            System.out.println(sql_search);
        }
        try {
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql_search);
            while (rs.next()) {
                ds.add(new QLHoaDon(rs.getInt("mahd"), rs.getFloat("songay"), rs.getInt("thanhtien"), rs.getInt("madp")));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return ds;
    }

    public static void main(String[] args) {
        Control_QLHoaDon nc = new Control_QLHoaDon();

        //nc.delete(new QLHoaDon("hd05","nv03","ph03","11-21-2021"));
        //  System.out.println(nc.getGIAHD("ph01","nv01"));
        List<QLHoaDon> ds = nc.search(new QLHoaDon(-9999, 2, -9999, -9999),"","","");
        for (QLHoaDon d : ds) {
            System.out.println(d);
        }
    }
}
