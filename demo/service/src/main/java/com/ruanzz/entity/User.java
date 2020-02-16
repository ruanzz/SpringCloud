package com.ruanzz.entity;

import com.ruanzz.starter.entity.BaseEntity;
import lombok.Data;

/**
 * @author Zhenzhuo.Ruan
 */
@Data
public class User extends BaseEntity {

  private static final long serialVersionUID = 3285950839417152875L;

  private String name;
  private Integer age;
  private String email;
}
