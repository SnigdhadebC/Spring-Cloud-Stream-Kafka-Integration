package com.application.controller;

import com.application.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/producer")
public class ApiController {

    @Autowired
    private MessageChannel output;

    @PostMapping
    public void registerUser(@RequestBody User user){
        System.out.println("User :: "+user);
        Message<User> message = MessageBuilder.withPayload(user).build();
        boolean data = output.send(message);
        System.out.println(" Data : "+data);
    }

}
