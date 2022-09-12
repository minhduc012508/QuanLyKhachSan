/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.MyConnection;
import Model.DatPhong;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author DELL
 */
public class Control_DatPhong implements DAO.DAO<DatPhong>{
    MyConnection mc = MyConnection.getInstance();
    Connection con = mc.getConnect();


    @Override
    public List<DatPhong> getAll() {
        List<DatPhong> ds = new ArrayList<>();
        try {
            String sql_select = "select * from datphong where tinhtrangthanhtoan=0";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql_select);
            while (rs.next()) {
                ds.add(new DatPhong(rs.getInt("id"),rs.getString("ngaydat"), rs.getString("ngaytra"), rs.getString("maphong"), rs.getString("manv")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ds;
    }
    
    public DatPhong getLast() {
        List<DatPhong> ds = new ArrayList<>();
        try {
            String sql_select = "select * from `datphong` order by id DESC LIMIT 1";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql_select);
            while (rs.next()) {
                ds.add(new DatPhong(rs.getInt("id"),rs.getString("ngaydat"), rs.getString("ngaytra"), rs.getString("maphong"), rs.getString("manv")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ds.get(0);
    }
    

    @Override
    public Optional<DatPhong> get(int d) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean insert(DatPhong t) {
        boolean check = false;
        try {
            String sql_insert = "insert into datphong values(null,?,?,?,?,0)";
            PreparedStatement pstate = con.prepareStatement(sql_insert);
            pstate.setString(1, t.getNgaydat());
            pstate.setString(2, t.getNgaytra());
            pstate.setString(3, t.getMaphong());
            pstate.setString(4, t.getManv());
            pstate.execute();
            check = true;
        } catch (Exception e) {
            e.printStackTrace();
            check = false;
        }
        return check;
    }

    @Override
    public boolean update(DatPhong t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public boolean resetTT(int id,String ngaytra) {
        boolean check = false;
        try {
            String sql_update = "update `datphong` set tinhtrangthanhtoan=1,ngaytra=? where id=?";
            PreparedStatement pstate = con.prepareStatement(sql_update);
            pstate.setInt(2, id);
            pstate.setString(1, ngaytra);
            pstate.execute();
            check = true;
        } catch (Exception e) {
            e.printStackTrace();
            check = false;
        }
        return check;
    }

    @Override
    public boolean delete(DatPhong t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<DatPhong> search(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
     public String getMaNV(int d) {
        int i = 1;
        List<DatPhong> ds = getAll();
        for (DatPhong dv : ds) {
            if (i == d) {
                return String.valueOf(dv.getManv());
            }
            i++;
        }
        return "";
    }
      public int getMaPhong(int d) {
        int i = 1;
        List<DatPhong> ds = getAll();
        for (DatPhong dv : ds) {
            if (i == d) {
                return dv.getId();
            }
            i++;
        }
        return -1;
    }
       public int getMaDatPhong(int d){
          int i = 1;
          List<DatPhong> ds = getAll();
        for (DatPhong dv : ds) {
            if (i == d) {
                return dv.getId();
            }
            i++;
        }
        return -1;
      }
       
       public DatPhong getDpByMaDp(int id){
        DatPhong qp = null;
        try{
            String sql_select = "select * from `datphong` where id="+id+"";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql_select);
            if(rs.next()){
                qp = new DatPhong(id,rs.getString("ngaydat"),rs.getString("ngaytra"),rs.getString("maphong"), rs.getString("manv"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return qp;
    }
     
      
    
      public static void main(String[] args) {
          Control_DatPhong dp = new Control_DatPhong();
        DatPhong ds = dp.getDpByMaDp(1);
       
            System.out.println(ds);
        
    }
}
