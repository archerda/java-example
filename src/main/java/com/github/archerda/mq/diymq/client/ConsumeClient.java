package com.github.archerda.mq.diymq.client;

/**
 * @author archerda
 */
public class ConsumeClient {

    public static void main(String[] args) throws Exception {

        String message = MqClient.consume();

        System.out.println("获取的消息为：" + message);
    }

}
