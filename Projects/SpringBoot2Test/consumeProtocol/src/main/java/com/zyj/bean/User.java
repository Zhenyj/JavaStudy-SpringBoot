package com.zyj.bean;

/**
 * @author zyj
 * @create 2021-06-02 17:50
 */

@SuppressWarnings("All")
public class User {

  // 用户ID
  private String userId;
  // 卡号
  private String cardId;
  // 姓名
  private String userName;
  // 现金余额
  private Double cashBalance;
  // 补贴余额
  private Double subsidyBalance;
  // 11位电话
  private String tel;
  // 密码
  private String password;

  public User() {
  }

  public User(String userId, String cardId, String userName, Double cashBalance, Double subsidyBalance,
      String tel, String password) {
    this.userId = userId;
    this.cardId = cardId;
    this.userName = userName;
    this.cashBalance = cashBalance;
    this.subsidyBalance = subsidyBalance;
    this.tel = tel;
    this.password = password;
  }

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public String getCardId() {
    return cardId;
  }

  public void setCardId(String cardId) {
    this.cardId = cardId;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public Double getCashBalance() {
    return cashBalance;
  }

  public void setCashBalance(Double cashBalance) {
    this.cashBalance = cashBalance;
  }

  public Double getSubsidyBalance() {
    return subsidyBalance;
  }

  public void setSubsidyBalance(Double subsidyBalance) {
    this.subsidyBalance = subsidyBalance;
  }

  public String getTel() {
    return tel;
  }

  public void setTel(String tel) {
    this.tel = tel;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  @Override
  public String toString() {
    return "User{" +
        "userId='" + userId + '\'' +
        ", cardId='" + cardId + '\'' +
        ", userName='" + userName + '\'' +
        ", cashBalance=" + cashBalance +
        ", subsidyBalance=" + subsidyBalance +
        '}';
  }
}
