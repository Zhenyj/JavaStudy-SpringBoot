package com.zyj.boot.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author zyj
 * @create 2021-06-03 16:56
 *
 * 只有在容器中的组件,才能拥有SpringBoot的功能
 */
//@Component
@ConfigurationProperties(prefix = "mycar")//配置绑定,与配置文件中的mycar前缀的配置信息进行绑定
public class Car {
  private String brand;
  private Integer price;

  public Car() {
  }

  public Car(String brand, Integer price) {
    this.brand = brand;
    this.price = price;
  }

  public String getBrand() {
    return brand;
  }

  public void setBrand(String brand) {
    this.brand = brand;
  }

  public Integer getPrice() {
    return price;
  }

  public void setPrice(Integer price) {
    this.price = price;
  }

  @Override
  public String toString() {
    return "Car{" +
        "brand='" + brand + '\'' +
        ", price=" + price +
        '}';
  }
}
