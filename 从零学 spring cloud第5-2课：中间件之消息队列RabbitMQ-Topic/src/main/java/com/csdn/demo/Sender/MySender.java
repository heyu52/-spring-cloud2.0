package com.csdn.demo.Sender;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MySender {
    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send() {
        String context = "我是发送者Send,队列是Topic.A";
        System.out.println("发送者 : " + context);
        this.rabbitTemplate.convertAndSend("TopicExchange", "Topic.A", context);
    }

    public void TopicSendMessage() {
        String context = "我是发送者TopicSendMessage,Topic.SendMessage";
        System.out.println("发送者 : " + context);
        this.rabbitTemplate.convertAndSend("TopicExchange", "Topic.SendMessage", context);
    }

    public void TopicSendMessageTest() {
        String context = "我是发送者TopicSendMessageTest,Topic.SendMessage.Test";
        System.out.println("发送者 : " + context);
        this.rabbitTemplate.convertAndSend("TopicExchange", "Topic.SendMessage.Test", context);
    }
}
