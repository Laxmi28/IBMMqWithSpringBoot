package com.ibm.producer;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class Mqproducer {
   


    private final ConnectionFactory connectionFactory;

    public Mqproducer(ConnectionFactory connectionFactory){
        this.connectionFactory = connectionFactory;
    }

    public void sendMessage(String queueName , String message){
        try(Connection connection = connectionFactory.createConnection();
             Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE)){
             Queue queue = session.createQueue(queueName);
             MessageProducer producer = session.createProducer(queue);
             TextMessage textMessage = session.createTextMessage(message);
             producer.send(textMessage);


         log.info("The message has been sent to the queue [{}]: {}" , queueName , message);
        }catch(JMSException exception){
          log.error("Exception occured : {} ", exception);
          throw new RuntimeException("The message sending process in the queue failed",exception);
        } 
    }
}
