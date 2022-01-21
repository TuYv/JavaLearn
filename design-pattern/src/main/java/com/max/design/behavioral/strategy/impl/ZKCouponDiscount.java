package com.max.design.behavioral.strategy.impl;

import com.max.design.behavioral.strategy.ICouponDiscount;

import java.math.BigDecimal;

/**
 * @author Rick
 * @date 2022-01-21 16:05
 */
public class ZKCouponDiscount implements ICouponDiscount<BigDecimal> {
    @Override public BigDecimal discountAmount(BigDecimal couponInfo, BigDecimal skuPrice) {
        BigDecimal discountAmount = skuPrice.multiply(couponInfo.setScale(2, BigDecimal.ROUND_HALF_UP));
        return discountAmount.compareTo(BigDecimal.ZERO) < 1 ? BigDecimal.ONE : discountAmount;
    }
}
