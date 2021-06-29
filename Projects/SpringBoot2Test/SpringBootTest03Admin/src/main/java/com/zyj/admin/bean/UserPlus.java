package com.zyj.admin.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author zyj
 * @create 2021-06-14 13:39
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@TableName("user_plus") // 指定对应的数据库表名,默认找表名与类名相同的数据库表
public class UserPlus {
  private Long id;
  private String name;
  private Integer age;
  private String email;

  @TableField(exist = false) // 表明数据库中没有该字段,mybatis-plus就不会去匹配
  private String password;
}
