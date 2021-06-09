package java6354.lessson13;

public class BankAccount6354 {
    private String BankID;
    private double balance;

    public BankAccount6354(String bankID, double balance) {
        BankID = bankID;
        this.balance = balance;
    }

    public BankAccount6354(String bankID) {
        BankID = bankID;


    }

    public String getBankID() {
        return BankID;
    }

    public void setBankID(String bankID) {
        BankID = bankID;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
