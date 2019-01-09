package com.github.archerda.mq.rocket.order.producer;

import org.apache.rocketmq.client.producer.MessageQueueSelector;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageQueue;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("orderMessageQueueSelector")
public class OrderMessageQueueSelector implements MessageQueueSelector {

    @Override
    public MessageQueue select(List<MessageQueue> list, Message message, Object orderId) {
        Integer id = (Integer) orderId;

        return list.get(id % list.size());
    }

}
