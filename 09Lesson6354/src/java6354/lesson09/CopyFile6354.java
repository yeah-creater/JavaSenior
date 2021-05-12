package java6354.lesson09;

import java.io.*;
import java.util.Scanner;

/**
 * @author yeah
 */
public class CopyFile6354 {
    public static void main(String[] args)  {
        Scanner input = new Scanner(System.in);
        System.out.print("请输入要拷贝的源文件名：");
        String source = input.nextLine();
        System.out.print("请输入目标文件名：");
        String target = input.nextLine();
        //调用checkFileXXXX()方法检查两个文件名是否可用
        //如果两个文件名可用，调用copyXXXX()方法完成文件拷贝，并返回文件的字节数
        if (checkFile6354(source, target)) {
            //调用System.currentTimeMillis()记下开始时间-->beginTime
            long beginTime = System.currentTimeMillis();
            long size = copy6354(source, target);
            //调用System.currentTimeMillis()得到当前时间，计算拷贝文件所用的时长
            long endTime = System.currentTimeMillis();
            long cost = endTime - beginTime;
            //输出拷贝文件的字节数和用时
            System.out.println("拷贝" + size + "字节文件");
            System.out.println("用时" + cost + "ms");
            return;
        }
        System.out.println("检查源文件是否存在或目标地址是否合法");

    }

    private static boolean checkFile6354(String sourceName, String targetName) {
        //确保源文件已经存在
        if (!new File(sourceName).exists()) {
            return false;
        }
        //调用File的getParentFile()，得到目标文件名所包含的路径
        File file = new File(targetName);
        if (!file.exists()) {
            if (!file.getParentFile().exists()) {
                if (!file.getParentFile().mkdirs()) {
                    return false;
                }
            }
        }
        //判断目标路径是否已经存在，如果不存在，创建
        return true;

    }

    private static long copy6354(String sourceName, String targetName) {
        try ( //针对源文件，创建带缓冲的输入流
              BufferedInputStream bis = new BufferedInputStream(new FileInputStream(sourceName));
              //针对目标文件，创建带缓冲的输出流
              BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(targetName))) {

            // 定义一个字节数组，作为缓冲区-->buff
            byte[] buff = new byte[1024];
            //循环执行下列步骤，直到文件结束
            int len = 0, size = 0;
            //1）从输入流中读取数据存入buff
            while ((len = bis.read(buff)) != -1) {
                //2）再把buff中的内容写入到输出流
                bos.write(buff, 0, len);
                //3）累加读到的字节数-->size
                size += len;
            }
            return size;
        } catch (IOException e) {
            e.printStackTrace();
        }

      return -1;
    }


}