package com.zyj.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class BootHelloTestApplication {

    public static void main (String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(BootHelloTestApplication.class, args);
    }

}
