/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author ANJAN
 */
public class connect_db {
    public static Connection ConnectDB(){
        try
           {      
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                Connection conn = DriverManager.getConnection("jdbc:mysql://sql12.freemysqlhosting.net/sql12317086?autoReconnect=true&useSSL=false", "sql12317086","VkyS1BFDbf");
                return conn;
           }
           catch (Exception ex){
              JOptionPane.showMessageDialog(null, ex);
              return null;
           }
    }
}
