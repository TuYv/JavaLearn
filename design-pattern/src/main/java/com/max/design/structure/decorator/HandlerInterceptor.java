package com.max.design.structure.decorator;

public interface HandlerInterceptor {

    boolean preHandle(String request, String response, Object handler);

}
