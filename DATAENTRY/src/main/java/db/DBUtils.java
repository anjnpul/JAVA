/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Anjan
 */
public class DBUtils {
    public static PreparedStatement getPreparedStatement(String sql){
        PreparedStatement ps = null;
        try{
            Class.forName("com.mysql.jdbc.Driver").newInstance();
        Connection conn = DriverManager.getConnection("jdbc:mysql://sql12.freemysqlhosting.net/sql12317086?autoReconnect=true&useSSL=false", "sql12317086","VkyS1BFDbf");
        ps = conn.prepareStatement(sql);
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }
        return ps;
    }
}
