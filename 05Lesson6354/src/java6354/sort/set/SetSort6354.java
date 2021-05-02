package java6354.sort.set;

import java6354.sort.Course6354;

import java6354.sort.SortByCredit6354;
import java6354.sort.SortByMore6354;
import java6354.sort.getCourse6354;

import java.util.*;

public class SetSort6354 {
    static Set<Course6354> addSet() {
        return getCourse6354.getSet();
    }

    public static void main(String[] args) {
        System.out.println("======使用成绩降序======:");
        System.out.println(Arrays.toString(new TreeSet<Course6354>(addSet()).toArray()));
        System.out.println("======使用学期升序======:");
        TreeSet<Course6354> tree2 = new TreeSet<Course6354>(new Comparator<Course6354>() {
            @Override
            public int compare(Course6354 o1, Course6354 o2) {
                if (o1.equals(o2)) {
                    return 0;//重复的去重
                }
                return o1.getTerm().compareTo(o2.getTerm()) >= 0 ? 1 : -1;
            }
        });
        tree2.addAll(addSet());
        System.out.println(Arrays.toString(tree2.toArray()));
        System.out.println("======使用学分升序======");
        TreeSet<Course6354> tree3 = new TreeSet<>(new SortByCredit6354());
        tree3.addAll(addSet());
        System.out.println(Arrays.toString(tree3.toArray()));
        System.out.println("=====关键字排序（升序）=====");
        TreeSet<Course6354> tree4 = new TreeSet<>(SortByMore6354::compare);
        tree4.addAll(addSet());
        System.out.println(Arrays.toString(tree4.toArray()));

    }

}
