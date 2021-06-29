package com.zyj.admin.servlet;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import lombok.extern.slf4j.Slf4j;

/**
 * @author zyj
 * @create 2021-06-12 12:26
 *
 * 使用Servlet API 注入Filter
 */
@Slf4j
//@WebFilter(urlPatterns = {"/css/*","/images/*"}) // 单*是Servlet写法,双**Spring写法
public class MyFilter implements Filter {

  @Override
  public void init(FilterConfig filterConfig) throws ServletException {
    log.info("MyFilter初始化完成");
  }

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
      throws IOException, ServletException {
    log.info("MyFilter运行");
    chain.doFilter(request, response);// 放行
  }

  @Override
  public void destroy() {
    log.info("MyFilter初始化销毁");
  }
}
