package java6354.lesson04;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;

/**
 * @purpose: 启动类(客户端)ListFilter6354
 */
public class ListFilter6354 extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        URL url = getClass().getResource("ListFilter6354View.fxml");
        Parent root = FXMLLoader.load(url);

        Scene scene = new Scene(root, 800, 800);
        primaryStage.setScene(scene);
        primaryStage.setTitle("筛选随机数");
        primaryStage.show();

    }
}
