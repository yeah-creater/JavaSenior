package java6354.bank;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import sun.nio.ch.ThreadPool;

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
 *
 * @author yeah
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
        if (!initBalance.matches(regex) || tfBankID.getText().trim().isEmpty()) {
            alertTips("初始余额,账户为空或格式错误");
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

        String out = "取款";
        String in = "存款";
        synchronized (this) {
            String name = Thread.currentThread().getName();
            if (name.contains(out)) {
                int deposit = Integer.parseInt(name.split(out)[1]);
                String info;
                if (balance < deposit) {
                    info = name + "失败," + "余额不足(" + balance + ")\n";
                }
                else{
                    info = name + "\n";
                    balance -= deposit;
                }
                taResult.appendText(info);
            } else {
                int deposit = Integer.parseInt(name.split(in)[1]);
                balance += deposit;
                String info = name + "\n";
                taResult.appendText(info);
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }


    @FXML
    void start6354(ActionEvent event) {
        if (check1()) {
            taResult.clear();
            lblBalance.setText("");
            List<String> deposits = getDeposit();
            for (int i = 0; i < deposits.size(); i++) {
                String deposit = deposits.get(i);
                if (deposit.charAt(0) == '-') {
                    deposit = deposit.replace("-", "");
                    new Thread(this::run, "线程" + (i + 1) + ": 取款" + deposit).start();
                } else {
                    deposit = deposit.replace("+", "");

                    new Thread(this::run, "线程" + (i + 1) + ": 存款" + deposit).start();
                }
            }

            lblBalance.setText("余额"+balance);
        }

    }

}
