import java.io.File;
import java.util.Arrays;
import java.util.TreeMap;

/**
 * @author yeah
 */
public class FileSummary6354 {
    static File dir;
    static int depth;
    static TreeMap<String, Integer> res = new TreeMap<>();

    static boolean check(String[] args) {
        String path = args[0];
        String depth = args[1];
        File file = new File(path);
        return file.isDirectory() && file.exists() && depth.matches("[1-9]\\d*");

    }

    static void listTopic() {
        System.out.println("=====统计目录的各类文件" + "=====");
        System.out.println("目录: " + dir.getAbsolutePath());
        System.out.println("统计的目录深度: " + depth);
    }

    static void dfs(File dir, int depth) {
        if (depth == 0) {
            return;
        }
        File[] subForD = dir.listFiles();
        if (subForD != null) {
            Arrays.stream(subForD).forEach(f -> {
                if (f.isDirectory()) {
                    dfs(f, depth - 1);
                } else {
                    String[] suffix = f.getName().split("\\.");
                    if (suffix.length == 1) {
                        res.merge("<none>", 1, Integer::sum);
                    } else {
                        res.merge(suffix[suffix.length - 1], 1, Integer::sum);
                    }
                }
            });
        }

    }

    static void listResult() {
        for (String suffix : res.keySet()) {
            System.out.println(suffix + ":" + res.get(suffix));
        }
    }

    public static void main(String[] args) {
        if (args.length == 2 && check(args)) {
            dir = new File(args[0]);
            depth = Integer.parseInt(args[1]);
            listTopic();
            dfs(dir, depth);
            listResult();
        } else {
            System.out.println("wrong parameters");
        }

    }
}
