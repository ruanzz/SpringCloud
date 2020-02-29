package com.ruanzz.bean;

/**
 * @author Zhenzhuo.Ruan
 */
public class HostBean extends BaseBean {

  private Double availVcpu;
  private Double availMemory;

  public Double getAvailVcpu() {
    return availVcpu;
  }

  public void setAvailVcpu(Double availVcpu) {
    this.availVcpu = availVcpu;
  }

  public Double getAvailMemory() {
    return availMemory;
  }

  public void setAvailMemory(Double availMemory) {
    this.availMemory = availMemory;
  }
}
