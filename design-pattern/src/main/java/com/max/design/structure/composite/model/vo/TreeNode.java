package com.max.design.structure.composite.model.vo;

import java.util.List;
import lombok.Data;

/**
 * @author Max.Tu
 * @program learning
 * @description 规则树节点信息
 * @create 2021-11-22 23:21
 **/
@Data
public class TreeNode {

    private Long treeId;            //规则树ID
    private Long treeNodeId;        //规则树节点ID
    private Integer nodeType;       //节点类型；1子叶、2果实
    private String nodeValue;       //节点值[nodeType=2]；果实值
    private String ruleKey;         //规则Key
    private String ruleDesc;        //规则描述
    private List<TreeNodeLink> treeNodeLinkList; //节点链路
}
