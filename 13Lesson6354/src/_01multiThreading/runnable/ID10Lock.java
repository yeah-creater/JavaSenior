package _01multiThreading.runnable;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Yeah
 * @date 2021/1/16 - 15:21
 * @intention:
 * 3Lock(锁)
 * 从JDK50开始,Java提供了更强大的线程同步机制——一通过显式定义同
 * 步锁对象来实现同步。同步锁使用Lock对象充当
 * ●java. util. concurrent, locks.Lock接口是控制多个线程对共享资源进行访问的
 * 工具。锁提供了对共享资源的独占访问,每次只能有一个线程对Lock对象
 * 加锁,线程开始访问共享资源之前应先获得Lock对象。
 * ReentrantLock类实现了Lock,它拥有与 synchronized相同的并发性和
 * 内存语义,在实现线程安全的控制中,比较常用的是 ReentrantLock,可以
 * 显式加锁、释放锁
 *
 * 题: synchronized与Lock的异同?
 * 相同:二者都可以解决线程安全问题
 * 不同: synchronized机制在执行完相应的同步代码以后,自动的释放同步监视器
 * LOck需要手动的启动同步(Lock()),同时结束同步也需要手动的实现 unLock())
 */
class Window4 implements Runnable{
    int ticket=100;
    ReentrantLock lock=new ReentrantLock();
    @Override
    public void run() {
        while(true){
            lock.lock();
            if(ticket>0) {
                try {
                    Thread.sleep(100);
                    System.out.println(Thread.currentThread().getName() + ":" + ticket);
                    ticket--;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }
    }
}
public class ID10Lock {
    public static void main(String[] args) {
        Window4 window4=new Window4();
        new Thread(window4).start();
        new Thread(window4).start();


    }
}
