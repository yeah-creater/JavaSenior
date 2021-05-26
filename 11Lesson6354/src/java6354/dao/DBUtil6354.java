package java6354.dao;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Objects;
import java.util.Properties;

/**
 * @author: yeah
 */
public class DBUtil6354 {
    static DataSource dataSource;
    static Connection conn;
    static PreparedStatement ps;
    static {
        InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("config/database6354.properties");
        Properties pros=new Properties();
        try {
            pros.load(is);
            dataSource = DruidDataSourceFactory.createDataSource(pros);
            conn=dataSource.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection(){
        return conn;
    }

    public static void close(){
        try {
            Objects.requireNonNull(ps).close();
            Objects.requireNonNull(conn).close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
