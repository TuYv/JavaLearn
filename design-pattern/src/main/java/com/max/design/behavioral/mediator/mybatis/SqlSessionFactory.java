package com.max.design.behavioral.mediator.mybatis;

/**
 * @author Rick
 * @date 2021-12-03 17:37
 */
public interface SqlSessionFactory {

    SqlSession openSession();
}
