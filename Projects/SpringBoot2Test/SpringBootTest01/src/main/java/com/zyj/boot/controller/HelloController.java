package com.zyj.boot.controller;

import com.zyj.boot.bean.Car;
import com.zyj.boot.bean.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zyj
 * @create 2021-06-02 9:21
 */
//@ResponseBody
//@Controller
//整合前两个注解
@RestController
public class HelloController {

  // 自动注入
  @Autowired
  Car car;

  @Autowired
  Person person;

  @RequestMapping("/hello")
  public String handle01(){
    return "Hello SpringBoot 2";
  }

  @RequestMapping("/car")
  public Car car(){
    return car;
  }

  @RequestMapping("/person")
  public Person person(){
    return person;
  }
}
