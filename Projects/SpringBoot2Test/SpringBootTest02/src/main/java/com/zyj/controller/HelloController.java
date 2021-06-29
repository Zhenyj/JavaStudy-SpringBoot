package com.zyj.controller;

import java.lang.reflect.Method;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zyj
 * @create 2021-06-05 22:56
 */

@RestController
public class HelloController {

  // 请求先找到Controller,如果Controller不能处理,就找静态资源,静态资源不存在则404
  @RequestMapping("/city_1.jpg")
  public String hello(){
    return "aaaa";
  }

  /**
   * Rest风格
   * 扩展点:如何将_method,换成自定义的
   */
//  @RequestMapping(value = "/user",method = RequestMethod.GET)
  @GetMapping("/user")
  public String getUser(){
    return "GET-张三";
  }

//  @RequestMapping(value = "/user",method = RequestMethod.POST)
  @PostMapping("/user")
  public String saveUser(){
    return "POST-张三";
  }

//  @RequestMapping(value = "/user",method = RequestMethod.PUT)
  @PutMapping("/user")
  public String putUser(){
    return "PUT-张三";
  }

//  @RequestMapping(value = "/user",method = RequestMethod.DELETE)
  @DeleteMapping("/user")
  public String deleteUser(){
    return "DELETE-张三";
  }


}
