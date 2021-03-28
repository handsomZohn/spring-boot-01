package readandwrite.book.cyc2018.javaIO.nio;


import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 *@Description  nio-client
 *@CreateDate   18/07/31 11:32
 *@Author        zohn
 *@Version       1.0
 *
 */
public class NIOClient {
    // 通道管理器
    private Selector selector;

    /**
     * 获得一个Socket通道，并对该通道做一些初始化工作
     * @param ip 要连接的服务器的IP地址
     * @param port 要连接的服务器的端口
     * @throws IOException
     */
    public void initClient(String ip, int port) throws IOException {
        // 获得一个Socket通道
        SocketChannel channel = SocketChannel.open();
        // 设置通道为非阻塞
        channel.configureBlocking(false);
        // 获得一个通道管理器
        this.selector = Selector.open();
        // 客户端连接服务器，其实方法执行并没有进行连接，需要在listen（）方法中调用channel.finishConnect();才能完成连接
        channel.connect(new InetSocketAddress(ip, port));
        // 将通道管理器和该通道绑定，并为改通道注册SeletionKey.OP_CONNECT事件。
        channel.register(selector, SelectionKey.OP_CONNECT);
    }

    /**
     * 采用轮训的方式监听selector上是否有需要处理的事件，如果有，则进行处理
     * @throws IOException
     */
    public void listen() throws IOException {
        // 轮询selector
        while (true) {
            selector.select();
            // 获取selector中选中项的迭代器
            Iterator<SelectionKey> keyIterator = this.selector.selectedKeys().iterator();
            while (keyIterator.hasNext()){
                SelectionKey key = keyIterator.next();
                // 删除选中的key防止重复处理
                keyIterator.remove();
                // 连接事件发生
                if (key.isConnectable()){
                    SocketChannel channel = (SocketChannel) key.channel();
                    // 如果正在连接 则完成连接
                    if (channel.isConnectionPending()){
                        channel.finishConnect();
                    }
                    // 设置成非阻塞
                    channel.configureBlocking(false);

                    // 在这里给服务端发送消息
                    channel.write(ByteBuffer.wrap(new String("向服务器发送一条消息").getBytes()));

                    // 在和服务器端连接成功之后，为了可以接收到服务端的消息，需要给通道设置读的权限。
                    channel.register(this.selector, SelectionKey.OP_READ);
                } else if (key.isReadable()) {
                    read(key);
                }
            }
        }
    }

    /**
     * 处理服务器端发来的信息 事件
     * @param key
     * @throws IOException
     */
    public void read (SelectionKey key) throws IOException {
        // 客户端可读取消息：得到事件发生的Socket通道
        SocketChannel channel = (SocketChannel) key.channel();
        // 创建读取的缓冲区
        ByteBuffer buffer = ByteBuffer.allocate(10);
        channel.read(buffer);
        byte[] data = buffer.array();
        String msg = new String(data).trim();
        System.out.println("服务端收到信息："+msg);
        ByteBuffer outBuffer = ByteBuffer.wrap(msg.getBytes());
        channel.write(outBuffer);// 将消息回送给客户端
    }

    /**
     * 启动客户端测试
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        NIOClient client = new NIOClient();
        client.initClient("localhost",8088);
        client.listen();
    }
}
