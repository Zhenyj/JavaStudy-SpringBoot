package com.zyj.boot.controller;

import com.zyj.boot.bean.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zyj
 * @create 2021-02-16 20:04
 */
//@Controller
//@ResponseBody
@RestController
public class HelloController {

    @Autowired
    Car car;

    @RequestMapping("/car")
    public Car getCar(){
        return car;
    }

    @RequestMapping("/hello")
    public String handle01(){
        return "Hello SpringBoot2!";
    }
}
