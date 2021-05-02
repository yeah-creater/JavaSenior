package java6354.lesson01;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

import java.time.LocalDateTime;
import java.util.*;

/**
 * @author Yeah
 * @date 2021/3/10 - 9:15
 */
public class Shopping6354 extends Application {
    private Stage primaryStage;
    private static Market6354 market;

    static {
        //初始化XXX超市和库存
        HashMap<Product6354, Integer> pLeft = new HashMap<>();
        pLeft.put(new Product6354("牙膏"), 2);
        pLeft.put(new Product6354("沐浴露"), 30);
        pLeft.put(new Product6354("牙刷"), 12);
        pLeft.put(new Product6354("电视机"), 18);
        pLeft.put(new Product6354("电风扇"), 45);
        market = new Market6354("永辉超市", pLeft);

    }

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        VBox root = new VBox(20);

        //窗口栏
        javafx.scene.control.Label lblMarket = new javafx.scene.control.Label("永辉超市");
        BorderStroke bs = new BorderStroke(Paint.valueOf("#8FBC8F")
                , BorderStrokeStyle.DOTTED
                , new CornerRadii(10)
                , new BorderWidths(3));
        lblMarket.setBorder(new Border(bs));
        lblMarket.setPadding(new javafx.geometry.Insets(10));
        //商品栏
        HBox hProduct = new HBox(10);
        Label gL = new Label(market.getProductLeft().keySet().toString());
        hProduct.getChildren().add(gL);

        //购物者一栏
        HBox hPerson = new HBox(10);
        javafx.scene.control.Label lblPerson = new javafx.scene.control.Label("购物者：");
        javafx.scene.control.TextField tfPerson = new javafx.scene.control.TextField();
        tfPerson.setPromptText("购物者姓名");
        hPerson.getChildren().addAll(lblPerson, tfPerson);

        //购物商品栏
        HBox hBuy = new HBox(10);
        javafx.scene.control.Label lblBuy = new javafx.scene.control.Label("购买商品清单：");
        javafx.scene.control.TextField tfBuy = new javafx.scene.control.TextField();
        tfBuy.setPrefWidth(420);
        tfBuy.setPromptText("用英文逗号分隔的商品名称");
        hBuy.getChildren().addAll(lblBuy, tfBuy);

        //按钮栏
        HBox hButton = new HBox(10);
        javafx.scene.control.Button buy = new javafx.scene.control.Button("购买");
        Button clear = new Button("清空消息");
        Label inf = new Label("消息窗口");
        hButton.getChildren().addAll(buy, inf, clear);
        hButton.setAlignment(Pos.CENTER);
        TextArea infArea = new TextArea();
        infArea.setEditable(false);

        //套娃
        root.getChildren().addAll(lblMarket, hProduct, hPerson, hBuy, hButton, infArea);
        root.setPadding(new Insets(10.0));
        root.setAlignment(Pos.TOP_CENTER);


        Scene scene = new Scene(root, 600, 500);
        primaryStage.getIcons().add(new Image("java6354/lesson01/logo.jpg"));
        primaryStage.setScene(scene);
        primaryStage.setTitle("超市购物");
        primaryStage.show();

        buy.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                List<Product6354> list = new ArrayList<>();
                String[] goods = tfBuy.getText().split(",");
                String name = tfPerson.getText();
                if ("".equals(name) || "".equals(tfBuy.getText())) {
                    infArea.appendText("请输入姓名或购物清单\n");
                } else {
                    Person6354 person = new Person6354(name);
                    for (int i = 0; i < goods.length; i++) {
                        list.add(new Product6354(goods[i]));
                    }
                    if ("下单成功".equals(person.shopping(market, list))) {
                        infArea.appendText("下单成功\n");
                        infArea.appendText("正在进入支付页面...\n");
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        infArea.appendText("支付成功\n");
                        infArea.appendText(person.getName() + "在永辉超市购物清单:\n" + list.toString() + "\n");
                    } else {
                        infArea.appendText(person.shopping(market, list) + "\n");
                    }
                    infArea.appendText(LocalDateTime.now() + "\n" + "---------------------------\n");
                }
            }
        });
        clear.setOnAction((e) -> infArea.clear());

    }

}
