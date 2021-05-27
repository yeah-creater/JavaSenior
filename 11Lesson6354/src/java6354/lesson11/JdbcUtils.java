package java6354.lesson11;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 * @author yeah
 */
public class JdbcUtils {
    private JdbcUtils(){};
    public static Connection con;
    public static PreparedStatement ps;

    public static Connection getDriverConnection() throws Exception{
        String url = "jdbc:mysql://localhost:3306/database1?serverTimezone=UTC";
        String user = "root";
        String password = "*********";
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection(url, user, password);
        return con;
    }
     public static void releaseResources() throws Exception{
        if(ps!=null){
            ps.close();
        }
        if(con!=null) {
            con.close();
        }
    }


}
