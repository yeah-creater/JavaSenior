package java6354.selection;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author Yeah
 * @date 2021/3/11 - 7:58
 */
public class SelectionWin6354 extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        //叶子节点
        Label up = new Label("211906354:叶本章");
        Button button = new Button("随机选人");
        Label down = new Label();

        //非叶子节点中的根结点
        VBox root = new VBox();
        root.getChildren().addAll(up,button,down);
        root.setAlignment(Pos.CENTER);
        root.setSpacing(18);

        Scene scene = new Scene(root,400,300);
        primaryStage.setTitle("随机选人");
        primaryStage.setScene(scene);
        primaryStage.show();

        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                FileInputStream fis = null;
                try {
                    fis = new FileInputStream("F:\\Code\\idea\\JAVAFullStack\\12JavaSenior\\Java6354\\01Lesson6354\\src\\java6354\\selection\\StudentList.txt");
                    byte[] bytes = new byte[10240];//文件小于10k
                    fis.read(bytes);
                    String s=new String(bytes);
                    String[] lists = s.split("\n");
                    int key=(int)(Math.random()*48);// 0~47
                    System.out.println(key);
                    down.setText("恭喜"+lists[key]+"           被选中");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                finally {
                    try {
                        fis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

            }
        });

    }
    public static void main(String[] args) {
        launch();
    }
}
