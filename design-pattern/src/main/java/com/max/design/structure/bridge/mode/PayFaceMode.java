package com.max.design.structure.bridge.mode;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Max.Tu
 * @program learning
 * @description
 * @create 2021-11-22 23:02
 **/
@Slf4j
public class PayFaceMode implements IPayMode{

    @Override
    public boolean security(String uId) {
        log.info("人脸支付，风控校验脸部识别");
        return true;
    }
}
