package com.zyj.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zyj.admin.bean.UserPlus;
import com.zyj.admin.mapper.UserPlusMapper;
import com.zyj.admin.service.UserPlusService;
import com.zyj.admin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zyj
 * @create 2021-06-14 13:57
 *
 *
 */
@Service
public class UserPlusServiceImpl extends ServiceImpl<UserPlusMapper, UserPlus> implements UserPlusService {

  @Autowired
  UserPlusMapper userPlusMapper;

  public void saveUserPlusWithoutId(UserPlus userPlus){
    userPlusMapper.saveUserPlusWithoutId(userPlus);
  }
}
