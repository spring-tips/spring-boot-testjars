package com.example.messageswebapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.experimental.boot.server.exec.CommonsExecWebServerFactoryBean;
import org.springframework.experimental.boot.test.context.DynamicProperty;
import org.springframework.experimental.boot.test.context.EnableDynamicProperty;

@TestConfiguration(proxyBeanMethods = false)
@EnableDynamicProperty
public class TestMessagesWebappApplication {

    @Bean
    @DynamicProperty(name = "messages-api.url", value = "'http://localhost:'+port +'/hello'" )
    static CommonsExecWebServerFactoryBean messagesApi() {
        return CommonsExecWebServerFactoryBean
                .builder()
                .mainClass("org.springframework.boot.loader.launch.JarLauncher")
                .classpath(classpath -> classpath.files("../messages-api/build/libs/messages-api-0.0.1-SNAPSHOT.jar"));
    }

    public static void main(String[] args) {
        SpringApplication
                .from(MessagesWebappApplication::main)
                .with(TestMessagesWebappApplication.class)
                .run(args);

    }
}