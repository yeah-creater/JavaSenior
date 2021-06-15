package java6354.lesson14;

import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author: yeah
 * （1）客户端通过键盘输入的内容，发送的服务端。
 * （2）服务端接收到信息后将内容输出到控制台，并保存到文本文件
 * 【说明1】请用Scanner完成键盘输入
 * 【说明2】请将视频中的文本传输改用Scanner和打印输出流
 * 【说明3】请用打印输出流完成写文本文件。
 */
public class TextServer6354 {
    /**
     * （1）接收文本信息：用Scanner包装Socket对象的输入流，接收客户端传来的文本信息
     * （2）输出到控制台：一边接收客户端的文本信息，一边发送到控制台
     * （3）保存到文本文件：用打印输出流将接收到的文本信息，保存到当前项目data目录下的文本文件text6354.txt
     */
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(23333);
        Socket client = server.accept();
        InputStream is = client.getInputStream();
        Scanner in = new Scanner(is);
        PrintWriter pw = new PrintWriter("data/text6354.txt");
        while (in.hasNext()) {
            String data = in.next();
            System.out.println(data);
            pw.write(data);
        }
        pw.close();
        is.close();
        client.close();
        server.close();
    }
}
