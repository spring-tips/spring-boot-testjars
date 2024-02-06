package com.example.messagesapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;
import java.util.Map;


@Controller
@ResponseBody
@SpringBootApplication
public class MessagesApiApplication {

    @GetMapping("/hello")
    Map<String, String> hello(@AuthenticationPrincipal Principal principal) {
        return Map.of("message", "hello, " + principal.getName() + "!");
    }

    public static void main(String[] args) {
        SpringApplication.run(MessagesApiApplication.class, args);
    }

}
