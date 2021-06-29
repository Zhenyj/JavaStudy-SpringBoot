package com.zyj.admin.service.impl;

import com.zyj.admin.bean.City;
import com.zyj.admin.mapper.CityMapper;
import com.zyj.admin.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zyj
 * @create 2021-06-13 23:48
 */
@Service
public class CityServiceImpl implements CityService {

  @Autowired
  CityMapper cityMapper;

  public City getCityById(Long id) {
    return cityMapper.getCityById(id);
  }

  public void saveCity(City city) {
    cityMapper.saveCity(city);
  }
}
