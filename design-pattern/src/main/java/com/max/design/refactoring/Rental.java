package com.max.design.refactoring;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 租凭
 * @program: learning
 * @description:
 * @author: Max.Tu
 * @create: 2021-10-31 09:03
 **/
@Data
@AllArgsConstructor
public class Rental {

    private Movie movie;
    private int daysRented;

    double getCharge() {
        return movie.getCharge(daysRented);
    }

    int getFrequentRenterPoint() {
        return movie.getFrequentRenterPoint(daysRented);
    }
}
