package java6354.lesson12;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: yeah
 */
public class SimpleStream6354 {
    static final int N = 10000010;
    static int[] prime = new int[N];
    static boolean[] st = new boolean[N];
    static int cnt;
    static long time1, time2;

    //线性筛质数
    static {
        st[1] = true;
        st[0] = true;
        for (int i = 2; i < N; i++) {
            if (!st[i]) {
                prime[cnt++] = i;
            }

            for (int j = 0; i * prime[j] < N; j++) {
                st[prime[j] * i] = true;
                if (i % prime[j] == 0) {
                    break;
                }
            }

        }
    }

    static boolean isPrime(int x) {
        if (x <= 1) {
            return false;
        }
        for (int i = 2; i <= x / i; i++) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }

    static List<Integer> getRandomNumbers(int beg, int end, int cnt) {
        List<Integer> res = new ArrayList<>();
        while (cnt-- > 0) {
            res.add((int) ((Math.random()) * (end + 1) + beg));
        }
        return res;
    }


    static void outputAndGetSum(List<Integer> numbers) {
        time1 = System.currentTimeMillis();

        int sum = numbers.stream().filter(x->!st[x]).mapToInt(x -> {
            System.out.print(x + " ");
            return x;
        }).sum();

        System.out.println("=" + sum);

    }

    public static void main(String[] args) {

        outputAndGetSum(getRandomNumbers(0, 600, 400));
        time2 = System.currentTimeMillis();
        System.out.println((time2 - time1) + "ms");
    }
}
