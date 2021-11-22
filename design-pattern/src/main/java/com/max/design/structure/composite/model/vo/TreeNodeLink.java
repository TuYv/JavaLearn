package com.max.design.structure.composite.model.vo;

import lombok.Data;

/**
 * @author Max.Tu
 * @program learning
 * @description 规则树线信息
 * @create 2021-11-22 23:23
 **/
@Data
public class TreeNodeLink {

    private Long nodeIdFrom;        //节点From
    private Long nodeIdTo;          //节点To
    private Integer ruleLimitType;  //限定类型；1:=;2:>;3:<;4:>=;5<=;6:enum[枚举范围]
    private String ruleLimitValue;  //限定值
}
