package java6354.lesson02;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import java.util.Arrays;


/**
 * @author Yeah
 * @date 2021/3/17 - 10:52
 */
public class Words6354 extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
       Template.newInstance(primaryStage,"提取三个字符的单词","211906354:叶本章",
               "输入单词:","提取单词");
       Template.bt.setOnAction(new EventHandler<ActionEvent>() {
           @Override
           public void handle(ActionEvent event) {
               String stringText = Template.tf.getText();
               String regex=" |,";
               String[] words = stringText.split(regex);
               Template.res.setText(Arrays.toString(Arrays.stream(words).filter(s->s.length()==3).toArray()));
           }
       });
    }
    
}
