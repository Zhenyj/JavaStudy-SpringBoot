package com.springboot;

import com.springboot.bean.Person;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * springBoot单元测试
 */
@RunWith(SpringRunner.class)
@SpringBootTest
class SpringBoot02ApplicationTests {

  @Autowired
  private Person person;

  @Test
  void contextLoads() {
    System.out.println(person);
  }

}
