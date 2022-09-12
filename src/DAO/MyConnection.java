/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
//import com.microsoft.sqlserver.jdbc.SQLServerDataSource;

import java.io.FileReader;
import java.sql.*;
import java.util.Properties;
import java.util.logging.Logger;
import java.util.logging.Level;

/**
 *
 * @author DELL
 */
public class MyConnection {
    private static MyConnection mcon;
    
    public static Connection conn = null;
    String user = "";
    String pass = "";
    String port = "";
    String host = "";
    String dbName = "";

    private MyConnection() {
        conn = getConnect();
    }

    public Connection getConnect() {
        if (conn == null) {
            conn = ConnectDB();
        }
        return conn;
    }

    public Connection ConnectDB() {
        Connection connz = null;
        try {

            FileReader fr = new FileReader("Connect.properties");
            Properties pr = new Properties();
            pr.load(fr);
            user = pr.getProperty("user");
            port = pr.getProperty("port");
            int portNB = Integer.parseInt(port);
            host = pr.getProperty("hostname");
            dbName = pr.getProperty("dbName");
            pass = pr.getProperty("password");
            String dbURL = "jdbc:mysql://"+host+":"+portNB+"/"+dbName;
            System.out.println(dbURL);
            connz = DriverManager.getConnection(dbURL, user, pass);
            System.out.println("Kết nối thành công!");
            //conn = connz;
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Oops Error!");
        }
        return connz;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone(); //To change body of generated methods, choose Tools | Templates.
    }
    public static MyConnection getInstance(){
        if(mcon == null){
            mcon = new MyConnection();
        }
        return mcon;
    }

    public static void main(String[] args) {
        MyConnection con = new MyConnection();
       // con.ConnectDB();
    }
}
