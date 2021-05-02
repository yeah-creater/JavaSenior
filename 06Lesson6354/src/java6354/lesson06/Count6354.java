package java6354.lesson06;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.TreeMap;
/**
 * @purpose: 统计字符串中每个字符出现的次数
 */
public class Count6354 {
    static TreeMap<Character,Integer> count6354(String str){
        TreeMap<Character,Integer> map=new TreeMap<>();
        for(int i=0;i<str.length();i++){
            char key = str.charAt(i);
            if(map.containsKey(key)){
                map.put(key,map.get(key)+1);
            }
            else {
                map.put(key,1);
            }
        }
        return map;
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        TreeMap<Character, Integer> map = count6354(str);
        Set<Character> keySet = map.keySet();
        for(Character ch:keySet){
            System.out.println(ch+":"+map.get(ch));
        }
    }
}
