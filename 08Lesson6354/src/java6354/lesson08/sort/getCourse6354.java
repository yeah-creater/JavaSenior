package java6354.lesson08.sort;



import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author yeah
 */
public class getCourse6354 {
    public static List<Course6354> getList() {
        ArrayList<Course6354> list = new ArrayList<>();
        list.add(new Course6354("zs", "2下", "B001 操作系统", 3, 90));
        list.add(new Course6354("ls", "1下", "B002 软件工程", 2, 60));
        list.add(new Course6354("ww", "3下", "B003 算法与数据结构", 4, 60));
        list.add(new Course6354("zl", "2上", "A001 离散数学", 2, 78));
        list.add(new Course6354("lb", "3下", "C001 数据库原理", 1, 78));
        list.add(new Course6354("wj", "2上", "A002 Java高级", 2, 90));
        list.add(new Course6354("stt", "2下", "A005 人工智能", 4, 78));
        list.add(new Course6354("loo", "1上", "C001 高等数学", 2, 58));
        list.add(new Course6354("zs", "2下", "B001 操作系统", 3, 90));
        return list;
    }

    public static Set<Course6354> getSet() {
        Set<Course6354> set = new TreeSet<>();
        set.add(new Course6354("zs", "2下", "B001 操作系统", 3, 90));
        set.add(new Course6354("zs", "2下", "B001 操作系统", 3, 90));
        set.add(new Course6354("ls", "1下", "B002 软件工程", 2, 60));
        set.add(new Course6354("ww", "3下", "B003 算法与数据结构", 4, 60));
        set.add(new Course6354("zl", "2上", "A001 离散数学", 2, 78));
        set.add(new Course6354("lb", "3下", "C001 数据库原理", 1, 78));
        set.add(new Course6354("wj", "2上", "A002 Java高级", 2, 90));
        set.add(new Course6354("stt", "2下", "A005 人工智能", 4, 78));
        set.add(new Course6354("loo", "1上", "C001 高等数学", 2, 58));
        return set;
    }
}
