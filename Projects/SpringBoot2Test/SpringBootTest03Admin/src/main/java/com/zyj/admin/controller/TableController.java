package com.zyj.admin.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zyj.admin.bean.User;
import com.zyj.admin.bean.UserPlus;
import com.zyj.admin.service.UserPlusService;
import java.lang.ProcessBuilder.Redirect;
import java.util.Arrays;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * @author zyj
 * @create 2021-06-08 21:30
 */
@Slf4j
@Controller
public class TableController {

  @Autowired
  UserPlusService userPlusService;

  @GetMapping("/basic_table")
  public String basicTable() {
    return "table/basic_table";
  }

  @GetMapping("/dynamic_table")
  public String dynamicTable(@RequestParam(value = "pn", defaultValue = "1") Integer pn, Model model) {
    // 表格内容动态遍历
//    List<User> users = Arrays.asList(new User("zhangsan", "123456"), new User("list", "123456"),
//        new User("haha", "123456"), new User("hehe", "123456"),
//        new User("hanhan", "123456"));
//    model.addAttribute("users", users);
    List<UserPlus> list = userPlusService.list();
//    model.addAttribute("users", list);
    Page<UserPlus> userPlusPage = new Page<>(pn, 2); // 当前页,单页数据量
    Page<UserPlus> page = userPlusService.page(userPlusPage, null);//分页查询的结果

    model.addAttribute("page", page);
    return "table/dynamic_table";
  }

  @GetMapping("/responsive_table")
  public String responsiveTable() {
    return "table/responsive_table";
  }

  @GetMapping("/editable_table")
  public String editableTable() {
    return "table/editable_table";
  }


}
