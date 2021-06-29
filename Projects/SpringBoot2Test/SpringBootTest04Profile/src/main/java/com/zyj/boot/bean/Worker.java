package com.zyj.boot.bean;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

/**
 * @author zyj
 * @create 2021-06-16 10:00
 */
@Data
@Component
@ConfigurationProperties("person")
@Profile("test") // 使用测试环境中的配置
public class Worker implements PersonInter {

    private String name;
    private Integer age;

    @Override
    public String getName () {
        return null;
    }

    @Override
    public Integer getAge () {
        return null;
    }
}
