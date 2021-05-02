package java6354.lesson03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
/**
 * @author Yeah
 * @date 2021/3/24 - 13:28
 */
public class LastDay6354 {
    static String getLastDay(String strDate) {
        //删除空格
        strDate = strDate.replaceAll(" +", "");
        //创建解析对象
        DateTimeFormatter dtf = null;
        try {
            dtf = DateTimeFormatter.ofPattern("yyyy-M");
            //获取年月对象
            YearMonth ym = YearMonth.from(dtf.parse(strDate));
            return ym.lengthOfMonth()+"";
        } catch (Exception exception) {
            return null;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("计算某月的最后一天");
        System.out.print("请按yyyy-M的格式输入:");
        String strDate=br.readLine();
        System.out.println("该月最后一天是:"+getLastDay(strDate));

    }
}
