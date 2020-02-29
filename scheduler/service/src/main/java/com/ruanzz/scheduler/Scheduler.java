package com.ruanzz.scheduler;

import com.ruanzz.VirtualResourceVO;
import java.util.List;

/**
 * @author Zhenzhuo.Ruan
 */
public interface Scheduler<R extends VirtualResourceVO> {

  List<R> schedule(List<R> virtualResourceList);

}
