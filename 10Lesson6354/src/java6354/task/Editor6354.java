package java6354.task;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

/**
 * @author yeah
 */
public class Editor6354 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        URL url = getClass().getResource("Editor6354View.fxml");
        Parent root = null;
        FXMLLoader loader = new FXMLLoader(url);
        try {
            root = loader.load();
            Scene scene = new Scene(root, 600, 400);
            primaryStage.setScene(scene);
            primaryStage.setTitle("文本编辑器");
            primaryStage.show();
            Editor6354Controller controller = loader.getController();
            controller.setCloseRequest(primaryStage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
