package com.springboot.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zyj
 * @create 2020-08-26 19:10
 */

@Component
@ConfigurationProperties(prefix = "person")
public class Person {
  private String name;
  private Integer age;
  private Long id;
  private Map<String, String> maps = new HashMap<>();
  private List<String> list;
  private List<Dog> dogs;
  private Dog dog;

  public Dog getDog() {
    return dog;
  }

  @Override
  public String toString() {
    return "Person{" +
            "name='" + name + '\'' +
            ", age=" + age +
            ", id=" + id +
            ", maps=" + maps +
            ", list=" + list +
            ", dogs=" + dogs +
            ", dog=" + dog +
            '}';
  }

  public void setDog(Dog dog) {
    this.dog = dog;
  }

  public List<Dog> getDogs() {
    return dogs;
  }

  public void setDogs(List<Dog> dogs) {
    this.dogs = dogs;
  }
  public void setName(String name) {
    this.name = name;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public void setMaps(Map<String, String> maps) {
    this.maps = maps;
  }

  public void setList(List<String> list) {
    this.list = list;
  }

  public String getName() {
    return name;
  }

  public Integer getAge() {
    return age;
  }

  public Long getId() {
    return id;
  }

  public Map<String, String> getMaps() {
    return maps;
  }

  public List<String> getList() {
    return list;
  }

}
