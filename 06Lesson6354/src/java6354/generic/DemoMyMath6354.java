package java6354.generic;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDate;
import java.util.ArrayList;

/**
 * @purpose: 使用泛型类MyMathXXXX
 */

public class DemoMyMath6354 {
    public static void main(String[] args) {
        MyMath6354<String> string = new MyMath6354<>("java","c++");
        System.out.println("大者:"+string.max6354());
        System.out.println("小者:"+string.min6354());
        MyMath6354<Character> character = new MyMath6354<>('V','C');
        System.out.println("大者:"+character.max6354());
        System.out.println("小者:"+character.min6354());
        MyMath6354<Integer> integer= new MyMath6354<>(Integer.MAX_VALUE,Integer.MIN_VALUE);
        System.out.println("大者:"+integer.max6354());
        System.out.println("小者:"+integer.min6354());
            //编译未通过，因为LocalDate类未实现可比较接口 LocalDate中比较日期都是通过年月日的比较
        MyMath6354<LocalDate> localDate= new MyMath6354<>(LocalDate.now(), LocalDate.of(2000,1,1));
        System.out.println("大者:"+localDate.max6354());
        System.out.println("小者:"+localDate.min6354());

    }
}
