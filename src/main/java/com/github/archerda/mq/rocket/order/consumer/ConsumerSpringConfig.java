package com.github.archerda.mq.rocket.order.consumer;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import java.io.IOException;

/**
 * @author archerda
 */
@Configurable
@ComponentScan("com.github.archerda.mq.rocket.order.consumer")
public class ConsumerSpringConfig {

    public static void main(String[] args) throws IOException, InterruptedException, RemotingException, MQClientException, MQBrokerException {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConsumerSpringConfig.class);
        context.start();

        System.in.read();
    }
}
