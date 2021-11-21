package com.max.design.structure.adapter.impl;

import com.max.design.structure.adapter.OrderAdapterService;
import com.max.design.structure.adapter.service.OrderService;

public class InsideOrderService implements OrderAdapterService {

    private OrderService orderService = new OrderService();

    public boolean isFirst(String uId) {
        return orderService.queryUserOrderCount(uId) <= 1;
    }

}
