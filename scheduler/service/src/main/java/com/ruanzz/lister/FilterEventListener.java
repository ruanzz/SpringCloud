package com.ruanzz.lister;

import com.ruanzz.bean.HostBean;
import com.ruanzz.bean.IpPoolBean;
import com.ruanzz.bean.Operator;
import com.ruanzz.bean.StoragePoolBean;
import com.ruanzz.lister.FilterEvent.FilterType;
import com.ruanzz.util.ResourceHolder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * 过滤监听器
 *
 * 获取数据
 *
 * @author Zhenzhuo.Ruan
 */
@Component
public class FilterEventListener {

  private List<HostBean> hostList;
  private List<StoragePoolBean> storagePoolList;
  private List<IpPoolBean> ipPoolList;

  @EventListener
  public void handlePreFilterEvent(FilterEvent event) {
    preFilter(event);

    // 过滤 不能拿来分配物理主机,存储池,IP池 TODO

    // 对过滤出来的资源进行打分和排序
    score(event);

    // 放到一个缓存类中
    ResourceHolder.getInstance().initialize(hostList, storagePoolList, ipPoolList);

  }


  private void preFilter(FilterEvent event) {
    Set<String> regionUuidList = event.getRegionUuidSet();
    regionUuidList.forEach(regionUuid -> {
      // 请求底层物理资源数据,封装成对应的Bean TODO

      Set<FilterType> filterTypeSet = event.getFilterTypeOperatorMap().keySet();
      if (filterTypeSet.contains(FilterType.Host)) {
        HostBean hostBean = new HostBean();
        hostBean.setRegionUuid("111");
        hostList = new ArrayList<>();
        hostList.add(hostBean);
      } else if (filterTypeSet.contains(FilterType.StoragePool)) {
        storagePoolList = new ArrayList<>();
      } else if (filterTypeSet.contains(FilterType.IpPool)) {
        ipPoolList = new ArrayList<>();
      }
    });
  }

  private void score(FilterEvent event) {
    for (Entry<FilterType, Operator> entry : event.getFilterTypeOperatorMap().entrySet()) {
      if (FilterType.Host.equals(entry.getKey())) {
        hostList = ResourceHolder.getInstance().sort(entry.getValue(), hostList);
      } else if (FilterType.StoragePool.equals(entry.getKey())) {
        storagePoolList = ResourceHolder.getInstance().sort(entry.getValue(), storagePoolList);
      } else if (FilterType.IpPool.equals(entry.getKey())) {
        ipPoolList = ResourceHolder.getInstance().sort(entry.getValue(), ipPoolList);
      }
    }
  }
}
