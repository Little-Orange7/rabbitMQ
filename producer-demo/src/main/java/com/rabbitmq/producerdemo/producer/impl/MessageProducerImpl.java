package com.rabbitmq.producerdemo.producer.impl;

import com.alibaba.fastjson.JSON;
import com.rabbitmq.producerdemo.producer.MessageProducer;
import org.springframework.amqp.core.AmqpTemplate;

public class MessageProducerImpl implements MessageProducer {
    private AmqpTemplate amqpTemplate;

    public AmqpTemplate getAmqpTemplate() {
        return amqpTemplate;
    }

    public void setAmqpTemplate(AmqpTemplate amqpTemplate) {
        this.amqpTemplate = amqpTemplate;
    }

    @Override
    public void sendMessageToQueue(String routingKey, Object obj) {
        String dataJson= JSON.toJSONString(obj);
        System.out.println("sendMessageToQueue  routingKey:"+routingKey+",dataJson:"+dataJson);
        amqpTemplate.convertAndSend(routingKey,dataJson);
    }
}
