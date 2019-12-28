import java.sql.*;
import javax.swing.JOptionPane;
public class SQLITE_CONNECT {
    Connection cin = null;
    public static Connection ConnectDB(){
        try
           {      
                Class.forName("org.sqlite.JDBC");
                Connection conn = DriverManager.getConnection("jdbc:sqlite:E:\\PROJECTS\\JAVA\\ANJAN\\test.db");
                return conn;
           }
           catch (Exception ex){
              JOptionPane.showMessageDialog(null, ex);
              return null;
           }
    }
}
