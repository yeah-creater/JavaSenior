package java6354.lesson03;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 * @author Yeah
 * @date 2021/3/24 - 12:49
 */
public class EndDate6354 {
    static String calc6354(String start) {
        //删除空格
        start = start.replaceAll(" +", "");
        //创建解析对象
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        //获取开工日期
        LocalDate strDate = null;
        try {
            strDate = LocalDate.from(dtf.parse(start));
            //判断输入的日期月份对应的天数是否合法
            //if (!dtf.format(strDate).equals(start)) return null;

        } catch (Exception exception) {
            return null;
        }
        //获取结业日期
        LocalDate endDate = strDate.plusDays(15);
        //创建格式化对象
        dtf = DateTimeFormatter.ofPattern("yyyy年M月d日 EEE");
        //格式化结业日期
        return dtf.format(endDate);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("请按yyyy-MM-dd的格式输入开班日期:");
        String strDate = br.readLine();
        String date = calc6354(strDate);
        System.out.println("结业日期是:"+date);
    }
}
