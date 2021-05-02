package java6354.register;

import javafx.beans.value.ChangeListener;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Register6354Controller {

    @FXML
    private TextField tfName;//用户名

    @FXML
    private PasswordField pf1;//第一次密码

    @FXML
    private PasswordField pf2;//第二次密码

    @FXML
    private TextField tfPhone;//手机号

    @FXML
    private Label lblName;//名字重复信息

    @FXML
    private Label lblPW1;//密码格式错误信息

    @FXML
    private Label lblPW2;//密码不一致错误信息

    @FXML
    private Label lblPhone;//手机号错误信息


    @FXML
    private ListView<User6354> lvUsers;

    static List<TextInputControl> inputs = new ArrayList<>();
    static List<Label> judges = new ArrayList<>();
    static HashSet<String> set = new HashSet<>();//存放已注册的用户名

    @FXML
    public void initialize() {
        //将输入保存在集合里
        inputs.add(tfName);
        inputs.add(pf1);
        inputs.add(pf2);
        inputs.add(tfPhone);
        //将判断信息添加到集合中
        judges.add(lblName);
        judges.add(lblPW1);
        judges.add(lblPW2);
        judges.add(lblPhone);
        ChangeListener listener = (a,b,c)->check();
        for (TextInputControl control : inputs) {
            control.focusedProperty().addListener(listener);
        }
    }

    //获取聚焦点的下标
    @FXML
    public int getFocusIndex() {
        for (int i = 0; i < inputs.size(); i++) {
            if (inputs.get(i).isFocused()) {
                return i;
            }
        }
        return -1;
    }

    //检查焦点外的其他文本框 当前焦点取消提醒窗
    @FXML
    public void check() {
        int focusIndex = getFocusIndex();
        for (int i = 0; i < inputs.size(); i++) {
            if (i == focusIndex)//得到焦点时取消提醒窗
            {
                judges.get(i).setVisible(false);
            } else {
                checkSelf(i);
            }
        }
    }

    //失去焦点时检查自己  输入为空不是用户名就不判断了
    @FXML
    public boolean checkSelf(int index) {
        for (int i = 0; i < inputs.size(); i++) {
            if (i == index) {
                if (inputs.get(i).getText().isEmpty()) {
                    if (i == 0) {
                        judges.get(0).setVisible(true);
                    }
                    return false;
                }
                switch (i) {
                    case 0: {
                        String text = inputs.get(0).getText();
                        judges.get(0).setVisible(set.contains(text));
                        return !set.contains(text);
                    }
                    case 1:
                    case 2: {
                        String text1 = inputs.get(1).getText();
                        String text2 = inputs.get(2).getText();//有可能为空
                        String regex = "(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{6,}";
                        if (index != 2) {
                            judges.get(1).setVisible(!text1.isEmpty() &&
                                    !text1.matches(regex));
                        }
                        if (index != 1) {
                            judges.get(2).setVisible(!text2.isEmpty() && !text1.equals(text2));
                        }
                        return i == 1 ? text1.matches(regex) :
                                text2.equals(text1);
                    }
                    case 3: {
                        String text = inputs.get(3).getText();
                        String regex = "1[3578]\\d{9}";
                        judges.get(3).setVisible(!text.matches(regex));
                        return text.matches(regex);
                    }
                    default:{
                       break;
                    }
                }
            }
        }
        return true;
    }

    //通过判断没有警告并且文本框都不为空
    @FXML
    public boolean checkAll() {
        for (TextInputControl control : inputs) {
            if (control.getText().isEmpty()) {
                return false;
            }
        }
        for (Label label : judges) {
            if (label.isVisible()) {
                return false;
            }
        }
        return true;
    }

    @FXML
    public void alertTips(String warning) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("用户注册V1.0｜集合版");
        alert.setHeaderText("Attention!");
        alert.setContentText(warning);
        alert.show();
    }

    @FXML
    void clear() {
        //重开
        for (TextInputControl control : inputs) {
            control.clear();
        }
        for (Label label : judges) {
            label.setVisible(false);
        }
    }

    @FXML
        //非输入框按回车直接进入okClick
    void enterKey() {//输入框按回车后进入这里判断当前焦点，满足进入下一个
        for (int i = 0; i < inputs.size() - 1; i++) {
            if (inputs.get(i).isFocused()) {
                if (!checkSelf(i)) {
                    alertTips("请输入正确信息");
                }
                inputs.get(i + 1).requestFocus();
                return;
            }
        }
        alertTips("到尾了!!!");
    }

    @FXML
    void noClick() {
        clear();
    }

    @FXML
    void okClick() {
        check();//原型毕露
        if (checkAll()) {//扫黑除恶
            alertTips("注册成功");
            String username = inputs.get(0).getText();
            String password = inputs.get(1).getText();
            String phone = inputs.get(3).getText();
            set.add(username);
            lvUsers.getItems().add(new User6354(username, password, phone));
            clear();
        } else {
            alertTips("注册失败");
        }
    }
}
