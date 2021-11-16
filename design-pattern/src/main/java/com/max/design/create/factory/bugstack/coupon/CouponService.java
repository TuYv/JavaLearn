package com.max.design.create.factory.bugstack.coupon;

/**
 * @program: learning
 * @description: 模拟优惠券服务
 * @author: Max.Tu
 * @create: 2021-11-16 23:15
 **/
public class CouponService {

    public CouponResult sendCoupon(String uId, String couponNumber, String uuid) {
        System.out.println("模拟发放优惠券一张：" + uId + "," + couponNumber + "," +uuid);
        return new CouponResult("0000" ,"发放成功");
    }
}
