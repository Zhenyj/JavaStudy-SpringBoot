package com.zyj.admin;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author zyj
 * @create 2021-06-15 8:50
 */
@DisplayName("Junit5功能测试")
@SpringBootTest //有这个注解才该测试类采用与springboot功能(@ExtendWith(SpringExtension.class))
public class JunitTests {

  @BeforeAll  // 所有测试之前
  static void testBeforeAll() {
    System.out.println("所有测试就要开始了...");
  }

  @BeforeEach
    // 在每个单元测试之前运行
  void testBeforeEach() {
    System.out.println("测试就要开始了......");
  }

  /**
   * 如果前一个断言失败,就结束执行,就不会执行后面的代码
   */
  @Test
  @DisplayName("简单断言测试")
  void testSimpleAssertions() {
    // assertEquals是否相等 assertNotEquals不相等
    assertEquals(5, cal(2, 3), "业务逻辑计算失败");
    String str1 = "abc";
    String str2 = "abc";
    String str3 = new String("abc");
    // 判断是否同一个对象
    assertSame(str1, str2, "两个对象不一样");
    assertSame(str2, str3, "两个对象不一样");
  }

  @Test
  @DisplayName("array assertion")
  void testArray() {
    // 数组比较,如果内容一一对应相等则相等
    assertArrayEquals(new int[]{1, 2}, new int[]{1, 2}, "数组不相等");
    assertArrayEquals(new int[]{2, 1}, new int[]{1, 2}, "数组不相等");
  }

  /**
   * 组合断言
   */
  @Test
  @DisplayName("组合断言")
  void all() {
    /**
     * 所有断言需要全部成功
     *
     * 可变参数Executable是函数式接口，可以使用lambda
     */
    assertAll("test",
        () -> assertTrue(true && true, "结果不是true"),
        () -> assertEquals(1, 2, "结果不是1"));
    System.out.println("断言正确");
  }

  @Test
  @DisplayName("异常断言")
  void testException() {
    // 判断是否会抛出某个异常
    assertThrows(ArithmeticException.class, () -> {
      int i = 10 / 1;
    }, "业务逻辑居然正常运行");
  }

  @Test
  @DisplayName("快速失败断言")
  void testFail() {
    if (2 == 2) {
      fail("测试失败");
    }
  }

  /**
   * 测试前置条件
   * 类似Disabled(禁用/跳过)
   */
  @Test
  @DisplayName("前置条件")
  void testAssumptions(){
    Assumptions.assumeTrue(false,"结果不是true");
    System.out.println(1111111);
  }

  @Test
  @DisplayName("测试displayName注解╯°□°）╯")
  void testDisplayName() {
    System.out.println(1);
  }

  private int cal(int a, int b) {
    return a + b;
  }

  @Disabled // 表示禁用,全部执行的时候不会执行该测试
  @Test
  void test2() {
    System.out.println(2);
  }

  @Test
  @Timeout(value = 500, unit = TimeUnit.MILLISECONDS)
    // 超时时间,默认单位秒
  void testTimeout() throws InterruptedException {
    Thread.sleep(600);
  }

  @Test
  @RepeatedTest(5)
    //重复执行5次
  void test3() {
    System.out.println(3);
  }

  @AfterEach
    // 在每个单元测试完成运行
  void testAfterEach() {
    System.out.println("测试结束......");
  }

  @AfterAll // 所有测试之后
  static void testAfterAll() {
    System.out.println("所有测试结束...");
  }
}
