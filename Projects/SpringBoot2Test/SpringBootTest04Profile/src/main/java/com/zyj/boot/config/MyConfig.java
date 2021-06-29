package com.zyj.boot.config;

import com.zyj.boot.bean.Color;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * @author zyj
 * @create 2021-06-16 10:23
 */
@Configuration
public class MyConfig {

    @Bean
    @Profile("prod") // 指定在prod环境下该组件才生效
    public Color red(){
        return new Color();
    }

    @Bean
    @Profile("test")// 指定在test环境下该组件才生效
    public Color green(){
        return new Color();
    }
}
