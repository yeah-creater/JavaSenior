package java6354.lesson08.filter;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author yeah
 */
public class FileFilter6354Controller {

    @FXML
    private TextField tfDir;

    @FXML
    private ListView<StringBuilder> lvFiles;

    @FXML
    private RadioButton rb1;

    @FXML
    private ToggleGroup tg;

    @FXML
    private RadioButton rb2;

    @FXML
    private RadioButton rb3;
    @FXML
    private String path;

    @FXML
    void realizeListener(Toggle selectButton) {
        lvFiles.getItems().clear();
        if (check(new File(tfDir.getText()))) {
            List<StringBuilder> list = new ArrayList<>();
            //匿名内部类
            if (selectButton.equals(rb1)) {
                list = FilenameFilters.inter6354(path);
            }
            //lambda
            else if (selectButton.equals(rb2)) {
                list = FilenameFilters.lambda6354(path);
            }
            //方法引用
            else if (selectButton.equals(rb3)) {
                list = FilenameFilters.reference6354(path);
            }
            lvFiles.getItems().setAll(list);
        }
    }

    @FXML
    void initialize() {
        //注册监听
        tg.selectedToggleProperty().addListener((observable -> {
            Toggle selectButton = tg.getSelectedToggle();
            realizeListener(selectButton);
        }));
    }

    @FXML
    public void alertTips(String warning) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("列出目录的内容");
        alert.setHeaderText("Attention!");
        alert.setContentText(warning);
        alert.show();
    }

    @FXML
    boolean check(File file) {
        if (!file.exists()) {
            alertTips("输入路径不存在");
            return false;
        }
        if (!file.isDirectory()) {
            alertTips("输入的目录不正确");
            return false;
        }
        return true;

    }

    @FXML
    void listFile(ActionEvent event) throws IOException {
        File file = new File("");
        path = tfDir.getText().trim();

        //如果在文本框中输入空串，按回车，默认列出当前项目的内容
        if (path.isEmpty()) {
            path = file.getCanonicalPath();
            tfDir.setText(path);
        }
        file = new File(path);
        if (check(file)) {
            realizeListener(tg.getSelectedToggle());
        }
    }
}
