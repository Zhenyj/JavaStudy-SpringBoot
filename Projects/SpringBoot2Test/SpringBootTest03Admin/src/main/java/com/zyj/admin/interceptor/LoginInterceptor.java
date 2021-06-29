package com.zyj.admin.interceptor;

import java.lang.ProcessBuilder.Redirect;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.logging.Log;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author zyj
 * @create 2021-06-08 23:07
 *
 * 登录检查
 * 1、配置好拦截器要拦截那些请求
 * 2、把这些配置放在容器中
 */
@Slf4j
public class LoginInterceptor implements HandlerInterceptor {

  /**
   * 目标方法执行之前
   * @param request
   * @param response
   * @param handler
   * @return
   * @throws Exception
   */
  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    //登录检查逻辑
    HttpSession session = request.getSession();
    Object loginUser = session.getAttribute("loginUser");

    if(loginUser!=null){
      return true;
    }
    //拦截,未登录
    request.setAttribute("msg", "请先登录");
//    response.sendRedirect("/");
    // 页面重定向后取不到attribute,使用request获取到转发器进行转发
    request.getRequestDispatcher("/").forward(request, response);
    return false;
  }

  /**
   * 目标方法执行完成
   * @param request
   * @param response
   * @param handler
   * @param modelAndView
   * @throws Exception
   */
  @Override
  public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
      ModelAndView modelAndView) throws Exception {
    log.info("postHandle执行{}", modelAndView);
  }

  /**
   * 页面渲染以后
   * @param request
   * @param response
   * @param handler
   * @param ex
   * @throws Exception
   */
  @Override
  public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
      throws Exception {
    log.info("afterCompletion执行异常{}",ex);
  }
}
