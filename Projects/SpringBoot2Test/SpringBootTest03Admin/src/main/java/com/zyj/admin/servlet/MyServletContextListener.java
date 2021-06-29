package com.zyj.admin.servlet;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import lombok.extern.slf4j.Slf4j;

/**
 * @author zyj
 * @create 2021-06-12 20:39
 *
 * 监听器
 * 使用Servlet API 注入Listener
 */
@Slf4j
//@WebListener
public class MyServletContextListener implements ServletContextListener {

  @Override
  public void contextInitialized(ServletContextEvent sce) {
    log.info("MyServletContextListener监听项目初始化完成");
  }

  @Override
  public void contextDestroyed(ServletContextEvent sce) {
    log.info("MyServletContextListener监听项目销毁");
  }
}
