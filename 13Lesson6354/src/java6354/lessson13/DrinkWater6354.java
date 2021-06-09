package java6354.lessson13;

/**
 * @author: yeah
 */
public class DrinkWater6354 {
    private static int waters = (int) 100L;


    public static void drinking6354() {
        while (waters > 0) {
            String name = Thread.currentThread().getName();
            if ("狗".equals(name)) {
                if (waters >= 5) {
                    waters -= 5;
                    System.out.println("狗狗喝水,还剩" + waters + "L水");
                } else if (waters < 2) {
                    break;
                }
            } else if ("猫".equals(name)) {
                if (waters >= 2) {
                    waters -= 2;
                    System.out.println("猫猫喝水,还剩" + waters + "L水");
                } else {
                    break;
                }
            }
        }
        System.out.println("水不够了,hhh");
    }


    public static void main(String[] args) {
        Thread dog = new Thread(DrinkWater6354::drinking6354, "狗");
        Thread cat = new Thread(DrinkWater6354::drinking6354, "猫");
        dog.start();
        cat.start();


    }
}
