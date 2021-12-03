package com.max.design.behavioral.mediator.mybatis;

import lombok.AllArgsConstructor;

/**
 * @author Rick
 * @date 2021-12-03 17:37
 */
@AllArgsConstructor
public class DefaultSqlSessionFactory implements SqlSessionFactory{

    private final Configuration configuration;

    @Override public SqlSession openSession() {
        return new DefaultSqlSession(configuration.connection, configuration.mapperElement);
    }
}
