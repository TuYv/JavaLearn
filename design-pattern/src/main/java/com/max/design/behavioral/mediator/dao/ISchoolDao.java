package com.max.design.behavioral.mediator.dao;

import com.max.design.behavioral.mediator.po.School;

public interface ISchoolDao {

    School querySchoolInfoById(Long treeId);

}
