package java6354.sort;

import java6354.sort.Course6354;

import java.util.Comparator;


public class SortByCredit6354 implements Comparator<Course6354> {
    @Override
    public int compare(Course6354 o1, Course6354 o2) {
        if (o1.equals(o2)) {
            return 0;
        }
        return o1.getCredit() - o2.getCredit() >= 0 ? 1 : -1;
    }
}
