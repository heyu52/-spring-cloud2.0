package com.csdn.demo.Receiver;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class MyReceiver {

    @KafkaListener(topics = {"test"})
    public void registryReceiver(ConsumerRecord<Integer, String> integerStringConsumerRecords) {
        System.out.println( "这是接收到的消息:"+ integerStringConsumerRecords.value());
    }
}
