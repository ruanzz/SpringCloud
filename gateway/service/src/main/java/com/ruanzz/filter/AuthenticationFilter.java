package com.ruanzz.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import com.ruanzz.auth.UserInfoVO;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 认证过滤器
 *
 * @author Zhenzhuo.Ruan
 */
@Component
public class AuthenticationFilter extends ZuulFilter {

  private static final Logger LOG = LoggerFactory.getLogger(AuthenticationFilter.class);
  private static final String PREFIX_URI = "/auth";

  private static String AUTH_PREFIX = "bearer ";

  @Override
  public String filterType() {
    return "pre";
  }

  @Override
  public int filterOrder() {
    return 1;
  }

  @Override
  public boolean shouldFilter() {
    return true;
  }

  @Override
  public Object run() throws ZuulException {

    RequestContext requestContext = RequestContext.getCurrentContext();
    HttpServletRequest request = requestContext.getRequest();
    if (StringUtils.startsWith(request.getRequestURI(), PREFIX_URI)) {
      return null;
    }

    String authorization = request.getHeader("Authorization");
    if (StringUtils.isBlank(authorization)) {
      return null;
    }

    if (!StringUtils.startsWithIgnoreCase(authorization, AUTH_PREFIX)) {
      return null;
    }

    // 校验token  TODO
    String token = StringUtils.substringAfter(authorization, AUTH_PREFIX);
    try {
      UserInfoVO userInfoVO = new UserInfoVO();
      // 认证成功将token解析为用户信息
      request.setAttribute("userInfo", userInfoVO);

    } catch (Exception ex) {
      LOG.error("校验token出错", ex);
    }

    return null;
  }
}
