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
        // 在控制台上输出向文件中写入的字节数
        System.out.println("文件大小为" + write6354(filename) + "B");
    }

    private static long write6354(String filename) {
        //【注意】请使用try…catch…finally进行异常处理，并释放资源
        // 步骤1：确定输出的文件（目的地）
        File file = new File(filename);
        // 如果filename中包含路径，必须确保路径已存在
        if (filename.contains("\\")) {
            if (!file.getParentFile().exists()) {
                if (!file.getParentFile().mkdirs()) {
                    System.out.println("路径不存在");
                    return -1;
                }
            }
        }
        FileWriter fw = null;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("请逐行输入数据，以end结束");
            // 步骤2：创建指向文件的字符输出流
            fw = new FileWriter(file, false);
            String data;
            // 步骤3：写数据
            while (!"end".equalsIgnoreCase(data = br.readLine())) {
                // 输入一行写一行
                fw.write(data);
                fw.append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 步骤4：关闭
            if (fw != null) {
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        // 返回文件的字节数
        return file.length();
    }

}
