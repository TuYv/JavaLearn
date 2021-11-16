package com.max.design.create.factory.bugstack;

import com.max.design.create.factory.bugstack.store.ICommodity;
import com.max.design.create.factory.bugstack.store.impl.CardCommodityService;
import com.max.design.create.factory.bugstack.store.impl.CouponCommodityService;
import com.max.design.create.factory.bugstack.store.impl.GoodsCommodityService;

/**
 * @author Max.Tu
 * @program learning
 * @description
 * @create 2021-11-16 23:40
 **/
public class StoreFactory {
    public ICommodity getCommodityService(int commodityType) {
        if (commodityType == 1) return new CardCommodityService();
        if (commodityType == 2) return new CouponCommodityService();
        if (commodityType == 3) return new GoodsCommodityService();
        throw new RuntimeException("不存在的商品服务类型");
    }
}
