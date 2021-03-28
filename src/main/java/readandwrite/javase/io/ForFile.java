package readandwrite.javase.io;


import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.channels.FileChannel;

/**
 * @Description 两种copy文件的方式
 * @CreateDate 18/10/24 14:13
 * @Author zohn
 * @Version 1.0
 */
public class ForFile {

    public static void main(String[] args) throws Exception {
      /*  File file = new File("e:/账户与PWD.txt");
        FileInputStream fileInputStream = new FileInputStream("e:/账户与PWD.txt");
        int i = fileInputStream.read();
        while (i != -1) {
            System.out.println(i);
        }
        fileInputStream.close();*/

        copyFileByStream(new File("e:/licence.txt"), new File("d:/账户与PWD.txt"));
        copyFileByChannel(new File("e:/licence.txt"), new File("d:/账户与PWD.txt"));
    }

    /**
     * @Description 通过传统的IO提供的流API来copy
     * @CreateDate 18/10/24 14:14
     * @Author zohn
     * @Version 1.0
     */
    public static void copyFileByStream(File source, File dest) throws IOException {
        try (
                InputStream inputStream = new FileInputStream(source);
                OutputStream outputStream = new FileOutputStream(dest)
        ) {
            byte[] buffer = new byte[1024];
            int length;
            while ((length = inputStream.read(buffer)) > 0) {
                outputStream.write(buffer, 0, length);
            }
        }
    }

    /**
     * @Description 通过nio的channel来copy
     * @CreateDate 18/10/24 14:14
     * @Author zohn
     * @Version 1.0
     */
    public static void copyFileByChannel(File source, File dest) throws IOException {
        try (
                FileChannel sourceChannel = new FileInputStream(source).getChannel();
                FileChannel destChannel = new FileOutputStream(dest).getChannel()
        ) {
            for (long count = sourceChannel.size(); count > 0; ) {
                long transferred = sourceChannel.transferTo(sourceChannel.position(), count, destChannel);
                sourceChannel.position(sourceChannel.position() + transferred);
                count -= transferred;
            }

        }
    }

    /**
     * @Description try-with-resource  需要关闭的资源只要实现了java.lang.AutoCloseable，就可以?动被关闭
     * try()??可以定义多个资源，它们的关闭顺序是最后在try()定义的资源先关闭
     * Ctrl + Alt + U 查看一个类的所有继承关系
     * @Author zohn
     * @Date 2020\3\13 0013 10:55
     * @Param []
     * @Return void
     */
    @Test
    public void copyFile(){
        try (
                FileInputStream fis = new FileInputStream("d:/practice.txt");
                BufferedInputStream bis = new BufferedInputStream(fis);
                FileOutputStream fos = new FileOutputStream("e:/practice.txt");
                BufferedOutputStream bos = new BufferedOutputStream(fos);
        ) {
            int size;
            byte[] buf = new byte[1024];
            while ((size = bis.read(buf)) != -1) {
                bos.write(buf, 0, size);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
