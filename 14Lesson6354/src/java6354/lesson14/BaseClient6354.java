package java6354.lesson14;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * @author: yeah
 * （1）按给定的IP和端口号向服务器端发送连接请求
 * （2）建立连接后，得到与该服务器端通信的Socket对象
 * （3）发送信息：通过Socket对象的输出流向服务器端发送信息
 * 在向服务器发送的请求信息中应包含自己的学号、姓名和问题
 * （4）接收信息：从Socket对象的输入流中接收服务器端传来的信息，显示在控制台上
 * （5）关闭
 */
public class BaseClient6354 {
    public static void main(String[] args) {
        Socket client = null;
        OutputStream os = null;
        InputStream is = null;
        try {
            //参数为服务器ip地址和端口号
            client = new Socket("localhost", 23333);
            //发送信息
            os = client.getOutputStream();
            os.write("客户端:211906354叶本章\n 1+1=?".getBytes(StandardCharsets.UTF_8));
            //关闭数据的输出,服务器端接收信息的循环才会停止
            client.shutdownOutput();
            //接收来自服务器的信息
            is = client.getInputStream();
            int len;
            byte[] data = new byte[1024];
            while ((len = is.read(data)) != -1) {
                System.out.println(new String(data, 0, len));
            }
            os.close();
            is.close();
            client.close();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
