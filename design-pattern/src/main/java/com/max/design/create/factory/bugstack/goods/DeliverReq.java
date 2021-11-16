package com.max.design.create.factory.bugstack.goods;

import lombok.Data;

/**
 * @program: learning
 * @description:
 * @author: Max.Tu
 * @create: 2021-11-16 23:18
 **/
@Data
public class DeliverReq {
    private String userName;
    private String userPhone;
    private String sku;
    private String orderId;
    private String consigneeUserName;
    private String consigneeUserPhone;
    private String consigneeUserAddress;
}
