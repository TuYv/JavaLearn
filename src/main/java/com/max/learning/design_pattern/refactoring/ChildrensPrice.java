package com.max.learning.design_pattern.refactoring;

/**
 * @program: learning
 * @description: 儿童类
 * @author: Max.Tu
 * @create: 2021-10-31 21:19
 **/
public class ChildrensPrice extends Price{

    @Override
    int getPriceCode() {
        return Movie.CHILDRENS;
    }

    @Override
    double getCharge(int daysRented) {
        double result = 1.5;
        if (daysRented > 3) {
            result += (daysRented - 3) * 1.5;
        }
        return result;
    }
}
