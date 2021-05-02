package java6354.lesson06;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
/**
 * @purpose:读取配置文件
 */
public class Profile6354 {
    public static void main(String[] args){
        Properties properties = new Properties();
        //InputStream stream = ClassLoader.getSystemClassLoader().getResourceAsStream("java6354/lesson06/MyProFile6354.properties");
        InputStream stream = Profile6354.class.getResourceAsStream("MyProFile6354.properties");
        //加载源文件
        try {
            properties.load(stream);
            System.out.println(((String) (properties.get("id"))).contains(" "));
            System.out.println("id:"+properties.get("id"));
            System.out.println("name:"+properties.get("name"));
            System.out.println("sex:"+properties.get("sex"));
            System.out.println("age:"+properties.get("age"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                stream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
