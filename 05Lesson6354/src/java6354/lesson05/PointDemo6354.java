package java6354.lesson05;

import java.util.*;

/**
 * @purpose: 验证课堂小测
 */
public class PointDemo6354 {
    static Collection<Point6354> collection;
    public static class Point6354 implements Comparable<Point6354> {
        private int x;
        private int y;

        public Point6354(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Point6354 point6354 = (Point6354) o;
            return Objects.equals(x, point6354.x) &&
                    Objects.equals(y, point6354.y);
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

        //按照从小到大排序  返回0代表相等(去重的时候注意)
        @Override
        public int compareTo(Point6354 p) {
            int t = x - p.x;
            return t == 0 ? y - p.y : t;
        }

        @Override
        public String toString() {
            return "(" + x + "," + y + ")";
        }

        static void demo1() {
            System.out.println("第一题答案:" + collection.contains(new Point6354(13, 15)));
        }

        static void demo2() {
            System.out.println("第二题答案:" + collection);
        }

        static void demo3() {
            System.out.println("第三题答案:" + collection);
        }

        public static void main(String[] args) {
            //********************************************
            collection = new ArrayList<>();
            collection.add(new Point6354(1, 2));
            collection.add(new Point6354(21, 31));
            collection.add(new Point6354(11, 15));
            collection.add(new Point6354(1, 2));
            collection.add(new Point6354(21, 17));
            collection.add(new Point6354(13, 15));
            //*********************************************
            System.out.println("重写HashCode和equals后......");
            demo1();
            //********************************************
            collection=new HashSet<>(collection);
            System.out.println("HashSet修改后......");
            demo2();
            //*******************************************
            System.out.println("TreeSet修改后......");
            Collection<Point6354> temp=new HashSet<>(collection);
            collection = new TreeSet<>(Point6354::compareTo);
            collection.addAll(temp);
            demo3();
        }
    }
}
