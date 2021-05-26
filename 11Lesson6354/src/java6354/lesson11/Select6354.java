package java6354.lesson11;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

/**
 * @author: yeah
 */
class Student6354 {
    private int id;
    private String sname;
    private String sno;

    public Student6354(int id, String sname, String sno) {
        this.id = id;
        this.sname = sname;
        this.sno = sno;
    }

    public Student6354() {
    }

    @Override
    public String toString() {
        return id + "   ," + sno + "," + sname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }
}

/**
 * @author yeah
 */
public class Select6354 {

    private static <T> void find6354(Class<T> clazz, String sql, Object... args) {
        try (Connection conn = JdbcUtils.getDriverConnection()) {
            JdbcUtils.ps = conn.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                JdbcUtils.ps.setObject(i + 1, args[i]);
            }
            //获取查询的结果集
            ResultSet rs = JdbcUtils.ps.executeQuery();
            //获取元数据
            ResultSetMetaData rsmd = JdbcUtils.ps.getMetaData();
            while (rs.next()) {
                //通过字节码获取一个对象  无参构造器
                T t = clazz.newInstance();
                for (int i = 0; i < rsmd.getColumnCount(); i++) {
                    //获取某行第i+1列的值
                    Object columnValue = rs.getObject(i + 1);
                    //获取某行第i+1列查询后的列名
                    String columnLabel = rsmd.getColumnLabel(i + 1);
                    //通过反射给对象赋值
                    Field field = clazz.getDeclaredField(columnLabel);
                    field.setAccessible(true);
                    field.set(t, columnValue);
                }
                System.out.println(t);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        find6354(Student6354.class, "select id,sno,sname from xslist where sname like ? and id<=?", "%志%", 100);
    }
}
