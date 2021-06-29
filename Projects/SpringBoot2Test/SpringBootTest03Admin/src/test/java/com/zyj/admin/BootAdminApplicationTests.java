package com.zyj.admin;

import com.zyj.admin.bean.UserPlus;
import com.zyj.admin.mapper.UserPlusMapper;
import java.util.List;
import java.util.Map;
import javax.sql.DataSource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

@Slf4j
@SpringBootTest
class BootAdminApplicationTests {

  @Autowired
  JdbcTemplate jdbcTemplate;

  @Autowired
  DataSource dataSource;

  @Autowired
  UserPlusMapper userPlusMapper;

  @Test
  void contextLoads() {
//    List<Map<String, Object>> list = jdbcTemplate.queryForList("SELECT * FROM user");
    Long num = jdbcTemplate.queryForObject("SELECT count(*) FROM user", Long.class);
    log.info("记录数:{}",num);

    log.info("数据源类型:{}",dataSource.getClass());
  }


  @Test
  void testUserPlusMapper(){
    UserPlus userPlus = userPlusMapper.selectById(1);
    log.info("用户信息:{}", userPlus);
  }
}
