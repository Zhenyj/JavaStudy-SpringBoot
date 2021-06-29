package com.zyj.boot.bean;

/**
 * @author zyj
 * @create 2021-06-02 10:18
 *
 * 宠物
 */
public class Pet {
  private String name;

  public Pet() {
  }

  public Pet(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return "Pet{" +
        "name='" + name + '\'' +
        '}';
  }
}
