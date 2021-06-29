package com.springboot.controller;

import com.springboot.bean.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zyj
 * @create 2020-08-26 17:21
 */
@RestController
public class HelloController {
  @Autowired
  private Person person;
  @RequestMapping("hello")
  public String hello(){
    return ("hello springBoot!666"+person);
  }
}


