package java6354.regex;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;


/**
 * @author Yeah
 * @date 2021/3/17 - 15:19
 */
public class CheckRegex6354 extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        //显示每个人的学号和姓名
        Label lblStudent = new Label("211906354:叶本章");
        BorderStroke bs = new BorderStroke(Paint.valueOf("#8FBC8F"),//边框的颜色
                BorderStrokeStyle.DOTTED,//边框的样式
                new CornerRadii(10),//边框四个角的圆角
                new BorderWidths(3));//边框的宽度
        lblStudent.setBorder(new Border(bs));//设置边框
        lblStudent.setPadding(new Insets(10));//设置边距

        //左边输入部分
        VBox vInput = new VBox(20);
        //第一行
        HBox hInput = new HBox(20);
        Label lTip1 = new Label("正则表达式:");
        TextField tfRegex = new TextField();
        hInput.setAlignment(Pos.CENTER_LEFT);
        hInput.getChildren().addAll(lTip1, tfRegex);

        //第二行
        Label lTip2 = new Label("输入要检验的一组字符串（用逗号分隔）");

        //第三行
        TextArea taInput = new TextArea();
        taInput.setPrefRowCount(50);
        //第4行
        Button bt = new Button("验证字符串是否符合正则表达式");

        //归并
        vInput.getChildren().addAll(hInput, lTip2, taInput, bt);
        vInput.setAlignment(Pos.CENTER);

        //右边结果部分
        TextArea taRegex = new TextArea();
        taRegex.setPrefColumnCount(20);
        taRegex.setPrefRowCount(4);
        taRegex.setWrapText(true);

        //正则表达式部分
        HBox hRegex = new HBox(20);
        //归并
        hRegex.getChildren().addAll(vInput, taRegex);
        hRegex.setAlignment(Pos.CENTER_LEFT);

        //垂直居中,包含2个部分
        VBox root = new VBox(20);
        //归并
        root.getChildren().addAll(lblStudent, hRegex);
        root.setSpacing(20);
        root.setPadding(new Insets(20));
        root.setAlignment(Pos.CENTER);
        root.setStyle("-fx-font-size:18");


        Scene scene = new Scene(root, 850, 500);
        primaryStage.setScene(scene);
        primaryStage.setTitle("验证正则表达式");
        primaryStage.show();

        bt.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                taRegex.clear();
                String regex=tfRegex.getText();
                String str=taInput.getText();
                String[] patternS = str.split(",|，");
                for(String s:patternS){
                    if(s.matches(regex)) {
                        taRegex.appendText(s+":true"+"\n");
                    } else {
                        taRegex.appendText(s+":false"+"\n");
                    }
                }

            }
        });
    }
}
