package java6354.sort.list;

import java6354.sort.Course6354;
import java6354.sort.SortByCredit6354;
import java6354.sort.SortByMore6354;
import java6354.sort.getCourse6354;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ListSort6354Controller {
    @FXML
    private RadioButton desByMark;

    @FXML
    private RadioButton asByTerm;

    @FXML
    private RadioButton asByCredit;

    @FXML
    private RadioButton asByBoth;

    @FXML
    private ListView<Course6354> lvCourse;

    List<Course6354> listCourse;

    @FXML
    public void initialize() {
        //设置监听
        InvalidationListener listener = new InvalidationListener() {
            @Override
            public void invalidated(Observable observable) {
                if (desByMark.isSelected()) {
                    descentByScore();
                } else if (asByTerm.isSelected()) {
                    ascentByTerm();
                } else if (asByCredit.isSelected()) {
                    ascentByCredit();
                } else {
                    ascentByTAndC();
                }
                lvCourse.getItems().setAll(listCourse);
            }
        };
        desByMark.selectedProperty().addListener(listener);
        asByTerm.selectedProperty().addListener(listener);
        asByCredit.selectedProperty().addListener(listener);
        asByBoth.selectedProperty().addListener(listener);
        listCourse = getCourse6354.getList();
        lvCourse.getItems().setAll(listCourse);
    }

    //按成绩降序 使用自然排序
    public void descentByScore() {
        Collections.sort(listCourse);
    }

    //按学期升序 使用比较器排序 使用匿名内部类
    public void ascentByTerm() {
        listCourse.sort(new Comparator<Course6354>() {
            @Override
            public int compare(Course6354 o1, Course6354 o2) {
                return o1.getTerm().compareTo(o2.getTerm());
            }
        });
    }

    //按学分升序 使用比较器排序 使用比较器类SorterByCreditXXXX
    public void ascentByCredit() {
        listCourse.sort(new SortByCredit6354());
    }

    //按学期、学分多关键字排序（升序）
    //使用比较器排序
    //使用方法引用
    public void ascentByTAndC() {
        listCourse.sort(SortByMore6354::compare);
    }

}
