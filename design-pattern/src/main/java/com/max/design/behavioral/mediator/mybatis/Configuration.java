package com.max.design.behavioral.mediator.mybatis;

import lombok.Setter;

import java.sql.Connection;
import java.util.Map;

/**
 * @author Rick
 * @date 2021-12-03 15:44
 */
@Setter
public class Configuration {

    protected Connection connection;
    /**
     * 暂时推测是从数据库的连接信息
     */
    protected Map<String, String> dataSource;
    /**
     * 这个是从xml读取到的sql集合
     */
    protected Map<String, XNode> mapperElement;

}
