package java6354.gui;

import java6354.gui.dao.Student6354;
import java6354.gui.dao.StudentDao6354Imp;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Optional;

/**
 * @author yeah
 */
public class EditStudent6354Controller {

    @FXML
    private BorderPane root;

    @FXML
    private Stage dialog;
    @FXML
    private Dialog6354Controller dialogController;

    @FXML
    private TableView<Student6354> tvStudents;

    @FXML
    private TableColumn<Student6354, String> colSno;

    @FXML
    private TableColumn<Student6354, String> colSname;

    @FXML
    private TableColumn<Student6354, Integer> colLx1;

    @FXML
    private TableColumn<Student6354, Integer> colLx2;

    @FXML
    public void initialize() {
        colSno.setCellValueFactory(new PropertyValueFactory<>("sno"));
        colSname.setCellValueFactory(new PropertyValueFactory<>("sname"));
        colLx1.setCellValueFactory(new PropertyValueFactory<>("lx1"));
        colLx2.setCellValueFactory(new PropertyValueFactory<>("lx2"));
        //---万恶之源
//        List<Student6354> allStudents = new StudentDao6354Imp().findAll6354();
//        tvStudents.getItems().setAll(allStudents);
        //---------
    }

    @FXML
    public void alertWindow(String title, String waring) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(waring);
        alert.getButtonTypes().setAll(ButtonType.YES, ButtonType.NO);
        Optional<ButtonType> type = alert.showAndWait();
        type.ifPresent((t) -> {
            //要删除
            if (t.equals(ButtonType.YES)) {
                int delIndex = tvStudents.getSelectionModel().getSelectedIndex();
                if (delIndex != -1) {
                    tvStudents.getItems().remove(delIndex);
                }
            }
        });


    }

    @FXML
    void createDialog6354() {
        Stage main = (Stage) root.getScene().getWindow();
        dialog = new Stage();
        URL url = getClass().getResource("Dialog6354View.fxml");
        Parent root = null;
        FXMLLoader loader = new FXMLLoader(url);
        try {
            root = loader.load();
            dialogController = loader.getController();
            Scene scene = new Scene(root, 400, 500);
            dialog.setScene(scene);
            dialog.setTitle("学生信息编辑");
            dialog.initOwner(main);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @FXML
    void add(ActionEvent event) {
        createDialog6354();
        dialogController.initAdd();
        dialog.showAndWait();
        Student6354 newStu = dialogController.getStudent();
        //stu不为空 说明点击了增加按钮
        if (newStu != null) {
            tvStudents.getItems().add(newStu);
        }

    }

    @FXML
    void change(ActionEvent event) {
        int index = tvStudents.getSelectionModel().getSelectedIndex();
        if (index != -1) {
            //选中才能修改
            createDialog6354();
            dialogController.initChange(tvStudents.getItems().get(index));
            dialog.showAndWait();
            Student6354 newStu = dialogController.getStudent();
            if (newStu != null) {
                tvStudents.getItems().set(index, newStu);
            }

        } else {
            alertWindow("选中提示", "请选择");
        }

    }

    @FXML
    void delete(ActionEvent event) {
        int index = tvStudents.getSelectionModel().getSelectedIndex();
        if (index != -1) {
            alertWindow("删除提示!", "是否删除?");
        } else {
            alertWindow("选中提示", "请选择");
        }
    }

    @FXML
    void doubleClick(MouseEvent event) {
        if (event.getClickCount() == 2) {
            change(null);
        }
    }

}
