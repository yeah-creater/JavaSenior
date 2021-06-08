package _01multiThreading.runnable;

/**
 * @author Yeah
 * @date 2021/1/14 - 16:14
 * @intention:
 */
class Window implements Runnable{
    private int tickets=100;
    @Override
    public void run() {
        while(true) {
            if(tickets>0) {
                System.out.println(Thread.currentThread().getName() + ":" + tickets);
                tickets--;
            }
            else{
                break;
            }
        }
    }
}
public class ID05WindowTest {
    public static void main(String[] args) {
        Window window = new Window();
        new Thread(window).start();
        new Thread(window).start();
        new Thread(window).start();

    }
}
