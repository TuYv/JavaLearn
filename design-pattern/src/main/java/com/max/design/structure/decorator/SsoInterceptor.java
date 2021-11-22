package com.max.design.structure.decorator;

/**
 * @author Max.Tu
 * @program learning
 * @description
 * @create 2021-11-22 23:51
 **/
public class SsoInterceptor implements HandlerInterceptor{

    @Override
    public boolean preHandle(String request, String response, Object handler) {
        // 模拟获取cookie
        String ticket = request.substring(1, 8);
        // 模拟校验
        return ticket.equals("success");
    }
}
