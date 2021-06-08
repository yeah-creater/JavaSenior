package _01multiThreading.communicity;


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Yeah
 * @date 2021/1/16 - 15:44
 * @intention:
 * 涉及到的三个方法
 * wait():一且执行此方法,当前线程就进入阻塞状态,并释放同步监视器
 * notify():一旦执行此方法,就会唤醒被wait的一个线程。如果有多个线程wait,就唤醒优先级高的线程
 * notifyAll():一且执行此方法,就会唤醒所有被wait的线程。
 *
 * 说明:
 * 1.wat(), notify(), notifyALl()三个方法必须使用在同步代码块或同步方法中
 * 2.wait(), notify(), notifyAll()三个方法的调用者必须是同步代码块或同步方法中的同步监视器
 * 否则,会出现 LLegaLMonitorstateException异常
 *
 * 面试题: sLeep()和wait()的异同?
 * 1.相同点:一且执行方法,都可以使得当前的线程进入阻塞状态
 * 2.不同点:1)两个方法声明的位置不同: Thread类中声明 sLeep(),Object类中声明wait
 * 2)调用的要求不同: sLeep()可纵在在何需要的场景下调用。wait()必须使用在同步代
 * 3)关于是否释放同步监视器:1如果两个方法都使用在同步代码块或同步方法中, sLeep()不会释放锁
 *   wait会
 */
class Flag{
    static int flag=1;
    static final Flag lock=new Flag();
}
class Odd implements Runnable{
    @Override
    public void run() {
        for(int i=1;i<=100;){
            synchronized (Flag.lock){
                if(Flag.flag==1){
                    System.out.println(i);
                    Flag.flag=2;
                    Flag.lock.notifyAll();
                    i+=2;
                }
                else{
                    try {
                        //和sleep不一样，会把锁自动释放
                        Flag.lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        }
    }
}
class Even implements Runnable{
    @Override
    public void run() {
        for(int i=2;i<=100;){
            synchronized (Flag.lock){
                if(Flag.flag==2){
                    System.out.println(i);
                    Flag.flag=1;
                    Flag.lock.notifyAll();
                    i+=2;
                }
                else{
                    try {
                        Flag.lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

}
public class Test {
    public static void main(String[] args) {
        new Thread(new Even()).start();
        new Thread(new Odd()).start();
    }
}
