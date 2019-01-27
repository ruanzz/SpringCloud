package com.ruanzz.common.vo;

import java.util.List;
import lombok.Data;

/**
 * @author ruanzz
 * @date 2019/1/27
 * @description REST接口返回分页数据
 */
@Data
public class PageResult<T> {

  private Long total;
  private Integer totalPage;
  private List<T> data;

  public PageResult(Long total, List<T> data) {
    this.total = total;
    this.data = data;
  }

  public PageResult(Long total, Integer totalPage, List<T> data) {
    this.total = total;
    this.totalPage = totalPage;
    this.data = data;
  }
}

