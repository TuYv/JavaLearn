package com.max.learning.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.max.learning.enums.ResultEnum;
import lombok.Data;

import java.util.Date;

/**
 * @author Rick
 * @date 2021-11-28 13:18
 */
public class TestDTO {

    @JSONField(name = "name")
    private String name;

    @JsonFormat(pattern="yyyy-MM-dd hh:mm:ss",timezone = "GMT+8")
    private Date time;

    private ResultEnum resultEnum;

    private String age;

    private Integer node;

    @JSONField(name = "longStringName")
    private String longStringName;

    public String getLongStringName() {
        return longStringName;
    }

    @JSONField(name = "longStringName")
    public void setLongStringName(String longStringName) {
        this.longStringName = longStringName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public ResultEnum getResultEnum() {
        return resultEnum;
    }

    public void setResultEnum(ResultEnum resultEnum) {
        this.resultEnum = resultEnum;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public Integer getNode() {
        return node;
    }

    public void setNode(Integer node) {
        this.node = node;
    }
}
