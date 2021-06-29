package com.zyj.admin.service;

import com.zyj.admin.bean.User;

/**
 * @author zyj
 * @create 2021-06-14 13:58
 */
public interface UserService {
  public User getUserByName(String userName);
}
