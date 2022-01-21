package com.max.design.behavioral.strategy.impl;

import com.max.design.behavioral.strategy.ICouponDiscount;

import java.math.BigDecimal;

/**
 * @author Rick
 * @date 2022-01-21 16:04
 */
public class ZJCouponDiscount implements ICouponDiscount<BigDecimal> {
    @Override public BigDecimal discountAmount(BigDecimal couponInfo, BigDecimal skuPrice) {
        BigDecimal discount = skuPrice.subtract(couponInfo);
        return discount.compareTo(BigDecimal.ZERO) < 1 ? BigDecimal.ONE : discount;
    }
}
