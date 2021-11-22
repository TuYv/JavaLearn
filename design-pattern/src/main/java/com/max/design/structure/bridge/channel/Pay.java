package com.max.design.structure.bridge.channel;

import com.max.design.structure.bridge.mode.IPayMode;
import java.math.BigDecimal;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Max.Tu
 * @program learning
 * @description
 * @create 2021-11-22 22:55
 **/
@Slf4j
public abstract class Pay {
    protected IPayMode payMode;

    public Pay(IPayMode payMode) {
        this.payMode = payMode;
    }

    public abstract String transfer(String uId, String tradeId, BigDecimal amount);


}
