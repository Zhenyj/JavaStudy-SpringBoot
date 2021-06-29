package com.zyj.admin.controller;

import com.zyj.admin.bean.User;
import com.zyj.admin.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author zyj
 * @create 2021-06-13 22:06
 */
@Slf4j
@Controller
public class UserController {
  @Autowired
  JdbcTemplate jdbcTemplate;

  @Autowired
  UserService userService;

  @GetMapping("/user")
  @ResponseBody
  public User getUserByName(@RequestParam("name") String userName){
    return userService.getUserByName(userName);
  }
}
