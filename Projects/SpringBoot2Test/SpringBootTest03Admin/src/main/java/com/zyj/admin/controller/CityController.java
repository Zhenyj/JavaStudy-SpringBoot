package com.zyj.admin.controller;

import com.zyj.admin.bean.City;
import com.zyj.admin.service.CityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author zyj
 * @create 2021-06-13 23:47
 */
@Slf4j
@Controller
public class CityController {

  @Autowired
  CityService cityService;

  @GetMapping("/city")
  @ResponseBody
  public City getCityById(@RequestParam("id") Long id) {
    return cityService.getCityById(id);
  }

  @PostMapping("/city")
  @ResponseBody
  public City saveCity(City city) {
    log.info("插入的city:{}", city.toString());
    cityService.saveCity(city);
    return city;
  }
}
