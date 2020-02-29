package com.ruanzz.scheduler;

import com.ruanzz.VirtualResourceVO;
import com.ruanzz.bean.Operator;
import com.ruanzz.lister.FilterEvent;
import com.ruanzz.lister.FilterEvent.FilterType;
import com.ruanzz.starter.util.ApplicationContextUtil;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Zhenzhuo.Ruan
 */
public abstract class AbstractScheduler<R extends VirtualResourceVO> implements
    Scheduler {

  protected List<R> virtualResourceList;
  protected Map<FilterType, Operator> filterTypeOperatorMap = new HashMap<>();

  @Override
  public List<R> schedule(List virtualResourceList) {
    this.virtualResourceList = virtualResourceList;
    // 获取底层数据,过滤不能用来调度的资源
    filter();
    // 寻找虚拟化资源落点
    lookup();
    // 校验资源落点是否正确
    if (verify()) {
      throw new RuntimeException("没有找到相应资源进行调度");
    }
    return this.virtualResourceList;
  }

  protected abstract void addFilterTypeAndOperator(Map<FilterType, Operator> filterTypeOperatorMap);

  protected void filter() {
    Set<String> regionUuidSet = virtualResourceList.stream()
        .map(resourceVo -> resourceVo.getRegionUuid())
        .collect(Collectors.toSet());
    FilterEvent filterEvent = new FilterEvent();
    filterEvent.setRegionUuidSet(regionUuidSet);
    addFilterTypeAndOperator(filterTypeOperatorMap);
    filterEvent.setFilterTypeOperatorMap(filterTypeOperatorMap);
    ApplicationContextUtil.getApplicationContext().publishEvent(filterEvent);
  }

  protected abstract void lookup();

  protected abstract boolean verify();


}
