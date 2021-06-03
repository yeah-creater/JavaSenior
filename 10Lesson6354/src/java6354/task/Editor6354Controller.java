package java6354.task;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * @author yeah
 * 摸鱼...
 */
public class Editor6354Controller {

    @FXML
    private Button open;
    @FXML
    private Button save;
    @FXML
    private Button saveAs;
    @FXML
    private TextField tfFilename;

    @FXML
    private boolean isChanged;
    @FXML
    private TextArea taText;

    @FXML
    void initialize() {
        taText.textProperty().addListener((o,a,b) -> {
            if(!a.equals(b)&&!a.equals("")){
                isChanged=true;
            }
        });
    }
    @FXML
    public void alertTips(String warning) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("文本编辑器的关闭提示");
        alert.setContentText(warning);
        alert.show();
    }
    @FXML
    void setCloseRequest(Stage stage){
        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                alertTips("是否将未存盘的修改保存到"+tfFilename.getText());
            }
        });

    }

    @FXML
    File chooseFile(ActionEvent event) {
        FileChooser fc = new FileChooser();
        fc.setTitle("请选择文件");
        fc.setInitialDirectory(new File("."));
        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("java文件 (*.java)", "*.java"));
        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("文本文件 (*.txt)", "*.txt"));
        if (event.getSource().equals(open)) {
            return fc.showOpenDialog(new Stage());
        }
        return fc.showSaveDialog(new Stage());

    }

    @FXML
    void openFile(ActionEvent event) {

        File file = chooseFile(event);
        if (file != null) {
            isChanged = false;
            taText.setText("");
            tfFilename.setText("");
            try (Scanner in = new Scanner(file)) {
                while (in.hasNext()) {
                    taText.appendText(in.nextLine() + "\n");
                }
                tfFilename.setText(file.getAbsolutePath());
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    void saveAsFile(ActionEvent event) {
        if(!taText.getText().equals("")) {
            File file = chooseFile(event);
            if (file != null) {
                try (PrintWriter pw = new PrintWriter(file)) {
                    pw.write(taText.getText());
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @FXML
    void saveFile(ActionEvent event) {
        if (isChanged) {
            File file = chooseFile(event);
            if (file != null) {
                try (PrintWriter pw = new PrintWriter(file)) {
                    pw.write(taText.getText());
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
