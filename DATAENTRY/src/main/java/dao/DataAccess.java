/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.*;
import db.DBUtils;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.data;

/**
 *
 * @author Anjan
 */
public class DataAccess {
    
    public static Connection getConnection(){  
        Connection con=null;  
        try{  
            Class.forName("com.mysql.jdbc.Driver").newInstance();
        Connection conn = DriverManager.getConnection("jdbc:mysql://sql12.freemysqlhosting.net/sql12317086?autoReconnect=true&useSSL=false", "sql12317086","VkyS1BFDbf"); 
        }catch(Exception e){System.out.println(e);}  
        return con;  
    }  
    
    public static int save(data e){  
        int status=0;  
        try{  
            Connection con=DataAccess.getConnection();  
            PreparedStatement ps=con.prepareStatement(  
                         "insert into DATA (REF, DATE, ACC, ACCTP, PARTY, PARTYTP, AMT, REM)values (?,?,?,?,?,?,?,?)");  
            ps.setString(1,e.getREF());  
            ps.setString(2,e.getDATE());  
            ps.setString(3,e.getACC());  
            ps.setString(4,e.getACCTP());  
            ps.setString(5,e.getPARTY());
            ps.setString(6,e.getPARTYTP());
            ps.setString(7,e.getAMT());
            ps.setString(8,e.getREM());
            status=ps.executeUpdate();  
               
        }catch(Exception ex){ex.printStackTrace();}  
          
        return status;  
    }  
}
