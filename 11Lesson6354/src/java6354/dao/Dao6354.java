package java6354.dao;

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
        } catch (SQLException troubles) {
            troubles.printStackTrace();
        }
        finally {
            DBUtil6354.close();
        }
    }

    public static void main(String[] args) {
        Student6354 stu=new Student6354();
        stu.setSno("1244");
        stu.setSname("哈哈哈哈");
        StudentDao6354Imp studentDao6354Imp = new StudentDao6354Imp();
//        System.out.println("新id为"+studentDao6354Imp.add6354(stu));
//        System.out.println(studentDao6354Imp.delete6364(85));
//        System.out.println(studentDao6354Imp.delete6364(100));
//        System.out.println(studentDao6354Imp.update6354(4, stu));
//        System.out.println(studentDao6354Imp.update6354(1, stu));
//        System.out.println(studentDao6354Imp.findStudent6354("211906354"));
//        System.out.println(studentDao6354Imp.findStudent6354("211")==null);
//        List<Student6354> all6354 = studentDao6354Imp.findAll6354();
//        for(Student6354 stu6354:all6354){
//            System.out.println(stu6354);
//        }
    }

}
