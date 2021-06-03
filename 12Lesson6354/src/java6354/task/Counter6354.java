package java6354.task;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author yeah
 */
public class Counter6354 {
    /**
     * （1）从键盘输入字符串
     * （2）用Stream API统计每个字符出现的次数
     * （3）按要求输出统计结果：①首先按字符出现次数降序②次数相同时按字母序升序
     */
    public static void main(String[] args) {
        System.out.println("请输入以空格结束的字符串:");
        Scanner in = new Scanner(System.in);
        String str = in.next();
        Stream<String> stringStream = Stream.of(str.split(""));

        Map<String, List<String>> map = stringStream.collect(Collectors.groupingBy(String::toString));
        map.keySet().stream().sorted(Comparator.comparingInt(s -> map.get(s).size()).reversed().
                thenComparing(Object::toString)).forEach(s -> {
            System.out.println(s + ":" + map.get(s).size());
        });

    }
}
