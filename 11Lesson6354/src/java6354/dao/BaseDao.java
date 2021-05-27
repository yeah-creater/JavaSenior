package java6354.dao;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import java.lang.reflect.Field;
import java.sql.*;
import java.util.List;

/**
 * @author: yeah
 */
public class BaseDao {
    public int update(String sql, Object... args) {
        DBUtil6354.conn = DBUtil6354.getConnection();
        try {
            DBUtil6354.ps = DBUtil6354.conn.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                DBUtil6354.ps.setObject(i + 1, args[i]);
            }
            int res = DBUtil6354.ps.executeUpdate();
            return res>0?1:-1;
        } catch (SQLException troubles) {
            troubles.printStackTrace();
        } finally {
            DBUtil6354.close();
        }
        return -1;
    }

    public <T> T query(Class<T> clazz, String sql, Object... args) {
        DBUtil6354.conn = DBUtil6354.getConnection();
        try {
            DBUtil6354.ps = DBUtil6354.conn.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                DBUtil6354.ps.setObject(i + 1, args[i]);
            }
            //结果集
            ResultSet rs = DBUtil6354.ps.executeQuery();
            //结果集元数据
            ResultSetMetaData rsmd = rs.getMetaData();
            //结果集的列数
            int columnCount = rsmd.getColumnCount();
            T t = clazz.newInstance();
            while (rs.next()) {
                for (int i = 0; i < columnCount; i++) {
                    //该行列的值
                    Object obj = rs.getObject(i+1);
                    if(obj==null) {
                        continue;
                    }
                    //该列的列名  要求数据库列名和对象属性名一样
                    String columnLabel = rsmd.getColumnLabel(i + 1);
                    Field filed = clazz.getDeclaredField(columnLabel);
                    filed.setAccessible(true);
                    filed.set(t, obj);
                }
                return t;
            }

        } catch (Exception troubles) {
            troubles.printStackTrace();
        } finally {
            DBUtil6354.close();
        }
        return null;
    }

    public <T> List<T> queryAll(Class<T> clazz, String sql, Object... args) {
        QueryRunner runner = new QueryRunner();
        DBUtil6354.conn = DBUtil6354.getConnection();
        BeanListHandler<T> handler = new BeanListHandler<>(clazz);
        try {
            return runner.query(DBUtil6354.conn, sql, handler, args);
        } catch (SQLException troubles) {
            troubles.printStackTrace();
        } finally {
            DBUtil6354.close();
        }
        return null;
    }

}
