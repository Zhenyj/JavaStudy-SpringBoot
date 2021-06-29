package com.zyj.boot.listener;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author zyj
 * @create 2021-06-19 23:05
 *
 * 应用一启动做一个一次性事情
 */
@Order(2)
@Component
public class MyCommandLineRunner implements CommandLineRunner {
    @Override
    public void run (String... args) throws Exception {
        System.out.println("MyCommandLineRunner...run...");
    }
}
