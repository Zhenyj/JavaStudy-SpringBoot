package com.zyj.boot.listener;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

/**
 * @author zyj
 * @create 2021-06-19 22:58
 */
public class MyApplicationListener implements ApplicationListener {
    @Override
    public void onApplicationEvent (ApplicationEvent event) {
        System.out.println("MyApplicationListener...onApplicationEvent...");
    }
}
