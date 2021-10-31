package com.max.learning.design_pattern.refactoring;

/**
 * @program: learning
 * @description: 新片
 * @author: Max.Tu
 * @create: 2021-10-31 21:20
 **/
public class NewReleasePrice extends Price{

    @Override
    int getPriceCode() {
        return Movie.NEW_RELEASE;
    }

    @Override
    double getCharge(int daysRented) {
        return daysRented * 3;
    }

    @Override
    int getFrequentRenterPoint(int daysRented) {
        return daysRented > 1 ? 2 : 1;
    }
}
