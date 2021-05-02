package java6354.nio2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class NIO2NewFile6354 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        URL url = getClass().getResource("NIO2NewFileView6354.fxml");
        Parent root = null;
        try {
            root = FXMLLoader.load(url);
            Scene scene = new Scene(root, 600, 400);
            primaryStage.setScene(scene);
            primaryStage.setTitle("创建新文件");
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
