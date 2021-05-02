package java6354.newdate;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.input.MouseEvent;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import java.time.temporal.TemporalAdjusters;

/**
 * @author Yeah
 * @date 2021/3/24 - 15:18
 */

/**
 * fxml文件的映射对象
 */
public class MothersDay6354Controller {
    /**
     * 有参与到逻辑判断的组件
     */
    @FXML
    private Spinner<Integer> sYear;
    @FXML
    private Label lblMothersDay;

    /**
     * 显示sYear年的母亲节
     */
    @FXML
    void buttonClick(MouseEvent event) {
        //获取年份
        Integer year = sYear.getValue();
        LocalDate date = LocalDate.of(year, 5, 1);
        //5月的第二个星期日是母亲节 ->五月的第一个星期日在加7天
        date = date.with(TemporalAdjusters.firstInMonth(DayOfWeek.SUNDAY)).plusDays(7);
        //格式化对象
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy年M月d日 EEE");
        //将母亲节显示在公屏上
        lblMothersDay.setText(dtf.format(date));
    }
}

