package java6354.bank;

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
public class Bank6354 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        URL url = getClass().getResource("Bank6354View.fxml");
        Parent root=null;
        try {
            root= FXMLLoader.load(url);
            Scene scene = new Scene(root, 800, 600);
            primaryStage.setScene(scene);
            primaryStage.setTitle("多线程同步");
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
