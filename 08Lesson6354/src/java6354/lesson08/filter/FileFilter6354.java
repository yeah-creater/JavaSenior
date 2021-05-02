package java6354.lesson08.filter;

/**
 * @author: yeah
 */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class FileFilter6354 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        URL url = getClass().getResource("FileFilter6354View.fxml");
        Parent root = null;
        try {
            root = FXMLLoader.load(url);
            Scene scene = new Scene(root, 900, 500);
            primaryStage.setScene(scene);
            primaryStage.setTitle("文件过滤器");
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
