package com.zyj.bean;

/**
 * @author zyj
 * @create 2021-06-02 18:04
 */
public enum PayType {
  CASH("现金"),
  SUBSIDY("补贴");

  String type;

  PayType(String type) {
    this.type = type;
  }

  public String getType() {
    return type;
  }
}
