package java6354.lesson07;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.File;
import java.io.IOException;

/**
 * @author yeah
 */
public class CreateNewFile6354Controller {
    @FXML
    public TextField tfFilename;
    @FXML
    public Label lblMessage;

    @FXML
    public void listAll(ActionEvent actionEvent) throws IOException {
        String fileName = tfFilename.getText().trim();
        File file = new File(fileName);
        if (!file.exists()) {
            //图中第27～33行代码的作用是什么？如果删除这段代码会产生什么影响，请举例说明？
            //(不存在的一个父目录会报异常)
            File parent = file.getParentFile();
            if (/*parent!=null*/!parent.exists()) {
                if (!parent.mkdirs()) {
                    //输入没有的盘符
                    throw new IOException("不能创建目录" + parent);
                }
                lblMessage.setText("创建目录" + parent);
            }
            file.createNewFile();//根目录无法创建文件
            lblMessage.setText("创建新文件" + file.getAbsolutePath());

        } else {
            lblMessage.setText("文件已存在");
        }
    }
}
