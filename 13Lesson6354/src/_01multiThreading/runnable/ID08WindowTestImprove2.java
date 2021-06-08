package _01multiThreading.runnable;

/**
 * @author Yeah
 * @date 2021/1/15 - 19:33
 * @intention:
 */
class Window3 implements Runnable{
    private int ticket=100;
    public synchronized void sell(){
            if (ticket > 0) {
                System.out.println(Thread.currentThread().getName() + ":" + ticket);
                ticket--;
            }
    }
    @Override
    public  void run() {
        while(ticket>0){
            sell();
        }

    }
}
public class ID08WindowTestImprove2 {
    public static void main(String[] args) {
        Window3 window3= new Window3();
        new Thread(window3).start();
        new Thread(window3).start();
        new Thread(window3).start();
    }
}
