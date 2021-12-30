package com.max.learning.service;

import com.alibaba.fastjson.JSON;
import com.max.learning.entity.BigTestDTO;
import com.max.learning.entity.TestDTO;
import com.max.learning.enums.ResultEnum;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Rick
 * @date 2021-12-09 10:45
 */
public class TestService {

    public static void main(String[] args) {
        int result = 0;
        int key = 0;
        for (int i = 1; i < 21; i++) {
            result += Math.pow(2, key);
            key++;
            System.out.println("第"+ i +"次循环，result: " + result);
        }
    }

    /*public static void main(String[] args) {

        List<TestDTO> list = new ArrayList<>();
        TestDTO testDTO = new TestDTO();
        testDTO.setResultEnum(ResultEnum.SUCCESS);
        TestDTO testDTO1 = new TestDTO();
        testDTO1.setResultEnum(ResultEnum.SUCCESS);
        TestDTO testDTO2 = new TestDTO();
        testDTO2.setResultEnum(ResultEnum.SUCCESS);
        TestDTO testDTO3 = new TestDTO();
        testDTO3.setResultEnum(ResultEnum.FAILED);
        TestDTO testDTO4 = new TestDTO();
        testDTO4.setResultEnum(ResultEnum.SUCCESS);
        list.add(testDTO);
        list.add(testDTO1);
        list.add(testDTO2);
        list.add(testDTO3);
        list.add(testDTO4);
        List<BigTestDTO> biglist = new ArrayList<>();
        BigTestDTO big = new BigTestDTO(list);
        BigTestDTO big1 = new BigTestDTO(list);
        BigTestDTO big2 = new BigTestDTO(list);
        BigTestDTO big3 = new BigTestDTO(list);
        BigTestDTO big4 = new BigTestDTO(list);
        biglist.add(big);
        biglist.add(big1);
        biglist.add(big2);
        biglist.add(big3);
        biglist.add(big4);

        biglist.forEach(bigx -> {
            bigx.setList(bigx.getList().stream().filter(x -> x.getResultEnum() != ResultEnum.FAILED).collect(Collectors.toList()));
        });
        biglist.forEach(bigx -> System.out.println(JSON.toJSONString(bigx)));
    }*/
}
