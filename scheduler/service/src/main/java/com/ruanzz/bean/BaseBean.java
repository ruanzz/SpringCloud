package com.ruanzz.bean;


/**
 * @author Zhenzhuo.Ruan
 */
public abstract class BaseBean {

  private Long Id;
  private String regionUuid;
  private Double score;
  // 可以计算当前得分
  private Operator operator;

  public Long getId() {
    return Id;
  }

  public void setId(Long id) {
    Id = id;
  }

  public String getRegionUuid() {
    return regionUuid;
  }

  public void setRegionUuid(String regionUuid) {
    this.regionUuid = regionUuid;
  }

  // 拿到的是当前最新的分数
  public Double getScore() {
    return operator != null ? operator.operate(this) : 0;
  }

  public void setOperator(Operator operator) {
    this.operator = operator;
  }
}
