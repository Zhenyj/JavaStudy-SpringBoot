package com.zyj.boot.config;

import com.zyj.boot.bean.Pet;
import com.zyj.boot.bean.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zyj
 * @create 2021-02-16 21:00
 *
 * 1、配置类里面使用@Bean标注在方法上给容器注册组件，默认也是单实例的
 * 2、配置类本身也是组件
 * 3、proxyBeanMethods：代理bean的方法
 *      FuLL(proxyBeanMethods = true)
 *      Lite(proxyBeanMethods = false)
 *      组件依赖
 */

@Configuration(proxyBeanMethods = true) //告诉springBoot这是一个配置类==配置文件
public class MyConfig {

    @Bean("zyj")
    public User user01(){
        return new User("zhangsan",18);
    }

    @Bean("tom")
    public Pet tomcatPet(){
        return new Pet("tomcat");
    }
}