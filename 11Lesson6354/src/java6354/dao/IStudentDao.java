package java6354.dao;

import java.util.List;

/**
 * @author: yeah
 */
public interface IStudentDao {
    /**
     * 功能：向数据表xslist中添加一条记录
     * @param stu 参数student对象中包含了新增记录中各字段的内容
     * @return 如果已向数据表添加了记录，返回新记录的id，否则返回-1
     */
    int add6354(Student6354 stu);

    /**
     * 功能：从数据表xslist中删除一行记录
     * @param id 用于定位xslist表中要删除的记录
     * @return 返回1表示已删除，返回-1表示未删除
     */
    int delete6364(int id);

    /**
     * 修改数据表xslist中的某行记录
     * @param id 用于定位xslist表中要修改的记录
     * @param stu 表示用newStudent对象中各属性的值，修改xslist表中对应的字段
     * @return 返回1表示已修改，返回-1表示未修改
     */
    int update6354(int id,Student6354 stu);

    /**
     * 从数据表xslist中读取数据加载到List<StudentXXXX>集合中
     * @return List<StudentXXXX>集合，数据表中的每行记录对应集合中的一个StudentXXXX对象（表中没有数据，则返回null）
     */
    List<Student6354> findAll6354();

    /**
     * 按学号在数据表中查找，返回该学号对应的StudentXXXX对象
     * @param sno 要查找的学号
     * @return 返回找到的StudentXXXX对象（没有找到返回null）
     */
    Student6354 findStudent6354(String sno);

}
