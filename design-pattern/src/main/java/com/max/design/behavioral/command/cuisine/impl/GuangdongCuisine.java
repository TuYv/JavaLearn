package com.max.design.behavioral.command.cuisine.impl;

import com.max.design.behavioral.command.cook.ICook;
import com.max.design.behavioral.command.cook.impl.GuangdongCook;
import com.max.design.behavioral.command.cuisine.ICuisine;

/**
 * @author Rick
 * @date 2021-12-01 18:57
 */
public class GuangdongCuisine implements ICuisine {
    private ICook cook;

    public GuangdongCuisine(ICook cook) {
        this.cook = cook;
    }
    @Override public void cook() {
        cook.doCooking();
    }
}
