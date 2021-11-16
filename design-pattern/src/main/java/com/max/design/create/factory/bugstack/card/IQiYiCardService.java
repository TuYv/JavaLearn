package com.max.design.create.factory.bugstack.card;

/**
 * @program: learning
 * @description: 模拟爱奇艺会员卡服务
 * @author: Max.Tu
 * @create: 2021-11-16 23:12
 **/
public class IQiYiCardService {

    public void grantToken(String bindMobileNumber, String cardId) {
        System.out.println("模拟发放爱奇艺会员卡一张： " + bindMobileNumber + ", " + cardId );
    }
}
