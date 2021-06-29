package com.zyj.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author zyj
 * @create 2021-02-16 18:12
 */

/**
 * @SpringBootApplication这是一个springboot应用
 */
@SpringBootApplication
public class MainApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(MainApplication.class, args);

        //String [] names = run.getBeanDefinitionNames();
        //for (String name : names) {
        //    System.out.println(name);
        //}
    }
}