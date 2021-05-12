package java6354.lesson09;


import org.junit.Test;

import java.io.*;
import java.time.LocalDateTime;

public class Demo {
    @Test
   public void test01() {
        File file = new File("a.txt");

        FileOutputStream fos = null;
        {
            try {
                fos = new FileOutputStream(file);
                try {
                    fos.write(Double.toString(12.67).getBytes() );
                    fos.write(LocalDateTime.now().toString().getBytes());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } finally {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    @Test
    public void test02() throws IOException {
        File file=new File("D:\\JavaSenior\\a.txt");
        FileInputStream fis=new FileInputStream(file);
        byte [] data=new byte[1024];
        int len=0;
        while((len=fis.read(data))!=-1){

            System.out.println(new String(data,0,len));

        }

    }
    @Test
    public void test03(){
    }
    @Test
    public void test04(){
      try( FileInputStream fis=new FileInputStream(new File("a.txt"));
           FileOutputStream fos=new FileOutputStream(new File("b.txt"))){

      } catch (FileNotFoundException e) {
          e.printStackTrace();
      } catch (IOException e) {
          e.printStackTrace();
      }
    }


}

