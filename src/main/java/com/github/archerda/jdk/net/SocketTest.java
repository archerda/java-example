package com.github.archerda.jdk.net;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Create by archerda on 2018/03/29.
 */
public class SocketTest {

    public static void main(String[] args) throws IOException {

        // 创建socket；
        Socket socket = new Socket("localhost", 8080);

        // 发送数据；
        OutputStream out = socket.getOutputStream();
        out.write("Hello socket. Give me something.".getBytes());
        out.flush();
        out.close();

        // 读取数据；
        InputStream in = socket.getInputStream();
        int data = in.read();
        System.out.println(data);
        in.close();

        socket.close();
    }
}
