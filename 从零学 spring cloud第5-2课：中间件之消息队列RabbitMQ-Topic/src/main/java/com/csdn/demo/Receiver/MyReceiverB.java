package com.csdn.demo.Receiver;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "Topic.SendMessage.Test")
public class MyReceiverB {

    @RabbitHandler
    public void process(String message) {
        System.out.println("接收者B : " + message);
    }

}
