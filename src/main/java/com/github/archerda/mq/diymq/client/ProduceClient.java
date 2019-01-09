package com.github.archerda.mq.diymq.client;

/**
 * @author archerda
 */
public class ProduceClient {

    public static void main(String[] args) throws Exception {
        MqClient.produce("Hello World");
    }

}
