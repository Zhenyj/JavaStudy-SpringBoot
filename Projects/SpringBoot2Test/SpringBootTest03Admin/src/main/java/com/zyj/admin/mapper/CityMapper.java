package com.zyj.admin.mapper;

import com.zyj.admin.bean.City;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author zyj
 * @create 2021-06-13 23:48
 *
 * 纯注解方式
 * 可以注解和xml一起使用
 */
//@Mapper 主程序入口标注@MapperScan扫描该包下的所有文件即可不需要单独使用注解
public interface CityMapper {

  @Select("select * from city where id=#{id}")
  public City getCityById(Long id);

  public void saveCity(City city);
}
