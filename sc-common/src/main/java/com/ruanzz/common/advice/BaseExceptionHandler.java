package com.ruanzz.common.advice;

import com.ruanzz.common.exception.AppException;
import com.ruanzz.common.vo.ResponeResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author ruanzz
 * @date 2018/12/16
 * @description 异常拦截处理器
 */
@Slf4j
@RestControllerAdvice
public class BaseExceptionHandler {

  @ExceptionHandler(AppException.class)
  public ResponseEntity<ResponeResult> handleException(AppException exception) {
    return ResponseEntity.status(exception.getExceptionEnum().getStatus())
        .body(new ResponeResult(exception.getExceptionEnum()));
  }
}
