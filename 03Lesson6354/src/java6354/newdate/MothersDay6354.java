package java6354.newdate;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.net.URL;

/**
 * @author Yeah
 * @date 2021/3/24 - 15:29
 */
public class MothersDay6354 extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        //获取路径
        URL url = getClass().getResource("MothersDay6354View.fxml");
        //通过类加载器加载根对象
        VBox root = FXMLLoader.load(url);
        //组装
        Scene scene = new Scene(root, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.setTitle("母亲节");
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch();
    }
}
