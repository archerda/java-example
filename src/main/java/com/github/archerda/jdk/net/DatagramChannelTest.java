package com.github.archerda.jdk.net;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;

/**
 * Create by archerda on 2018/03/27.
 */
public class DatagramChannelTest {

    private void send() throws IOException {
        DatagramChannel datagramChannel = DatagramChannel.open();
        datagramChannel.socket().bind(new InetSocketAddress(9999));

        String data = "Hello DatagramChannel!";

        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        byteBuffer.clear();
        byteBuffer.put(data.getBytes());

        byteBuffer.flip();
        int byteSent = datagramChannel.send(byteBuffer, new InetSocketAddress(8080));
    }

    private void receive() throws IOException {
        DatagramChannel datagramChannel = DatagramChannel.open();
        datagramChannel.socket().bind(new InetSocketAddress(9999));

        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        byteBuffer.clear();
        datagramChannel.receive(byteBuffer);

        System.out.println(new String(byteBuffer.array()));
    }
}
