package com.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.ViewResolver;

@SpringBootApplication
public class SpringBoot04QuickApplication {

  public static void main(String[] args) {
    SpringApplication.run(SpringBoot04QuickApplication.class, args);
  }

  @Bean
  public ViewResolver myViewResolver(){
    return myViewResolver();
  }
}
