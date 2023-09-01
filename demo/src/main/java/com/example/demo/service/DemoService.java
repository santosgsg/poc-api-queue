package com.example.demo.service;

import com.example.demo.model.Demo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DemoService {

    @Autowired
    private RabbitTemplate template;

    public void createNewExchange(Demo demo) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String jsonMessage = mapper.writeValueAsString(demo);
        Message message = new Message(jsonMessage.getBytes());

        template.send("demo.test", "#", message);
    }

    //routing key example:
    //red.cold.cheap -> routing key
    //*.cold.* -> filter
    //*.*.cheap -> filter
    //red.*.cheap
}
