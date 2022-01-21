package com.max.design.behavioral.strategy.impl;

import com.max.design.behavioral.strategy.ICouponDiscount;

import java.math.BigDecimal;
import java.util.Map;

/**
 * @author Rick
 * @date 2022-01-21 15:32
 */
public class MJCouponDiscount implements ICouponDiscount<Map<String,BigDecimal>> {
    @Override public BigDecimal discountAmount(Map<String, BigDecimal> couponInfo, BigDecimal skuPrice) {
        BigDecimal m = couponInfo.get("m");
        BigDecimal j = couponInfo.get("j");

        if (m.compareTo(skuPrice) < 0) {
            BigDecimal discountAmount = skuPrice.subtract(j);
            return discountAmount.compareTo(BigDecimal.ZERO) < 1 ? BigDecimal.ONE : discountAmount;
        } else {
            return skuPrice;
        }
    }
}
