package java6354.lesson05;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * @purpose: 不重复的随机数(HashSet)
 */
public class HashSetRandom6354 {
    /**
     *
     * @param count 随机产生整数的数量
     * @param min   随机产生的数的最小值
     * @param max   随机产生的数的最大值
     * @return      无重复数的集合
     */
    static Set<Integer> getRandomNumberSet(int count,int min,int max){
        if(count<0) {
            throw new IllegalArgumentException("Count should not be Negative Integer");
        }
        if(min>max) {
            throw new IllegalArgumentException("Min should not greater than Max");
        }
        Random random=new Random();
        HashSet<Integer> set=new HashSet<>();
        for(int i=0;i<count;){
            int x=random.nextInt(max-min+1)+min;
            if(set.add(x)) {
                i++;
            }
        }
        return set;
    }
    static <E>void showSet(Set<E> set){
        for(E e:set) {
            System.out.print(e+" ");
        }
    }
    public static void main(String[] args) {
        Set<Integer> set = getRandomNumberSet(10, 50, 80);
        showSet(set);
    }
}
