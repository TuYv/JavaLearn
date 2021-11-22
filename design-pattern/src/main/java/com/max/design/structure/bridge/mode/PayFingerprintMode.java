package com.max.design.structure.bridge.mode;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Max.Tu
 * @program learning
 * @description
 * @create 2021-11-22 23:03
 **/
@Slf4j
public class PayFingerprintMode implements IPayMode{

    @Override
    public boolean security(String uId) {
        log.info("指纹支付，风控校验指纹信息");
        return true;
    }
}
