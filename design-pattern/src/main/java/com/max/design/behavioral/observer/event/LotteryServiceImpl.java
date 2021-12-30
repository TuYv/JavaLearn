package com.max.design.behavioral.observer.event;

import com.max.design.behavioral.observer.LotteryResult;
import com.max.design.behavioral.observer.MinibusTargetService;

import java.util.Date;

/**
 * @author Rick
 * @date 2021-12-30 19:39
 */
public class LotteryServiceImpl extends LotteryService{

    private MinibusTargetService minibusTargetService = new MinibusTargetService();

    @Override protected LotteryResult doDraw(String uId) {
        String lottery = minibusTargetService.lottery(uId);

        return new LotteryResult(uId, lottery, new Date());
    }
}
