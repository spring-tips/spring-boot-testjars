package com.example.messageswebapp;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.client.JdkClientHttpRequestFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestClient;

import java.net.URI;
import java.util.Map;
import java.util.Objects;

@SpringBootApplication
public class MessagesWebappApplication {


    public static void main(String[] args) {
        SpringApplication.run(MessagesWebappApplication.class, args);
    }

}


@Controller
class WebappController {

    private final RestClient http = RestClient.builder()
            .requestFactory(new JdkClientHttpRequestFactory())
            .build();

    private final URI uri;

    public WebappController(@Value("${messages-api.url}") URI uri) {
        this.uri = uri;
    }

    @GetMapping("/")
    String index(Map<String, Object> attrs ) {

        var messageFromApi = Objects.requireNonNull(this.http
                        .get()
                        .uri(this.uri)
                        .retrieve()
                        .toEntity(new ParameterizedTypeReference<Map<String, String>>() {
                        })
                        .getBody())
                .get("message");

        attrs.put("message", messageFromApi);
        return "index";
    }


}