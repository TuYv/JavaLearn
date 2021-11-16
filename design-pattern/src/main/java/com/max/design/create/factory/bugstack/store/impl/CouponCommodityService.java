package com.max.design.create.factory.bugstack.store.impl;

import com.alibaba.fastjson.JSON;
import com.max.design.create.factory.bugstack.coupon.CouponResult;
import com.max.design.create.factory.bugstack.coupon.CouponService;
import com.max.design.create.factory.bugstack.store.ICommodity;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Max.Tu
 * @program learning
 * @description
 * @create 2021-11-16 23:35
 **/
@Slf4j
public class CouponCommodityService implements ICommodity {

    private CouponService couponService = new CouponService();

    @Override
    public void sendCommodity(String uId, String commodityId, String bizId,
        Map<String, String> extMap) throws Exception {

        CouponResult couponResult = couponService.sendCoupon(uId, commodityId, bizId);
        log.info("请求参数[优惠券] => uId：{} commodityId：{} bizId：{} extMap：{}", uId, commodityId, bizId, JSON
            .toJSON(extMap));
        log.info("测试结果[优惠券]：{}", JSON.toJSON(couponResult));
        if (!"0000".equals(couponResult.getCode())) throw new RuntimeException(couponResult.getInfo());
    }
}
