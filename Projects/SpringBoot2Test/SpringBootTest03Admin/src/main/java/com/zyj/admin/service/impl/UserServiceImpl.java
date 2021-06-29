package com.zyj.admin.service.impl;

import com.zyj.admin.bean.User;
import com.zyj.admin.mapper.UserMapper;
import com.zyj.admin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zyj
 * @create 2021-06-13 22:01
 */

@Service
public class UserServiceImpl implements UserService {

  @Autowired
  UserMapper userMapper;

  public User getUserByName(String userName){
    return userMapper.getUserByName(userName);
  }
}
