package com.ruanzz.common.exception;

import com.ruanzz.common._enum.ExceptionEnum;
import lombok.Getter;

/**
 * @author ruanzz
 * @date 2018/12/16
 * @description 基础异常
 */
@Getter
public class BaseException extends RuntimeException {

  private ExceptionEnum exceptionEnum;

  public BaseException(ExceptionEnum exceptionEnum) {
    System.out.println("******************" + exceptionEnum.getMsg());
    this.exceptionEnum = exceptionEnum;
  }
}
