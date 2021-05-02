package java6354.lesson08.sort;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;

/**
 * @author yeah
 */
public class ListSort6354 extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        URL url = getClass().getResource("ListSort6354View.fxml");
        Parent root = FXMLLoader.load(url);

        Scene scene = new Scene(root, 700, 500);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Java8对象排序新方法");
        primaryStage.show();
    }
}
