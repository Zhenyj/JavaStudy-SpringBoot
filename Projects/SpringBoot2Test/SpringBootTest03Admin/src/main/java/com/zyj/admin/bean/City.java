package com.zyj.admin.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author zyj
 * @create 2021-06-13 23:46
 */

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class City {
  private Long id;
  private String name;
  private String state;
  private String country;

  public City(String name,String state,String country){
    this.name = name;
    this.state = state;
    this.country = country;
  }
}
