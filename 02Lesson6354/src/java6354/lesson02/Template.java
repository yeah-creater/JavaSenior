package java6354.lesson02;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

/**
 * @author Yeah
 * @date 2021/3/17 - 10:27
 */
public class Template {
    static Button bt;
    static Label res;
    static TextField tf;
    static void newInstance(Stage primaryStage,String title, String author, String tip, String button){
        Label lblStudent = new Label(author);
        BorderStroke bs = new BorderStroke(Paint.valueOf("#8FBC8F")
                , BorderStrokeStyle.DOTTED
                , new CornerRadii(10)
                , new BorderWidths(3));
        lblStudent.setBorder(new Border(bs));
        lblStudent.setPadding(new Insets(10));

        HBox input = new HBox(20);
        input.setAlignment(Pos.CENTER_LEFT);
        Label lbDigit = new Label(tip);
        tf = new TextField();
        input.getChildren().addAll(lbDigit, tf);

        bt = new Button(button);
        res = new Label();

        VBox root = new VBox(20);
        root.setPadding(new Insets(20.0));
        root.setAlignment(Pos.TOP_CENTER);
        root.getChildren().addAll(lblStudent,input, bt, res);
        Scene scene = new Scene(root, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.setTitle(title);
        primaryStage.show();

    }
    

}
