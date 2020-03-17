package com.ruanzz;

/**
 * @author Zhenzhuo.Ruan
 */
public class VolumeVO extends AbstractResourceVO {

  private VmVO vm;
  private Integer size;

  public VmVO getVm() {
    return vm;
  }

  public void setVm(VmVO vm) {
    this.vm = vm;
  }

  public Integer getSize() {
    return size;
  }

  public void setSize(Integer size) {
    this.size = size;
  }

  @Override
  public String toString() {
    return "VolumeVO{" +
        "vm=" + vm +
        ", size=" + size +
        '}';
  }
}
