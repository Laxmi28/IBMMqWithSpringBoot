package com.ibm.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.model.RequestMessage;
import com.ibm.producer.Mqproducer;

import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/mq")
@Slf4j
public class TestController {
    
    private final Mqproducer mqproducer;

    public TestController(Mqproducer mqproducer){
        this.mqproducer = mqproducer;
    }
   
   @PostMapping("/send")
   public void sendMessage(@RequestBody RequestMessage message){
        mqproducer.sendMessage("DEV.QUEUE.1" ,message.getMessage());
        log.info("message sent successfully");
   }
}
