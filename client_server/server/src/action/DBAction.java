/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import beans.Worker;
import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 展贝
 */
public class DBAction {

    private static final String url = "jdbc:mysql://localhost:3306/workers";
    private static final String driver = "com.mysql.jdbc.Driver";
    private static final String user = "root";
    private static final String pass = "123456";

    private Connection con;

    public void init() throws ClassNotFoundException {
        try {
            if (con != null) {
                return;
            }
            Class.forName(driver);
            con = (Connection) DriverManager.getConnection(url, user, pass);
            System.out.printf("con 连接成功");
        } catch (SQLException ex) {
            Logger.getLogger(DBAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void close() throws SQLException {
        if (con != null) {
            con.close();
        }
    }

    public boolean check(Worker w) throws ClassNotFoundException {
        String s = "select * from worker where id=" + w.getId() + " " + "and" + " " + "pass=" + w.getPass();
        System.out.println(s);
        try {
            init();
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(s);
            if (rs.next()) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBAction.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean InWorking(Worker w) throws ClassNotFoundException {
        String s = "insert into WorkingStatus values("+  w.getId()+","+ w.getStatus()+ ")";
        System.out.println(s);
        try {
            init();
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(s);
            if (rs.next()) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBAction.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
