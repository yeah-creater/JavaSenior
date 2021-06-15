package java6354.lesson14;

import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author: yeah
 */
public class TextClient6354 {
    /**
     * （1）使用Scanner从键盘输入文本
     * （2）发送文本信息：用打印输出流包装Socket对象的输出流，将键盘输入的文本发送
     */
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        String data = in.nextLine();
        Socket client = new Socket("localhost", 23333);
        OutputStream os = client.getOutputStream();
        PrintWriter pw = new PrintWriter(os);
        pw.write(data);
        pw.close();
        os.close();
        in.close();
        client.close();

    }
}
