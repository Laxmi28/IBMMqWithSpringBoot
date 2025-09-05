package com.ibm.listener;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;


@Component
public class Mqlistener {
    
    @JmsListener(destination = "DEV.QUEUE.1")
    private void recieveMessage(String message){
       System.out.println("Received message " + message);
    }


}
