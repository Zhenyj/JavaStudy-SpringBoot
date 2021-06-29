package com.zyj.controller;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.boot.Banner.Mode;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author zyj
 * @create 2021-06-07 20:12
 *
 * 普通的控制器,用于页面跳转
 */
@Controller
public class RequestController {

  @GetMapping("/goto")
  public String goToPage(HttpServletRequest request) {
    request.setAttribute("msg", "成功....");
    request.setAttribute("code", 200);
    return "forward:/success";// 转发到 /success请求
  }

  /**
   *
   * 可以通过@RequestAttribute获取attribute(域属性)
   * @param msg
   * @return
   */
  @GetMapping("/success")
  @ResponseBody
  public Map success(@RequestAttribute("msg") String msg,
      @RequestAttribute("code") String code,
      HttpServletRequest request) {
    Object msg1 = request.getAttribute("msg");

    Map<String, Object> map = new HashMap<>();

    map.put("req_method", msg1);
    map.put("annotation_msg", msg);
    map.put("annotation_code", code);
    return map;
  }

  @GetMapping("/params")
  public String testParam(Map<String,Object> map,
      Model model,
      HttpServletRequest request,
      HttpServletResponse response){
    map.put("hello", "world 666");
    model.addAttribute("world", "hello 666");
    request.setAttribute("message", "hello world");
    response.addCookie(new Cookie("c1", "v1"));
    return "forward:/success1";
  }

  @GetMapping("/success1")
  @ResponseBody
  public Map success1(HttpServletRequest request) {
    Object msg1 = request.getAttribute("msg");

    Map<String, Object> map = new HashMap<>();

    Object hello = request.getAttribute("hello");
    Object world = request.getAttribute("world");
    Object message = request.getAttribute("message");
    map.put("hello", hello);
    map.put("world", world);
    map.put("message", message);
    return map;
  }
}
