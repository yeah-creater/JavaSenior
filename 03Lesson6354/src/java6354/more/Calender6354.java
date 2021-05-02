package java6354.more;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.net.URL;

/**
 * @author Yeah
 * @date 2021/3/25 - 14:16
 */
public class Calender6354 extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        URL url = getClass().getResource("Calendar6354View.fxml");
        BorderPane root = FXMLLoader.load(url);

        Scene scene = new Scene(root, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.setTitle("显示月历");
        primaryStage.show();

    }
}
