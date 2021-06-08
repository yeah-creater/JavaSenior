package _01multiThreading.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author Yeah
 * @date 2021/1/17 - 16:15
 * @intention:
 *
 * 如何理解实现 CalLable接口的方式创建多线程比实现 RunnabLe接口创建多线程方式强大?
 * 1.caLL()可似有返回值的
 * 2.caLL()可以抛出异常,被外面的操作捕获,获取异常的信息
 * 3. Callable是支持泛型的
 */
public class ID11MyCallable implements Callable {
    @Override
    public Object call() throws Exception {
        for(int i=0;i<100;i++){
            if(i%2==0){
                System.out.println(i);
            }
        }
        return null;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ID11MyCallable idMyCallable = new ID11MyCallable();
        FutureTask futureTask = new FutureTask(idMyCallable);
        new Thread(futureTask).start();

    }
}
