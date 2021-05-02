package java6354.task;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;

public class NoRepeatStudent6354 extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        URL url = getClass().getResource("NoRepeatStudent6354View.fxml");
        Parent root = FXMLLoader.load(url);

        Scene scene = new Scene(root, 500, 400);
        primaryStage.setScene(scene);
        primaryStage.setTitle("ListView与对象集合");
        primaryStage.show();
    }
}
