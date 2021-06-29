package com.zyj.boot;

import ch.qos.logback.core.db.DBHelper;
import com.zyj.boot.bean.Pet;
import com.zyj.boot.bean.User;
import com.zyj.boot.config.Myconfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author zyj
 * @create 2021-06-02 9:19
 */
// 告诉SpringBoot这是一个SpringBoot应用
@SpringBootApplication
public class MainApplication {

  public static void main(String[] args) {
    // 启动,返回IOC容器
    ConfigurableApplicationContext run = SpringApplication.run(MainApplication.class, args);
    // 查看容器里的组件
    String[] beanDefinitionNames = run.getBeanDefinitionNames();
    for (String beanDefinitionName : beanDefinitionNames) {
      System.out.println(beanDefinitionName);
    }

    User obj1 = run.getBean("user01",User.class);
    User obj2 = run.getBean("user01",User.class);
    System.out.println("组件:"+(obj1==obj2));

    //如果@Configuration( proxyBeanMethods = true)代理对象调用方法。SpringBoot总会检查这个组件是否是代理
    //保持组件单实例
    Myconfig mc = run.getBean(Myconfig.class);
    User user1 = mc.user01();
    User user2 = mc.user01();
    System.out.println(user1==user2);

    User user01 = run.getBean("user01",User.class);
    Pet tom01 = run.getBean("tom",Pet.class);
    System.out.println("用户的宠物:"+(user01.getPet()==tom01));

    System.out.println("===========");
    String[] beanNamesForType = run.getBeanNamesForType(User.class);
    for (String s : beanNamesForType) {
      System.out.println(s);
    }
    DBHelper bean = run.getBean(DBHelper.class);
    System.out.println(bean);

    System.out.println("haha:"+run.containsBean("haha"));
    System.out.println("hehe:"+run.containsBean("hehe"));
  }
}
