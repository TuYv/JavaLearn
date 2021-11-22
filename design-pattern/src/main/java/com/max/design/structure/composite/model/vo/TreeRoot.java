package com.max.design.structure.composite.model.vo;

import lombok.Data;

/**
 * @author Max.Tu
 * @program learning
 * @description 树根信息
 * @create 2021-11-22 23:20
 **/
@Data
public class TreeRoot {

    private Long treeId;         //规则树ID
    private Long treeRootNodeId; //规则树根ID
    private String treeName;     //规则树名称
}
