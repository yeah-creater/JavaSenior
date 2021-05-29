package java6354.gui;/**
 * @author: yeah
 */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class EditStudent6354 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        URL url = getClass().getResource("EditStudent6354View.fxml");
        Parent root = null;
        FXMLLoader loader = new FXMLLoader(url);
        try {
            root = loader.load();
            Scene scene = new Scene(root, 600, 400);
            primaryStage.setScene(scene);
            primaryStage.setTitle("维护学生数据表");
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
