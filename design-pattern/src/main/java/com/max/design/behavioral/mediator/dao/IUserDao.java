package com.max.design.behavioral.mediator.dao;

import com.max.design.behavioral.mediator.po.User;

public interface IUserDao {

     User queryUserInfoById(Long id);

}
