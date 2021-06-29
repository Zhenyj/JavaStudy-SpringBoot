package com.zyj.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zyj.admin.bean.UserPlus;

/**
 * @author zyj
 * @create 2021-06-14 13:56
 */
public interface UserPlusService extends IService<UserPlus> {

  public void saveUserPlusWithoutId(UserPlus userPlus);
}
