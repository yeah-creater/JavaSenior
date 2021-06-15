package java6354.lesson14;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.Objects;

/**
 * @author: yeah
 * 服务器
 * （1）创建ServerSocket对象，并绑定端口号
 * （2）调用accept()方法监听是否有客户端发送连接请求
 * （3）当接收到客户端的连接请求，建立连接后，得到与该客户端通信的Socket对象
 * （4）接收信息：从Socket对象的输入流中接收客户端传来的信息，显示在控制台上
 * （5）发送信息：通过Socket对象的输出流向客户端发送信息
 * 请按“工号：XXXXXXXX”的格式向客户端发送信息，其中XXXXXXXX用自己的学号和姓名替换
 * （6）关闭
 */
public class BaseServer6354 {
    public static void main(String[] args) {

        Socket client = null;
        ServerSocket server = null;
        OutputStream os = null;
        PrintWriter pw = null;
        InputStream is = null;
        try {
            //创建一个服务器
            server = new ServerSocket(23333);
//            while (true) {
            //获取客户端对象
            client = server.accept();
            //获取客户端的数据流对象
            is = client.getInputStream();
            //打印流 显示信息
            pw = new PrintWriter(new OutputStreamWriter(System.out));
            byte[] data = new byte[1024];
            int len = 0;
            System.out.println(LocalTime.now());
            while ((len = is.read(data)) != -1) {
                pw.write(new String(data, 0, len));
            }
            pw.flush();
            //服务器给客户端反馈
            os = client.getOutputStream();
            os.write("服务器:To->211906354叶本章\n 1+1=11".getBytes(StandardCharsets.UTF_8));
//            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (client != null) {
                    client.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
//            try {
//                if (server != null) {
//                    server.close();
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
            try {
                Objects.requireNonNull(os).close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (pw != null) {
                pw.close();
            }
            try {
                Objects.requireNonNull(is).close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
