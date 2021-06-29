package com.zyj.admin.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author zyj
 * @create 2021-06-09 22:48
 *
 * 文件上传测试
 */
@Controller
@Slf4j
public class formTestController {

  @GetMapping("form_layouts")
  public String formLayouts() {
    return "form/form_layouts";
  }

  @GetMapping("editors")
  public String editors() {
    return "form/editors";
  }

  @GetMapping("form_advanced_components")
  public String form_advanced_components() {
    return "form/form_advanced_components";
  }

  @GetMapping("form_validation")
  public String form_validation() {
    return "form/form_validation";
  }

  @GetMapping("form_wizard")
  public String form_wizard() {
    return "form/form_wizard";
  }

  /**
   * MultipartFile 自动封装上传的文件
   *
   * @param email
   * @param userName
   * @param headerImg
   * @param photos
   *
   * @return
   */
  @PostMapping("/upload")
  public String upload(@RequestParam("email") String email,
      @RequestParam("username") String userName,
      @RequestParam("headerImg") MultipartFile headerImg,
      @RequestParam("photos") MultipartFile[] photos) {
    log.info("上传的信息:email={},usernamme={},headerImg={},photos={}",
        email, userName, headerImg.getSize(), photos.length);
    if (!headerImg.isEmpty()) {
      // 保存到文件服务器
      String originalFilename = headerImg.getOriginalFilename();// 获取文件名
      try {
        headerImg.transferTo(new File("F:\\JavaProjects\\idea\\SpringBootTest\\"
            + "SpringBootTest03Admin\\src\\main\\resources\\static\\upload\\" + originalFilename));
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    if (photos.length > 0) {
      for (MultipartFile photo : photos) {
        if (!photo.isEmpty()) {
          try {
            String originalFilename = photo.getOriginalFilename();
            photo.transferTo(new File("F:\\JavaProjects\\idea\\SpringBootTest\\"
                + "SpringBootTest03Admin\\src\\main\\resources\\static\\upload\\" + originalFilename));
          } catch (IOException e) {
            e.printStackTrace();
          }
        }
      }
    }
    return "redirect:/main.html";
  }
}
