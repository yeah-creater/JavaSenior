package java6354.newdate;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.net.URL;

/**
 * @author Yeah
 * @date 2021/3/24 - 16:24
 */
public class BirthDay6354 extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        //加载fxml文件
        URL url = getClass().getResource("BirthDay6354View.fxml");
        VBox root = FXMLLoader.load(url);

        Scene scene = new Scene(root, 400, 400);
        primaryStage.setTitle("生日计算");
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
