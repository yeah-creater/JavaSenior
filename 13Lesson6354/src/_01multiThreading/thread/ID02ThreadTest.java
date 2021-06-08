package _01multiThreading.thread;

/**
 * @author Yeah
 * @date 2021/1/14 - 14:27
 * @intention: 多线程的第一种创建方法->继承Thread类
 *            1.继承
 *            2.重写run方法->此线程要执行的操作
 *            3.创建对象
 *            4.调用start方法
 *
 * 1. start():启动当前线程;调用当前线程的run(
 * 2.run():通常要重写 Thread类中的此方法,将创建的线程要执行的操作声在此方法中
 * 3. currentThread():静态方法,返回执行当前代码的线程
 * 4. getName():获取当前线程的名字
 * 5. setName():设置当前线程的名字
 * 6.yield():释放当前cpu的执行权
 * 7.join():在线程a中调用线程b的join(),此时线程a就进入阻塞状态,直到线程b完全执行完以后,线程a才结束阻塞状态
 * 8.stop():已过时。当执行此方法时,强制结束当前线程
 * 9.sleep( Long millonitime):让当前线程联”指定 millitime毫秒。在指定 imillitime毫秒时间内,当前线程是阻塞状态
 * 10. isAlive():判断当前线程是否存活
 */
class SubThread1 extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            if(i%2==0){
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
            if(i%10==0){
                yield();//主动释放cpu执行权
            }
        }
    }
}
class SubThread2 extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            if(i%2==1){
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
        }
    }
}
public class ID02ThreadTest {
    public static void main(String[] args) {
        //启动当前线程，调用该对象的run方法
        SubThread1 t1 = new SubThread1();
        SubThread2 t2 = new SubThread2();
        t1.setPriority(Thread.MAX_PRIORITY);
        t2.setPriority(8);
        t1.start();
        t2.start();
        for (int i = 0; i < 10000; i++) {
            System.out.println("hello");
        }
        System.out.println(t1.isAlive());

    }
}
