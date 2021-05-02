package java6354.generic;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @purpose: 统计字符串中每个字符出现的次数
 */
public class Count6354 {
    static TreeMap<Character,Integer> count6354(String str){
        TreeMap<Character,Integer> map=new TreeMap<>();
        for(int i=0;i<str.length();i++){
            char key = str.charAt(i);
            map.merge(key,1,Integer::sum);
        }
        return map;
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        TreeMap<Character, Integer> map = count6354(str);
        Set<Map.Entry<Character, Integer>> entrySet = map.entrySet();
        //将Map转为List< Entry>
        ArrayList<Map.Entry<Character, Integer>> list = new ArrayList<>(entrySet);
        //采用比较器排序法对List< Entry>排序
        list.sort(new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                if (!o1.getValue().equals(o2.getValue())) {
                    return o2.getValue() - o1.getValue();
                }
                return o1.getKey() - o2.getKey();
            }
        });
        System.out.println(Arrays.toString(list.toArray()));

    }
}
