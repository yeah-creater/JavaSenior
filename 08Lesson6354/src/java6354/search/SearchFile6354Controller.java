package java6354.search;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.DirectoryChooser;
import javafx.stage.Window;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Stream;

/**
 * @author yeah
 */
public class SearchFile6354Controller {

    @FXML
    private ListView<String> lvFiles;

    @FXML
    private TextField tfDir;

    @FXML
    private Label lblCount;
    @FXML
    private Label lblDir;

    int cntOfSubDir;
    int cntOfSubFile;
    final int ZERO = 0;

    @FXML
    public void reset() {
        cntOfSubFile = ZERO;
        cntOfSubDir = ZERO;
        lblCount.setText("");
        lblDir.setText("");
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
    void listAll(ActionEvent event) throws IOException {
        File file = new File("");
        String path = tfDir.getText().trim();
        //如果在文本框中输入空串，按回车，默认列出当前目录的内容
        if (path.isEmpty()) {
            // 当前项目路径
            path = file.getCanonicalPath();
        }
        file = new File(path);
        if (check(file)) {
            list(file);
            lblDir.setText("当前目录:" + file.toString());
        }
    }

    @FXML
    public void list(File file) throws IOException {
        reset();
        lvFiles.getItems().clear();
        //使用Files的list方法得到目录中的所有Path对象
        Stream<Path> paths = Files.list(file.toPath());
        List<String> folders= new ArrayList<>();
        List<String> files=new ArrayList<>();
        //按要求将每个Path转换成MyFileXXXX对象，添加到TabletView中
        paths.forEach(p -> {
            String name = p.toFile().getName();
            String type;
            if(p.toFile().isFile()){
                String fileName = p.toFile().getName();
                int index = fileName.lastIndexOf(".");

                if(index!=-1){
                   type=name.substring(index+1,fileName.length())+"类型";
                }
                else{
                    type="未知类型";
                }
            }
            else{
                type="文件夹";
            }
            if ("文件夹".equals(type)) {
                folders.add(name+",  "+type);
                cntOfSubDir++;
            } else {
                cntOfSubFile++;
                files.add(name+",  "+type);
            }
        });
        //文件夹在所有文件之前
        // 所有文件夹按字母升序显示（不区分大小写）
        // 所有文件按字母升序显示（不区分大小写）

        folders.sort(Comparator.comparing(String::toUpperCase));
        files.sort(Comparator.comparing(String::toUpperCase));
        lvFiles.getItems().addAll(folders);
        lvFiles.getItems().addAll(files);
        lblCount.setText("子目录: " + cntOfSubDir + ", 文件: " + cntOfSubFile);
    }


    /**
     * JavaFX使用DirectoryChooser类弹出窗口选择目录，基本步骤如下，请自主学习该类的使用：
     * （1）new创建实例
     * （2）设置属性，如默认目录等
     * （3）打开窗口
     * （4）接收选择结果
     */
    @FXML
    void selectDir(ActionEvent actionEvent) throws IOException {
        File dir = openDirChooser();
        if (dir != null) {
            tfDir.setText("");
            list(dir);
            lblDir.setText("当前目录:" + dir);
        }
    }

    public static File openDirChooser() {
        //new创建实例
        DirectoryChooser dirChooser = new DirectoryChooser();
        //设置属性，如默认目录等
        dirChooser.setInitialDirectory(new File("C:\\"));
        dirChooser.setTitle("打开文件夹");
        //打开窗口
        File selectedFile = dirChooser.showDialog(new MyWindow());
        //返回选择结果
        return selectedFile;
    }
    static class MyWindow extends Window {

    }
}
