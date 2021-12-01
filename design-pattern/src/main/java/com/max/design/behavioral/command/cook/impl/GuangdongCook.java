package com.max.design.behavioral.command.cook.impl;

import com.max.design.behavioral.command.cook.ICook;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Rick
 * @date 2021-11-25 22:19
 */
@Slf4j
public class GuangdongCook implements ICook {
    @Override public void doCooking() {
        log.info("广东厨师，烹饪鲁菜，宫廷最大菜系，以孔府风味为龙头");
    }
}
