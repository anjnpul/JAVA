import java.sql.*;
import javax.swing.JOptionPane;
public class MYSQL_CONNECT {
    Connection cin = null;
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
