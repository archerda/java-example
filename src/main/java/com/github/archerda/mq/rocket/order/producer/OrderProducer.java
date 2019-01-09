package com.github.archerda.mq.rocket.order.producer;

import org.apache.log4j.Logger;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component("orderProducer")
public class OrderProducer {

    private static final String NAME_SERVER_ADDR = "localhost:9876";
    private static final String PRODUCER_GROUP_NAME = "archerda-order-producer";

    private Logger logger = Logger.getLogger(getClass());

    private DefaultMQProducer producer;

    @PostConstruct
    public void init() throws Exception {
        logger.info("开始启动生产者服务...");

        //创建一个消息生产者，并设置一个消息生产者组
        producer = new DefaultMQProducer(PRODUCER_GROUP_NAME);
        //指定 NameServer 地址
        producer.setNamesrvAddr(NAME_SERVER_ADDR);
        //初始化 Producer，整个应用生命周期内只需要初始化一次
        producer.start();

        logger.info("生产者服务启动成功.");
    }

    @PreDestroy
    public void destroy() {
        logger.info("开始关闭生产者服务...");

        producer.shutdown();

        logger.info("生产者服务已关闭.");
    }

    public DefaultMQProducer getProducer() {
        return producer;
    }
}
