package com.ruanzz.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 审计过滤器
 *
 * @author Zhenzhuo.Ruan
 */
public class AuditLogFilter extends ZuulFilter {

  private static final Logger LOG = LoggerFactory.getLogger(AuditLogFilter.class);

  @Override
  public String filterType() {
    return "pre";
  }

  @Override
  public int filterOrder() {
    return 2;
  }

  @Override
  public boolean shouldFilter() {
    return true;
  }

  @Override
  public Object run() throws ZuulException {
    LOG.info("Audit log filter");
    return null;
  }
}
