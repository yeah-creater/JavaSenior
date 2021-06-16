package java6354.lesson14;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author: yeah
 */
public class OneClient6354 {
    /**
     * （1）从配置文件中读取服务端的IP和端口号
     * （2）按给定的IP和端口号向服务器端发送连接请求
     * （3）建立连接后，立即接收服务平台发来的欢迎用语，显示在控制台上
     * （4）从键盘输入问题，并发送给服务平台
     * （5）接收并显示服务平台给出的答案
     * （6）重复（4）、（5），直到输入谢谢，停止会话（【思考】如何设置结束条件？）
     * （7）关闭
     */
    public static void main(String[] args) throws Exception {
        String ip = "localhost";
        int port = 23333;
        Socket client = new Socket(ip, port);
        System.out.println("客户端");
        System.out.println("连接" + ip + " " + port);
        //服务端发来的消息
        InputStream is = client.getInputStream();
        Scanner iss = new Scanner(is);
//        System.out.println(iss.nextLine());
        //发给服务端消息
        OutputStream os = client.getOutputStream();
        PrintStream ps = new PrintStream(os);
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.println("请输入问题");
            String pro = in.nextLine();
            ps.println(pro);

            if ("谢谢".equals(pro.trim())) {
                break;
            }
            System.out.println(iss.nextLine());
        }

    }
}
