package com.ibm.producer;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class Mqproducer {
   
    private final JmsTemplate jmsTemplate;

    public Mqproducer(JmsTemplate jmsTemplate){
        this.jmsTemplate = jmsTemplate;
    }

    public void sendMessage(String queue , String message){
        jmsTemplate.convertAndSend(queue,message);
        System.out.println("Message sent");
    }
}
