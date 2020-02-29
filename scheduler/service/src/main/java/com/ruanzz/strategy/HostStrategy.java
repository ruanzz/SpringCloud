package com.ruanzz.strategy;

import com.ruanzz.VmVO;
import com.ruanzz.bean.HostBean;
import java.util.List;
import java.util.Optional;

/**
 * @author Zhenzhuo.Ruan
 */
public class HostStrategy extends AbstractStrategy<VmVO, HostBean> {


  public HostStrategy(VmVO virtualResource, List<HostBean> resourceList) {
    super(virtualResource, resourceList);
  }

  @Override
  public boolean lookup() {
    Optional<HostBean> hostOptional = this.resourceList.stream()
        .filter(hostBean -> hostBean.getAvailVcpu() > virtualResource.getVcpu()
            && hostBean.getAvailMemory() > virtualResource.getMemory()
        ).findFirst();

    if (!hostOptional.isPresent()) {
      return false;
    }
    virtualResource.setHostId(String.valueOf(hostOptional.get().getId()));
    return true;
  }
}
