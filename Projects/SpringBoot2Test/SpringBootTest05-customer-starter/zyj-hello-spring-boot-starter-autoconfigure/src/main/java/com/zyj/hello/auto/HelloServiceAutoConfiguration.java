package com.zyj.hello.auto;

import com.zyj.hello.bean.HelloProperties;
import com.zyj.hello.service.HelloService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zyj
 * @create 2021-06-16 22:52
 *
 * 自动配置类
 */
@Configuration
// 属性文件绑定功能,因为helloService绑定着HelloProperties
@EnableConfigurationProperties(HelloProperties.class) //默认HelloProperties会放入容器中
public class HelloServiceAutoConfiguration {

    @ConditionalOnMissingBean(HelloService.class)
    @Bean
    public HelloService helloService(){
        HelloService helloService = new HelloService();
        return helloService;
    }
}
