package java6354.task;


import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import org.w3c.dom.ls.LSOutput;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


/**
 * @author yeah
 */
public class CourseStream6354 {
    /**
     * （1）按开课学期分组
     * （2）统计并列出课程清单，课程清单按成绩排序
     * @param args
     */

    public static void main(String[] args)  {
        Map<String, List<Course6354>> result = getCourses().stream().collect(Collectors.groupingBy(Course6354::getTerm));
        //key流
        Stream<String> keyResult = result.keySet().stream().sorted();
        for(Object term:keyResult.toArray()){
            System.out.println("=====学期: "+term+"=====");
            System.out.println("共" + (long) result.get(term).size() + "门课程,"+" 平均分"+
                    result.get(term).stream().mapToInt(s->s.score).average().orElse(0.00));
            result.get(term).forEach(System.out::println);
        }


    }

    private static List<Course6354> getCourses() {
        List<Course6354> courses = new ArrayList<Course6354>();
        courses.add(new Course6354("A001", "C程序设计基础", "1上", 4, 80));
        courses.add(new Course6354("A004", "离散数学", "1下", 3, 79));
        courses.add(new Course6354("B002", "Python程序基础", "1下", 2, 85));
        courses.add(new Course6354("A002", "面向对象程序设计", "2上", 3, 78));
        courses.add(new Course6354("C012", "软件测试", "3下", 2, 72));
        courses.add(new Course6354("C001", "Java程序高级开发", "3上", 2, 83));
        courses.add(new Course6354("0003", "大学物理", "2上", 2, 77));
        courses.add(new Course6354("C002", "软件工程", "3下", 3, 75));
        courses.add(new Course6354("C011", "移动项目Dev", "3下", 2, 87));
        courses.add(new Course6354("B001", "操作系统", "2下", 3, 90));
        courses.add(new Course6354("A005", "算法与数据结构", "2上", 3, 82));
        courses.add(new Course6354("A003", "数据库原理", "2上", 3, 78));
        courses.add(new Course6354("C003", "前端开发技术", "3上", 3, 69));
        courses.add(new Course6354("B003", "网络基础", "2下", 3, 75));
        courses.add(new Course6354("0001", "大学英语", "1上", 3, 80));
        courses.add(new Course6354("0002", "高等数学", "1下", 2, 85));
        courses.add(new Course6354("B004", "计算机net", "1下", 4, 68));
        courses.add(new Course6354("B005", "计算机数组原理", "2上", 4, 78));
        return courses;
    }

    private static class Course6354 {
        private String no;//课程编号
        private String name;//课程名称
        private String term;//开课学期
        private int credit;//学分
        private int score;//成绩

        public Course6354() {
            super();
        }

        public Course6354(String no, String name, String term, int credit, int score) {
            super();
            this.no = no;
            this.name = name;
            this.term = term;
            this.credit = credit;
            this.score = score;
        }

        public String getNo() {
            return no;
        }

        public void setNo(String no) {
            this.no = no;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return String.format("%s %-15s %s,%d,%02d", no, name, term, credit, score);
        }

        public String getTerm() {
            return term;
        }

        public void setTerm(String term) {
            this.term = term;
        }

        public int getCredit() {
            return credit;
        }

        public void setCredit(int credit) {
            this.credit = credit;
        }

        public int getScore() {
            return score;
        }

        public void setScore(int score) {
            this.score = score;
        }

    }

}
