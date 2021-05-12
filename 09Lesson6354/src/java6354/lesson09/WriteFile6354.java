package java6354.lesson09;

import java.io.*;
import java.time.LocalDateTime;
import java.util.Scanner;
import java.util.zip.InflaterInputStream;

/**
 * @author yeah
 */
public class WriteFile6354 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("请输入文件名：");
        String filename = input.nextLine();
        // 调用writeXXXX()向文件中输出字符串，并返回字节数
        System.out.println("请逐行输入数据，以end结束");
        // 在控制台上输出向文件中写入的字节数
    }

    private static long write6354(String filename) {
        //【注意】请使用try…catch…finally进行异常处理，并释放资源
        // 步骤1：确定输出的文件（目的地）
        File file = new File(filename);
        // 如果filename中包含路径，必须确保路径已存在
        if (!file.exists()) {
            System.out.println("当前路径不存在");
            return 0;
        }

        FileWriter fw = null;
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        try {
            // 步骤2：创建指向文件的字符输出流
            fw = new FileWriter(file, false);
            // 步骤3：写数据
            br.readLine();
            // 输入一行写一行
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 步骤4：关闭
            if(fw!=null) {
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            // 返回文件的字节数
            return file.length();
        }
    }

}
