package com.zyj.boot.config;

import com.zyj.boot.controller.HelloController;
import com.zyj.hello.service.HelloService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zyj
 * @create 2021-06-17 22:02
 */
@Configuration
public class MyConfig {

    //@Bean
    public HelloService helloService(){
        HelloService helloService = new HelloService();
        return helloService;
    }
}
