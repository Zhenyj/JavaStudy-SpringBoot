package com.zyj.bean;

import java.util.Calendar;

/**
 * @author zyj
 * @create 2021-06-02 23:04
 */

@SuppressWarnings("All")
public class acceptMessage {
  // 功能码
  private String f;
  // 金额
  private String m;
  // 设备号
  private String d;
  // 姓名
  private String n;
  // 现金,补贴
  private Double b;
  // 菜单名
  private String[] u;
  // 菜单单价
  private Double[] k;
  // 管理卡功能、挂失结果、错误类型
  private String g;
  // 次数
  private Integer r;
  // 结果的编号
  private String o;
  // 错误代码
  private String e;
  // 年*月*日*时*分*秒
  private String t;

  public acceptMessage() {
  }

  public String getF() {
    return f;
  }

  public void setF(String f) {
    this.f = f;
  }

  public String getM() {
    return m;
  }

  public void setM(String m) {
    this.m = m;
  }

  public String getD() {
    return d;
  }

  public void setD(String d) {
    this.d = d;
  }

  public String getN() {
    return n;
  }

  public void setN(String n) {
    this.n = n;
  }

  public Double getB() {
    return b;
  }

  public void setB(Double b) {
    this.b = b;
  }

  public String[] getU() {
    return u;
  }

  public void setU(String[] u) {
    this.u = u;
  }

  public Double[] getK() {
    return k;
  }

  public void setK(Double[] k) {
    this.k = k;
  }

  public String getG() {
    return g;
  }

  public void setG(String g) {
    this.g = g;
  }

  public String getO() {
    return o;
  }

  public void setO(String o) {
    this.o = o;
  }

  public String getE() {
    return e;
  }

  public void setE(String e) {
    this.e = e;
  }

  public String getT() {
    return t;
  }

  public void setT() {
    Calendar cal = Calendar.getInstance();
    int year = cal.get(Calendar.YEAR);
    int month = cal.get(Calendar.MONTH)+1;
    int day = cal.get(Calendar.DAY_OF_MONTH);
    int hour = cal.get(Calendar.HOUR_OF_DAY);
    int minute = cal.get(Calendar.MINUTE);
    int second = cal.get(Calendar.SECOND);
    t = year+"*"+month+"*"+day+"*"+hour+"*"+minute+"*"+second;
  }

  public void setT(String t) {
    this.t = t;
  }

  public Integer getR() {
    return r;
  }

  public void setR(Integer r) {
    this.r = r;
  }

  /**
   * F功能码M金额D设备号N姓名B现金,补贴
   * F功能码M金额D设备号N姓名B卡上余额
   * @return
   */
  public String FMDNBtoString(){
    return "F:"+f+"&M:"+m+"&D:"+d+"&N:"+n+"&B:"+b+"&T:"+t;
  }

  /**
   * F功能码N菜单名M菜单单价D设备号
   * @return
   */
  public String FNMDtoString(){
    return "F:"+f+"&M:"+m+"&D:"+d+"&N:"+n+"&T:"+t;
  }

  /**
   * F功能码G管理卡功能N用户姓名
   * @return
   */
  public String FGNtoString(){
    return "F:"+f+"&G:"+g+"&N:"+n+"&T:"+t;
  }

  /**
   * F功能码D设备号N姓名R次数
   * @return
   */
  public String FDNRtoString(){
    return "F:"+f+"&D:"+d+"&N:"+n+"&R:"+r+"&T:"+t;
  }

  /**
   * F功能码D设备号N姓名B余额
   * @return
   */
  public String FDNBtoString(){
    return "F:"+f+"&D:"+d+"&N:"+n+"&B:"+b+"&T:"+t;
  }

  /**
   * F功能码D设备号M消费金额R消费笔数
   * @return
   */
  public String FDMRtoString(){
    return "F:"+f+"&D:"+d+"&M:"+m+"&R:"+r+"&T:"+t;
  }

  /**
   * F功能码D设备号
   * @return
   */
  public String FDtoString(){
    return "F:"+f+"&D:"+d+"&T:"+t;
  }

  /**
   * F功能码N姓名G挂失结果O结果的编号
   * @return
   */
  public String FNGOtoString(){
    return "F:"+f+"&N:"+n+"&G:"+g+"&O:"+o+"&T:"+t;
  }

  /**
   * F功能码E错误代码G错误类型
   * @return
   */
  public String FEGtoString(){
    return "F:"+f+"&E:"+e+"&G:"+g+"&T:"+t;
  }

  /**
   * F功能码E错误代码G错误类型D设备号
   * @return
   */
  public String FEGDtoString(){
    return "F:"+f+"&E:"+e+"&G:"+g+"&D:"+d+"&T:"+t;
  }
}
