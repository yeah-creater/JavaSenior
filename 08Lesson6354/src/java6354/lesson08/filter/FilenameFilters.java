package java6354.lesson08.filter;

import java.io.File;
import java.io.FilenameFilter;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

/**
 * @author yeah
 */
public class FilenameFilters {
    static void pack(String path,ArrayList<StringBuilder> list,String[] list1,String[] list2,String[] list3){
        list.add(new StringBuilder("(1)后缀为java的文件: "+list1.length));
        for(String name:list1) {
            list.add(new StringBuilder(new StringBuilder(path+"\\").append(name)));
        }
        list.add(new StringBuilder("(2)大于2k的文件: "+list2.length));
        for(String name:list2) {
            list.add(new StringBuilder(new StringBuilder(path+"\\").append(name)));
        }
        list.add(new StringBuilder("(3)3天前到现在修改的文件: "+list3.length));
        for(String name:list3) {
            list.add(new StringBuilder(new StringBuilder(path+"\\").append(name)));
        }
    }
    /**
     * 用匿名内部类实现文件过滤器接口FilenameFilter
     */
    static List<StringBuilder> inter6354(String path) {
        File file = new File(path);
        ArrayList<StringBuilder> list = new ArrayList<>();
        file.list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return false;
            }
        });
        String[] list1 = file.list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith(".java");
            }
        });


        String[] list2 = file.list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                File file = new File(dir, name);
                return file.isFile()&file.length() > 2048;
            }
        });
        String[] list3 = file.list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                File file = new File(dir, name);
                //三天前
                LocalDateTime localDateTime = LocalDateTime.now().minusDays(3);
                long milli = localDateTime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
                return file.isFile()&file.lastModified()>milli;
            }
        });
        assert list1 != null;
        pack(path,list,list1,list2,list3);
        return list;

    }

    /**
     * 用Lambda表达式实现文件过滤器接口FilenameFilter
     */
    static List<StringBuilder> lambda6354(String path) {
        File file = new File(path);
        ArrayList<StringBuilder> list = new ArrayList<>();
        String[] list1 = file.list((dir, name) -> name.endsWith(".java"));

        String[] list2 = file.list((dir, name) -> {
            File file1 = new File(dir, name);
            return file1.isFile()& file1.length() > 2048;
        });
        String[] list3 = file.list((dir, name) -> {
            File file12 = new File(dir, name);
            //三天前
            LocalDateTime localDateTime = LocalDateTime.now().minusDays(3);
            long milli = localDateTime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
            return file12.isFile()& file12.lastModified()>milli;
        });
        assert list1 != null;
        pack(path,list,list1,list2,list3);
        return list;
    }

    /**
     * referenceXXXX方法：用方法引用实现文件过滤器接口FilenameFilter
     */
    static List<StringBuilder> reference6354(String path) {
        File file = new File(path);
        ArrayList<StringBuilder> list = new ArrayList<>();
        String[] list1 = file.list(Filters::filterByType);
        String[] list2 = file.list(Filters::filterBySize);
        String[] list3 = file.list(Filters::filterByModified);
        assert list1 != null;
        pack(path,list,list1,list2,list3);
        return list;
    }

}
