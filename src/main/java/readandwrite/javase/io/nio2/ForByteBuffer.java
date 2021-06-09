package readandwrite.javase.io.nio2;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.security.SecureRandom;

/**
 * @Description 看看ByteBuffer是一个什么鬼
 * @CreateDate 18/10/09 14:34
 * @Author zohn
 * @Version 1.0
 */
public class ForByteBuffer {
    public static void byteBufferTest() {
        // 是抽象类Buffer
        // Buffer的直接子类 也是抽象类 不能被实例化
        //ByteBuffer byteBuffer = n

        System.out.println("-----test allocate-----");
        System.out.println("Before allocate:" + Runtime.getRuntime().freeMemory());

        // 为ByteBuffer分配内存 发现分配的是RAM 就是服务器本身的内存
        // while (true) {
        // 1024byte = 1kb
        ByteBuffer buffer = ByteBuffer.allocate(1024 * 1024 * 1024);
        System.out.println("buffer:" + buffer);

        System.out.println("After allocate:" + Runtime.getRuntime().freeMemory());
        // }

        System.out.println("-----test wrap-----");
        byte[] bytes = new byte[32];
        ByteBuffer wrap = ByteBuffer.wrap(bytes);
        System.out.println(wrap);
        ByteBuffer byteBuffer = ByteBuffer.wrap(bytes, 10, 10);
        System.out.println(byteBuffer);
    }

    public static void flipTest() {
        // 声明一个int缓冲区
        IntBuffer intBuffer = IntBuffer.allocate(10);
        // 放入数据
        for (int i = 0; i < 5; i++) {
            int nextInt = new SecureRandom().nextInt(10);
            intBuffer.put(nextInt);
        }

        // 读取数据
        // buffer的读写转换全靠flip方法实现
        intBuffer.flip();
        while (intBuffer.hasRemaining()) {
            System.out.println(intBuffer.get());
        }


    }


    public static void flipTest02() {
        IntBuffer intBuffer = IntBuffer.allocate(20);

        System.out.println("buffer capacity : " + intBuffer.capacity());

        for (int i = 0; i < 20; i++) {
            int nextInt = new SecureRandom().nextInt(20);
            intBuffer.put(nextInt);
        }

        System.out.println("before flip limit is : " + intBuffer.limit());
        System.out.println("before flip position is : " + intBuffer.position());

        intBuffer.flip();
        // 如果不调用flip方法进行输出,则输出的是buffer里面的空位置的默认值 比如int的默认值是0
        // 就算放满了也不会输出放入的值
        // enter while loop: 0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-
        // enter while loop: 18-12-3-11-3-

        System.out.println("after flip limit is : " + intBuffer.limit());
        System.out.println("after flip position is : " + intBuffer.position());

        System.out.print("enter while loop: ");

        while (intBuffer.hasRemaining()) {
            System.out.print(intBuffer.get() + "-");
        }
    }


    public static void main(String[] args) {
        // byteBufferTest();
        // flipTest();
        flipTest02();
        //System.out.println(1024*1024*1024);
    }
}
