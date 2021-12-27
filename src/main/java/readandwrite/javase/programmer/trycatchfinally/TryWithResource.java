package readandwrite.javase.programmer.trycatchfinally;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * @ClassName TryWithResource
 * @Description 需要关闭的资源只要实现了了java.lang.AutoCloseable，就可以⾃自动被关闭
 * try()⾥里里⾯面可以定义多个资源，它们的关闭顺序是最后在try()定义的资源先关闭
 * @Date 2021/12/19 10:33
 * @Version 1.0
 **/
public class TryWithResource {


    public static void main(String[] args) {
        test01();
    }


    public static void test01() {
        try (FileInputStream fileInputStream = new FileInputStream("C:\\Users\\zzohn\\Desktop\\Erwin使用指南.pdf");
             BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
             FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\zzohn\\Desktop\\Erwin使用指南-副本.pdf");
             BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream)) {
            int size;
            byte[] bytes = new byte[1024];
            while ((size = bufferedInputStream.read(bytes)) != -1) {
                bufferedOutputStream.write(bytes, 0, size);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
