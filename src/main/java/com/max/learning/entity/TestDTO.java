package com.max.learning.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * @author Rick
 * @date 2021-11-28 13:18
 */
@Data
public class TestDTO {

    @JsonFormat(pattern="yyyy-MM-dd hh:mm:ss",timezone = "GMT+8")
    private Date time;
}
