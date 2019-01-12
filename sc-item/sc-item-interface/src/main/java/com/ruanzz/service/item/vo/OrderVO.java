package com.ruanzz.service.item.vo;

import java.io.Serializable;

/**
 * @author ruanzz
 * @date 2019/1/12
 * @description order VO类
 */
public class OrderVO implements Serializable {

  private String code;

  public OrderVO() {
  }

  public OrderVO(String code) {
    this.code = code;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

}
