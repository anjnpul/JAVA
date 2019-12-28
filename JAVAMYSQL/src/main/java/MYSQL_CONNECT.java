import java.sql.*;
import javax.swing.JOptionPane;
public class MYSQL_CONNECT {
    Connection cin = null;
    public static Connection ConnectDB(){
        try
           {      
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                Connection conn = DriverManager.getConnection("jdbc:mysql://johnny.heliohost.org/anjnpul_anjan?autoReconnect=true&useSSL=false", "anjnpul_anjan","indian");
                return conn;
           }
           catch (Exception ex){
              JOptionPane.showMessageDialog(null, ex);
              return null;
           }
    }
}
