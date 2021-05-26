package java6354.dao;

import org.sqlite.core.DB;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author: yeah
 */
public class Dao6354 {
    static void delete6354(int id){
        DBUtil6354.conn=DBUtil6354.getConnection();
        try {
            DBUtil6354.ps=DBUtil6354.conn.prepareStatement("delete from xslist where id=?");
            DBUtil6354.ps.setObject(1,id);
            DBUtil6354.ps.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        finally {
            DBUtil6354.close();
        }
    }
    public static void main(String[] args) throws Exception {
        delete6354(2);
    }
}
