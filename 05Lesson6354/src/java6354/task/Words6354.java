package java6354.task;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;


public class Words6354 extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        URL url = getClass().getResource("Words6354View.fxml");
        Parent root = FXMLLoader.load(url);

        Scene scene = new Scene(root, 800, 500);
        primaryStage.setScene(scene);
        primaryStage.setTitle("提取单词表");
        primaryStage.show();

    }
}
