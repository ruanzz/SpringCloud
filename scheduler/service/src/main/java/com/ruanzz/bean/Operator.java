package com.ruanzz.bean;

/**
 * 计算得分的算子
 *
 * @author ZhenZhuo.Ruan
 */

@FunctionalInterface
public interface Operator<T extends BaseBean> {

  Double operate(T t);
}
