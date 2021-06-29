package com.zyj.admin.config;

import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zyj
 * @create 2021-06-14 14:32
 */
@Configuration
public class MybatisConfig {

  @Bean
  public MybatisPlusInterceptor paginationInnerInterceptor(){
    MybatisPlusInterceptor mybatisPlusInterceptor = new MybatisPlusInterceptor();

    // 分页拦截器
    PaginationInnerInterceptor paginationInnerInterceptor = new PaginationInnerInterceptor();
    paginationInnerInterceptor.setOverflow(true); // true:最后一页点下一页回到首页,false:继续请求下一页
    paginationInnerInterceptor.setMaxLimit(500L);
    mybatisPlusInterceptor.addInnerInterceptor(paginationInnerInterceptor);
    return mybatisPlusInterceptor;
  }
}
