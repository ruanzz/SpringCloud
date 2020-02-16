package com.ruanzz.starter.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

/**
 * @author Zhenzhuo.Ruan
 */
public class BaseEntity implements Serializable {

  @TableId(type = IdType.AUTO)
  protected Long id;

}
