package model;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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
	
	public static int save(Data e) {
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
	
	public static List<Data> getAllData() {
        List<Data> list = new ArrayList<Data>();

        try {
            Connection con = DataAccess.getConnection();
            PreparedStatement ps = con.prepareStatement("select * from DATA");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Data e = new Data();
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
	
	public static int upddata(Data e){  
        int status=0;  
        try{  
            Connection con=DataAccess.getConnection();  
            PreparedStatement ps=con.prepareStatement(  
                         "update DATA set REF=?,DATE=?,ACC=?,ACCTP=?, PARTY=?, PARTYTP=?, AMT=?, REM=?, PROJ=? where ID=?");  
            ps.setString(1, e.getREF());
            ps.setString(2, e.getDATE());
            ps.setString(3, e.getACC());
            ps.setString(4, e.getACCTP());
            ps.setString(5, e.getPARTY());
            ps.setString(6, e.getPARTYTP());
            ps.setString(7, e.getAMT());
            ps.setString(8, e.getREM());
            ps.setString(9, e.getPROJ());  
            ps.setInt(10,e.getID());  
              
            status=ps.executeUpdate();  
               
        }catch(Exception ex){ex.printStackTrace();}  
          
        return status;  
    }  
	
	public static int deldata(int ID){  
        int status=0;  
        try{  
            Connection con=DataAccess.getConnection();  
            PreparedStatement ps=con.prepareStatement("delete from DATA where id=?");  
            ps.setInt(1,ID);  
            status=ps.executeUpdate();  
        }catch(Exception e){e.printStackTrace();}  
          
        return status;  
    }  
}
