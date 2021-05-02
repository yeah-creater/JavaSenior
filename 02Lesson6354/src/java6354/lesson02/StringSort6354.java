package java6354.lesson02;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import java.util.Arrays;
/**
 * @author Yeah
 * @date 2021/3/17 - 9:12
 */
public class StringSort6354 extends Application {
    static int[] q;
    //快排模板
    static void quickSort(int l, int r) {
        if(l>=r) {
            return;
        }
        int i=l-1,j=r+1,x=q[l+r>>1];
        while (i<j){
            do {
                i++;
            } while (q[i]<x);
            do {
                j--;
            } while (q[j]>x);
            if(i<j){
                int tmp=q[i];
                q[i]=q[j];
                q[j]=tmp;
            }
        }
        quickSort(l,j);
        quickSort(j+1,r);
    }
    @Override
    public void start(Stage primaryStage) {
        Template.newInstance(primaryStage,"字符串中的数字排序","211906354:叶本章",
                "输入数字串:","排序");
        Template.bt.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //获取文本域
                String digitText = Template.tf.getText();
                String regex="[^\\d|-]+";
                String[] digit = digitText.split(regex);
                q=new int[digit.length];
                try {
                    for(int i=0;i<q.length;i++) {
                        q[i]=Integer.parseInt(digit[i]);
                    }
                    quickSort(0,q.length-1);
                    Template.res.setText("排序结果:"+Arrays.toString(q));
                } catch (NumberFormatException e) {
                    Template.res.setText("输入格式错误");
                }
            }
        });
    }
    public static void main(String[] args) {
        launch();
    }
}
