package java6354.more;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Locale;
public class Calendar6354Controller {
    @FXML
    private DatePicker dpSelect;

    @FXML
    private Label lblMonth;

    @FXML
    private  GridPane gpDayList;
    @FXML
    void initialize(){
        //初始化显示当月的日历
        showCalendar(LocalDate.now());
    }

    @FXML
    void onClick(ActionEvent event) {
        //清空日历
        clear();
        showCalendar(dpSelect.getValue());

    }
    void clear(){
        for(int i=1;i<=6;i++) {
            for(int j=0;j<7;j++) {
                ((Label) (gpDayList.getChildren().get(7 * i + j))).setText("");
            }
        }
    }
    void showCalendar(LocalDate date){
        //得到月对象
        String month = null;
        try {
            //空输入  显示空白日期?
            month = date.getMonth().getDisplayName(TextStyle.FULL, Locale.CHINA);
        } catch (Exception exception) {
            return;
        }
        String strYm = date.format(DateTimeFormatter.ofPattern("yyyy年"+month+"的日历"));
        lblMonth.setText(strYm);
        //获取这个月的天数
        int days = date.lengthOfMonth();
        //获取这个月第一天是星期几
        int day = date.withDayOfMonth(1).getDayOfWeek().getValue();
        ObservableList<Node> labels = gpDayList.getChildren();

        //日期计数器
        int x=1;
        if(day!=7) {
            for(int i=day;i<=6;i++) {
                ((Label) labels.get(7 + i)).setText((x++) + "");
            }
        }
        int row=2,col=0;
        while (x<=days) {
            if(col==7){
                col=0;
                row++;
            }
            ((Label)labels.get(7*row+col++)).setText((x++)+"");
        }

    }
}
