package com.max.design.structure.composite.service.logic.impl;

import com.max.design.structure.composite.service.logic.BaseLogic;
import java.util.Map;

public class UserGenderFilter extends BaseLogic {

    @Override
    public String matterValue(Long treeId, String userId, Map<String, String> decisionMatter) {
        return decisionMatter.get("gender");
    }

}
