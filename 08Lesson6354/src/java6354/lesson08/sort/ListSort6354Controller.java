package java6354.lesson08.sort;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import java.util.Comparator;
import java.util.List;

/**
 * @author yeah
 */

public class ListSort6354Controller {

    @FXML
    private RadioButton rb1;
    @FXML
    private RadioButton rb2;
    @FXML
    private RadioButton rb3;
    @FXML
    private RadioButton rb4;

    @FXML
    private ToggleGroup tg;

    @FXML
    private ListView<Course6354> lvCourse;



    @FXML
    void initialize(){
        ObservableList<Course6354> items = lvCourse.getItems();
        List<Course6354> list = getCourse6354.getList();
        items.setAll(list);
        tg.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
            //按成绩降序
            if(rb1.isSelected()){
                list.sort(Comparator.comparingInt(Course6354::getScore).reversed());
            }
            //按学期升序
            else if(rb2.isSelected()){
                list.sort(Comparator.comparing(Course6354::getTerm));
            }
            //按学分升序
            else if(rb3.isSelected()) {
                list.sort(Comparator.comparingInt(course6354 -> course6354.getCredit()));
            }
            //按学期升序，学分降序
            else if(rb4.isSelected()){
                //2个reverse负负得正
                list.sort(Comparator.comparing(Course6354::getTerm).reversed().
                thenComparingInt(Course6354::getCredit).reversed());

            }
            items.setAll(list);

        });
    }

}
