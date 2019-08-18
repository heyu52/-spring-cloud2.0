package com.csdn.demo.Sender;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MySender {
    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send() {
        String context = "广播消息来了";
        System.out.println("发送者 : " + context);
        this.rabbitTemplate.convertAndSend("fanoutExchange","", context);
    }
}
