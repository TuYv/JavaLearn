package com.max.design.behavioral.mediator.mybatis;

import java.util.List;

/**
 * @author Rick
 * @date 2021-12-03 15:53
 */
public interface SqlSession {
    <T> T selectOne(String statement);

    <T> T selectOne(String statement, Object parameter);

    <T> List<T> selectList(String statement);

    <T> List<T> selectList(String statement, Object parameter);

    void close();
}
