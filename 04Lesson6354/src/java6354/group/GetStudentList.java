package java6354.group;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;


public class GetStudentList {
    public static List<Student6354> getStudentList() {
        Scanner sc = null;
        ArrayList<Student6354> list = new ArrayList<>();
        try {
            sc = new Scanner(new File("04Lesson6354/data/StudentList(one million).txt"));
            while (sc.hasNext()) {
                String line = sc.nextLine();
                list.add(new Student6354(line.split(" ")[1]));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return list;
    }
}
