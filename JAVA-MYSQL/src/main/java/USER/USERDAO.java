
package USER;
import java.util.*;  
import java.sql.*;
/**
 *
 * @author ANJAN
 */
public class USERDAO {
    public static Connection getConnection(){  
        Connection con=null;  
        try{  
            Class.forName("com.mysql.jdbc.Driver").newInstance();
                con = DriverManager.getConnection("jdbc:mysql://sql12.freemysqlhosting.net/sql12317086?autoReconnect=true&useSSL=false", "sql12317086","VkyS1BFDbf");  
        }catch(Exception e){System.out.println(e);}  
        return con;  
    }  
    
    public static int save(USER.USER_MODEL e){  
        int status=0;  
        try{  
            Connection con=USERDAO.getConnection();  
            PreparedStatement ps=con.prepareStatement(  
                         "insert into user(user,pass) values (?,?)");  
            ps.setString(1,e.getuser());  
            ps.setString(2,e.getpass());  
            
              
            status=ps.executeUpdate();  
              
        }catch(Exception ex){ex.printStackTrace();}  
          
        return status;  
    }  
    
    public static int update(USER.USER_MODEL e){  
        int status=0;  
        try{  
            Connection con=USER.USERDAO.getConnection();  
            PreparedStatement ps=con.prepareStatement(  
                         "update user set user=?,pass=? where uid=?");  
            ps.setString(1,e.getuser());  
            ps.setString(2,e.getpass());    
            ps.setInt(3,e.getId());  
              
            status=ps.executeUpdate();  
               
        }catch(Exception ex){ex.printStackTrace();}  
          
        return status;  
    }  
    
    public static int delete(int uid){  
        int status=0;  
        try{  
            Connection con=USER.USERDAO.getConnection();  
            PreparedStatement ps=con.prepareStatement("delete from user where uid=?");  
            ps.setInt(1,uid);  
            status=ps.executeUpdate();  
              
        }catch(Exception e){e.printStackTrace();}  
          
        return status;  
    }
    
    public static USER.USER_MODEL getEmployeeById(int id){  
        USER.USER_MODEL e=new USER.USER_MODEL();  
          
        try{  
            Connection con=USER.USERDAO.getConnection();  
            PreparedStatement ps=con.prepareStatement("select * from user where uid=?");  
            ps.setInt(1,id);  
            ResultSet rs=ps.executeQuery();  
            if(rs.next()){  
                e.setId(rs.getInt(1));  
                e.setName(rs.getString(2));  
                e.setPassword(rs.getString(3));    
            }  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return e;  
    } 
    
    public static List<USER.USER_MODEL> getAllEmployees(){  
        List<USER.USER_MODEL> list=new ArrayList<USER.USER_MODEL>();  
          
        try{  
            Connection con=USER.USERDAO.getConnection();  
            PreparedStatement ps=con.prepareStatement("select * from user");  
            ResultSet rs=ps.executeQuery();  
            while(rs.next()){  
                USER.USER_MODEL e=new USER.USER_MODEL();  
                e.setId(rs.getInt(1));  
                e.setName(rs.getString(2));  
                e.setPassword(rs.getString(3));  
                list.add(e);  
            }   
        }catch(Exception e){e.printStackTrace();}  
          
        return list;  
    }  
}
