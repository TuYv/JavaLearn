package com.max.design.structure.decorator;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * @author Max.Tu
 * @program learning
 * @description
 * @create 2021-11-22 23:52
 **/
public abstract class SsoDecorator implements  HandlerInterceptor{

    private HandlerInterceptor handler;

    private SsoDecorator(){}

    public SsoDecorator(HandlerInterceptor handlerInterceptor) {
        this.handler = handlerInterceptor;
    }
    public boolean preHandle(String request, String response, Object handler) {
        return this.handler.preHandle(request, response, handler);
    }

}
