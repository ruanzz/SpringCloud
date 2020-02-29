package com.ruanzz.util;

import com.ruanzz.bean.BaseBean;
import com.ruanzz.bean.HostBean;
import com.ruanzz.bean.IpPoolBean;
import com.ruanzz.bean.Operator;
import com.ruanzz.bean.StoragePoolBean;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Zhenzhuo.Ruan
 */
public class ResourceHolder {

  private volatile static ResourceHolder resourceHolder;

  private List<HostBean> hostList;
  private List<StoragePoolBean> storagePoolList;
  private List<IpPoolBean> ipPoolList;

  private ResourceHolder() {

  }

  public static ResourceHolder getInstance() {
    if (resourceHolder == null) {
      createInstance();
    }
    return resourceHolder;
  }

  private static synchronized void createInstance() {
    if (resourceHolder != null) {
      return;
    }
    resourceHolder = new ResourceHolder();
  }

  public void initialize(List<HostBean> hostList, List<StoragePoolBean> storagePoolList,
      List<IpPoolBean> ipPoolList) {
    this.hostList = hostList;
    this.storagePoolList = storagePoolList;
    this.ipPoolList = ipPoolList;
  }

  public <R extends BaseBean> List<R> sort(List<R> beanList) {
    return beanList.stream()
        .sorted((bean1, bean2) -> bean1.getScore() > bean2.getScore() ? 1 : -1).collect(
            Collectors.toList());
  }

  public <R extends BaseBean> List<R> sort(Operator operator, List<R> beanList) {
    beanList.forEach(bean -> bean.setOperator(operator));
    return sort(beanList);
  }

  public List<HostBean> getHostList() {
    return hostList;
  }

  public void setHostList(List<HostBean> hostList) {
    this.hostList = hostList;
  }

  public List<StoragePoolBean> getStoragePoolList() {
    return storagePoolList;
  }

  public void setStoragePoolList(List<StoragePoolBean> storagePoolList) {
    this.storagePoolList = storagePoolList;
  }

  public List<IpPoolBean> getIpPoolList() {
    return ipPoolList;
  }

  public void setIpPoolList(List<IpPoolBean> ipPoolList) {
    this.ipPoolList = ipPoolList;
  }
}
