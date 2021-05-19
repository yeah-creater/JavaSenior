package java6354.data;

import java.io.*;

public class StudyObjectData6354 {
    public static void writeStudent6354() {
        try(ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream(new File("student.dat")))){
            oos.writeObject(new Student6354("ybz",20));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void readStudent6354() {
        File file = new File("student.dat");
        if(!file.exists()){
            System.out.println("文件不存在");
            return;
        }
        try(ObjectInputStream ois=new ObjectInputStream(new FileInputStream(file))){
            Student6354 stu = (Student6354)ois.readObject();
            System.out.println(stu);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        //writeStudent6354();
        readStudent6354();
    }
}
