package java6354.generic;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @purpose:Map集合的两种遍历方法
 */
public class MapForeach6354 {
    static void print6354(Map<String,String> map,Set<String> keys){
        for(String s:keys){
            System.out.println(s+":"+map.get(s));
        }
    }
    static void print6354(Set<Map.Entry<String,String>> entries,HashMap<String,String> map){
        Iterator<Map.Entry<String, String>> iterator = entries.iterator();
        while (iterator.hasNext()){
            Map.Entry<String, String> entry = iterator.next();
            System.out.println(entry.getKey()+":"+entry.getValue());
        }

    }
    public static void main(String[] args) {
        HashMap<String,String> map=new HashMap<>();
        map.put("1","zs");
        map.put("2","ls");
        map.put("1","ww");
        map.put("4","zl");
        map.put("a","2");
        map.remove("a");
        Set<String> keys = map.keySet();
        Set<Map.Entry<String, String>> entries = map.entrySet();
        print6354(map,keys);
        print6354(entries,map);
    }
}
