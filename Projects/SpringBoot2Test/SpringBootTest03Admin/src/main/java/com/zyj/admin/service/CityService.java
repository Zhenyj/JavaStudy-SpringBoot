package com.zyj.admin.service;

import com.zyj.admin.bean.City;

/**
 * @author zyj
 * @create 2021-06-14 13:59
 */
public interface CityService {

  public City getCityById(Long id);

  public void saveCity(City city);
}
