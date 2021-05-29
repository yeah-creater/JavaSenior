package java6354.gui;

import java6354.gui.dao.Student6354;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


/**
 * @author yeah
 */
public class Dialog6354Controller {
    @FXML
    private Student6354 stu;

    @FXML
    private AnchorPane root;

    @FXML
    private TextField tfSno;

    @FXML
    private TextField tfSname;

    @FXML
    private TextField tfLx1;

    @FXML
    private TextField tfLx2;

    @FXML
    private Button btnYes;

    @FXML
    Student6354 getStudent() {
        return stu;
    }

    @FXML
    void clear() {
        tfSno.setText("");
        tfSname.setText("");
        tfLx1.setText("");
        tfLx2.setText("");
    }
    @FXML
    void fill(Student6354 stu){
        tfSno.setText(stu.getSno());
        tfSname.setText(stu.getSname());
        tfLx1.setText(stu.getLx1() + "");
        tfLx2.setText(stu.getLx2() + "");
    }

    @FXML
    public void alertWindow(String title, String waring) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(waring);
        alert.getButtonTypes().setAll(ButtonType.YES, ButtonType.NO);
        alert.show();
    }

    @FXML
    boolean check(String sname, String sno, String lx1, String lx2) {
        String regex1 = "\\d{9}";
        String regex2 = "\\d+";
        return sno.matches(regex1) && lx1.matches(regex2) && lx2.matches(regex2);
    }

    @FXML
    void initAdd() {
        stu = null;
        btnYes.setText("增加");
        clear();

    }

    @FXML
    void initChange(Student6354 stu) {
        this.stu = null;
        btnYes.setText("修改");
        fill(stu);
    }

    @FXML
    void no(ActionEvent event) {
        //关闭舞台
        ((Stage) root.getScene().getWindow()).close();
    }

    @FXML
    void yes(ActionEvent event) {
        String sno = tfSno.getText();
        String sname = tfSname.getText();
        String lx1 = tfLx1.getText();
        String lx2 = tfLx2.getText();
        //判断信息的合法性及赋值给目标对象
        if (check(sname, sno, lx1, lx2)) {
            stu = new Student6354(sno, sname, Integer.parseInt(lx1), Integer.parseInt(lx2));
            alertWindow("学生信息提醒", "添加或修改成功");
            //关闭舞台
            ((Stage) root.getScene().getWindow()).close();
        } else {
            alertWindow("学生信息提示", "信息为空或不合法");
        }

    }

}
