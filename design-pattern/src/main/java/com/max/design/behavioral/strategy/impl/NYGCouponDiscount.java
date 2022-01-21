package com.max.design.behavioral.strategy.impl;

import com.max.design.behavioral.strategy.ICouponDiscount;

import java.math.BigDecimal;

/**
 * @author Rick
 * @date 2022-01-21 16:02
 */
public class NYGCouponDiscount implements ICouponDiscount<BigDecimal> {
    @Override public BigDecimal discountAmount(BigDecimal couponInfo, BigDecimal skuPrice) {
        return couponInfo;
    }
}
