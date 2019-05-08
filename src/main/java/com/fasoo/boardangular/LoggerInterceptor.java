package com.fasoo.boardangular;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
public class LoggerInterceptor implements HandlerInterceptor {

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
    log.info(request.getRemoteAddr() + " -> " + request.getRequestURI());
    /**
     * way to read http body portion
     * '{' + request.getReader().lines().collect(Collectors.joining(System.lineSeparator())) + '}'
     */
    return true;
  }
}
