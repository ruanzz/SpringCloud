package com.ruanzz.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import com.ruanzz.auth.UserInfoVO;
import java.util.Objects;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;

/**
 * 授权过滤器
 *
 * @author Zhenzhuo.Ruan
 */
public class AuthorizationFilter extends ZuulFilter {

  private static final Logger LOG = LoggerFactory.getLogger(AuthorizationFilter.class);

  @Override
  public String filterType() {
    return "pre";
  }

  @Override
  public int filterOrder() {
    return 3;
  }

  @Override
  public boolean shouldFilter() {
    return true;
  }

  @Override
  public Object run() throws ZuulException {
    LOG.info("Authorization filter");

    RequestContext requestContext = RequestContext.getCurrentContext();
    HttpServletRequest request = requestContext.getRequest();
    UserInfoVO userInfo = (UserInfoVO) request.getAttribute("userInfo");
    if (Objects.isNull(userInfo)) {
      handleError(HttpStatus.UNAUTHORIZED);
    }

    if (!hasPermission(userInfo, request)) {
      handleError(HttpStatus.FORBIDDEN);
    }

    return null;
  }

  private boolean hasPermission(UserInfoVO userInfo, HttpServletRequest request) {

    // TODO 调用权限服务验证

    return false;
  }

  private void handleError(HttpStatus status) {
    RequestContext requestContext = RequestContext.getCurrentContext();
    HttpServletResponse response = requestContext.getResponse();
    response.setStatus(status.value());
    response.setContentType("application");
    requestContext.setSendZuulResponse(false);
  }
}
