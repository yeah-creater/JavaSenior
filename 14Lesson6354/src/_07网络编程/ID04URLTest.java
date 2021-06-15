package _07网络编程;

import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * @author Yeah
 * @date 2021/2/2 - 19:42
 * @intention:
 */
public class ID04URLTest {
    public static void main(String[] args) throws Exception {
        URL url = new URL("https://www.baidu.com");
        URLConnection conn = url.openConnection();
        OutputStream outputStream = conn.getOutputStream();
        System.out.println(url.getProtocol());
        System.out.println(url.getPath());
    }
}
