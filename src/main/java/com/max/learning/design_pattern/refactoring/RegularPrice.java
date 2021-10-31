package com.max.learning.design_pattern.refactoring;

/**
 * @program: learning
 * @description: 经典
 * @author: Max.Tu
 * @create: 2021-10-31 21:21
 **/
public class RegularPrice extends Price{

    @Override
    int getPriceCode() {
        return Movie.REGULAR;
    }

    @Override
    double getCharge(int daysRented) {
        double result = 2;
        if (daysRented > 2) result += (daysRented - 2) * 1.5;
        return result;
    }
}
