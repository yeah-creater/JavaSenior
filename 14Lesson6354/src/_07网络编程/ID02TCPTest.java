package _07网络编程;

import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Yeah
 * @date 2021/2/2 - 18:05
 * @intention:
 * 实现TCP的网络编程
 * 客户端发送信息给服务端，服务端保存文件，并且传给客户端保存成功
 */
public class ID02TCPTest {
    @Test
    public void client() throws Exception{
        //参数为服务器ip地址和端口号
        Socket client = new Socket(InetAddress.getByName("localhost"),23333);
        OutputStream os = client.getOutputStream();
        os.write("Hello".getBytes());
        //关闭数据的输出,服务器端接收信息的循环才会停止
        client.shutdownOutput();
        //获取服务器发来的信息
        InputStream is = client.getInputStream();
        int len;
        byte[]data=new byte[1024];
        while ((len=is.read(data))!=-1){
            System.out.println(new String(data,0,len));
        }
        os.close();
        is.close();
        client.close();
    }
    @Test
    public void server () throws Exception{
        //创建一个服务器
        ServerSocket server = new ServerSocket(23333);
        //获取客户端对象
        Socket client = server.accept();
        //获取客户端的数据流对象
        InputStream is = client.getInputStream();
        //保存
        FileOutputStream fos = new FileOutputStream(new File("网络编程.txt"));
        int len;
        byte[]data=new byte[1024];
        while ((len=is.read(data))!=-1){
            fos.write(data,0,len);
        }
        System.out.println("信息接收完毕");
        //服务器给客户端反馈
        OutputStream os = client.getOutputStream();
        os.write("Get it".getBytes());
        server.close();
        client.close();
        is.close();
        fos.close();
        os.close();
    }

}
