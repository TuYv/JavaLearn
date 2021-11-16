package com.max.design.create.factory.bugstack.store.impl;

import com.alibaba.fastjson.JSON;
import com.max.design.create.factory.bugstack.card.IQiYiCard;
import com.max.design.create.factory.bugstack.card.IQiYiCardService;
import com.max.design.create.factory.bugstack.store.ICommodity;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Max.Tu
 * @program learning
 * @description
 * @create 2021-11-16 23:32
 **/
@Slf4j
public class CardCommodityService implements ICommodity {

    private IQiYiCardService iQiYiCardService = new IQiYiCardService();

    @Override
    public void sendCommodity(String uId, String commodityId, String bizId,
        Map<String, String> extMap) throws Exception {
        String mobile = queryUserMobile(uId);
        iQiYiCardService.grantToken(mobile, bizId);
        log.info("请求参数[爱奇艺兑换卡] => uId：{} commodityId：{} bizId：{} extMap：{}", uId, commodityId, bizId, JSON
            .toJSON(extMap));
        log.info("测试结果[爱奇艺兑换卡]：success");
    }

    private String queryUserMobile(String uId) {
        return "18818584616";
    }
}
