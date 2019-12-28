import java.sql.*;
import javax.swing.JOptionPane;
public class MYSQL_CONNECT {
    Connection cin = null;
    public static Connection ConnectDB(){
        try
           {      
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?autoReconnect=true&useSSL=false", "root","INDIAN");
                return conn;
           }
           catch (Exception ex){
              JOptionPane.showMessageDialog(null, ex);
              return null;
           }
    }
}
