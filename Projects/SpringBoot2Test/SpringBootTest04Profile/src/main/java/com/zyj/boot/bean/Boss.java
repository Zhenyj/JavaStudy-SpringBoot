package com.zyj.boot.bean;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

/**
 * @author zyj
 * @create 2021-06-16 9:59
 */
@Data
@Component
@ConfigurationProperties("person")
@Profile("prod") // 使用生产环境中的配置
public class Boss implements PersonInter {

    private String name;
    private Integer age;

    @Override
    public String getName () {
        return name;
    }

    @Override
    public Integer getAge () {
        return age;
    }
}
