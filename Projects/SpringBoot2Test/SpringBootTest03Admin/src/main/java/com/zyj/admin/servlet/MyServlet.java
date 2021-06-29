package com.zyj.admin.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author zyj
 * @create 2021-06-12 12:20
 *
 * 使用Servlet API 注入HttpServlet
 * 使用Servlet API 直接响应，没有经过Spring拦截器
 */
//@WebServlet(urlPatterns = "/my")
public class MyServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    resp.getWriter().write("666666");
  }
}
