package java6354.newdate;

import javafx.event.ActionEvent;

/**
 * @author Yeah
 * @date 2021/3/24 - 16:20
 */

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;

import java.time.LocalDate;
import java.time.Month;
import java.time.MonthDay;
import java.time.temporal.ChronoUnit;


public class BirthDay6354Controller {
    /**
     * 获取出生日期
     */
    @FXML
    private DatePicker dpBirthDay;

    /**
     * 显示信息
     */
    @FXML
    private Label lblResult;

    @FXML
    void change(ActionEvent event) {
        lblResult.setText("");
        //生日日期
        LocalDate birthDay = dpBirthDay.getValue();
        //处理空输入
        if (birthDay==null) {
            return;
        }
        //提取生日的月份和天
        MonthDay day = MonthDay.from(birthDay);
        //当前日期
        LocalDate date = LocalDate.now();
        //提取当前日期的月份和天
        MonthDay now = MonthDay.from(date);
        if(ChronoUnit.DAYS.between(birthDay,date)<0){
            lblResult.setText("Are you from the future?");
            return;
        }
        //闰年2月29号生日
        if (day.getMonth() == Month.FEBRUARY && day.getDayOfMonth() == 29) {
            //今年是闰年
            if (date.isLeapYear()) {
                //算出今年生日的日期和今天的天数差
                long betweenDays = ChronoUnit.DAYS.between(LocalDate.of(date.getYear(), day.getMonth(), day.getDayOfMonth()), date);
                if (betweenDays == 0) {
                    lblResult.setText("今天是你的生日");
                } else if (betweenDays > 0) {
                    lblResult.setText("你生日已过,在" + LocalDate.of(date.getYear(),day.getMonth(),day.getDayOfMonth()));
                } else {
                    lblResult.setText("你生日将在" + LocalDate.of(date.getYear(),day.getMonth(),day.getDayOfMonth()) + "度过");
                }
            }
            //今年不可能过生日
            else {
                LocalDate tmp = date;
                while (!tmp.isLeapYear()) {
                    tmp = tmp.plusYears(1);
                }
                lblResult.setText("你生日将在" + LocalDate.of(tmp.getYear(), day.getMonth(), day.getDayOfMonth()) + "度过");
            }

        }
        //不是在2月29生日
        else {
            //算出今年生日的日期和今天的天数差
            long betweenDays = ChronoUnit.DAYS.between(LocalDate.of(date.getYear(), day.getMonth(), day.getDayOfMonth()), date);
            if (betweenDays == 0) {
                lblResult.setText("今天是你的生日");
            } else if (betweenDays > 0) {
                lblResult.setText("你生日已过,在" + LocalDate.of(date.getYear(),day.getMonth(),day.getDayOfMonth()));
            } else {
                lblResult.setText("你生日将在" + LocalDate.of(date.getYear(),day.getMonth(),day.getDayOfMonth()) + "度过");
            }
        }

    }

}
