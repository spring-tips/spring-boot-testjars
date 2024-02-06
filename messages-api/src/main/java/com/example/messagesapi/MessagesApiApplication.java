package com.example.messagesapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;


@Controller
@ResponseBody
@SpringBootApplication
public class MessagesApiApplication {

    @GetMapping("/hello")
    Map<String, String> hello() {
        return Map.of("message", "hello, Spring Boot!");
    }

    public static void main(String[] args) {
        SpringApplication.run(MessagesApiApplication.class, args);
    }

}
