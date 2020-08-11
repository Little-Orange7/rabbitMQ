package com.rabbitmq.producerdemo.producer;

public interface MessageProducer {
    void sendMessageToQueue(String routingKey,Object obj);
}
