package com.github.archerda.jdk.net;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * Create by archerda on 2018/03/27.
 */
public class SocketChannelClientTest {

    public static void main(String[] args) throws IOException {
        new SocketChannelClientTest().connectServer();
    }

    private void connectServer() throws IOException {
        // 创建一个 SocketChannel对象，
        // 请注意，这个时候还没有连接到服务器端
        SocketChannel socketChannel = SocketChannel.open();

        // 开始连接到服务端；
        socketChannel.connect(new InetSocketAddress("localhost", 8080));

        // 在客户端创建 字节缓冲区；
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

        String msg = "Hello Socket! Hello Java!";

        // 往字节缓冲区添加数据；
        byteBuffer.put(msg.getBytes());

        // 切换到读模式；
        byteBuffer.flip();

        while (byteBuffer.hasRemaining()) {
            // 将字节缓冲区的数据，写到通道中去；
            socketChannel.write(byteBuffer);
        }

        socketChannel.close();
    }
}
