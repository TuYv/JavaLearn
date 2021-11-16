package com.max.design.create.factory.bugstack.goods;

import com.alibaba.fastjson.JSON;

/**
 * @program: learning
 * @description: 模拟实物商品服务
 * @author: Max.Tu
 * @create: 2021-11-16 23:21
 **/
public class GoodsService {
    public boolean deliverGoods(DeliverReq req) {
        System.out.println("模拟发货实物商品一个：" + JSON.toJSONString(req));
        return true;
    }
}
