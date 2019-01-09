package com.github.archerda.mq.rocket.order.consumer;

import org.apache.log4j.Logger;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.MessageListenerOrderly;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

@Component("orderConsumer")
public class OrderConsumer {

    private static final String NAME_SERVER_ADDR = "localhost:9876";
    private static final String CONSUMER_GROUP_NAME = "archerda-order-consumer";
    private static final String TOPIC_NAME = "archerda-order-topic";

    private Logger logger = Logger.getLogger(getClass());

    private DefaultMQPushConsumer consumer;

    @Resource
    private MessageListenerOrderly orderMessageListener;

    @PostConstruct
    public void init() throws Exception {
        logger.info("开始启动消费者服务...");

        //创建一个消息消费者，并设置一个消息消费者组
        consumer = new DefaultMQPushConsumer(CONSUMER_GROUP_NAME);
        //指定 NameServer 地址
        consumer.setNamesrvAddr(NAME_SERVER_ADDR);
        //设置Consumer第一次启动是从队列头部开始消费还是队列尾部开始消费
        consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);

        //订阅指定 Topic 下的所有消息
        consumer.subscribe(TOPIC_NAME, "*");

        //注册消息监听器
        consumer.registerMessageListener(orderMessageListener);

        // 消费者对象在使用之前必须要调用 start 初始化
        consumer.start();

        logger.info("消费者服务启动成功.");
    }

    @PreDestroy
    public void destroy() {
        logger.info("开始关闭消费者服务...");

        consumer.shutdown();

        logger.info("消费者服务已关闭.");
    }

    public DefaultMQPushConsumer getConsumer() {
        return consumer;
    }
}
