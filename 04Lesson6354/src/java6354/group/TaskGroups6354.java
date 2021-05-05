package java6354.group;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.security.Signature;
import java.util.ArrayList;


/**
 * @author yeah
 */
public class TaskGroups6354 {
    static int SIZE;
    static int left;
    static ArrayList<Student6354> allStudents;//存储所有学生
    static ArrayList<ArrayList<Student6354>> groups;//存储所有小组
    static ArrayList<Integer> groupsCnt;//每组的数量
    static boolean[] isOk;//记录已经分配好的编号
    static final int T1=5;
    static final int T2=6;
    static final int T3=7;

    /**
     *
     * @param left 剩余人数
     * @return 剩余人数是否可以用5~7凑出
     */
    public boolean isOk(int left) {
        if(left<0) {
            return false;
        }
        //5,6,7不能凑出的数就这些
        return !(left==1||left==2||left==3||left==4||left==8||left==9);
    }

    /**
     * @return 返回某组随机且合法的人数
     */
    public int getRandomValidCnt() {
        while (true) {
            int cnt = (int) (Math.random() * 3) + 5;
            left -= cnt;
            if (isOk(left)) {
                return cnt;
            }
            left += cnt;
        }
    }

    /**
     * @return 返回未分配且随机的学生编号
     */
    public int getRandomValidId() {
        while (true) {
            int id = (int) (Math.random() * SIZE);
            if (!isOk[id]) {
                return id;
            }
        }
    }

    /**
     * 初始化学生集合
     */
    public void initialize() {
        allStudents = (ArrayList<Student6354>) GetStudentList.getStudentList();
        SIZE = allStudents.size();
        left = SIZE;
        groups = new ArrayList<>();
        isOk = new boolean[SIZE];
        groupsCnt = new ArrayList<>();
    }


    /**
     * @param cnt 当前小组随机分配人数
     */
    public void divide(int cnt) {
        ArrayList<Student6354> group = new ArrayList<>();
        for (int i = 0; i < cnt; i++) {
            int id = getRandomValidId();
            group.add(allStudents.get(id));
            isOk[id] = true;
        }
        groups.add(group);
        groupsCnt.add(cnt);
    }

    /**
     * 得到分组
     */
    public void divide() {
        //已分配的学生数量
        int okCnt = 0;
        while (okCnt < SIZE) {
            //合法的小组人员数量
            int cnt = getRandomValidCnt();
            divide(cnt);
            okCnt += cnt;
        }
    }

    /**
     * 展示每个小组的信息
     */
    public void show() throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write("班级人数: " + SIZE + "\n");
        bw.write("经过一次循环,得到分组方案:分为" + groupsCnt.size() + "组 " + groupsCnt + "\n");
        int index = 0;
        for (ArrayList<Student6354> group : groups) {
            bw.write("第" + (index + 1) + "组:" + group + " " + groupsCnt.get(index++) + "人" + "\n");
        }
        bw.flush();
    }

    /**
     * 组装方法
     */
    public void work() {
        initialize();
        long start = System.currentTimeMillis();
        divide();
        try {
            show();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        System.out.println("数据量:"+SIZE);
        long end = System.currentTimeMillis();
        long time=(end-start);
        System.out.println("耗时(读取文件不计入)："+time+"ms");
        System.out.println("over!!!");
    }
}
