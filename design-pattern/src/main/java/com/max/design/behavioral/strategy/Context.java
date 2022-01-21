package com.max.design.behavioral.strategy;

import java.math.BigDecimal;

/**
 * @author Rick
 * @date 2022-01-21 16:07
 */
public class Context<T> {
    private ICouponDiscount<T> couponDiscount;

    public Context(ICouponDiscount<T> couponDiscount) {
        this.couponDiscount = couponDiscount;
    }
    BigDecimal discountAmount(T couponInfo, BigDecimal skuPrice) {
        return this.couponDiscount.discountAmount(couponInfo, skuPrice);
    }
}
