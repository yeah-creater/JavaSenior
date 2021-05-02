package java6354.lesson08.filter;

import java.io.File;
import java.time.LocalDateTime;
import java.time.ZoneId;

/**
 * @author: yeah
 */
public class Filters {
    static boolean filterByType(File dir, String name){
        return name.endsWith(".java");
    }
    static boolean filterBySize(File dir, String name){
        File file = new File(dir, name);
        return file.isFile()&file.length() > 2048;
    }
    static boolean filterByModified(File dir, String name){
        File file = new File(dir, name);
        //三天前
        LocalDateTime localDateTime = LocalDateTime.now().minusDays(3);
        long milli = localDateTime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
        return file.isFile()&file.lastModified()>milli;
    }
}
