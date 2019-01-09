package com.github.archerda.jdk.net;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 * Create by archerda on 2018/03/26.
 */
public class SelectorTest {

    public static void main(String[] args) throws Exception {
        new SelectorTest().initSelector();
    }

    private void initSelector() throws IOException {

        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        ServerSocket serverSocket = serverSocketChannel.socket();
        serverSocket.bind(new InetSocketAddress(8080));
        Selector selector = Selector.open();
        serverSocketChannel.configureBlocking(false);
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        while (true) {
            System.out.println("-------Selector服务器端开始接收客户端的连接---------");

            int n = selector.select();
            // int n = selector.selectNow();
            if (n == 0) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                continue; // nothing to do;
            }

            Iterator<SelectionKey> it = selector.selectedKeys().iterator();
            while (it.hasNext()) {
                SelectionKey key = it.next();

                if (key.isAcceptable()) {
                    ServerSocketChannel server = (ServerSocketChannel) key.channel();
                    SocketChannel channel = server.accept();
                    if (channel == null) {
                        // handle code, could happen;
                        continue;
                    }
                    channel.configureBlocking(false);
                    channel.register(selector, SelectionKey.OP_READ);
                    System.out.println("Accept remote socket address: " + channel.socket().getRemoteSocketAddress());
                }
                if (key.isReadable()) {
                    readDataFromSocket(key);
                }
                it.remove(); // 这句话是必要的；
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static void readDataFromSocket(SelectionKey key) throws IOException {
        SocketChannel channel = (SocketChannel) key.channel();
        if (channel == null) {
            // handle code, could happen;
            return;
        }

        System.out.println("Read remote socket address: " + channel.socket().getRemoteSocketAddress());

        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        int readSize = channel.read(byteBuffer);
        while (readSize != -1) {
            byteBuffer.flip();
            System.out.println(new String(byteBuffer.array()));
            byteBuffer.clear();
            readSize = channel.read(byteBuffer);
        }

        // 从channel读取完数据后，要手动关闭；
        // 否则会导致这个channel一直能被selector select出来；
        channel.close();
    }
}
