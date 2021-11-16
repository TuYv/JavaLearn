package com.max.design.refactoring;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @program: learning
 * @description: 顾客
 * @author: Max.Tu
 * @create: 2021-10-31 09:04
 **/
@Data
@AllArgsConstructor
public class Customer {

    private String name;
    private List rentals;

    public String statement() {
        String result = "Rental Record for " + getName() + "\n";
        for (int i = 0; i < rentals.size(); i++) {
            Rental each = (Rental) rentals.get(i);
            //show figures for this rental
            result += "\t" + each.getMovie().getTitle() + "\t" + each.getCharge() + "\n";
        }
        //add footer lines
        result += "Amount owed is " + getTotalCharge() + "\n";
        result += "You earned "+ getTotalFrequentRenterPoints() + " frequent renter points";
        return result;

    }
    private double getTotalCharge() {
        double result  = 0;
        for(int i = 0; i <rentals.size(); i++) {
            Rental each = (Rental) rentals.get(i);
            result += each.getCharge();
        }
        return result;
    }
    private int getTotalFrequentRenterPoints() {
        int result  = 0;
        for(int i = 0; i <rentals.size(); i++) {
            Rental each = (Rental) rentals.get(i);
            result += each.getFrequentRenterPoint();
        }
        return result;
    }
}
