package com.springboot.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author zyj
 * @create 2020-08-26 10:10
 * 将配置文件中配置的每一个属性的值，映射到这个组件中
 * @ConfigurationProperties：告诉SpringBoot将本类中的所有属性和配置文件中相关的配置进行绑定； prefix = "person"：配置文件中哪个下面的所有属性进行一一映射
 * <p>
 * 只有这个组件是容器中的组件，才能容器提供的@ConfigurationProperties功能；
 */
@Component
//@ConfigurationProperties(prefix = "person")
public class Person {

  @Value("${person.name}")
  private String name;
  @Value("${person.age}")
  private Integer age;
  @Value("${person.boss}")
  private Boolean boss;
  @Value("${person.birth}")
  private Date birth;
  private Map<String, Object> maps;
  private List<Object> lists;
  private Dog dog;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  public Boolean getBoss() {
    return boss;
  }

  public void setBoss(Boolean boss) {
    this.boss = boss;
  }

  public Date getBirth() {
    return birth;
  }

  public void setBirth(Date birth) {
    this.birth = birth;
  }

  public Map<String, Object> getMaps() {
    return maps;
  }

  public void setMaps(Map<String, Object> maps) {
    this.maps = maps;
  }

  public List<Object> getLists() {
    return lists;
  }

  public void setLists(List<Object> lists) {
    this.lists = lists;
  }

  public Dog getDog() {
    return dog;
  }

  public void setDog(Dog dog) {
    this.dog = dog;
  }

  @Override
  public String toString() {
    return "Person{" +
            "name='" + name + '\'' +
            ", age=" + age +
            ", boss=" + boss +
            ", birth=" + birth +
            ", maps=" + maps +
            ", lists=" + lists +
            ", dog=" + dog +
            '}';
  }
}
