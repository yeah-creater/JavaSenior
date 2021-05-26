package java6354.lesson11;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.stream.IntStream;

/**
 * @author yeah
 */
public class BatchDemo6354 {

    public static void main(String[] args) throws Exception {
        Connection conn = JdbcUtils.getDriverConnection();
        // （3）执行SQL语句
        String sql = "INSERT INTO  xslist (SNO, SNAME) VALUES (?,?);";
        //默认自动提交自动提交事务，每次成功地执行一个SQL语句时，就会向数据库自动提交
        //开启事务（取消自动提交事务）
        conn.setAutoCommit(false);
        JdbcUtils.ps = conn.prepareStatement(sql);
        Files.lines(Paths.get("data/StudentList.txt")).forEach(line -> {
            String[] datas = line.trim().split(" ");
            try {

                JdbcUtils.ps.setString(1, datas[0]);
                JdbcUtils.ps.setString(2, datas[1]);
                //添加到批处理中（批量传参）
                JdbcUtils.ps.addBatch();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
        //批量执行
        int[] results = JdbcUtils.ps.executeBatch();
        //提交事务
        conn.commit();
        //恢复自动提交事务
        conn.setAutoCommit(true);

        // （4）关闭资源
        JdbcUtils.releaseResources();
        //使用Stream统计执行结果（下一次课介绍）
        int success = IntStream.of(results).filter(n -> n > 0).sum();
        long fail = IntStream.of(results).filter(n -> n < 0).count();
        System.out.println(String.format("成功添加：%d，失败：%d", success, fail));
    }
}