package com.ruanzz.scheduler;

import com.ruanzz.AbstractResourceVO;
import java.util.List;

/**
 * @author Zhenzhuo.Ruan
 */
public interface Scheduler<R extends AbstractResourceVO> {

  /**
   * 资源调度
   */
  List<R> schedule(List<R> virtualResourceList);

}
