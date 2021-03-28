package readandwrite.book.cyc2018.javaIO;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @Description 使用字节流进行文件复制
 * @CreateDate 18/07/18 14:15
 * @Author zohn
 * @Version 1.0
 */
public class ByteCopyFileExample {
    public static void main(String[] args) throws IOException {
        String src = "d:\\licence.txt", dist = "e:\\licence.txt";
        System.out.println("复制文件开始：" + System.currentTimeMillis());
        copyFile(src,dist);
        System.out.println("复制文件结束：" + System.currentTimeMillis());
        System.out.println("复制文件开始：" + System.currentTimeMillis());
        copyFile();
        System.out.println("复制文件结束：" + System.currentTimeMillis());
    }

    /**
     *
     * @param src 原文件路径
     * @param dist 目标文件路径
     * @throws IOException
     */
    static void copyFile(String src, String dist) throws IOException {
        FileInputStream fis = new FileInputStream(src);
        FileOutputStream fos = new FileOutputStream(dist);
        byte[] buffer = new byte[20 * 1024];
        // read()最多读取buffer.length个字节，返回实际读取的个数
        // 返回-1表示读到eof，即文件尾
        while (fis.read(buffer, 0, buffer.length) != -1){
            fos.write(buffer);
        }
        fos.close();
        fis.close();
    }

    // Java I/O使用装饰者模式来实现。
    // 以InputStream为例，InputStream是抽象组件 FileInputStream是InputStream的子类，是具体组件，提供字节流的输入操作
    // 实例化一个具有缓存功能的字节流对象时，只需在FileInputStream对象上再套一层BufferedInputStream对象即可。
    static void copyFile() throws IOException{
        FileInputStream fis = new FileInputStream("d:\\licence.txt");
        // 具有缓存功能的字节流对象
        BufferedInputStream bis = new BufferedInputStream(fis);
        FileOutputStream fos = new FileOutputStream("e:\\licence.txt");
        byte[] buffer = new byte[1024];
        while (bis.read(buffer, 0, buffer.length) != -1){
            fos.write(buffer);
        }
        fos.close();
        bis.close();
    }
}
