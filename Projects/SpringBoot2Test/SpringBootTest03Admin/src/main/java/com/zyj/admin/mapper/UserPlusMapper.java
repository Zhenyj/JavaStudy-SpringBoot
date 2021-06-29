package com.zyj.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zyj.admin.bean.UserPlus;
import org.apache.ibatis.annotations.Insert;

/**
 *
 * Mapper继承该接口后,无需编写mapper.xml,即可拥有基础的CRUD功能
 * @author zyj
 * @create 2021-06-14 13:42
 */
public interface UserPlusMapper extends BaseMapper<UserPlus> {

  void saveUserPlusWithoutId(UserPlus userPlus);
}
