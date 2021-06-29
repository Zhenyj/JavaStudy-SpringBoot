package com.zyj.hello.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author zyj
 * @create 2021-06-16 22:48
 */
@ConfigurationProperties("zyj.hello")
public class HelloProperties {
    private String prefix;
    private String suffix;

    public String getPrefix () {
        return prefix;
    }

    public void setPrefix (String prefix) {
        this.prefix = prefix;
    }

    public String getSuffix () {
        return suffix;
    }

    public void setSuffix (String suffix) {
        this.suffix = suffix;
    }
}
