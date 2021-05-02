package java6354.lesson04;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * @purpose:编写事件处理程序 要求:
 * （1）基于FXML创建JavaFX窗口，即创建FXML文件ListFilterXXXX.fxml、控制器类ListFilterXXXXController、启动类ListFilterXXXX
 * （2）随机产生20个[60,100]的整数，并显示在左边的ListView中
 * （3）统计其中是5的倍数的数据个数，并显示到右边的ListView中
 */
public class ListFilter6354Controller {
    public static final int SIZE = 20;
    @FXML
    private ListView<Integer> lvAll;
    @FXML
    private Label lbl5;
    @FXML
    private ListView<Integer> lv5;
    List<Integer> llsAll;
    List<Integer> lls5;

    //createListXXXX方法：负责随机产生20个[60,100]的整数，存储到集合中
    public void createList6354() {
        llsAll = new ArrayList<>();
        for (int i = 0; i < SIZE; i++) {
            llsAll.add((int)(Math.random()*61)+40);
        }
        //调用ListView的getItem方法，得到ObservableList<T>
        ObservableList<Integer> nodes = lvAll.getItems();
        //调用ObservableList<T>的addAll方法，将List<T>添加到ObservableList<T>
        nodes.addAll(llsAll);

    }

    //findListXXXX方法：负责从一个集合中提取5的倍数的数据，放到另一个集合
    public void findList6354() {
        lls5 = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            if (llsAll.get(i) % 5 == 0) {
                lls5.add(llsAll.get(i));
            }
        }
        //调用ListView的getItem方法，得到ObservableList<T>
        ObservableList<Integer> nodes = lv5.getItems();
        //调用ObservableList<T>的addAll方法，将List<T>添加到ObservableList<T>
        nodes.addAll(lls5);
    }

    @FXML
    public void buttonClick(ActionEvent actionEvent) {
        lvAll.getItems().clear();
        lv5.getItems().clear();
        createList6354();
        findList6354();
    }
}
