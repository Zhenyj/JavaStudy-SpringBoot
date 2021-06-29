package com.zyj.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.Cookie;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zyj
 * @create 2021-06-07 12:24
 *
 * <li>@PathVariable（路径变量）</1i>
 * <1i>@RequestHeader（获取请求头)</li>
 * <li>@RequestParam（获取请求参数)</li>
 * <1i>@CookieValue（获取cookie值）</li>
 * <li>@RequestBody（获取请求体[POST])</1i>
 * <1i>@RequestAttribute（获取request域属性）</li>
 * <li>@MatrixVariable（矩阵变量)</1i>
 */

@RestController
public class ParameterTestController {

  /**
   * 可用postman测试
   * * @PathVariable表示从来源于路径变量 /car/{id}
   * * @RequestParam表示来源于请求参数 /car?id=xxx
   * * @CookieValue可用获取cookie值
   *
   * 可用用Map接受所有的@PathVariable,@RequestParam中所有接收到的变量或参数,封装到一个Map中
   *
   * @param id
   * @param name
   *
   * @return
   */
  @GetMapping("/car/{id}/owner/{username}") //相当于/car/xxx/owner/xxx
  public Map<String, Object> getCar(@PathVariable("id") Integer id, @PathVariable("username") String name,
      @PathVariable Map<String, String> pv,
      @RequestHeader("User-Agent") String userAgent,
      @RequestHeader Map<String, String> header,
      @RequestParam("age") Integer age,
      @RequestParam("inters") List<String> inters,
      @RequestParam Map<String, String> params) {
    // http://localhost:8080/car/1/owner/zhangsan
    // @PathVariable
    Map<String, Object> map = new HashMap<>();
    map.put("id", id);
    map.put("name", name);
    map.put("pv", pv);
    // @RequestHeader
    map.put("userAgent", userAgent);
    map.put("headers", header);
    //http://localhost:8080/car/1/owner/zhangsan?age=18&inters=basketball&inters=game
    // @RequestParam
    map.put("age", age);
    map.put("inters", inters);// 多值属性用List接收(&inters=basketball&inters=game)
    map.put("params", params); // 因为是用params中的value是String,所以多值属性也只会有第一个值

    // @CookieValue
//    @CookieValue("_ga") String _ga,
//    @CookieValue("_ga") Cookie cookies
//    map.put("_ga", _ga);
//    System.out.println(cookie.getName() + "=====>" + cookie.getValue());
    return map;
  }

  /**
   * * @RequestBody 获取post请求的请求体,required为false时支持参数null值
   * @param content
   * @return
   */
  @PostMapping("/save")
  public Map<String,Object> postMethod(@RequestBody(required = false) String content){
    // http://localhost:8080/save
    Map<String, Object> map = new HashMap<>();
    map.put("content", content);
    return map;
  }

  /**
   * * @MatrixVariable（矩阵变量)
   * url:http://localhost:8080/cars/sell;low=34;brand=BYD,AUDI,BMW
   *
   * 语法:';'后面是矩阵变量一个key对多个value时用','隔开,可以用List集合接收。而前面的/cars/sell才是真正的请求路径
   * 注意：
   * 1.SpringBoot默认禁用了矩阵变量
   * 手动开启:
   * 原理：对于路径的处理,UrlPathHelper进行解析,而其中的removeSemicolonContent方法会移除分号内容
   * 2.因为矩阵变量必须有url路径变量才能被解析,所以矩阵变量是要绑定在路径变量中的,所以需要用{xxx},
   * 并可以用@PathVariable获取实际的请求路径,就是路径变量不带'/'
   * @return
   */
  @GetMapping("/cars/{path}")
  public Map carsSell(@MatrixVariable("low") Integer low,
      @MatrixVariable("brand") List<String> brand,
      @PathVariable("path") String path){
    Map<String, Object> map = new HashMap<>();
    map.put("low",low);
    map.put("brand", brand);
    map.put("path", path);
    return map;
  }

  /**
   * url:http://localhost:8080/boss/1;age=30/2;age=25
   *
   * 如果存在相同名字的矩阵变量,可以利用设置@MatrixVariable中pathVar值来判断是哪个路径变量里的矩阵变量
   * @param bossAge
   * @param empAge
   * @return
   */
  @GetMapping("/boss/{bossId}/{empId}")
  public Map boos(@MatrixVariable(value = "age",pathVar = "bossId") Integer bossAge,
      @MatrixVariable(value = "age",pathVar = "empId") Integer empAge){
    Map<String,Object> map = new HashMap<>();
    map.put("bossAge", bossAge);
    map.put("empAge", empAge);
    return map;
  }
}
