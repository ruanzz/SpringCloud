package com.ruanzz.strategy;

import com.ruanzz.VirtualResourceVO;
import com.ruanzz.bean.BaseBean;
import java.util.List;

/**
 * @author Zhenzhuo.Ruan
 */
public abstract class AbstractStrategy<V extends VirtualResourceVO, R extends BaseBean> implements
    Strategy {

  protected V virtualResource;

  protected List<R> resourceList;

  public AbstractStrategy(V virtualResource, List<R> resourceList) {
    this.virtualResource = virtualResource;
    this.resourceList = resourceList;
  }


}
