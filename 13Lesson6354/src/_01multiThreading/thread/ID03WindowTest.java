package _01multiThreading.thread;


/**
 * @author Yeah
 * @date 2021/1/14 - 15:41
 * @intention:
 */
class Window extends Thread{
    private static int tickets=100;
    @Override
    public void run() {
        while(true){
            if(tickets>0){
                System.out.println("票号为"+tickets);
                tickets--;
            }
            else{
                break;
            }
        }
    }
}
public class ID03WindowTest {
    public static void main(String[] args) {
        Window t1 = new Window();
        Window t2 = new Window();
        Window t3 = new Window();
        t1.start();
        t2.start();
        t3.start();

    }
}
