package com.max.design.structure.decorator;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Max.Tu
 * @program learning
 * @description
 * @create 2021-11-22 23:54
 **/
@Slf4j
public class LoginSsoDecorator extends SsoDecorator{

    public LoginSsoDecorator(HandlerInterceptor handlerInterceptor) {
        super(handlerInterceptor);
    }

    private static Map<String, String> authMap = new ConcurrentHashMap<String, String>();

    static {
        authMap.put("huahua", "queryUserInfo");
        authMap.put("doudou", "queryUserInfo");
    }

    @Override
    public boolean preHandle(String request, String response, Object handler) {
        boolean success = super.preHandle(request, response, handler);
        if (!success) return false;
        String userId = request.substring(8);
        String method = authMap.get(userId);
        log.info("模拟单点登录方法访问拦截校验：{} {}", userId, method);
        // 模拟方法校验
        return "queryUserInfo".equals(method);
    }
}
