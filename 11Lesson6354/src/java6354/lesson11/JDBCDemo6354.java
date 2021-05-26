package java6354.lesson11;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @author: yeah
 */
public class JDBCDemo6354 {
    // 172.23.45.95
    private static final String URL = "jdbc:mysql://localhost:3306/database1?serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PW = "ybz666yeah";
    private static final String DRIVER="com.mysql.cj.jdbc.Driver";


    public static void main(String[] args) throws Exception{
        //加载驱动
        Class.forName(DRIVER);
        //连接数据库
        Connection conn = DriverManager.getConnection(URL, USER, PW);
        //输出数据库名称、版本号、数据库的URL
        System.out.println("使用的数据库产品:"+conn.getMetaData().getDatabaseProductName());
        System.out.println("版本号:"+conn.getMetaData().getDatabaseProductVersion());
        System.out.println("数据库的URL:"+conn.getMetaData().getURL());
        //关闭连接
        conn.close();

    }

}
