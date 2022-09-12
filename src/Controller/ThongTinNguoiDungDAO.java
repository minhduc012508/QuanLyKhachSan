/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.ThongTinNguoiDung;
import DAO.MyConnection;
import java.security.interfaces.RSAKey;
import java.util.List;
import java.util.Optional;
import java.sql.*;

/**
 *
 * @author DELL
 */
public class ThongTinNguoiDungDAO implements DAO.DAO {

    private static final String TABLE_NAME = "thongtinnguoidung";
    MyConnection mc = MyConnection.getInstance();
    Connection con = mc.getConnect();

    @Override
    public List getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Optional get(int d) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public ThongTinNguoiDung get(String tentaikhoan) {
        ThongTinNguoiDung tt = new ThongTinNguoiDung();
        try {
            String sql_select = "select thongtinnguoidung.*,loggin.MatKhau\n"
                    + "from thongtinnguoidung, loggin\n"
                    + "where thongtinnguoidung.TaiKhoan = loggin.TaiKhoan and\n"
                    + "thongtinnguoidung.TaiKhoan = '" + tentaikhoan + "'";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql_select);
            while (rs.next()) {
                tt = new ThongTinNguoiDung(rs.getString("HoTen"), rs.getString("TaiKhoan"), rs.getString("Mail"), rs.getString("SDT"), rs.getString("MatKhau"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tt;
    }

    @Override
    public boolean insert(Object t) {
        ThongTinNguoiDung tt = (ThongTinNguoiDung) t;
        boolean key = false;
        try {
            String sql_update = "insert into " + TABLE_NAME + " values("
                    + "'" + tt.getHoTen() + "',"
                    + "'" + tt.getTaiKhoan() + "',"
                    + "'" + tt.getMail() + "',"
                    + "'" + tt.getSDT() + "')";
            Statement st = con.createStatement();
            int rs = st.executeUpdate(sql_update);
            System.out.println(rs);
            if (rs == 1) {
                key = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return key;
    }

    @Override
    public boolean update(Object t) {
        ThongTinNguoiDung tt = (ThongTinNguoiDung) t;
        boolean key = false;
        try {
            String sql_update = "update " + TABLE_NAME + " set "
                    + "HoTen='" + tt.getHoTen() + "',Mail='" + tt.getMail() + "',SDT='" + tt.getSDT()
                    + "' where TaiKhoan='" + tt.getTaiKhoan() + "'";
            Statement st = con.createStatement();
            int rs = st.executeUpdate(sql_update);
            System.out.println(rs);
            if (rs == 1) {
                key = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return key;
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
//        ThongTinNguoiDungDAO td = new ThongTinNguoiDungDAO();
//        td.update(new ThongTinNguoiDung("Do Minh Duc","sa","mailthaydoi","0971441259",""));
//        
    }
}
