package com.example.springbootrabbitmq.controller;

import com.example.springbootrabbitmq.dto.User;
import com.example.springbootrabbitmq.publisher.RabbitMQJsonProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class MessageJsonController {
  private RabbitMQJsonProducer jsonProducer;

  public MessageJsonController(RabbitMQJsonProducer jsonProducer) {
    this.jsonProducer = jsonProducer;
  }

  // http://localhost:8080/api/v1/publish
  @PostMapping("/publish")
  public ResponseEntity<String> sendJsonMessage(@RequestBody User user) {
    jsonProducer.sendJsonMessage(user);
    return ResponseEntity.ok("Json message sent to RabbitMQ...");
  }
}
