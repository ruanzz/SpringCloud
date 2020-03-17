package com.ruanzz;

/**
 * @author Zhenzhuo.Ruan
 */
public class NetworkVO extends AbstractResourceVO {

  private VmVO vm;
  private String ip;

  public VmVO getVm() {
    return vm;
  }

  public void setVm(VmVO vm) {
    this.vm = vm;
  }

  public String getIp() {
    return ip;
  }

  public void setIp(String ip) {
    this.ip = ip;
  }

  @Override
  public String toString() {
    return "NetworkVO{" +
        "vm=" + vm +
        ", ip='" + ip + '\'' +
        '}';
  }
}
