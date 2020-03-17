package com.ruanzz;

/**
 * @author Zhenzhuo.Ruan
 */
public class VmVO extends AbstractResourceVO {

  private Integer vcpu;
  private Integer memory;
  private Integer storage;

  private String hostId;
  private String storagePoolId;

  public Integer getVcpu() {
    return vcpu;
  }

  public void setVcpu(Integer vcpu) {
    this.vcpu = vcpu;
  }

  public Integer getMemory() {
    return memory;
  }

  public void setMemory(Integer memory) {
    this.memory = memory;
  }

  public Integer getStorage() {
    return storage;
  }

  public void setStorage(Integer storage) {
    this.storage = storage;
  }

  public String getHostId() {
    return hostId;
  }

  public void setHostId(String hostId) {
    this.hostId = hostId;
  }

  public String getStoragePoolId() {
    return storagePoolId;
  }

  public void setStoragePoolId(String storagePoolId) {
    this.storagePoolId = storagePoolId;
  }

  @Override
  public String toString() {
    return "VmVO{" +
        "vcpu=" + vcpu +
        ", memory=" + memory +
        ", storage=" + storage +
        ", hostId='" + hostId + '\'' +
        ", storagePoolId='" + storagePoolId + '\'' +
        '}';
  }
}
