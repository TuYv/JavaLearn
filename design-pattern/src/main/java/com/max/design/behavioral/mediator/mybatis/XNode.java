package com.max.design.behavioral.mediator.mybatis;

import lombok.Data;

import java.util.Map;

/**
 * 这个是从xml读取到的配置
 * @author Rick
 * @date 2021-12-03 15:46
 */
@Data
public class XNode {

    private String namespace;
    private String id;
    private String parameterType;
    private String resultType;
    private String sql;
    private Map<Integer, String> parameter;
}
