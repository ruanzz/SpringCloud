package com.ruanzz;

/**
 * @author Zhenzhuo.Ruan
 */
public abstract class AbstractResourceVO {

  protected String uuid;
  protected String regionUuid;

  public String getUuid() {
    return uuid;
  }

  public void setUuid(String uuid) {
    this.uuid = uuid;
  }

  public String getRegionUuid() {
    return regionUuid;
  }

  public void setRegionUuid(String regionUuid) {
    this.regionUuid = regionUuid;
  }
}
