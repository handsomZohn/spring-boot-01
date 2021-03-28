package readandwrite.book.cyc2018.javaIO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @Description 使用NIO快速复制文件
 * @CreateDate 18/07/18 15:53
 * @Author zohn
 * @Version 1.0
 */
public class NIOFastCopyFile {
    public static void main(String[] args) throws IOException {
        String src = "d:\\licence.txt", dist = "e:\\licence.txt";
        System.out.println("复制文件开始：" + System.currentTimeMillis());
        fastCopyFile(src,dist);
        System.out.println("复制文件结束：" + System.currentTimeMillis());

    }

    /**
     * NIO快速复制文件
     *
     * @param src  源文件
     * @param dist 目标文件
     * @throws IOException
     */
    static void fastCopyFile(String src, String dist) throws IOException {
        // 获取源文件的输入字节流
        FileInputStream fis = new FileInputStream(src);
        // 获取输入字节流的文件通道
        FileChannel fisChannel = fis.getChannel();
        // 获取目标文件的输出字节流
        FileOutputStream fos = new FileOutputStream(dist);
        // 获取输出字节流的文件通道
        FileChannel fosChannel = fos.getChannel();
        // 为缓冲区分配1024个字节
        ByteBuffer buffer = ByteBuffer.allocateDirect(1024);
        while (true) {
            // 从输入通道中读取数据到缓冲区中
            int r = fisChannel.read(buffer);
            // read() 返回-1 表示EOF
            if (r == -1){
                break;
            }
            buffer.flip();
            // 把缓冲区的内容写入输出文件中
            fosChannel.write(buffer);
            // 清空缓冲区
            buffer.clear();
        }
    }
    // NIO与IO的区别主要有以下两点：
    // NIO是非阻塞的。应当注意:FileChannel不能切换到非阻塞模式，套接字Channel可以；
    // NIO面向块，IO面向流
}
