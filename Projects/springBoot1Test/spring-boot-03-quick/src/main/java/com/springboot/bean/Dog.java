package com.springboot.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author zyj
 * @create 2020-08-26 19:27
 */
@Component
@ConfigurationProperties(prefix = "dog")
public class Dog {
  private String name;
  private Integer age;

  @Override
  public String toString() {
    return "Dog{" +
            "name='" + name + '\'' +
            ", age=" + age +
            '}';
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  public String getName() {
    return name;
  }

  public Integer getAge() {
    return age;
  }
}
