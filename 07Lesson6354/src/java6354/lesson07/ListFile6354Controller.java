package java6354.lesson07;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class ListFile6354Controller {

    @FXML
    private ListView<StringBuilder> lvFiles;

    @FXML
    private TextField tfDir;

    @FXML
    private Label lblCount;

    static int CntOfSubDir;
    static int CntOfSubFile;
    static final int ZERO=0;
    static StringBuilder info;
    @FXML
    public void reset(){
        info=new StringBuilder();
        CntOfSubFile=ZERO;
        CntOfSubDir=ZERO;
        lblCount.setText("");
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
        reset();
        File file = new File("");
        String path=tfDir.getText().trim();
        if (path.isEmpty()) {//如果在文本框中输入空串，按回车，默认列出当前目录的内容
            path=file.getCanonicalPath();// 当前项目路径
        }
        file = new File(path);
        if (check(file)) {
            File[] files = file.listFiles();
            assert files != null;
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            for(File f:files){
                if(f.isDirectory()){
                    CntOfSubDir++;
                    info.append("文件夹, ").append(f.getName()).append(",   ").append
                            (sdf.format(f.lastModified())).append("\n");
                }
                else{
                    info.append(f.getName()).append(",   ").append(sdf.format(f.lastModified())).append(", ").
                            append((f.length()+1024-1)/1024).append("KB").append("\n");
                    CntOfSubFile++;
                }
            }
            lblCount.setText("子目录: "+CntOfSubDir+", 文件: "+CntOfSubFile);
            lvFiles.getItems().setAll(info);
        }

    }
}
