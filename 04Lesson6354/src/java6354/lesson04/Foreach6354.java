package java6354.lesson04;
import java.lang.reflect.Array;
import java.util.*;
/**
 * @purpose:练习遍历集合的多种方法
 */
//创建StudentXXXX类
class Student6354 {
    private String name;
    private int age;
    public Student6354(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public Student6354() {
    }
    @Override
    public String toString() {
        return name + ":" + age;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
}

public class Foreach6354 {
    //在ForeachXXXX类中添加useIteratorXXXX方法
    public static <E> void useIterator6354(Collection<E> students) {
        Iterator<E> studentIterator = students.iterator();
        System.out.println("=====用集合的迭代器遍历输出=====");
        while (studentIterator.hasNext()) {
            E student = studentIterator.next();
            System.out.println(student);
        }
    }

    //在ForeachXXXX类中添加useForeachXXXX方法：
    public static <E> void useForeach6354(Collection<E> students) {
        System.out.println("=====用增强for遍历输出=====");
        for (E e : students) {
            System.out.println(e);
        }
    }

    //在ForeachXXXX类中添加useListXXXX方法：
    public static <E> void useList6354(List<E> eList) {
        System.out.println("=====按序号遍历输出=====");
        for (int i = 0; i < eList.size(); i++) {
            System.out.println("No" + i + ":" + eList.get(i));
        }
    }

    //在ForeachXXXX类中添加useArrayXXXX方法：
    public static <E> void useArray6354(Collection<E> eCollection, Class<E> eClass) {
        @SuppressWarnings("unchecked")//Unchecked cast: 'java.lang.Object' to 'E[]'
        E[] e = (E[]) Array.newInstance(eClass, eCollection.size());//创建和输入类型相同的数组
        e = eCollection.toArray(e);

        System.out.println("======通过数组遍历输出=====");
        for (int i = 0; i < e.length; i++) {
            System.out.println(e[i]);
        }
    }

    public static void main(String[] args) {
        Student6354[] students = {
                new Student6354("贾宝玉", 16),
                new Student6354("林黛玉", 15),
                new Student6354("许文强", 28),
                new Student6354("冯程程", 20),
                new Student6354("楚留香", 25),
                new Student6354("苏蓉蓉", 22),
        };
        List<Student6354> studentList = Arrays.asList(students);

        useIterator6354(studentList);
        useList6354(studentList);
        useArray6354(studentList, Student6354.class);
        useForeach6354(studentList);
    }

}
