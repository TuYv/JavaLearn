package com.max.design.structure.composite.model.aggregates;

import com.max.design.structure.composite.model.vo.TreeNode;
import com.max.design.structure.composite.model.vo.TreeRoot;
import java.util.Map;
import lombok.Data;

/**
 * 规则树聚合
 * @author Max.Tu
 * @program learning
 * @description
 * @create 2021-11-22 23:20
 **/
@Data
public class TreeRich {

    private TreeRoot treeRoot;                          //树根信息
    private Map<Long, TreeNode> treeNodeMap;        //树节点ID -> 子节点
}
