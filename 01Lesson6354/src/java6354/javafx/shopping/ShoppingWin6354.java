package java6354.javafx.shopping;

import javafx.application.Application;
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
 * @date 2021/3/11 - 12:34
 */
public class ShoppingWin6354 extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    //从局部到整体(最底层到叶子节点)
    @Override
    public void start(Stage primaryStage) {

        //创建控件标签对象
        Label lblStudent = new Label("211906354:叶本章");
        //修饰标签的对象
        BorderStroke bs = new BorderStroke(Paint.valueOf("#8FBC8F")
                , BorderStrokeStyle.DOTTED
                , new CornerRadii(10)
                , new BorderWidths(3));
        //标签进行装饰CSS
        lblStudent.setBorder(new Border(bs));
        lblStudent.setPadding(new Insets(10));

        //创建默认布局方式是水平的分支节点对象
        HBox hPerson = new HBox(10);
        //分支的子节点
        Label lblPerson = new Label("购物者：");
        TextField tfPerson = new TextField();
        tfPerson.setPromptText("购物者姓名");
        //将分支的子节点添加到分支上去
        hPerson.getChildren().addAll(lblPerson, tfPerson);

        //另一个分支对象
        HBox hBuy = new HBox(10);
        //标签对象
        Label lblBuy = new Label("购买商品清单：");
        //文本域对象
        TextField tfBuy = new TextField();
        tfBuy.setPrefWidth(420);
        tfBuy.setPromptText("用逗号分隔的商品名称");
        //将叶子节点添加到父节点上
        hBuy.getChildren().addAll(lblBuy, tfBuy);

        //单独的叶子节点
        Button button = new Button("购买");
        //后面显示购物者及购物清单的信息
        Label lblGet = new Label();

        //创建根结点
        VBox root = new VBox(20);
        //将第二层的节点添加到根结点中
        root.getChildren().addAll(lblStudent, hPerson, hBuy, button, lblGet);
        root.setPadding(new Insets(20.0));
        //设置对齐方式为向上居中
        root.setAlignment(Pos.TOP_CENTER);

        //将根结点添加到scene中并设置scene大小
        Scene scene = new Scene(root, 600, 400);
        //primaryStage设置标题,添加scene对象及展示
        primaryStage.setScene(scene);
        primaryStage.setTitle("超市购物");
        primaryStage.show();

    }


}
