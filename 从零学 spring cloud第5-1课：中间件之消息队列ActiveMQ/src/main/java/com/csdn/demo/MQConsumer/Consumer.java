package com.csdn.demo.MQConsumer;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

    @JmsListener(destination = "csdn.queue")
    public void receiveQueue(String text) {
        System.out.println("Consumer queue msg : "+text);
    }

    @JmsListener(destination = "csdn.topic")
    public void receiveTopicB(String text) {
        System.out.println("处理广播消息A : "+text);
    }

    @JmsListener(destination = "csdn.topic")
    public void receiveTopicC(String text) {
        System.out.println("处理广播消息B : "+text);
    }

    @JmsListener(destination = "csdn.queue", containerFactory = "queueListenerFactory")
    public void receiveQueueA(String text) {
        System.out.println("处理队列消息A : "+text);
    }

    @JmsListener(destination = "csdn.topic", containerFactory = "topicListenerFactory")
    public void receiveTopicD(String text) {
        System.out.println("处理广播消息D : "+text);
    }
}
