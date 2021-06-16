package java6354.lesson14;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * @author: yeah
 * （1）当有客户向服务平台发送请求时，服务平台首先回应一句欢迎用语。
 * （2）客户通过键盘输入问题向服务平台提问
 * （3）服务平台根据问题给出答案（从键盘输入答案）
 * （4）重复（2）、（3），直到客户端发出谢谢后，服务端返回再见，会话结束
 */
public class OneServer6354 {
    /**
     * （1）创建ServerSocket对象，并绑定端口号，如18888
     * （2）调用accept()方法监听是否有客户端发送连接请求
     * （3）当接收到客户端的连接请求，在控制台上显示客户端IP地址和端口号
     * （4）首先向客户端发送一句欢迎用语
     * （5）接收客户端发来的问题，并显示在控制台上
     * （6）从键盘输入答案，并把答案发送给客户端
     * （7）重复（5）和（6），当接收到客户端的”谢谢”后，发送”再见”结束会话
     * （8）关闭
     * 【提示1】客户端IP地址：socket.getInetAddress().getHostAddress()
     * 【提示2】客户端端口号：socket.getPort()
     */
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(23333);
        Socket client = server.accept();
        OutputStream os = client.getOutputStream();
        PrintStream ps = new PrintStream(os);
        InputStream is = client.getInputStream();
        Scanner in = new Scanner(System.in);
        Scanner iss = new Scanner(is);
//        pw.write((server.getLocalPort()+"服务平台"));

        System.out.println(client.getInetAddress().getHostAddress() + ":" + client.getPort());
        while (true) {
            String pro = iss.nextLine();
            if ("谢谢".equals(pro)) {
                break;
            }
            System.out.println("问题：" + pro);
            String ans = in.nextLine();
            ps.println(ans);
        }

    }
}
