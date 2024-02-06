package com.example.messageswebapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@Controller
@SpringBootApplication
public class MessagesWebappApplication {

    @GetMapping("/")
    String index(Map<String, Object> attrs) {
        attrs.put("message", "Hello Spring Boot");
        return "index";
    }

    public static void main(String[] args) {
        SpringApplication.run(MessagesWebappApplication.class, args);
    }

}
