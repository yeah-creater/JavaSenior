package java6354.ktv;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * @purpose:控制器类KTVSelectXXXXController
 */

/**
 * 实验要求
 * （1）基于FXML创建JavaFX窗口，即创建FXML文件KTVSelectXXXXView.fxml、
 * 控制器类KTVSelectXXXXController、启动类KTVSelectXXXX
 * （2）打开窗口时在ListView中显示所有曲目
 * （3）添加歌曲：把新的歌曲添加ListView当前选中项的前面
 * （4）歌曲置顶：把ListView当前选中项的歌曲放到列表的首位
 * （5）上移一首：把ListView当前选中项的歌曲在列表中提前一位
 * （6）下移一首：把ListView当前选中项的歌曲在列表中后移一位
 * （7）对于不符合逻辑的情况，弹出窗口给予提示
 */
class People{
    String name;

    public People(String name) {
        this.name = name;
    }
}
public class KTVSelect6354Controller {
    public static final int EMPTY = -1;
    public static final int TOP = 0;

    @FXML
    private TextField tfNewName;

    @FXML
    private ListView<String> lvNames;

    //初始化歌单列表
    @FXML
    public void initialize() {
//        List<People> list=new ArrayList<>();
//        list.add(new People("zs"));
//        lvNames.getItems().setAll(list);
//        lvNames.getItems().set(0,new People("ls"));
//        System.out.println(list.get(0).name);
//        System.out.println(list.hashCode()==lvNames.getItems().hashCode());
//        lvNames.getItems().set(0,new People("ls"));
//        System.out.println(list.hashCode()==lvNames.getItems().hashCode());
//        System.out.println(list.get(0).hashCode()==lvNames.getItems().get(0).hashCode());

        List<String> list = Arrays.asList("大鱼", "不分手的恋爱", "说好不哭", "那女孩对我说", "那个男孩", "就这样");
        lvNames.getItems().addAll(list);
        list.set(1,"哈哈哈");
        System.out.println(lvNames.getItems().get(1));
//        lvNames.getItems().set(1,"分手的恋爱");
//        System.out.println(Arrays.toString(list.toArray()));
//        lvNames.getItems().addAll(list);
//        lvNames.getSelectionModel().select(0);
    }
    @FXML
    public void alertTips(String warning) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("KTV点歌");
        alert.setHeaderText("Attention!");
        alert.setContentText(warning);
        alert.show();
    }

    @FXML
    public boolean isEmptyList() {
        if (lvNames.getItems().size() == 0) {
            alertTips("当前歌单为空");
            return true;
        }
        return false;
    }

    @FXML
    public boolean isTop(String warning) {
        if (lvNames.getFocusModel().getFocusedIndex() == TOP) {
            alertTips(warning);
            return true;
        }
        return false;
    }

    @FXML
    public boolean isBottom() {
        if (lvNames.getFocusModel().getFocusedIndex() == lvNames.getItems().size() - 1) {
            alertTips("当前歌曲不能再下移啦!");
            return true;
        }
        return false;
    }

    @FXML
    public void changeLocation(ActionEvent event) {
        Button button = (Button) event.getSource();
        String source = button.getText();
        int insertOffset = 0, removeOffset = 0;
        if ("下移一首".equals(source)) {
            insertOffset = 2;
        } else if ("上移一首".equals(source)) {
            insertOffset = -1;
            removeOffset = 1;
        }
        else if("置顶".equals(source)){
            insertOffset=-lvNames.getFocusModel().getFocusedIndex();
            removeOffset= 1;
        }
        //获取选中项的索引及  和插入的索引
        int index = lvNames.getFocusModel().getFocusedIndex();
        int insertIndex = index + insertOffset;//(插入操作是前插)
        //获取选中项的值
//        String value = lvNames.getFocusModel().getFocusedItem();
//        //插入新的选中项
//        lvNames.getItems().add(insertIndex, value);
//        //删除旧的选中项
//        lvNames.getItems().remove(index + removeOffset);
//        //原来的歌名还是处于被选中状态
//        lvNames.getSelectionModel().select(value);
    }

    @FXML
    void addClick(ActionEvent event) {
        //对输入框内容的合法性进行判断
        String song = tfNewName.getText().replaceAll(" +", "");

        if ("".equals(song)) {
            alertTips("请不要输入空格或空值!");
            return;
        }
        //判断当前加入的歌曲是否已存在(输入标点符号等暂未考虑)
        if (lvNames.getItems().contains(song)) {
            alertTips("【" + song + "】" + "已在歌单中!");
            return;
        }
        //获取选中项的索引
        int index = lvNames.getSelectionModel().getSelectedIndex();
        //若原歌单为空,index移到首位
        if (index == EMPTY) {
            index++;
        }
//        lvNames.getItems().add(index, song);
        //增加新的歌名后，使新歌名处于被选中状态
        lvNames.getSelectionModel().select(index);
    }

    @FXML
    void downClick(ActionEvent event) {
        //短路或 进行判断歌单为空及选中项已到边界
        if (isEmptyList() | isBottom()) {
            return;
        }
        changeLocation(event);

    }

    @FXML
    void upClick(ActionEvent event) {
        if (isEmptyList() | isTop("当前歌曲不能再上移啦!")) {
            return;
        }
        changeLocation(event);
    }

    @FXML
    void topClick(ActionEvent event) {
        if (isEmptyList() | isTop("当前歌曲已置顶!")) {
            return;
        }
        changeLocation(event);
    }
}


