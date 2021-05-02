package java6354.nio2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class NIO2NewFile6354Controller {
    @FXML
    public TextField tfFilename;
    @FXML
    public Label lblMessage;
    @FXML
    public void listAll(ActionEvent actionEvent) throws IOException {
        lblMessage.setText("");
        String fileName = tfFilename.getText().trim();
        File file=new File(fileName);
        if(!file.exists()){
            File parent = file.getParentFile();
            //目录不存在
            if(parent!=null&&!parent.exists()){
                if(!parent.mkdirs()){
                    lblMessage.setText("Windows找不到\""+fileName+"\""+" 检查拼写是否错误");
                    return;
                }
            }
            File tmp=file.getParentFile();
            //在文件下创建文件?
            while (tmp!=null){
                if(tmp.isFile()){
                    lblMessage.setText("Windows找不到\""+fileName+"\""+" 检查拼写是否错误");
                    return;
                }
                tmp=tmp.getParentFile();
            }
            //盘符不存在
            if(parent==null) {
                lblMessage.setText("Windows找不到\""+fileName+"\"");
                return;
            }
            if(!Objects.equals(file.getParentFile(), new File("C:\\"))) {
                file.createNewFile();
                lblMessage.setText("创建新文件" + file.getAbsolutePath());
            }
            else {
                lblMessage.setText("创建失败");
            }
        }
        else{
            lblMessage.setText("文件已存在");
        }
    }
}
