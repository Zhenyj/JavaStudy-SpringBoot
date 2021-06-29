package com.zyj.admin.servlet;

import java.util.Arrays;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zyj
 * @create 2021-06-12 20:49
 *
 * 第二种方法注入(Servlet,Filter,Listener)
 * 使用RegistrationBean注入
 */

@Configuration(proxyBeanMethods = true)// 默认true,保证依赖的组件是单实例的
public class MyRegistConfig {

  @Bean
  public ServletRegistrationBean myServlet(){
    MyServlet myServlet = new MyServlet();
    // 注册自定义的Servlet,映射路径
    return new ServletRegistrationBean(myServlet, "/my");
  }

  @Bean
  public FilterRegistrationBean myFilter(){
    MyFilter myFilter = new MyFilter();
    // 第一种拦截servlet映射的路径
//    return new FilterRegistrationBean(myFilter,myServlet());
    // 第二种另外拦截路径
    FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(myFilter);
    filterRegistrationBean.setUrlPatterns(Arrays.asList("/my","/css/*"));
    return filterRegistrationBean;
  }

  @Bean
  public ServletListenerRegistrationBean myServletContextListener(){
    return new ServletListenerRegistrationBean(new MyServletContextListener());
  }
}
