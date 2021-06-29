package com.zyj.boot.bean;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author zyj
 * @create 2021-06-05 21:22
 */

@Component
@ConfigurationProperties(prefix = "person")
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Person {
  private String name;
  private Boolean boss;
  private Date both;
  private Integer age;
  private Pet pet;
  private String[] interests;
  private List<String> animal;
  private Map<String,Object> score;
  private Set<Double> salarys;
  private Map<String,List<Pet>> allPets;
}
