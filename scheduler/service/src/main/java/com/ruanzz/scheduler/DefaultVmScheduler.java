package com.ruanzz.scheduler;

import com.ruanzz.VmVO;
import com.ruanzz.bean.HostBean;
import com.ruanzz.bean.Operator;
import com.ruanzz.lister.FilterEvent.FilterType;
import com.ruanzz.strategy.HostStrategy;
import com.ruanzz.util.ResourceHolder;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Zhenzhuo.Ruan
 */
public class DefaultVmScheduler extends AbstractScheduler<VmVO> {

  private static final Integer CPU_WEIGHT = 1;
  private static final Integer MEMORY_WEIGHT = 5;

  @Override
  protected void addFilterTypeAndOperator(Map<FilterType, Operator> filterTypeOperatorMap) {
    filterTypeOperatorMap.put(FilterType.Host, new HostOperator());
  }


  @Override
  protected void lookup() {
    for (VmVO vmVO : this.virtualResourceList) {
      List<HostBean> availableHostList = ResourceHolder.getInstance().getHostList().stream()
          .filter(hostBean -> hostBean.getRegionUuid().equals(vmVO.getRegionUuid())).collect(
              Collectors.toList());
      HostStrategy hostStrategy = new HostStrategy(vmVO, availableHostList);
      if (!hostStrategy.lookup()) {
        throw new RuntimeException("找不到满足的物理主机");
      }
    }
  }

  @Override
  protected boolean verify() {
    return false;
  }


  class HostOperator implements Operator<HostBean> {

    @Override
    public Double operate(HostBean hostBean) {
      return hostBean.getAvailVcpu() * CPU_WEIGHT + hostBean.getAvailMemory() * MEMORY_WEIGHT;
    }
  }
}
