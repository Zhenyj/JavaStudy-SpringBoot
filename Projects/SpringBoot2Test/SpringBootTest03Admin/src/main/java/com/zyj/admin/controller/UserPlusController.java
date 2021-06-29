package com.zyj.admin.controller;

import com.zyj.admin.bean.UserPlus;
import com.zyj.admin.service.UserPlusService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * @author zyj
 * @create 2021-06-14 13:42
 */
@Slf4j
@Controller
@RequestMapping("/userplus")
public class UserPlusController {

  @Autowired
  UserPlusService userPlusService;

  @GetMapping("/add")
  public String addUserPlus(UserPlus userPlus,
      @RequestParam("pn") Integer pn,
      RedirectAttributes ra){
    userPlusService.saveUserPlusWithoutId(userPlus);
    ra.addAttribute("pn",pn);
    return "redirect:/dynamic_table";
  }

  @PostMapping("/add")
  public String addUserPlus(@RequestParam("pn") Integer pn,
      UserPlus userPlus,
      RedirectAttributes ra){
    userPlusService.saveUserPlusWithoutId(userPlus);
    ra.addAttribute("pn",pn);
    return "redirect:/dynamic_table";
  }

  @GetMapping("/delete/{id}")
  public String deleteUserPlus(@PathVariable("id") Integer id,
      @RequestParam(value = "pn", defaultValue = "1") Integer pn,
      RedirectAttributes ra) {

    userPlusService.removeById(id);
    // 重定向携带一个属性,返回某一页
    ra.addAttribute("pn", pn);

    return "redirect:/dynamic_table";
  }
}
