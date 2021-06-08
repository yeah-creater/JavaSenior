package _01multiThreading.runnable;



/**
 * @author Yeah
 * @date 2021/1/15 - 15:53
 * @intention:
 * 1.问题:卖票过程中,出现了重票、错票-->出现了线程的安全问题
 * 2.问题出现的原因:当某个线程架作车票的过程中,尚未操作完成时,其他线程参与进来,也操作车票
 * 3.如何解决:当一个线程在操作ticket的时候,其他线程不能参与进来。直到线和a操作完 ticket时
 *   线程才可纵开始操作ticket,这种情况即使线程出现了阻塞,也不能被改变
 * 4.在ava中,我们通过同步机制,来解决线程的安全问题。
 *  方式一:同步代码块
 *     synchronized(同步监视器){
 *     需要被同步的代码
 *  }
 *  说明:1.粲作共享数据的代码,即为商要被同步的代码
 *      2.共享数据:多个线程共同操作的变量。比如: ticket就是共享数据。
 *      3.同步监视器,俗称:锁。任何一个类的对象,都可以充当锁。
 *      要求:多个线程必须要共用同一把锁。
 *
 *   方式二:同步方法
 *     如果操作共享数据的代码完整的声明在一个方法中,我们不妨将此方法声明同步的
 *     关于同步方法的总结:
 *      1.同步方法仍然涉及到同步监视器,只是不需要我们显式的声明
 *      2.非静态的同步方法,同步监视器是:this
 *      静态的同步方法,同步监视器是:当前类本身
 *
 *
 * 5.同步的方式,解决了线程的安全问题
 * 操作同步代码时,只能有一个线程参与,其他线程等待。相当于是一个单线程的过程,效率低-->局部性
 */
class Window2 implements Runnable{
    private int tickets=100;
    Object obj=new Object();
    @Override
    public void run() {
        while(true) {
            synchronized (obj) {
                if (tickets > 0) {
                    System.out.println(Thread.currentThread().getName() + ":" + tickets);
                    tickets--;
                } else {
                    break;
                }
            }
        }
    }
}
public class ID07WindowTestImprove {
    public static void main(String[] args) {
        Window2 window2= new Window2();
        new Thread(window2).start();
        new Thread(window2).start();
        new Thread(window2).start();
    }
}
