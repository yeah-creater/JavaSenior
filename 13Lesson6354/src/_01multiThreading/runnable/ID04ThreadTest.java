package _01multiThreading.runnable;

/**
 * @author Yeah
 * @date 2021/1/14 - 15:57
 * @intention:创建多线程的方式二:实现 Runnable按口
 * 1.创建一个实现了 Runnable按口的类
 * 2.实现类去实现 Runnable中的象方法:run()
 * 3.创建实现类的对象
 * 4.将此对象作为参数传道到 Thread类的构造器中,创建 Thread类的对象
 * 5.通过 Thread类的对象用 start()
 */
class SubThread implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(i);
        }
    }
}
public class ID04ThreadTest {
    public static void main(String[] args) {
        Thread t1 = new Thread(new SubThread());
        t1.start();
    }
}
