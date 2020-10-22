package com.application.service;

import com.application.model.User;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.stereotype.Service;

@Service
public class MessageListener {

    @StreamListener(Processor.INPUT)
    public void consumerMessage(User user){
        System.out.println("Message received from Kafka Channel ....");
        System.out.println(user);
    }
}
