package com.max.design.structure.bridge.mode;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Max.Tu
 * @program learning
 * @description
 * @create 2021-11-22 23:01
 **/
@Slf4j
public class PayCypher implements IPayMode{

    @Override
    public boolean security(String uId) {
        log.info("密码支付，风控校验环境安全");
        return true;
    }
}
