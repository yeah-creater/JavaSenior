package java6354.lessson13;

/**
 * @author yeah
 */
public class BankSynchronized6354 {
    private final BankAccount6354 count;

    public BankSynchronized6354(BankAccount6354 count) {
        this.count = count;
    }

    public void bank6354() {
        String name = Thread.currentThread().getName();
        double money = 0, balance = 0;
        String action = "";
        if (name.equals("会计")) {
            money = 300;
            action = "存入";
        } else if (name.equals("出纳")) {
            money = -100;
            action = "取出";
        }
        synchronized (this) {
            for (int i = 0; i < 3; i++) {
                balance = count.getBalance() + money;
                if(balance<0){
                    System.out.println("账户余额不足");
                    balance = count.getBalance() - money;
                    continue;
                }
                count.setBalance(balance);
                System.out.println(name + action + Math.abs(money));
                System.out.println(count.getBankID() + "账户余额" + count.getBalance());
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    public static void main(String[] args) {
        BankSynchronized6354 bs = new BankSynchronized6354(new BankAccount6354("211906354", 100));
        new Thread(bs::bank6354,"出纳").start();
        new Thread(bs::bank6354,"会计").start();


    }
}
