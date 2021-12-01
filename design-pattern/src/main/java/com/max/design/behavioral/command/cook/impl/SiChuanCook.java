package com.max.design.behavioral.command.cook.impl;

import com.max.design.behavioral.command.cook.ICook;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Rick
 * @date 2021-12-01 19:04
 */
@Slf4j
public class SiChuanCook implements ICook {
    @Override public void doCooking() {
        log.info("四川厨师，烹饪川菜，中国最有特色的菜系，也是民间最大菜系。");
    }
}
