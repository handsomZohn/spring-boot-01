package readandwrite.book.cyc2018.javaIO;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 *@Description  套接字NIO实例客户端
 *@CreateDate   18/07/18 16:21
 *@Author        zohn
 *@Version       1.0
 *
 */
public class NIOClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 8888);
        OutputStream outputStream = socket.getOutputStream();
        String s = "hello world";
        outputStream.write(s.getBytes());
        outputStream.close();
    }
}
