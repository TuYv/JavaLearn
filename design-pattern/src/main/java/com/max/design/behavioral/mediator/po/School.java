package com.max.design.behavioral.mediator.po;

import lombok.Data;

import java.util.Date;
@Data
public class School {

    private Long id;
    private String name;
    private String address;
    private Date createTime;
    private Date updateTime;

}
