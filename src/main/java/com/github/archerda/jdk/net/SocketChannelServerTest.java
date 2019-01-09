package com.github.archerda.jdk.net;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * Create by archerda on 2018/03/27.
 */
public class SocketChannelServerTest {

    public static void main(String[] args) throws IOException{
        new SocketChannelServerTest().initServer();
    }

    private void initServer() throws IOException {

        // 服务器端，通过open方法，来创建ServerSocketChannel
        // 注意，此时，服务器端，还没有进行绑定端口；
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();

        // 设置为非阻塞模式；
        // 如果注释掉下面这行代码，会切到阻塞模式；
        serverSocketChannel.configureBlocking(false);

        // 绑定端口号；
        serverSocketChannel.bind(new InetSocketAddress(8080));

        // 创建字节缓存区
        // 缓存区的大小是1024字节，这个可以自己调试，如改成64,128....
        ByteBuffer buffer = ByteBuffer.allocate(1024);

        while (true) {
            System.out.println("-------服务器端开始接收客户端的连接---------");

            // 在服务器端，接收客户端的链接，如果存在客户端的话，就返回一个SocketChannel对象
            // 如果是阻塞模式的话，没有新的链接进来，就会阻塞在这里，否则，往下执行
            // 如果是非阻塞模式的话，没有新的链接进来，就会立马返回一个null，程序不会阻塞在这里，会立马往下进行的
            SocketChannel socketChannel = serverSocketChannel.accept();
            if (socketChannel != null) {
                while (true) {
                    // 清除缓存区的数据，可以接收新的数据
                    buffer.clear();

                    // 将管道socketChannel的数据读取到 缓存byteBuffer里
                    // readSize 表示 读取的字节数
                    int readSize = socketChannel.read(buffer);
                    if (readSize == -1) {
                        break;
                    }

                    // 再从 字节缓存里，进行其他 业务逻辑操作，
                    // 注意，这里的缓存区使用的字节类型
                    // 因此，如果需要其他类型的话，需要进行转换
                    System.out.println(new String(buffer.array()));
                }
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
