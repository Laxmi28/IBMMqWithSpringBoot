package com.ibm.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.producer.Mqproducer;

@RestController
@RequestMapping("/mq")
public class TestController {
    
    private final Mqproducer mqproducer;

    public TestController(Mqproducer mqproducer){
        this.mqproducer = mqproducer;
    }
   
   @GetMapping("/send")
   public void sendMessage(@RequestParam String message){
        mqproducer.sendMessage("DEV.QUEUE.1" ,message);
        System.out.println("controller message sent");
   }
}
