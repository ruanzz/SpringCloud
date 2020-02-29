package com.ruanzz.lister;

import com.ruanzz.bean.Operator;
import java.util.Map;
import java.util.Set;

/**
 * @author Zhenzhuo.Ruan
 */
public class FilterEvent {

  private Set<String> regionUuidSet;
  private Map<FilterType, Operator> filterTypeOperatorMap;


  public Set<String> getRegionUuidSet() {
    return regionUuidSet;
  }

  public void setRegionUuidSet(Set<String> regionUuidSet) {
    this.regionUuidSet = regionUuidSet;
  }

  public enum FilterType {
    Host, StoragePool, IpPool;
  }

  public Map<FilterType, Operator> getFilterTypeOperatorMap() {
    return filterTypeOperatorMap;
  }

  public void setFilterTypeOperatorMap(
      Map<FilterType, Operator> filterTypeOperatorMap) {
    this.filterTypeOperatorMap = filterTypeOperatorMap;
  }
}
