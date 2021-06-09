package java6354.bank;


/**
 * @author yeah
 */
public class ThreadAndRunnable6354 {
    private int tickets = 20;
    private String flag = "窗口";
    private int idx = 0;

    public void sell() {
        while (true) {
            synchronized (this) {
                if (tickets <= 0) {
                    break;
                }
                String name = Thread.currentThread().getName();
                if (name.equals(flag + (idx % 3))) {
                    idx++;
                    this.notifyAll();
                    System.out.println(Thread.currentThread().getName() + "在售票, 还有" + --tickets + "张票");
                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        System.out.println(Thread.currentThread().getName() + "票已售空");
    }


    public static void main(String[] args) {
        ThreadAndRunnable6354 tr = new ThreadAndRunnable6354();
        new Thread(tr::sell, "窗口0").start();
        new Thread(tr::sell, "窗口1").start();
        new Thread(tr::sell, "窗口2").start();
    }

}
