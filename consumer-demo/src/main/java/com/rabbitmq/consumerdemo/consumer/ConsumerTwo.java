package com.rabbitmq.consumerdemo.consumer;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;

public class ConsumerTwo implements MessageListener {

    @Override
    public void onMessage(Message message) {
        String messageJson=new String(message.getBody());
        System.out.println("ConsumerTwo  messageJson:"+messageJson);
    }
}
