package _01multiThreading.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Yeah
 * @date 2021/1/17 - 16:56
 * @intention:
 */
public class ThreadPool {
    public static void main(String[] args) {
        //线程池
        ExecutorService service = Executors.newFixedThreadPool(8);
        //适用于Runnable
        service.submit(new Runnable() {
            @Override
            public void run() {
                for(int i=1;i<=100;i++){
                    System.out.println(i);
                }
            }
        });
        System.out.println("hello");
        service.shutdown();
    }
}
