package java6354.bank;


/**
 * @author: yeah
 */
public class DrinkWater6354 {
    private static DrinkWater6354 lock = new DrinkWater6354();
    private static int waters = (int) 30L;
    private static String flag = "狗";

    public static void drinking6354() {
        while (true) {
            synchronized (lock) {
                if (waters <= 0) {
                    break;
                }
                String name = Thread.currentThread().getName();
                if (name.equals(flag)) {
                    lock.notifyAll();
                    flag = flag.equals("狗") ? "猫" : "狗";
                    if ("狗".equals(name) && waters < 5) {
                        System.out.println("狗狗水不够了");
                        break;
                    }
                    if ("猫".equals(name) && waters < 2) {
                        System.out.println("猫猫水不够了");
                        break;
                    }
                    waters -= name.equals("狗") ? 5 : 2;
                    System.out.println(name + "在喝水, " + "还有" + waters + "L水");
                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }


    public static void main(String[] args) {
        Thread dog = new Thread(DrinkWater6354::drinking6354, "狗");
        Thread cat = new Thread(DrinkWater6354::drinking6354, "猫");
        dog.start();
        cat.start();

    }
}
