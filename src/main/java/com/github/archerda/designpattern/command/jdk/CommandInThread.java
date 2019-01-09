package com.github.archerda.designpattern.command.jdk;

/**
 * Create by archerda on 2017/11/15.
 */
public class CommandInThread {

    public static void main(String[] args) {

        // 创建Command：直接命令(没有Receiver)
        Runnable runnable = () -> System.out.println("I am a Receiver");

        // 创建一个Invoker：请求发起人
        Thread thread = new Thread(runnable);

        // 发起请求
        thread.start();

    }
}
