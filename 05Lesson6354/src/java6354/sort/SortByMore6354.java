package java6354.sort;

import java6354.sort.Course6354;

import java.util.Comparator;

/**
 * @purpose:
 */
public class SortByMore6354 {
    public static int compare(Course6354 o1, Course6354 o2) {
        if(o1.equals(o2)) {
            return 0;
        }
        int t = o1.getTerm().compareTo(o2.getTerm());
        if (t != 0) {
            return t;
        }
        return o1.getCredit() - o2.getCredit()>=0?1:-1;
    }
}
