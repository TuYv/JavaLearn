package com.max.design.behavioral.command;

import com.max.design.behavioral.command.cuisine.ICuisine;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Rick
 * @date 2021-12-01 19:00
 */
@Slf4j
public class XiaoEr {
    private List<ICuisine> cuisineList = new ArrayList<ICuisine>();

    public void order(ICuisine cuisine) {
        cuisineList.add(cuisine);
    }

    public synchronized void placeOrder() {
        for (ICuisine cuisine : cuisineList) {
            cuisine.cook();
        }
        cuisineList.clear();
    }
}
