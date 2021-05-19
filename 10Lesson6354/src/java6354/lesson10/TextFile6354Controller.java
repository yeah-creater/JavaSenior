package java6354.lesson10;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;
import java.util.Scanner;

/**
 * @author yeah
 */
public class TextFile6354Controller {

    @FXML
    private Button src;
    @FXML
    private Button tar;

    @FXML
    private Label lblSource;

    @FXML
    private Label lblTarget;

    @FXML
    private TextArea taText;

    @FXML
    File chooseFile(ActionEvent event) {
        FileChooser fc = new FileChooser();
        fc.setTitle("请选择文件");
        fc.setInitialDirectory(new File("."));
        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("文本文件 (*.txt)", "*.txt"));
        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("所有 (*.*)", "*.*"));
        if (event.getSource().equals(src)) {
            return fc.showOpenDialog(new Stage());
        }
        return fc.showSaveDialog(new Stage());
    }

//    主要的处理逻辑，对文本文件的按行读写的方式进行复制
//  （1）从文本文件中读一行
//  （2）将当前行写入目标文件
//  （3）将当前行添加到文本域

    @FXML
    void copyFile(ActionEvent event) {

        if (!lblTarget.getText().isEmpty() && !lblSource.getText().isEmpty()) {
            taText.setText("");
            try (Scanner in = new Scanner(new FileInputStream(lblSource.getText()));
                 PrintStream ps = new PrintStream(new FileOutputStream(lblTarget.getText()))) {
                while (in.hasNext()) {
                    String data = in.nextLine();
                    ps.println(data);
                    taText.appendText(data + "\n");
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    void selectSource(ActionEvent event) {
        File file = chooseFile(event);
        if (file != null && file.getName().endsWith(".txt")) {
            lblSource.setText(file.getAbsolutePath());
        }
    }

    @FXML
    void selectTarget(ActionEvent event) {
        File file = chooseFile(event);
        if (file != null && file.getName().endsWith(".txt")) {
            lblTarget.setText(file.getAbsolutePath());
        }
    }

}
