package com.zyj.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.PathMatcher;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.util.UrlPathHelper;

/**
 * @author zyj
 * @create 2021-06-06 22:48
 */

@Configuration(proxyBeanMethods = false)
public class WebConfig implements WebMvcConfigurer {

  @Bean
  public HiddenHttpMethodFilter hiddenHttpMethodFilter(){
    HiddenHttpMethodFilter methodFilter = new HiddenHttpMethodFilter();
//    methodFilter.setMethodParam("_m"); //修改表单使用Rest风格时的,将_method改成_m
    return methodFilter;
  }

  /**
   * 设置不移除分号后面的内容，开启请求的矩阵变量功能
   */
  // 第一行种方法,直接往容器中放入一个组件
//  @Bean
//  public WebMvcConfigurer webMvcConfigurer(){
//    return new WebMvcConfigurer() {
//      @Override
//      public void configurePathMatch(PathMatchConfigurer configurer) {
//        UrlPathHelper urlPathHelper = new UrlPathHelper();
//        // 设置不移除分号后面的内容，开启请求的矩阵变量功能
//        urlPathHelper.setRemoveSemicolonContent(false);
//        configurer.setUrlPathHelper(urlPathHelper);
//      }
//    };
//  }

  // 第二种方法,实现WebMvcConfigurer重写configurePathMatch
  @Override
  public void configurePathMatch(PathMatchConfigurer configurer) {
    UrlPathHelper urlPathHelper = new UrlPathHelper();
    // 设置不移除分号后面的内容，开启请求的矩阵变量功能
    urlPathHelper.setRemoveSemicolonContent(false);
    configurer.setUrlPathHelper(urlPathHelper);
  }
}
