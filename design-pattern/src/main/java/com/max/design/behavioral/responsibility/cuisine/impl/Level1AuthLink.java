package com.max.design.behavioral.responsibility.cuisine.impl;

import com.max.design.behavioral.responsibility.AuthInfo;
import com.max.design.behavioral.responsibility.AuthLink;
import com.max.design.behavioral.responsibility.AuthService;

import java.util.Date;

/**
 * @author Rick
 * @date 2021-11-25 21:32
 */
public class Level1AuthLink extends AuthLink {
    public Level1AuthLink(String levelUserId, String levelUserName) {
        super(levelUserId, levelUserName);
    }

    @Override public AuthInfo doAuth(String uId, String orderId, Date authDate) {
        Date date = AuthService.queryAuthInfo(levelUserId, orderId);
        if (null == date) {
            return new AuthInfo("0001", "单号: ", orderId, " 状态: 待一级审批负责人 ", levelUserName);
        }
        AuthLink next = super.next();
        if (null == next) {
            return new AuthInfo("0000", "单号: ", orderId, "状态: 一级审批完成负责人", "时间: ", sdf.format(date), "审批人: ", levelUserName);
        }
        return next.doAuth(uId, orderId, authDate);
    }
}
