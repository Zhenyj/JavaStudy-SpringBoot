package com.zyj.admin.mapper;

import com.zyj.admin.bean.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author zyj
 * @create 2021-06-13 21:46
 */

//@Mapper 主程序入口标注@MapperScan扫描该包下的所有文件即可不需要单独使用注解
public interface UserMapper {


  public abstract User getUserByName(String userName);
}
