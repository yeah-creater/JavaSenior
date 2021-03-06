package java6354.lesson11;

import java.sql.Connection;

/**
 * @author: yeah
 */
public class SimpleDML6354 {
    private static final String SQL_CREATE = "CREATE TABLE xslist" + "(" +
            "id integer PRIMARY KEY AUTO_INCREMENT NOT NULL," +
            "sno varchar(100) NOT NULL," +
            "sname varchar(100)," +
            "lx1 integer," +
            "lx2 integer" + ")";

    public static boolean comOpe(String sql, Object... args) {
        try (Connection conn = JdbcUtils.getDriverConnection()) {
            JdbcUtils.ps = conn.prepareStatement(sql);
            //填充字符
            for (int i = 0; i < args.length; i++) {
                JdbcUtils.ps.setObject(i + 1, args[i]);
            }
            //执行语句
            boolean res = JdbcUtils.ps.execute();
            JdbcUtils.releaseResources();
            return res;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    private static boolean create6354(String sql) {
       return comOpe(sql);
    }

    private static boolean insert6354(String sql, Object... args) {
        return comOpe(sql, args);
    }

    private static boolean update6354(String sql) {
        return comOpe(sql);
    }

    private static boolean delete6354(String sql, Object... args) {
        return comOpe(sql, args);
    }
    private static void execute6354(){
        //create6354(SQL_CREATE);
        //insert6354()
        update6354("update xslist set lx1 = id*2 ,lx2=lx1+id");
        delete6354("delete from xslist where lx1 % ? = 0", 3);
    }

    public static void main(String[] args) {
//        if (create6354(SQL_CREATE)) {
//            System.out.println("创建成功");
//        } else {
//            System.out.println("表已存在,无需创建");
//        }
//       update6354("update xslist set lx1 = id*2 ,lx2=lx1+id");
//      delete6354("delete from xslist where lx1 % ? = 0", 3);
        execute6354();

    }
}
