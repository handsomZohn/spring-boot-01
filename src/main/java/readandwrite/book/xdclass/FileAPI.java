package readandwrite.book.xdclass;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 *@Description 找出某目录下的所有子目录以及子文件并打印到控制台上
 *@CreateDate 2020\3\13 0013 11:05
 *@Author zohn
 *@Version 1.0
 */
public class FileAPI {
    public static void main(String[] args) {

        List<String> paths = new ArrayList<>();

        getAllFilePaths(new File("D:\\zohn"), paths);

        for (String path : paths) {
            System.out.println(path);
        }
    }

    /**
     * @Description 获取所有文件的路径
     * @Author zohn
     * @Date 2020\3\13 0013 11:09
     * @Param [filePath, paths]
     * @Return void
     */
    private static void getAllFilePaths(File filePath, List<String> paths) {
        File[] files = filePath.listFiles();
        if (files == null) {
            return;
        }
        for (File f : files) {
            if (f.isDirectory()) {
                paths.add(f.getPath());
                getAllFilePaths(f, paths);// 递归调用
            } else {
                paths.add(f.getPath());
            }
        }
    }
}
