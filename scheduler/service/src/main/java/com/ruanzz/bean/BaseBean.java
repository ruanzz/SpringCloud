package com.ruanzz.bean;


/**
 * @author Zhenzhuo.Ruan
 */
public abstract class BaseBean {

  private Long id;
  private String regionUuid;
  private Double score;
  private Operator operator;

  public void setId(Long id) {
    this.id = id;
  }

  public Long getId() {
    return id;
  }

  public String getRegionUuid() {
    return regionUuid;
  }

  public void setRegionUuid(String regionUuid) {
    this.regionUuid = regionUuid;
  }

  /**
   * 拿到的是当前最新的分数
   */
  public Double getScore() {
    return operator != null ? operator.operate(this) : 0;
  }

  public void setOperator(Operator operator) {
    this.operator = operator;
  }
}
