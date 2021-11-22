package com.max.design.structure.composite.service.engine;

import com.max.design.structure.composite.model.aggregates.TreeRich;
import com.max.design.structure.composite.model.vo.EngineResult;
import java.util.Map;

public interface IEngine {

    EngineResult process(final Long treeId, final String userId, TreeRich treeRich, final Map<String, String> decisionMatter);

}
