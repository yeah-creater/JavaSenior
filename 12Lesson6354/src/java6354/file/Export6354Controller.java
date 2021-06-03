package java6354.file;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

/**
 * @author yeah
 */
public class Export6354Controller {

    @FXML
    private TextField tfDir;

    @FXML
    private TextField tfSuffix;

    @FXML
    private Button btnExport;

    @FXML
    private Label lblExport;

    /**
     * （1）“选择主目录”按钮，弹出窗口选择目录
     * （2）文件名后缀文本框中，以空格分隔输入一组文件名后缀
     * （3）“导出文件”按钮，弹出对话框，将符合要求的文件名导出到指定的文本文件中
     */
    @FXML
    File chooseDirectory() {
        DirectoryChooser dc = new DirectoryChooser();
        dc.setTitle("请选择目录");
        dc.setInitialDirectory(new File("."));
        return dc.showDialog(new Stage());
    }

    @FXML
    void openDirectory() {
        File dir = chooseDirectory();
        if (dir != null) {
            //设置可按按钮
            btnExport.setDisable(false);
            tfDir.setText(dir.getAbsolutePath());
        }
    }

    @FXML
    void saveToDirectory(String[] kinds) {
        //保存到的目录文件
        File dir = chooseDirectory();
        if (dir != null) {
            selectFile(dir, kinds);
        }
    }

    @FXML
    boolean checkPost(File file, String[] kinds) {
        if (tfSuffix.getText().trim().isEmpty()) {
            return true;
        }
        return Arrays.stream(kinds).anyMatch(k -> file.getName().endsWith(k));
    }

    @FXML
    void selectFile(File desDir, String[] kinds) {
        String path = tfDir.getText();
        File dir = new File(path);
        String desPath = desDir.getAbsolutePath();
        AtomicInteger cnt = new AtomicInteger();
        try (Stream<Path> files = Files.list(dir.toPath())) {
            Stream<Path> dirStream = files.filter(f -> new File(f.toFile().getAbsolutePath()).isDirectory());
            dirStream.forEach(f -> {
                File subDir = new File(f.toFile().getAbsolutePath());
                File[] subSubFiles = subDir.listFiles();
                if (subSubFiles != null) {
                    //保存到目标文件&&统计数量
                    Arrays.stream(subSubFiles).filter(ff -> checkPost(ff, kinds) && ff.isFile()).forEach(fff -> {
                        String filePath = desPath + "/" + fff.getName();
                        String srcPath = fff.getAbsolutePath();
                        //文件名相同我就偷个懒 覆盖了
                        try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(filePath));
                             BufferedInputStream bis = new BufferedInputStream(new FileInputStream(srcPath))) {
                            byte[] data = new byte[1024];
                            cnt.getAndIncrement();
                            int len;
                            while ((len = bis.read(data)) != -1) {
                                bos.write(data, 0, len);
                            }

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    });

                }
            });
            lblExport.setText("导出文件名:" + cnt);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * （1）文件位置：主目录下所有第一级子目录中的文件，但不包含主目录中的文件
     * （2）文件筛选：如果如下图所示，输入了文件名后缀，则导出*.txt、*.java的文件名，否则，导出所有文件
     */

    @FXML
    void export(ActionEvent event) {
        String[] kinds = tfSuffix.getText().trim().split(" +");
        saveToDirectory(kinds);

    }

    @FXML
    void getDir(ActionEvent event) {
        openDirectory();
    }

}
