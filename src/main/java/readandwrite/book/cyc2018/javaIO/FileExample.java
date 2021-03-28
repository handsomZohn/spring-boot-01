package readandwrite.book.cyc2018.javaIO;

import java.io.File;

/**
 *@Description  递归的输入一个目录下所有文件
 *@CreateDate   18/07/18 9:58
 *@Author        zohn
 *@Version       1.0
 *
 */
public class FileExample {
    public static void main(String[] args) {
        // File可用于表示文件和目录 只用于表示文件的信息 不表示文件的内容
        File dir = new File("d:/upload");
        listAllFiles(dir);
    }



    static void listAllFiles(File dir) {
        if (dir.isFile()) {
            System.out.println(dir.getName());
            return;
        }
        for (File file : dir.listFiles()) {
            listAllFiles(file);
        }
    }
}
