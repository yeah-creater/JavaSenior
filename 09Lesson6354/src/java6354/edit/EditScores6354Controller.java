package java6354.edit;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.io.*;


/**
 * @author yeah
 */
public class EditScores6354Controller {
    @FXML
    private Button open;
    @FXML
    private Button save;
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
    void initialize() {
        //设置可编辑
        tvScores.setEditable(true);
        colName.setCellFactory(TextFieldTableCell.forTableColumn());
        colChinese.setCellFactory(TextFieldTableCell.forTableColumn(new MyStringConverter()));
        colEnglish.setCellFactory(TextFieldTableCell.forTableColumn(new MyStringConverter()));
        colMath.setCellFactory(TextFieldTableCell.forTableColumn(new MyStringConverter()));

        //当修改某个单元格，按回车确认后，再次按回车，能够让下一个单元格进入编辑状态
        tvScores.editingCellProperty().addListener((obr,o,n)->{
            if(n==null){
                tvScores.requestFocus();
                if(o.getColumn()<tvScores.getColumns().size()-1){
                    tvScores.getFocusModel().focusRightCell();
                }
                else{
                    tvScores.getFocusModel().focus(o.getRow(),tvScores.getColumns().get(0));
                }
            }
        });
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colChinese.setCellValueFactory(new PropertyValueFactory<>("chinese"));
        colMath.setCellValueFactory(new PropertyValueFactory<>("math"));
        colEnglish.setCellValueFactory(new PropertyValueFactory<>("english"));
    }

    @FXML
    void reset() {
        lblFilename.setText("");
        tvScores.getItems().clear();

    }
    @FXML
    File chooseFile(ActionEvent event){
        FileChooser fc = new FileChooser();
        fc.setTitle("请选择学生文件");
        fc.setInitialDirectory(new File("."));
        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("文本文件 (*.txt)", "*.txt"));
        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("所有 (*.*)", "*.*"));
        if(event.getSource().equals(open)) {
            return fc.showOpenDialog(new Stage());
        }
        return fc.showSaveDialog(new Stage());
    }

    @FXML
    void openFile(ActionEvent event) {
        File file=chooseFile(event);

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
            lblFilename.setText(tvScores.getItems().size() + "条学生数据: " + file.getPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void saveFile(ActionEvent event) {
        File file=chooseFile(event);
        if (file != null && file.getName().endsWith(".txt") && !tvScores.getItems().isEmpty()) {
            writeFile(file);
        }
    }

    @FXML
    void writeFile(File file) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            for(Score6354 score:tvScores.getItems()){
                bw.write(score.toString());
                bw.newLine();
            }
            lblFilename.setText("保存成功");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void add(ActionEvent event) {
        tvScores.getItems().add(new Score6354("new",0,0,0));
    }

    @FXML
    void delete(ActionEvent event) {
        int index=tvScores.getSelectionModel().getSelectedIndex();
        if(index!=-1){
            tvScores.getItems().remove(index);
        }
    }
}
