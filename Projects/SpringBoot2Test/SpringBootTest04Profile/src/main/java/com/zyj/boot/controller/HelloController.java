package com.zyj.boot.controller;

import com.zyj.boot.bean.Person;
import com.zyj.boot.bean.PersonInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zyj
 * @create 2021-06-16 9:04
 */
@RestController
public class HelloController {

    // 从配置文件中找到对应值,没有的话用默认值李四
    @Value("${person.name:李四}")
    private String name;

    @Autowired
    private Person person;

    @Autowired
    private PersonInter personInter;

    @Value("${MAVEN_HOME}") // 可以来自系统环境变量
    private String msg;

    @Value("${os.name}") //操作系统的名字
    private String osName;

    @GetMapping("/hello")
    public Person hello(){
        return person;
    }

    @GetMapping("/helloPerson")
    public String helloPerson(){
        return personInter.getClass().toString();
    }

    @GetMapping("/msg")
    public String getMsg(){
        return "MAVEN_HOME:"+msg+",操作系统:"+osName;
    }
}
