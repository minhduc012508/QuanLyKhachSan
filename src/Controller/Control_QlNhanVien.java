/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.QLNhanVien;
import DAO.MyConnection;
import java.util.List;
import java.util.Optional;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class Control_QlNhanVien implements DAO.DAO<QLNhanVien> {

    MyConnection mc = MyConnection.getInstance();
    Connection con = mc.getConnect();

    @Override
    public List<QLNhanVien> getAll() {
        List<QLNhanVien> ds = new ArrayList<>();
        try {
            String sql_select = "select * from nhanvien";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql_select);
            while (rs.next()) {
                ds.add(new QLNhanVien(rs.getString("MANV"), rs.getString("TENNV"), rs.getString("CHUCVU"), rs.getFloat("LUONGNV"), rs.getString("NGAYSINH"), rs.getString("GIOITINH"), rs.getString("CHUTHICH")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ds;
    }

    public String getManv(int d) {
        int i = 1;
        List<QLNhanVien> ds = getAll();
        for (QLNhanVien dv : ds) {
            if (i == d) {
                return dv.getMnv();
            }
            i++;
        }
        return "";
    }

    public List getAll(String tennv) {
        List<QLNhanVien> ds = new ArrayList<>();
        try {
            String sql_select = "select * from nhanvien where TENNV like '%" + tennv + "%'";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql_select);
            while (rs.next()) {
                ds.add(new QLNhanVien(rs.getString("MANV"), rs.getString("TENNV"), rs.getString("CHUCVU"), rs.getFloat("LUONGNV"), rs.getString("NGAYSINH"), rs.getString("GIOITINH"), rs.getString("CHUTHICH")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ds;
    }

    @Override
    public Optional<QLNhanVien> get(int d) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public QLNhanVien getNhanVienByMaNV(String manv){
        QLNhanVien qp = null;
        try{
            String sql_select = "select * from nhanvien where MANV='"+manv+"'";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql_select);
            while(rs.next()){
                qp = new QLNhanVien(rs.getString("MANV"), rs.getString("TENNV"), rs.getString("CHUCVU"), rs.getFloat("LUONGNV"), rs.getString("NGAYSINH"), rs.getString("GIOITINH"), rs.getString("CHUTHICH"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return qp;
    }

    @Override
    public boolean insert(QLNhanVien t) {
        boolean check = false;
        try {
            String sql_insert = "insert into nhanvien values(?,?,?,?,?,?,?)";
            PreparedStatement pstate = con.prepareStatement(sql_insert);
            pstate.setString(1, t.getMnv());
            pstate.setString(2, t.getTennv());
            pstate.setString(3, t.getChucvu());
            pstate.setFloat(4, t.getLuong());
            pstate.setString(5, t.getNgaysinh());
            pstate.setString(6, t.getGioitinh());
            pstate.setString(7, t.getChuthich());
            pstate.execute();
            check = true;
        } catch (Exception e) {
            System.out.println("Bao loi!");
            check = false;
        }
        return check;
    }

    @Override
    public boolean update(QLNhanVien t) {
        boolean check = false;
        try {
            String sql_update = "update nhanvien set TENNV=?,CHUCVU=?,LUONGNV=?,"
                    + "NGAYSINH=?,GIOITINH=?,CHUTHICH=? where MANV=?";
            PreparedStatement pstate = con.prepareStatement(sql_update);
            pstate.setString(7, t.getMnv());
            pstate.setString(1, t.getTennv());
            pstate.setString(2, t.getChucvu());
            pstate.setFloat(3, t.getLuong());
            pstate.setString(4, t.getNgaysinh());
            pstate.setString(5, t.getGioitinh());
            pstate.setString(6, t.getChuthich());
            pstate.execute();
            check = true;
        } catch (Exception e) {
            e.printStackTrace();
            check = false;
        }
        return check;
    }

    @Override
    public boolean delete(QLNhanVien t) {
        boolean check = false;
        try {
            String sql_delete = "delete from nhanvien where MANV=?";
            PreparedStatement ps = con.prepareStatement(sql_delete);
            ps.setString(1, t.getMnv());
            ps.execute();
            check = true;
        } catch (Exception e) {
            e.printStackTrace();
            check = false;
        }
        return check;
    }

    @Override
    public List<QLNhanVien> search(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public static String replaceLast(String text, String regex, String replacement) {
        return text.replaceFirst("(?s)"+regex+"(?!.*?"+regex+")", replacement);
    }

    public List<QLNhanVien> search(QLNhanVien ql) {
        List<QLNhanVien> ds = new ArrayList<>();
        String sql_search = "select * from `nhanvien`";
        int dem = 0;
        if(!String.valueOf(ql.getMnv()).isEmpty() || !String.valueOf(ql.getNgaysinh()).isEmpty() || !String.valueOf(ql.getTennv()).isEmpty() || !String.valueOf(ql.getChucvu()).isEmpty()
                 || !String.valueOf(ql.getChuthich()).isEmpty() || !String.valueOf(ql.getGioitinh()).isEmpty()
                || !String.valueOf(ql.getLuong()).isEmpty()){
            sql_search += " where";
            if(!ql.getMnv().isEmpty()){
                sql_search += " MANV like '%" + ql.getMnv()+ "%' and";
                dem = 1;
            }
            if(!ql.getNgaysinh().isEmpty()){
                dem = 1;
                sql_search += " NGAYSINH like '%"+ql.getNgaysinh()+"%' and";
            }
            if(!ql.getTennv().isEmpty()){
                dem = 1;
                sql_search += " TENNV like '%"+ql.getTennv()+"%' and";
            }
            if(!ql.getChucvu().isEmpty()){
                dem = 1;
                sql_search += " CHUCVU like '%"+ql.getChucvu()+"%' and";
            }
            if(!ql.getChuthich().isEmpty()){
                dem = 1;
                sql_search += " CHUTHICH like '%"+ql.getChuthich()+"%' and";
            }
            if(!ql.getGioitinh().isEmpty()){
                dem = 1;
                sql_search += " GIOITINH like '%"+ql.getGioitinh()+"%' and";
            }
            if(ql.getLuong()!=-9999){
                dem = 1;
                sql_search += " LUONGNV like '%"+(long)ql.getLuong()+"%' and";
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
                ds.add(new QLNhanVien(rs.getString("MANV"), rs.getString("TENNV"), rs.getString("CHUCVU"), rs.getFloat("LUONGNV"), rs.getString("NGAYSINH"), rs.getString("GIOITINH"), rs.getString("CHUTHICH")));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return ds;
    }

    public static void main(String[] args) {
        Control_QlNhanVien nc = new Control_QlNhanVien();

      //  nc.delete(new QLNhanVien("nv0001", "khum biet", "vkl", 2000, "10-09-2000", "Nam", "ko"));

//        List<QLNhanVien> ls = nc.search(new QLNhanVien("", "", "", 0, "", "", ""));
//        for (QLNhanVien l : ls) {
//            System.out.println(l);
//        }
System.out.println(nc.getNhanVienByMaNV("nv01"));
    }
}
