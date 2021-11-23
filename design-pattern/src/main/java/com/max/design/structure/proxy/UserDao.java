package com.max.design.structure.proxy;

import com.max.design.structure.proxy.agent.Select;

public interface UserDao {

    @Select("select userName from user where id = #{uId}")
    String queryUserInfo(String uId);
}
