package readandwrite.javase.io;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName File
 * @Description ⽂文件API使⽤用，简单递归逻辑代码编写、代码编写规范，简洁性
 * @Date 2021/12/19 11:11
 * @Version 1.0
 **/
public class FileAPI {

    public static void main(String[] args) {
        ArrayList<String> paths = new ArrayList<>();
        getAllPath(new File("C:\\Users\\zzohn\\Desktop\\"), paths);
        for (String path : paths) {
            System.out.println(paths);
        }
    }


    public static void getAllPath(File filePath, List<String> paths) {
        File[] files = filePath.listFiles();
        if (files == null) {
            return;
        }

        for (File file : files) {
            if (file.isDirectory()) {
                paths.add(file.getPath());
                getAllPath(file, paths);
            } else {
                paths.add(file.getPath());
            }
        }
    }
}
