package com.zyj.admin;

import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.annotation.MapperScans;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;

@MapperScan("com.zyj.admin.mapper") // 使用该注解扫描的包中的mybatis映射文件不需要再标注@Mapper注解
@ServletComponentScan(basePackages = "com.zyj.admin")//扫描包下的servlet
@SpringBootApplication(exclude = RedisAutoConfiguration.class)
public class BootAdminApplication {

  public static void main(String[] args) {
    SpringApplication.run(BootAdminApplication.class, args);
  }

}
