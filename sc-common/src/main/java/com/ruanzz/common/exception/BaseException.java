package com.ruanzz.common.exception;

import com.ruanzz.common._enum.ExceptionEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ruanzz
 * @date 2018/12/16
 * @description 基础异常
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseException extends RuntimeException {
  private ExceptionEnum exceptionEnum;
}
