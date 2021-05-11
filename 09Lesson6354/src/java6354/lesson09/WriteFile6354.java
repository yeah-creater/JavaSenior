package java6354.lesson09;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.time.LocalDateTime;
import java.util.Scanner;

/**
 * @author yeah
 */
public class WriteFile6354 {

  public static void main(String[] args)  {
    Scanner input = new Scanner(System.in);
    System.out.print("请输入文件名：");
    String filename = input.nextLine();
    // 调用writeXXXX()向文件中输出字符串，并返回字节数
    // 在控制台上输出向文件中写入的字节数
  }

  private static long writeXXXX(String filename)  {
    //【注意】请使用try…catch…finally进行异常处理，并释放资源
    // 步骤1：确定输出的文件（目的地）
    // 如果filename中包含路径，必须确保路径已存在
    // 步骤2：创建指向文件的字符输出流
    // 步骤3：写数据
    // 输入一行写一行
    // 步骤4：关闭
    // 返回文件的字节数
    return 0;
  }

}
