package _01multiThreading.runnable;

import javax.sound.midi.Soundbank;
import java.sql.SQLOutput;
import java.util.zip.CheckedOutputStream;

/**
 * @author Yeah
 * @date 2021/1/16 - 14:24
 * @intention:
 *
 * ●死锁
 * 不同的线程分别占用对方需要的同步资源不放弃,都在等待对方放弃
 * 自己需要的同步资源,就形成了线程的死锁I
 * 出现死锁后,不会出现异常,不会出现提示,只是所有的线程都处于
 * 阻塞状态,无法继续
 * ●解决方法
 * 专门的算法、原则
 * 尽量减少同步资源的定义
 * 尽量避免嵌套同步
 */
public class ID09DeadLock {
    public static void main(String[] args) {
       StringBuilder sb1=new StringBuilder();
       StringBuilder sb2=new StringBuilder();
       new Thread(){
           @Override
           public void run() {
               synchronized (sb1){
                   sb1.append("a");
                   System.out.println(sb1);
                   try {
                       Thread.sleep(1000);
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
                   synchronized (sb2){
                       sb2.append("b");
                       System.out.println(sb2);
                   }

               }
           }
       }.start();
       new Thread(new Runnable() {
           @Override
           public void run() {
               synchronized (sb2){
                   sb1.append("a2");
                   System.out.println(sb1);
                   try {
                       Thread.sleep(100);
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
                   synchronized (sb1){
                       sb2.append("b2");
                       System.out.println(sb2);

                   }
               }
           }
       }).start();

    }


}
