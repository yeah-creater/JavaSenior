package java6354.lessson13;


class TicketThread6354 extends Thread{
    private String threadName;
    private int tickets;

    public TicketThread6354(String threadName) {
        this.threadName = threadName;
    }

    @Override
    public void run() {
        while (tickets<100){
            tickets++;
            System.out.println(threadName+"窗口,已售"+tickets+"张票");
        }
        System.out.println(threadName+"窗口,票已售空");

    }
}
class TicketRunnable6354 implements Runnable{
    private int tickets;
    @Override
    public void run() {
        while (tickets<100){
            tickets++;
            System.out.println(Thread.currentThread().getName()+"窗口,已售"+tickets+"张票");
        }
        System.out.println(Thread.currentThread().getName()+"窗口,票已售空");
    }
}
/**
 * @author yeah
 */
public class ThreadAndRunnable6354 {
    static void saleByThread6354(){
        new TicketThread6354("叶本章1").start();
        new TicketThread6354("叶本章2").start();
        new TicketThread6354("叶本章3").start();
    }
    static void saleByRunnable6354(){
        TicketRunnable6354 ticketRunnable6354 = new TicketRunnable6354();
        new Thread(ticketRunnable6354, "叶本章1").start();
        new Thread(ticketRunnable6354, "叶本章2").start();
        new Thread(ticketRunnable6354, "叶本章3").start();

    }

    public static void main(String[] args) {
        //saleByThread6354();
        saleByRunnable6354();
    }

}
