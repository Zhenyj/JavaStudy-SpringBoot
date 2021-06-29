package com.zyj.bean;

/**
 * @author zyj
 * @create 2021-06-02 22:10
 */
@SuppressWarnings("All")
public class SendMessage {
  // 功能码
  private String f;
  // 金额
  private Double m;
  // 设备号
  private String d;
  // 管理员
  private String n;
  // 卡号
  private String c;
  // 菜单号
  private String[] u;
  // 每个菜
  private String[] k;
  // 计次版本
  private String v;
  // 11位电话号码
  private String t;
  // 6位密码
  private String p;
  // 微信收款码
  private String g;
  // 签名
  private static final String X="05D5FF3632384E4D4325385600000000";

  public SendMessage() {
  }

  public SendMessage(String f, Double m, String d, String n, String c, String[] u, String[] k, String v, String t,
      String p, String g) {
    this.f = f;
    this.m = m;
    this.d = d;
    this.n = n;
    this.c = c;
    this.u = u;
    this.k = k;
    this.v = v;
    this.t = t;
    this.p = p;
    this.g = g;
  }

  public String getF() {
    return f;
  }

  public void setF(String f) {
    this.f = f;
  }

  public Double getM() {
    return m;
  }

  public void setM(Double m) {
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

  public String getC() {
    return c;
  }

  public void setC(String c) {
    this.c = c;
  }

  public String[] getU() {
    return u;
  }

  public void setU(String[] u) {
    this.u = u;
  }

  public String[] getK() {
    return k;
  }

  public void setK(String[] k) {
    this.k = k;
  }

  public String getV() {
    return v;
  }

  public void setV(String v) {
    this.v = v;
  }

  public String getT() {
    return t;
  }

  public void setT(String t) {
    this.t = t;
  }

  public String getP() {
    return p;
  }

  public void setP(String p) {
    this.p = p;
  }

  public String getG() {
    return g;
  }

  public void setG(String g) {
    this.g = g;
  }

  /**
   * F功能码M金额D设备号C卡号
   * @return
   */
  public String FMDCtoString(){
    return "F:"+f+"&M:"+m+"&D:"+d+"&C:"+c+"&X:"+X;
  }

  /**
   * F功能码U菜单号D设备号
   * @return
   */
  public String FUDtoString(){
    StringBuffer sb = new StringBuffer("F:"+f+"&U:");
    for(String s :u){
      sb.append(s+",");
    }
    if(sb.toString().endsWith(",")){
      sb.deleteCharAt(sb.length()-1);
    }
    sb.append("&D:"+d+"&X:"+X);
    return sb.toString();
  }

  /**
   * F功能码U菜单号（多个菜单用英文逗号隔开）K每个菜D设备号C卡号
   * @return
   */
  public String FUKDCtoString(){
    StringBuffer sb = new StringBuffer("F:"+f+"&U:");
    for(String s :u){
      sb.append(s+",");
    }
    if(sb.toString().endsWith(",")){
      sb.deleteCharAt(sb.length()-1);
    }
    for(String s:k){
      sb.append(s+",");
    }
    if(sb.toString().endsWith(",")){
      sb.deleteCharAt(sb.length()-1);
    }
    sb.append("&D:"+d+"&C:"+c+"&X:"+X);
    return sb.toString();
  }

  /**
   * F功能码D设备号C卡号
   * @return
   */
  public String FDCtoString(){
    return "F:"+f+"&D:"+d+"&C:"+c+"&X:"+X;
  }

  /**
   * F功能码D设备号C卡号M金额N管理员
   * @return
   */
  public String FDCMNtoString(){
    return "F:"+f+"&M:"+m+"&D:"+d+"&C:"+c+"N:"+n+"&X:"+X;
  }

  /**
   * F功能码D设备号V计次版本
   * @return
   */
  public String FDVtoString(){
    return "F:"+f+"&D:"+d+"&V"+v+"&X:"+X;
  }

  /**
   * F功能码D设备号
   * @return
   */
  public String FDtoString(){
    return "F:"+f+"&D:"+d+"&X:"+X;
  }

  /**
   * F功能码D设备号C卡号T11位电话号P6位密码
   * @return
   */
  public String FDCTPtoString(){
    return "F:"+f+"&D:"+d+"&C:"+c+"&T:"+t+"&P:"+p+"&X:"+X;
  }

  /**
   * F功能码D机器号G微信收款码M消费金额
   * @return
   */
  public String FDGMtoString(){
    return "F:"+f+"&D:"+d+"&G:"+g+"&M:"+m+"&X:"+X;
  }
}
