package com.zyj.admin.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import java.sql.SQLException;
import java.util.Arrays;
import javax.sql.DataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zyj
 * @create 2021-06-13 14:33
 *
 * 自定义配置druid数据源
 */

@Deprecated
//@Configuration
public class MyDataSourceConfig  {

  @Bean
  @ConfigurationProperties(prefix = "spring.datasource")
  public DataSource dataSource() throws SQLException {
    DruidDataSource druidDataSource = new DruidDataSource();

//    druidDataSource.setUrl();
//    druidDataSource.setUsername();
//    druidDataSource.setPassword();
    // 加入监控功能(stat),防火墙功能(wall)
    // setXxx方法就可以在配置文件中指定
//    druidDataSource.setFilters("stat,wall");
//    druidDataSource.setMaxActive(10);
    return druidDataSource;
  }

  /**
   * 配置druid数据源的监控页功能
   * @return
   */
  @Bean
  public ServletRegistrationBean statViewServlet(){
    StatViewServlet statViewServlet = new StatViewServlet();
    ServletRegistrationBean<StatViewServlet> registrationBean = new ServletRegistrationBean<>(
        statViewServlet, "/druid/*");
    // 监管也添加初始化参数，账号密码(需要登录后才可使用监控页)
    registrationBean.addInitParameter("loginUsername","admin");
    registrationBean.addInitParameter("loginPassword", "123456");
    return registrationBean;
  }

  /**
   * WebStatFilter 用来采集web-jdbc关联监控的数据
   * @return
   */
  @Bean
  public FilterRegistrationBean webStatFilter(){
    WebStatFilter webStatFilter = new WebStatFilter();
    FilterRegistrationBean<WebStatFilter> filterRegistrationBean = new FilterRegistrationBean<>(webStatFilter);
    // 拦截路径
    filterRegistrationBean.setUrlPatterns(Arrays.asList("/*"));
    // 不拦截静态资源
    filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gis,*.jpg,*.png,*.css,*.ico,/druid/*");
    return filterRegistrationBean;
  }
}
