package com.zyj.boot.config;

import ch.qos.logback.core.db.DBHelper;
import com.zyj.boot.bean.Car;
import com.zyj.boot.bean.Pet;
import com.zyj.boot.bean.User;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

/**
 * @author zyj
 * @create 2021-06-02 10:22
 *
 * 1、配置类里面使用@Bean标注在方法上给容器注册组件，默认也是单实例的
 * 2、配置类本身也是组件
 * 3、proxyBeanMethods: 代理bean的方法,默认true使用代理
 * FuLL(proxyBeanMethods = true),如果会被别人组件依赖，一般使用true
 * Lite(proxyBeanMethods = false),如果只是单单注册组件且没有别人组件依赖于该组件时,一般用false
 * 组件依赖
 * 4、Import({User.cLass,DBHelper.class})
 * 给容器中自动创建出这两个类型的组件、默认组件的名字就是全类名
 */

@Import({User.class, DBHelper.class})
@Configuration(proxyBeanMethods = false) // 告诉SpringBoot这是一个配置类
//@ConditionalOnBean(name = "tom") // 条件装配注解,有tom组件时才将以下组件注入容器
@ConditionalOnMissingBean(name = "tom") // 没有tom组件时将组件注入容器
@ImportResource("classpath:beans.xml")//导入资源,可以导入Spring的配置文件
//1、开启Car配置绑定功能
//2、把这个Car这个组件自动注册到容器中
//3、此注解可以将第三方的类注入容器中(本项目的类自然也可以),因为第三方写好的类我们不能加@Component注解,就可以用该注解实现
@EnableConfigurationProperties(Car.class)
public class Myconfig {

  /**
   * 无论对配置类中的这个组件注册方法调用多少次获取的都是之前注册容器中的单实例对象
   * @return
   */
  // 条件装配注解
//  @ConditionalOnBean(name = "tom") //判断是否有该名字的组件,如果有才注入这个组件,没有则不注入此组件
  @Bean //给容器中添加组件。以方法名作为组件的id。返回类型就是组件类型。返回的值，就是组件在容器中的实例
  public User user01(){
    User zyj = new User("甄英俊",18);
    // user组件依赖Pet组件
    zyj.setPet(tomcatPet());
    return zyj;
  }

  @Bean("tom")
  public Pet tomcatPet(){
    return new Pet("tomcat");
  }
}
