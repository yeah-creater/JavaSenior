package java6354.register;
/**
 * @purpose: 客户端
 */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class Register6354 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        URL url = getClass().getResource("Register6354View.fxml");
        Parent root = FXMLLoader.load(url);

        Scene scene = new Scene(root, 700, 500);
        primaryStage.setScene(scene);
        primaryStage.setTitle("用户注册V1.0｜集合版");
        primaryStage.show();
    }
}
