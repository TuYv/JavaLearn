package com.max.learning.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * @author Rick
 * @date 2021-12-09 10:49
 */
@Data
@AllArgsConstructor
public class BigTestDTO {
    private List<TestDTO> list;
}
