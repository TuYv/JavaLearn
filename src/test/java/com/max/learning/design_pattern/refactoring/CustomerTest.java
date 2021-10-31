package com.max.learning.design_pattern.refactoring;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Vector;
import org.junit.jupiter.api.Test;

class CustomerTest {

    @Test
    void statement() {
        //初始化电影
        Movie matrix = new Movie("The matrix", 1);
        Movie yiyi = new Movie("yiyi", 1);
        Movie tomAndJerry = new Movie("Tom And Jerry", 2);
        //初始化租借
        Rental rental1 = new Rental(matrix, 3);
        Rental rental2 = new Rental(yiyi, 5);
        Rental rental3 = new Rental(tomAndJerry, 5);

        Vector vector = new Vector();
        vector.add(rental1);
        vector.add(rental2);
        vector.add(rental3);
        Customer zhangsan = new Customer("zhangsan", vector);

        String result = zhangsan.statement();
        System.out.println(result);
    }
}