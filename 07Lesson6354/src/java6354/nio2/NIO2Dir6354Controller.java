package java6354.nio2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.stream.Stream;

public class NIO2Dir6354Controller {
    @FXML
    private TextField tfDir;
    @FXML
    private Label lblCount;
    @FXML
    private TableView<MyFile6354> tableFiles;
    @FXML
    private TableColumn<MyFile6354, String> colName;
    @FXML
    private TableColumn<MyFile6354, String> colTime;
    @FXML
    private TableColumn<MyFile6354, String> colType;
    @FXML
    private TableColumn<MyFile6354, String> colSize;

    static int CntOfSubDir;
    static int CntOfSubFile;
    static final int ZERO = 0;

    public void reset() {
        CntOfSubFile = ZERO;
        CntOfSubDir = ZERO;
        lblCount.setText("");//重置label
    }

    @FXML
    public void initialize() {
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colType.setCellValueFactory(new PropertyValueFactory<>("type"));
        colTime.setCellValueFactory(new PropertyValueFactory<>("modifiedTime"));
        colSize.setCellValueFactory(new PropertyValueFactory<>("size"));
    }

    @FXML
    public void alertTips(String warning) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("NOI2与TableView显示目录内容");
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

    public void listAll(ActionEvent actionEvent) throws IOException {
        reset();
        tableFiles.getItems().clear();
        File file = new File("");
        String path = tfDir.getText().trim();
        if (path.isEmpty()) {//如果在文本框中输入空串，按回车，默认列出当前目录的内容
            path = file.getCanonicalPath();// 当前项目路径
            tfDir.setText(path);
        }
        file = new File(path);
        if (check(file)) {//检查输入的目录是否正确（Files的isDirectory方法）
            list(file);
        }
    }

    @FXML
    public void doubleClick(MouseEvent mouseEvent) throws IOException {
        if (mouseEvent.getClickCount() == 2) {//双击判断
            MyFile6354 selectedItem = tableFiles.getSelectionModel().getSelectedItem();//选中的文件对象
            if(selectedItem!=null) {
                if ("文件夹".equals(selectedItem.getType())) {
                    tfDir.setText(tfDir.getText() + "\\" + selectedItem.getName());
                    listAll(null);
                }
            }
        }
    }

    @FXML
    public void list(File file) throws IOException {
        Stream<Path> paths = Files.list(file.toPath());//使用Files的list方法得到目录中的所有Path对象
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        paths.forEach(p -> {//按要求将每个Path转换成MyFileXXXX对象，添加到TabletView中
            String name = p.toFile().getName();
            String modifiedTime = sdf.format(p.toFile().lastModified());
            String type = p.toFile().isFile() ? "" : "文件夹";
            String size = p.toFile().isDirectory() ? "" : (p.toFile().length()+1023 )/ 1024 + "KB";
            tableFiles.getItems().add(new MyFile6354(name, modifiedTime, type, size));
            if ("".equals(type)) {
                CntOfSubFile++;
            } else {
                CntOfSubDir++;
            }
        });
        //子目录在前，文件在后，子目录和文件都按字典序排列
        Collections.sort(tableFiles.getItems());
        lblCount.setText("子目录: " + CntOfSubDir + ", 文件: " + CntOfSubFile);
    }
}


