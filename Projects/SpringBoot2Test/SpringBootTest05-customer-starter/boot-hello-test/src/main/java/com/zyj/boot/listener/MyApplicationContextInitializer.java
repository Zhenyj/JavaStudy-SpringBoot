package com.zyj.boot.listener;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author zyj
 * @create 2021-06-19 22:56
 */
public class MyApplicationContextInitializer implements ApplicationContextInitializer {

    @Override
    public void initialize (ConfigurableApplicationContext applicationContext) {
        System.out.println("MyApplicationContextInitializer...initialize...");
    }
}
