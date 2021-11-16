package com.max.design.refactoring;

/**
 * @program: learning
 * @description: 价格
 * @author: Max.Tu
 * @create: 2021-10-31 21:18
 **/
public abstract class Price {
    abstract int getPriceCode();

    abstract double getCharge(int daysRented);

    int getFrequentRenterPoint(int daysRented) {
        return 1;
    }
}
