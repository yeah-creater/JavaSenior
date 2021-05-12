package java6354.lesson09;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.*;

/**
 * @author yeah
 */
public class ReadFile6354Controller {

    @FXML
    private TextField tfFilename;

    @FXML
    private TextArea taText;

    @FXML
    void readFile(ActionEvent event) {
        String fileName = tfFilename.getText().trim();
        File file=new File(fileName);
        if(!file.exists()){
            taText.setText("文件不存在");
            tfFilename.setText("");
            return;
        }
        taText.setText("");
        try(BufferedReader bw=new BufferedReader(new FileReader(file))){
            String data;
            while ((data=bw.readLine())!=null){
                taText.appendText(data+"\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
