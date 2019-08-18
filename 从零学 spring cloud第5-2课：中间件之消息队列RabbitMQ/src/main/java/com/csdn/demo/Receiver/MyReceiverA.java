package com.csdn.demo.Receiver;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "csdn")
public class MyReceiverA {
    @RabbitHandler
    public void process(String hello) {
        System.out.println("我是接收者A  : " + hello);
    }
}
