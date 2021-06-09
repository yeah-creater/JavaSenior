package java6354.bank;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * （1）输入银行帐户的基本信息
 * （2）在左边的文本域中输入多笔存、取款的金额（每行一笔，负数表示取款）
 * （3）单击Start按钮，模拟多线程完成存取款的操作（每个线程只完成一笔存或取款的操作），
 * 并按要求将处理存取款的信息显示在右边的文本域中
 * （4）取款时，需要判断帐户的余额是否充足，如果余额不足，取款失败。
 * （5）存取款全部处理结束后，显示账户的最终余额
 */

public class Bank6354Controller {

    @FXML
    private TextField tfBankID;

    @FXML
    private TextField tfBalance0;

    @FXML
    private Label lblErrMsg;

    @FXML
    private TextArea taMoney;

    @FXML
    private Label lblBalance;

    @FXML
    private TextArea taResult;
    @FXML
    private int balance;

    @FXML
    public void alertTips(String warning) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("多线程同步");
        alert.setHeaderText("Attention!");
        alert.setContentText(warning);
        alert.show();
    }

    @FXML
    List<String> getDeposit() {
        List<String> result = new ArrayList<>();
        String[] deposits = taMoney.getText().split("\n");
        Arrays.stream(deposits).filter(this::check2).forEach(result::add);
        return result;
    }

    @FXML
    boolean check1() {
        String initBalance = tfBalance0.getText().trim();
        String regex = "[+]?\\d+|[-]?0+";
        if (!initBalance.matches(regex)) {
            alertTips("初始余额为空或格式错误");
            return false;
        }
        balance = Integer.parseInt(initBalance.replaceAll("[+]|[-]", ""));
        return true;
    }

    @FXML
    boolean check2(String deposit) {
        String regex = "[+|-]?\\d+";
        return deposit.matches(regex);
    }

    @FXML
    void run() {
        String name = Thread.currentThread().getName();
        synchronized (this) {
            if ("取款".equals(name)) {
                System.out.println("取钱");
            } else {
                System.out.println("存钱");
            }
        }
    }


    @FXML
    void start6354(ActionEvent event) {
        if (check1()) {
            int idx=1;
            for (String val : getDeposit()) {
                if (val.charAt(0) == '-') {
                    new Thread(this::run, "取款").start();
                }
                //数字或+
                else {
                    new Thread(this::run, "存款").start();
                }
            }
        }
    }

}
