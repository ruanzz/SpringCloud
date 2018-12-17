package com.ruanzz.common.vo;

import com.ruanzz.common._enum.ExceptionEnum;
import lombok.Data;

/**
 * @author ruanzz
 * @date 2018/12/16
 * @description 响应结果
 */
@Data
public class ResponeResult {

  private int status;
  private String message;
  private Long timestamp;

  public ResponeResult(ExceptionEnum exceptionEnum) {
    this.status = exceptionEnum.getStatus();
    this.message = exceptionEnum.getMsg();
    this.timestamp = System.currentTimeMillis();
  }
}
