package com.github.archerda.jdk.net.nio;

import java.io.IOException;

/**
 * 1. ServerSocketChannel --(.socket())--> Socket --(.bind())
 *                        --(.registry(Selector))
 *
 * 2. Selector --(.select())--> Set<SelectionKey> --(.channel())--> [ServerSocketChannel --(.accept())-->] SocketChannel
 * @author archerda
 */
public class TimeServer {
    /**
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        int port = 8080;
        if (args != null && args.length > 0) {
            try {
                port = Integer.valueOf(args[0]);
            } catch (NumberFormatException e) {
                // 采用默认值
            }
        }
        MultiplexerTimeServer timeServer = new MultiplexerTimeServer(port);
        new Thread(timeServer, "NIO-MultiplexerTimeServer-001").start();
    }
}
