package com.max.learning.enums;

import lombok.Getter;

/**
 * @author Rick
 * @date 2021-12-07 19:22
 */
public enum ResultEnum implements BaseEnum{
    //成功
    SUCCESS(1,"成功"),
    //失败
    FAILED(2, "失败")
    ;

    @Getter
    int code;
    @Getter
    String des;

    ResultEnum(int code, String des) {
        this.code = code;
        this.des = des;
    }
}
