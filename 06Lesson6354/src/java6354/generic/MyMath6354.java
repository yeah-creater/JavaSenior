package java6354.generic;

/**
 * @purpose:自定义泛型类
 */
public class MyMath6354<T extends Comparable<? super T>>{
    T t1;
    T t2;
    public MyMath6354(T t1, T t2) {
        System.out.println("测试的对象"+t1.getClass());
        this.t1 = t1;
        this.t2 = t2;
    }

    public T max6354(){
        return t1.compareTo(t2)>0?t1:t2;
    }
    public T min6354(){
        return t1.compareTo(t2)<0?t1:t2;
    }
    
}
