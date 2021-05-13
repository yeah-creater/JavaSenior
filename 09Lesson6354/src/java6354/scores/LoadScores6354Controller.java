package java6354.scores;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.*;
import java.util.Comparator;


/**
 * @author yeah
 */
public class LoadScores6354Controller {

    @FXML
    private Label lblFilename;

    @FXML
    private TableView<Score6354> tvScores;

    @FXML
    private TableColumn<Score6354, String> colName;

    @FXML
    private TableColumn<Score6354, Integer> colChinese;

    @FXML
    private TableColumn<Score6354, Integer> colMath;

    @FXML
    private TableColumn<Score6354, Integer> colEnglish;

    @FXML
    private TableColumn<Score6354, Integer> colSum;

    @FXML
    void reset() {
        lblFilename.setText("");
        tvScores.getItems().clear();
    }

    @FXML
    void initialize() {
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colChinese.setCellValueFactory(new PropertyValueFactory<>("chinese"));
        colMath.setCellValueFactory(new PropertyValueFactory<>("math"));
        colEnglish.setCellValueFactory(new PropertyValueFactory<>("english"));
        colSum.setCellValueFactory(new PropertyValueFactory<>("sum"));
    }

    @FXML
    void openFile(ActionEvent event) {
        /**
         * FileChooser将弹出对话框，选择文件运行效果如下图所示，请自主学习FileChooser，按下列步骤使用：
         * （1）new一个FileChooser
         * （2）设置标题
         * （3）设置初始目录
         * （4）如下图所示设置两种文件过滤：*.txt和*.*
         * （5）打开对话框
         */
        FileChooser fc = new FileChooser();
        fc.setTitle("请选择学生文件");
        fc.setInitialDirectory(new File("."));
        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("文本文件 (*.txt)", "*.txt"));
        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("所有 (*.*)", "*.*"));
        File file = fc.showOpenDialog(new Stage());

        //文件打开后的操作
        if (file != null && file.getName().endsWith(".txt")) {
            reset();
            readFile(file);
        }
    }

    @FXML
    void readFile(File file) {
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String infos;
            while ((infos = br.readLine()) != null) {
                String[] info = infos.split(",");
                if (info.length == 4) {
                    tvScores.getItems().add(new Score6354(info[0], Integer.parseInt(info[1]),
                            Integer.parseInt(info[2]), Integer.parseInt(info[3])));
                }
            }
            //排序
            tvScores.getItems().sort(Comparator.comparingInt(Score6354::getSum).thenComparingInt(Score6354::getMath).reversed());
            lblFilename.setText(tvScores.getItems().size() + "条学生数据: " + file.getPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
