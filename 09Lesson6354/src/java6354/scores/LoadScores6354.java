package java6354.scores;/**
 * @author: yeah
 */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class LoadScores6354 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        URL url = getClass().getResource("LoadScores6354View.fxml");
        Parent root = null;
        try {
            root = FXMLLoader.load(url);
            Scene scene = new Scene(root, 600, 400);
            primaryStage.setScene(scene);
            primaryStage.setTitle("加载学生成绩单");
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
