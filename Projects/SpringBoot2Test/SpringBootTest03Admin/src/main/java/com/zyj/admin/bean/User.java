package com.zyj.admin.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Component;

/**
 * @author zyj
 * @create 2021-06-08 20:35
 */

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class User {

  private Integer id;

  private String userName;
  private String password;

  public User(String userName,String password){
    this.userName=userName;
    this.password=password;
  }
}
