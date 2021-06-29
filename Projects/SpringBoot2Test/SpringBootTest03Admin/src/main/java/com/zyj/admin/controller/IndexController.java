package com.zyj.admin.controller;

import com.zyj.admin.bean.User;
import javax.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.util.StringUtils;

/**
 * @author zyj
 * @create 2021-06-08 20:06
 */

@Slf4j
@Controller
public class IndexController {

  @Autowired
  JdbcTemplate jdbcTemplate;

  @ResponseBody
  @GetMapping("/sql")
  public String queryFromDb(){
    Long num = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM user", Long.class);
    return num.toString();
  }

  /**
   * 跳转登录页
   *
   * @return
   */
  @GetMapping({"/","/login"})
  public String loginPage() {
    return "login";// 模板名
  }

  @PostMapping("login")
  public String main(User user, HttpSession session, Model model) {
    if (!StringUtils.isEmpty(user.getUserName()) && "123456".equals(user.getPassword())) {
      // 把登录成功的用户保存起来
      session.setAttribute("loginUser", user);
      // 登录成功才能进行重定向
      // 因为正常跳转main页面的话,浏览器的请求还是login,刷新页面会导致重新提交表单发送login请求
      // 所以使用redirect进行重定向
      return "redirect:/main.html";
    } else {
      model.addAttribute("msg", "账号密码错误");
      // 回到登录页
      return "login";
    }
  }

  /**
   * main页面
   *
   * @return
   */
  @GetMapping("main.html")
  public String mainPage(HttpSession session,Model model) {
    log.info("当前方式是{}", "mainPage");
    // 这样会导致请求路径为main.html就会进入页面
    // 是否登录,拦截器、过滤器
    // 登录页面重定向前,添加attribute来进行验证,防止用户直接通过main.html请求进入main页面
    Object loginUser = session.getAttribute("loginUser");
    if (loginUser != null) {
      return "main";
    }else{
      model.addAttribute("msg", "请先登录");
      return "login";
    }
  }
}
