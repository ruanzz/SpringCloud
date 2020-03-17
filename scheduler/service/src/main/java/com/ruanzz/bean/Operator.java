package com.ruanzz.bean;

/**
 * 计算得分的算子
 *
 * @author ZhenZhuo.Ruan
 */

@FunctionalInterface
public interface Operator<T extends BaseBean> {

  /**
   * 计算得分
   *
   * @param t 资源
   */
  Double operate(T t);
}
