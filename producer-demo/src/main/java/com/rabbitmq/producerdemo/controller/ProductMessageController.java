package com.rabbitmq.producerdemo.controller;

import com.alibaba.fastjson.JSON;
import com.rabbitmq.producerdemo.controller.pojo.TestPojo;
import com.rabbitmq.producerdemo.producer.MessageProducer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/producer")
public class ProductMessageController {

    @Resource
    private MessageProducer messageProducer;

    @Value("${routingKey.two}")
    private String routingKey;

    @GetMapping("/pushMessage")
    public String productMessage(){
        TestPojo tp=new TestPojo();
        tp.setName("Jack");
        tp.setLogin("JackLogin");
        tp.setPassword("123456");
        tp.setAge(20);
        messageProducer.sendMessageToQueue(routingKey,tp);
        return "OK";
    }

}
