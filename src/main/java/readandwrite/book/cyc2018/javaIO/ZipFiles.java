package readandwrite.book.cyc2018.javaIO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * @Description 指定几个文件打包为zip
 * @CreateDate 18/08/08 10:43
 * @Author zohn
 * @Version 1.0
 */
public class ZipFiles {


    public static void main(String[] args) throws Exception {
        File[] srcFiles = {new File("E:\\AboutStr.java"), new File("E:\\licence.txt"), new File("E:\\user.txt")};
        File zipFile = new File("E:\\zipDemo.zip");
        zipFiles(srcFiles, zipFile);
    }

    /**
     * 将指定的文件打包为zip
     *
     * @param srcFiels 源文件：要打包为zip的文件
     * @param zipFile  zip文件
     * @throws Exception
     */
    public static void zipFiles(File[] srcFiels, File zipFile) throws Exception {
        // 不存在 创建
        if (!zipFile.exists()) {
            zipFile.createNewFile();
        }

        // 创建流对象
        FileOutputStream fos = null;
        ZipOutputStream zos = null;
        FileInputStream fis = null;

        // 实例化流对象
        fos = new FileOutputStream(zipFile);
        zos = new ZipOutputStream(fos);
        ZipEntry zipEntry = null;

        // 遍历源文件数组
        for (int i = 0; i < srcFiels.length; i++) {
            // 将源文件数组中的当前文件读入FileInputStream流中
            fis = new FileInputStream(srcFiels[i]);
            // 实例化ZipEntry 对象，源文件数组中的当前文件
            zipEntry = new ZipEntry(srcFiels[i].getName());
            zos.putNextEntry(zipEntry);
            // 该变量记录每次真正读取的字节个数
            int len;
            // 定义每次读取的字节数组
            byte[] buffer = new byte[1024];
            while ((len = fis.read(buffer)) > 0) {
                zos.write(buffer, 0, len);
            }
        }

        zos.closeEntry();
        zos.close();
        fis.close();
        fos.close();
    }

}
