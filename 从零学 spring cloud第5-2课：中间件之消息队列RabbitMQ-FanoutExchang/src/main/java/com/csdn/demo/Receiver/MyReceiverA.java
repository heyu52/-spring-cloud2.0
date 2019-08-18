package com.csdn.demo.Receiver;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "队列A")
public class MyReceiverA {

    @RabbitHandler
    public void process(String message) {
        System.out.println("接收者 A: " + message);
    }

}
