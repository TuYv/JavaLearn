package com.max.design.structure.adapter.impl;

import com.max.design.structure.adapter.OrderAdapterService;
import com.max.design.structure.adapter.service.POPOrderService;

public class POPOrderAdapterServiceImpl implements OrderAdapterService {

    private POPOrderService popOrderService = new POPOrderService();

    public boolean isFirst(String uId) {
        return popOrderService.isFirstOrder(uId);
    }

}
