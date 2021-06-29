package com.zyj.boot.listener;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author zyj
 * @create 2021-06-19 23:05
 */
@Order(1)
@Component
public class MyApplicationRunner implements ApplicationRunner {
    @Override
    public void run (ApplicationArguments args) throws Exception {
        System.out.println("MyApplicationRunner...run...");
    }
}
