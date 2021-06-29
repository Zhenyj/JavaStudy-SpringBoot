package com.zyj.admin.config;

import com.zyj.admin.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author zyj
 * @create 2021-06-08 23:11
 *
 * 1、编写一个拦截器实现HandlerInterceptor接口
 * 2、拦截器注册到容器中
 * 3、指定拦截规则,注意【如果是拦截所有，静态资源也会被拦截】
 *
 * *@EnableWebMvc：全面接管
 * 1、官方的自动配置全部失效,需要自己重新定义慎用
 */

//@EnableWebMvc // 全面接管
@Configuration
public class AdminConfig implements WebMvcConfigurer {

//  /**
//   * 使用@EnableWebMvc注解后重新定义静态资源行为
//   * @param registry
//   */
//  @Override
//  public void addResourceHandlers(ResourceHandlerRegistry registry) {
//    /**
//     * 访问 /aa/** 所有请求都去 classpath:/static/ 下面进行匹配
//     */
//    registry.addResourceHandler("/aa/**")
//    .addResourceLocations("classpath:/static/");
//  }

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    // addPathPatterns拦截请求
    // excludePathPatterns放行的请求
    // 拦截/**是拦截所有请求包括静态资源的请求,一般都是用/**拦截所有请求,在excludePathPatterns放行指定请求
    // 也可以在配置文件中修改静态资源访问路径前缀 然后再excludePathPatterns中放行 /前缀/**
    registry.addInterceptor(new LoginInterceptor())
        .addPathPatterns("/**")
        .excludePathPatterns("/", "/login", "/css/**", "/fonts/**", "/images/**", "/js/**","/aa/**",
            "/sql","/user","/city","/userplus/**");
  }


}
