package java6354.task;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.util.*;

public class NoRepeatStudent6354Controller {
   
    @FXML
    public ListView<Student6354> lvStudent;
    @FXML
    private TextField tfName;
    @FXML
    private TextField tfAge;

    //打开窗口时ListView中显示一组Student对象，默认选中第一项，并将第一项的姓名和年龄显示在文本框中
    @FXML
    public void initialize() {
        List<Student6354> students = new ArrayList<>();
//        students.add(new Student6354("xe", 20));
//        students.add(new Student6354("zs", 30));
//        students.add(new Student6354("ls", 2));
//        students.add(new Student6354("ww", 45));
//        students.add(new Student6354("zl", 18));
        lvStudent.getItems().setAll(students);
        if (!lvStudent.getItems().isEmpty()) {
            lvStudent.getSelectionModel().selectFirst();
            tfName.setText(lvStudent.getItems().get(0).getName());
            tfAge.setText(lvStudent.getItems().get(0).getAge() + "");
        }
    }

    @FXML
    public void alertTips(String warning) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("ListView与对象集合");
        alert.setHeaderText("Attention!");
        alert.setContentText(warning);
        alert.show();
    }

    @FXML
    public boolean isValidInput(String name, String ageS) {
        try {
            int age = Integer.parseInt(ageS);
            if (name.isEmpty() || age < 0 || age > 300) {
                alertTips("年龄或姓名不符合规范");
                return false;
            }
            return true;
        } catch (NumberFormatException e) {
            alertTips("年龄或姓名不符合规范");
            return false;
        }

    }

    @FXML
    public boolean isEmptyList() {
        if (lvStudent.getItems().isEmpty()) {
            alertTips("对象列表为空");
            return true;
        }
        return false;
    }

    //单击增加按钮，以文本框中的姓名和年龄创建对象，添加到ListView的末端
    @FXML
    public void addClick(ActionEvent actionEvent) {
        String name = tfName.getText().replaceAll(" +", "");
        String ageS = tfAge.getText().replaceAll(" +", "");
        if (isValidInput(name, ageS)) {
            lvStudent.getItems().add(new Student6354(name, Integer.parseInt(ageS)));
        }
        lvStudent.getSelectionModel().selectFirst();
    }

    //单击修改按钮，以文本框中的姓名和年龄修改ListView中当前选中项

    public void changeClick(ActionEvent actionEvent) {
        if (isEmptyList()) {
            return;
        }
        String name = tfName.getText().replaceAll(" +", "");
        String ageS = tfAge.getText().replaceAll(" +", "");
        if (isValidInput(name, ageS)) {
            int index = lvStudent.getSelectionModel().getSelectedIndex();
            Student6354 s = new Student6354(name, Integer.parseInt(ageS));
            if (lvStudent.getItems().get(index).equals(s)) {
                alertTips("你改了个寂寞");
            } else {
                lvStudent.getItems().set(index, s);
            }
        }
        lvStudent.getSelectionModel().selectFirst();

    }

    //单击清除重复项按钮，清除ListView中相同的Student对象

    public void clearClick(ActionEvent actionEvent) {
        if (isEmptyList()) {
            return;
        }
        ObservableList<Student6354> students = lvStudent.getItems();
        LinkedHashSet<Student6354> tree = new LinkedHashSet<>(students);//过滤
        students.setAll(tree);
        lvStudent.getSelectionModel().selectFirst();
    }

    //在ListView选中某项，对应的姓名和年龄显示在文本框中
    @FXML
    public void chooseClick(MouseEvent mouseEvent) {
        if (isEmptyList()) {
            return;
        }
        int index = lvStudent.getSelectionModel().getSelectedIndex();//获取选中项的下标
        tfName.setText(lvStudent.getItems().get(index).getName());
        tfAge.setText(lvStudent.getItems().get(index).getAge() + "");
    }
}
