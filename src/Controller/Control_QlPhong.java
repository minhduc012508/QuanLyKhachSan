/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.QlPhong;
import DAO.MyConnection;
import MyJson.JsonReader;
import com.sun.xml.internal.messaging.saaj.soap.impl.ElementImpl;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONArray;
import org.json.JSONException;

/**
 *
 * @author DELL
 */
public class Control_QlPhong implements DAO.DAO<QlPhong> {
    JsonReader jr = new JsonReader();
    MyConnection mc = MyConnection.getInstance();
    Connection con = mc.getConnect();
    
    private final String urlSearch = "http://localhost/QLKS_Phong/searchPhong.php";
    

    private final String urlGetAll = "http://localhost/QLKS_Phong/getAllData.php";
    @Override
    public List<QlPhong> getAll() {
        List<QlPhong> ds = null;
        try {
            //        try {
//            String sql_select = "select * from phong";
//            Statement st = con.createStatement();
//            ResultSet rs = st.executeQuery(sql_select);
//            while (rs.next()) {
//                ds.add(new QlPhong(rs.getString("MAPHONG"), rs.getString("TENPHONG"),
//                        rs.getString("LOAIPHONG"), rs.getFloat("GIAPHONG"),
//                        rs.getString("CHUTHICH"), rs.getString("TINHTRANG"), rs.getString("MANV"), rs.getString("MADV")));
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
     
            ds = jr.convertJSONArrayToArrayList(jr.readJsonFromUrl(urlGetAll));
        } catch (IOException ex) {
            Logger.getLogger(Control_QlPhong.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JSONException ex) {
            Logger.getLogger(Control_QlPhong.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ds;
    }
    
    private final String urlGetAllWithEnable = "http://localhost/QLKS_Phong/getAllWithEnable.php";
    public List<QlPhong> getAllWithEnable() {
        List<QlPhong> ds = null;
        try {
            //        try {
//            String sql_select = "select * from phong";
//            Statement st = con.createStatement();
//            ResultSet rs = st.executeQuery(sql_select);
//            while (rs.next()) {
//                ds.add(new QlPhong(rs.getString("MAPHONG"), rs.getString("TENPHONG"),
//                        rs.getString("LOAIPHONG"), rs.getFloat("GIAPHONG"),
//                        rs.getString("CHUTHICH"), rs.getString("TINHTRANG"), rs.getString("MANV"), rs.getString("MADV")));
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
     
            ds = jr.convertJSONArrayToArrayList(jr.readJsonFromUrl(urlGetAllWithEnable));
        } catch (IOException ex) {
            Logger.getLogger(Control_QlPhong.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JSONException ex) {
            Logger.getLogger(Control_QlPhong.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ds;
    }
    
    private final String urlGetAllWithTenPhong = "http://localhost/QLKS_Phong/getAllWithTenPhong.php";
    public List<QlPhong> getAll(String tenphong) {
        List<QlPhong> ds = null;
//        try {
//            String sql_select = "select * from phong where TENPHONG like '%" + tenphong + "%'";
//            Statement st = con.createStatement();
//            ResultSet rs = st.executeQuery(sql_select);
//            while (rs.next()) {
//                ds.add(new QlPhong(rs.getString("MAPHONG"), rs.getString("TENPHONG"),
//                        rs.getString("LOAIPHONG"), rs.getFloat("GIAPHONG"),
//                        rs.getString("CHUTHICH"), rs.getString("TINHTRANG"), rs.getString("MANV"), rs.getString("MADV")));
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
       try{
           ds = jr.convertJSONArrayToArrayList(new JSONArray(jr.getPhongWithName(tenphong,urlGetAllWithTenPhong)));
       } catch (IOException ex) {
            Logger.getLogger(Control_QlPhong.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JSONException ex) {
            Logger.getLogger(Control_QlPhong.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ds;
    }
     
    
    public String getMaPhong(int d){
        int i = 1;
        List<QlPhong> ds = getAll();
        for (QlPhong dv : ds) {
            if (i == d) {
                return dv.getMaphong();
            }
            i++;
        }
        return "";
    }

    public String getMaKH(int d) {
        int i = 1;
        List<QlPhong> ds = getAll();
        for (QlPhong dv : ds) {
            if (i == d) {
                return dv.getMaphong();
            }
            i++;
        }
        return "";
    }

   

    @Override
    public Optional<QlPhong> get(int d) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private final String urlInsert = "http://localhost/QLKS_Phong/insertPhong.php";
    @Override
    public boolean insert(QlPhong t) {
        boolean check = false;
        try {
//            String sql_insert = "insert into phong values(?,?,?,?,?,?,?,?)";
//            PreparedStatement pstate = con.prepareStatement(sql_insert);
//            pstate.setString(1, t.getMaphong());
//            pstate.setString(2, t.getTenphong());
//            pstate.setString(3, t.getLoaiphong());
//            pstate.setFloat(4, t.getGiaphong());
//            pstate.setString(5, t.getChuthich());
//            pstate.setString(6, t.getTinhtrang());
//            pstate.setString(7, t.getManv());
//            pstate.setString(8, t.getMadv());
//            pstate.execute();
//            check = true;
              String checkInsert = jr.insertPhong(t,urlInsert);
              if(checkInsert.equals("success")){
                  check = true;
              }
        } catch (Exception e) {
            e.printStackTrace();
            check = false;
        }
        return check;
    }

    private final String urlUpdate = "http://localhost/QLKS_Phong/updatePhong.php";
    @Override
    public boolean update(QlPhong t) {
        boolean check = false;
        try {
//            String sql_update = "update phong set TENPHONG=?,LOAIPHONG=?,GIAPHONG=?,CHUTHICH=?,TINHTRANG=? where MAPHONG=?";
//            PreparedStatement pstate = con.prepareStatement(sql_update);
//            pstate.setString(6, t.getMaphong());
//            pstate.setString(1, t.getTenphong());
//            pstate.setString(2, t.getLoaiphong());
//            pstate.setFloat(3, t.getGiaphong());
//            pstate.setString(4, t.getChuthich());
//            pstate.setString(5, t.getTinhtrang());
//            pstate.execute();
//            check = true;
            String checkUpdate = jr.updatePhong(t, urlUpdate);
            if(checkUpdate.equals("success")){
                check = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            check = false;
        }
        return check;
    }

    private final String urlUpdateTinhTrang = "http://localhost/QLKS_Phong/updateTinhTrang.php";
    public boolean updateTT(String maphong) {
        boolean check = false;
        try {
//            String sql_update = "update phong set TINHTRANG=? where MAPHONG=?";
//            PreparedStatement pstate = con.prepareStatement(sql_update);
//            pstate.setString(2, maphong);
//            pstate.setString(1, "het");
//            pstate.execute();
//            check = true;
            String checkUpdate = jr.updateTinhTrang(maphong, urlUpdateTinhTrang);
            if(checkUpdate.equals("success")){
                check = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            check = false;
        }
        return check;
    }
    public boolean resetTT(String maphong) {
        boolean check = false;
        try {
            String sql_update = "update `phong` set TINHTRANG='con' where MAPHONG=?";
            PreparedStatement pstate = con.prepareStatement(sql_update);
            pstate.setString(1, maphong);
            pstate.execute();
            check = true;
        } catch (Exception e) {
            e.printStackTrace();
            check = false;
        }
        return check;
    }

    private final String urlDelete = "http://localhost/QLKS_Phong/deletePhong.php";
    @Override
    public boolean delete(QlPhong t) {
        boolean check = false;
        try {
//            String sql_delete = "delete phong where MAPHONG=?";
//            PreparedStatement ps = con.prepareStatement(sql_delete);
//            ps.setString(1, t.getMaphong());
//            ps.execute();
//            check = true;
              String checkDelete = jr.deletePhong(t,urlDelete);
              if(checkDelete.equals("success")){
                  check = true;
              }
        } catch (Exception e) {
            e.printStackTrace();
            check = false;
        }
        return check;
    }

    @Override
    public List<QlPhong> search(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public static String replaceLast(String text, String regex, String replacement) {
        return text.replaceFirst("(?s)"+regex+"(?!.*?"+regex+")", replacement);
    }

    public List<QlPhong> search(QlPhong ql) {
        List<QlPhong> ds = new ArrayList<>();
        String sql_search = "select * from `phong`";
        int dem = 0;
        if(!String.valueOf(ql.getMaphong()).isEmpty() || !String.valueOf(ql.getGiaphong()).isEmpty() || !String.valueOf(ql.getLoaiphong()).isEmpty() || !String.valueOf(ql.getTenphong()).isEmpty()
                 || !String.valueOf(ql.getTinhtrang()).isEmpty() || !String.valueOf(ql.getChuthich()).isEmpty()){
            sql_search += " where";
            if(!String.valueOf(ql.getMaphong()).isEmpty()){
                sql_search += " MAPHONG like '%" + ql.getMaphong()+ "%' and";
                dem = 1;
            }
            if(ql.getGiaphong()!=-9999){
                sql_search += " GIAPHONG like '%"+(int)ql.getGiaphong()+"%' and";
                dem = 1;
            }
            if(!ql.getLoaiphong().isEmpty()){
                sql_search += " LOAIPHONG like '%"+ql.getLoaiphong()+"%' and";
                dem = 1;
            }
            if(!ql.getTenphong().isEmpty()){
                sql_search += " TENPHONG like '%"+ql.getTenphong()+"%' and";
                dem = 1;
            }
            if(!ql.getChuthich().isEmpty()){
                sql_search += " CHUTHICH like '%"+ql.getChuthich()+"%' and";
                dem = 1;
            }
            if(!ql.getTinhtrang().isEmpty()){
                sql_search += " TINHTRANG like '%"+ql.getTinhtrang()+"%' and";
                dem = 1;
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
                ds.add(new QlPhong(rs.getString("MAPHONG"), rs.getString("TENPHONG"),
                        rs.getString("LOAIPHONG"), rs.getFloat("GIAPHONG"),
                        rs.getString("CHUTHICH"), rs.getString("TINHTRANG")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ds;
    }
    
    public QlPhong getPhongByMaPhong(String maphong){
        QlPhong qp = null;
        try{
            String sql_select = "select * from phong where MAPHONG='"+maphong+"'";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql_select);
            if(rs.next()){
                qp = new QlPhong(rs.getString("MAPHONG"), rs.getString("TENPHONG"), rs.getString("LOAIPHONG"),rs.getFloat("GIAPHONG"), rs.getString("CHUTHICH"),rs.getString("TINHTRANG"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return qp;
    }

    public static void main(String[] args) {
        
        Control_QlPhong nc = new Control_QlPhong();
//
//        List<QlPhong> ls = nc.search(new QlPhong("", "", "", 5, "", ""));
//        for (QlPhong l : ls) {
//            System.out.println(l);
//        }
         System.out.println(nc.getPhongByMaPhong("6756"));
    }

 
    
}
