/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.*;
import db.DBUtils;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.data;

/**
 *
 * @author Anjan
 */
public class DataAccess {

    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conn = DriverManager.getConnection("jdbc:mysql://sql12.freemysqlhosting.net/sql12317086?autoReconnect=true&useSSL=false", "sql12317086", "VkyS1BFDbf");
        } catch (Exception e) {
            System.out.println(e);
        }
        return conn;
    }

    public static int save(data e) {
        int status = 0;
        try {
            Connection con = DataAccess.getConnection();
            PreparedStatement ps = con.prepareStatement("insert into DATA(REF, DATE, ACC, ACCTP, PARTY, PARTYTP, AMT, REM, PROJ) values (?,?,?,?,?,?,?,?,?)");
            ps.setString(1, e.getREF());
            ps.setString(2, e.getDATE());
            ps.setString(3, e.getACC());
            ps.setString(4, e.getACCTP());
            ps.setString(5, e.getPARTY());
            ps.setString(6, e.getPARTYTP());
            ps.setString(7, e.getAMT());
            ps.setString(8, e.getREM());
            ps.setString(9, e.getPROJ());
            status = ps.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return status;
    }

    public static List<data> getAllData() {
        List<data> list = new ArrayList<data>();

        try {
            Connection con = DataAccess.getConnection();
            PreparedStatement ps = con.prepareStatement("select * from DATA");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                data e = new data();
                e.setID(rs.getInt(1));
                e.setREF(rs.getString(2));
                e.setDATE(rs.getString(3));
                e.setACC(rs.getString(4));
                e.setACCTP(rs.getString(5));
                e.setPARTY(rs.getString(6));
                e.setPARTYTP(rs.getString(7));
                e.setAMT(rs.getString(8));
                e.setREM(rs.getString(9));
                e.setPROJ(rs.getString(10));
                list.add(e);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
