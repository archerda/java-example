package com.github.archerda.mq.rocket.order.producer;

import com.github.archerda.mq.rocket.order.OrderMessage;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import java.io.IOException;

/**
 * @author archerda
 */
@Configurable
@ComponentScan("com.github.archerda.mq.rocket.order.producer")
public class ProducerSpringConfig {

    private static final String TOPIC_NAME = "archerda-order-topic";

    public static void main(String[] args) throws IOException, InterruptedException, RemotingException, MQClientException, MQBrokerException {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ProducerSpringConfig.class);
        context.start();

        OrderProducer orderProducer = context.getBean(OrderProducer.class);
        OrderMessageQueueSelector queueSelector = context.getBean(OrderMessageQueueSelector.class);

        String[] statusNames = {"已创建", "已付款", "已配送", "已取消", "已完成"};

        // 模拟订单消息
        for (int orderId = 1; orderId <= 10; orderId++) {
            for (int i = 0; i < statusNames.length; i++) {
                String messageContent = new OrderMessage()
                        .setId(orderId)
                        .setStatus(statusNames[i])
                        .setSendOrder(i)
                        .setContent("Hello orderly rocketMQ message.").toString();

                Message message = new Message(TOPIC_NAME,
                        statusNames[i],
                        orderId + "#" + statusNames[i],
                        messageContent.getBytes());

                SendResult sendResult = orderProducer.getProducer().send(message, queueSelector, orderId);

                System.out.println(sendResult);
            }
        }


    }
}
