package com.zyj.hello.service;

import com.zyj.hello.bean.HelloProperties;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author zyj
 * @create 2021-06-16 22:47
 *
 * 默认不要放在容器中
 */
public class HelloService {

    @Autowired
    HelloProperties helloProperties;

    public String sayHello(String name){
        return helloProperties.getPrefix() + ": "+name+"》 "+ helloProperties.getSuffix();
    }
}
