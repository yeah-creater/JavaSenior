package java6354.task;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;

import java.util.Arrays;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Words6354Controller {
    @FXML
    public ListView<String> lvWords;
    @FXML
    public TextArea taWords;
    @FXML
    public Label lblCount;

    @SuppressWarnings("AlibabaAvoidPatternCompileInMethod")
    @FXML
    public void buttonClick(ActionEvent actionEvent) {
        //去除首尾空格
        String info = taWords.getText().trim();
        String regex="[a-zA-Z]+";
        //模式对象
        @SuppressWarnings("AlibabaAvoidPatternCompileInMethod")
        final Pattern pattern=Pattern.compile(regex);
        //匹配器
        Matcher matcher = pattern.matcher(info);
        //不重复排序集合
        TreeSet<String> tree=new TreeSet<>();
        if(info.isEmpty()){
            lblCount.setText("空值...");
            return;
        }
        while (matcher.find()){
            tree.add(matcher.group().toLowerCase());
        }
        lvWords.getItems().setAll(tree);
        lblCount.setText("有"+tree.size()+"个唯一的单词");
    }
}
