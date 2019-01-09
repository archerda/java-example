package com.github.archerda.jdk.shutdownhook;

import java.io.IOException;

/**
 * 以下场景，钩子可以被激活：
 * - 程序正常退出；
 * - 使用 System.exit()；
 * - 终端使用 Ctrl+C 触发的中断；
 * - 系统关闭；
 * - OutOfMemory宕机；
 * - 使用 kill pid 干掉进程；
 *
 * 以下场景，钩子不被激活：
 * - 使用 kill -9 pid 强制关闭；
 *
 * @author archerda
 */
public class ShutdownHook {

    public static void main(String[] args) throws IOException {
        Runtime.getRuntime().addShutdownHook(
                new Thread(
                        () -> System.out.println("This is a shutdown hook.")
                )
        );

        System.out.println("Application start.");
        // System.in.read();
        // System.exit(-1);
    }
}
