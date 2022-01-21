package com.max.design.behavioral.strategy;

import java.math.BigDecimal;

/**
 * @author Rick
 * @date 2022-01-21 15:29
 */
public interface ICouponDiscount <T>{
    /**
     * 优惠券金额计算
     * @param couponInfo
     * @param skuPrice
     * @return
     */
    BigDecimal discountAmount(T couponInfo, BigDecimal skuPrice);

}
