/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.MyConnection;
import Model.ThongKe_Phong;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author DELL
 */
public class Control_TK_Phong implements DAO.DAO<ThongKe_Phong> {

    MyConnection mc = MyConnection.getInstance();
    Connection con = mc.getConnect();

    @Override
    public List<ThongKe_Phong> getAll() {
        List<ThongKe_Phong> ds = new ArrayList<>();
        try {
            String sql_select = "SELECT phong.TENPHONG AS 'tenphong',COUNT(phong.TENPHONG) AS 'solan'\n"
                    + "FROM `phong`,`datphong`\n"
                    + "WHERE phong.MAPHONG = datphong.maphong\n"
                    + "GROUP BY phong.TENPHONG";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql_select);
            while (rs.next()) {
                ds.add(new ThongKe_Phong(rs.getString("tenphong"), rs.getInt("SOLAN")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ds;
    }

    public List<ThongKe_Phong> getAllbyDay(String dayFrom, String dayTo) {
        List<ThongKe_Phong> ds = new ArrayList<>();
        try {
            String sql_select = "SELECT phong.TENPHONG AS 'tenphong',COUNT(phong.TENPHONG) AS 'solan'\n"
                    + "FROM `phong`,`datphong`\n"
                    + "WHERE phong.MAPHONG = datphong.maphong AND datphong.ngaydat BETWEEN '" + dayFrom + "' AND '" + dayTo + "'\n"
                    + "GROUP BY phong.TENPHONG";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql_select);
            while (rs.next()) {
                ds.add(new ThongKe_Phong(rs.getString("tenphong"), rs.getInt("solan")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ds;
    }

    public List<ThongKe_Phong> getAllDaysbyDay(String dayFrom, String dayTo) {
        List<ThongKe_Phong> ds = new ArrayList<>();
        try {
            String sql_select = "SELECT phong.TENPHONG AS 'tenphong',SUM(DATEDIFF(IF(DATEDIFF(datphong.ngaytra,'" + dayTo + "')<0,datphong.ngaytra,'" + dayTo + "'),datphong.ngaydat)) as 'solan'\n"
                    + "FROM `phong`,`datphong`\n"
                    + "WHERE phong.MAPHONG = datphong.maphong and datphong.ngaydat BETWEEN '" + dayFrom + "' AND '" + dayTo + "'\n"
                    + "GROUP BY phong.TENPHONG";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql_select);
            while (rs.next()) {
                ds.add(new ThongKe_Phong(rs.getString("tenphong"), rs.getInt("solan")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ds;
    }

    public List<ThongKe_Phong> getAllPricebyDayFrom(String dayFrom, String dayTo) {
        List<ThongKe_Phong> ds = new ArrayList<>();
        try {
            String sql_select = "SELECT phong.TENPHONG AS 'tenphong',SUM(hoadon.thanhtien) AS 'solan'\n"
                    + "FROM `phong`,`hoadon`,`datphong`\n"
                    + "WHERE phong.MAPHONG = datphong.maphong AND hoadon.madp = datphong.id AND datphong.tinhtrangthanhtoan = 1\n"
                    + "AND datphong.ngaydat BETWEEN '" + dayFrom + "' AND '" + dayTo + "'\n"
                    + "GROUP BY phong.TENPHONG";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql_select);
            while (rs.next()) {
                ds.add(new ThongKe_Phong(rs.getString("tenphong"), rs.getFloat("solan")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ds;
    }

    public List<ThongKe_Phong> getAllPricebyDayTo(String dayFrom, String dayTo) {
        List<ThongKe_Phong> ds = new ArrayList<>();
        try {
            String sql_select = "SELECT phong.TENPHONG AS 'tenphong',SUM(hoadon.thanhtien) AS 'solan'\n"
                    + "FROM `phong`,`hoadon`,`datphong`\n"
                    + "WHERE phong.MAPHONG = datphong.maphong AND hoadon.madp = datphong.id AND datphong.tinhtrangthanhtoan = 1\n"
                    + "AND datphong.ngaytra BETWEEN '" + dayFrom + "' AND '" + dayTo + "'\n"
                    + "GROUP BY phong.TENPHONG";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql_select);
            while (rs.next()) {
                ds.add(new ThongKe_Phong(rs.getString("tenphong"), rs.getFloat("solan")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ds;
    }

    public List<ThongKe_Phong> getAllPricebyRoom(String idRoom, int year) {
        int index = 0;
        List<ThongKe_Phong> ds = new ArrayList<>();
        List<ThongKe_Phong> ds_available = new ArrayList<>();
        String sql_year = "";
        String sql_idroom = "";
        if (!idRoom.equals("all")) {
            sql_idroom = " AND phong.MAPHONG='" + idRoom + "'";
        }
        if (year != -1) {
            sql_year = " AND Year(datphong.ngaytra)=" + year;
        }
        try {
            String sql_select = "SELECT month(datphong.ngaytra) AS 'Tháng',SUM(hoadon.thanhtien) as 'Giá'\n"
                    + "FROM hoadon,datphong,phong\n"
                    + "WHERE hoadon.madp = datphong.id and phong.MAPHONG = datphong.maphong" + sql_idroom + sql_year + "\n"
                    + "GROUP BY month(datphong.ngaytra)";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql_select);
            while (rs.next()) {
                ds_available.add(new ThongKe_Phong(rs.getString("Tháng"), rs.getFloat("Giá")));
            }
            if (ds_available.size() > 0) {
                for (int i = 1; i <= 12; i++) {
                    if (index < ds_available.size() && Integer.parseInt(ds_available.get(index).getKey()) == i) {
                        ds.add(new ThongKe_Phong(String.valueOf(i), ds_available.get(index).getValue()));
                        index++;
                    } else {
                        ds.add(new ThongKe_Phong(String.valueOf(i), 0));
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ds;
    }

    @Override
    public Optional<ThongKe_Phong> get(int d) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean insert(ThongKe_Phong t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(ThongKe_Phong t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(ThongKe_Phong t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ThongKe_Phong> search(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static void main(String[] args) {
        Control_TK_Phong dp = new Control_TK_Phong();
        List<ThongKe_Phong> ds = dp.getAllPricebyRoom("ph04", 2022);
        for (ThongKe_Phong d : ds) {
            System.out.println(d);
        }
    }
}
