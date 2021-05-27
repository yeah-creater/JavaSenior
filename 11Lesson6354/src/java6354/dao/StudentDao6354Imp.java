package java6354.dao;

import java.util.List;

/**
 * @author: yeah
 */
public class StudentDao6354Imp extends BaseDao implements IStudentDao6354 {
    @Override
    public int add6354(Student6354 stu) {
        String sno = stu.getSno();
        String sname = stu.getSname();
        String sql = "INSERT INTO xslist(sno,sname) VALUES(?,?)";
        if(update(sql, sno, sname)==1) {
            //学号默认也是主键了呀，虽然数据库没设置
            sql = "SElECT * FROM xslist WHERE sno = ?";
            Student6354 stu1 = query(Student6354.class, sql, sno);
            return stu1.getId();
        }
        return -1;

    }

    @Override
    public int delete6364(int id) {
        String sql = "DELETE FROM xslist WHERE id=?";
        return update(sql, id);
    }

    @Override
    public int update6354(int id, Student6354 stu) {
        String sno = stu.getSno();
        String sname = stu.getSname();
        String sql = "UPDATE xslist SET sno=?,sname=? where id=?";
        return update(sql, sno, sname, id);
    }

    @Override
    public Student6354 findStudent6354(String sno) {
        String sql = "SELECT * FROM xslist WHERE sno = ?";
        return query(Student6354.class, sql, sno);
    }

    @Override
    public List<Student6354> findAll6354() {
        String sql = "SELECT * FROM xslist";
        return queryAll(Student6354.class, sql);
    }

}
