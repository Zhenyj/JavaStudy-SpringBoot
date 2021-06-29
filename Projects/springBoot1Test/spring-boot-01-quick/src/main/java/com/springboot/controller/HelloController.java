package com.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author zyj
 * @create 2020-08-26 9:51
 */

@ResponseBody //这个类所有返回的数据会直接写给浏览器(如果是对象转为json数据)
@Controller
public class HelloController {


  @RequestMapping("/hello")
  public String hello(){
    return "hello world quick!";
  }

}

