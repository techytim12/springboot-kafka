package com.kafka.springboot.controller;

import com.kafka.springboot.kafka.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/kafka")
public class MessageController {

    private KafkaProducer kafkaProducer;

    public MessageController(KafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    /*@RequestParam("message) -> this gets the query parameter from the url
     http://localhost:8080/api/v1/kafka/publish/publish?message=hello-world*/
    @GetMapping("/publish")
    public ResponseEntity<String> publish(@RequestParam("Message") String Message){
        kafkaProducer.sendMessage(Message);
        return ResponseEntity.ok("Message published to topic");
    }
}
