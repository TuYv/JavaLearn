package com.max.learning.utils;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.read.listener.ReadListener;
import com.alibaba.excel.util.ListUtils;
import com.alibaba.fastjson.JSON;
import com.max.learning.entity.ResourceDTO;
import com.max.learning.entity.RoleDTO;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author Rick
 * @date 2021-12-24 17:22
 */
@Slf4j
public class ExcelUtils {

    public static void main(String[] args) {
        simpleWrite();
        System.out.println("done");
    }

    public static List<RoleDTO> doBuild() {

        List<RoleDTO> roleList = simpleRead();
        List<ResourceDTO> resourceList = simpleRead2();
        Map<String,List<String>> parentMap = resourceList.stream()
            .collect(Collectors.groupingBy(ResourceDTO::getParent_id, Collectors.mapping(ResourceDTO::getId, Collectors.toList())));
        Map<String,String> resourceMap = resourceList.stream().collect(Collectors.toMap(ResourceDTO::getId, ResourceDTO::getMenu_name));

        roleList.forEach(role -> {
            String[] resourceTree = role.getResource_tree().replace("[","").replace("]","").split(",");
            List<String> resourceIdList = getResourceTree(Arrays.asList(resourceTree), parentMap);
            role.setResource_tree(resourceIdList.stream()
                .distinct()
                .map(x -> resourceMap.get(x))
                .collect(Collectors.joining(",")));
        });
        return roleList;
    }

    public static List<String> getResourceTree(List<String> list, Map<String,List<String>> parentMap) {
        List<String> result = new ArrayList<>();
        list.forEach(x -> {
            if (parentMap.containsKey(x) && parentMap.get(x).get(0) != "0") {
                result.addAll(getResourceTree(parentMap.get(x), parentMap));
            } else {
                result.add(x);
            }
        });
        return result;
    }


    public static List<RoleDTO> simpleRead() {
        String fileName = "C:\\Users\\Rick\\Documents\\yaduo\\002-??????\\role.xlsx";
        List<RoleDTO> roleList = new ArrayList<>();
        // ??????2???
        // ??????????????? ?????????????????????DemoDataListener
        // ?????? ????????????????????????class??????????????????????????????sheet ????????????????????????
        EasyExcel.read(fileName, RoleDTO.class, new ReadListener<RoleDTO>() {
            /**
             * ????????????????????????
             */
            public static final int BATCH_COUNT = 3000;
            /**
             *????????????
             */
            private List<RoleDTO> cachedDataList = ListUtils.newArrayListWithExpectedSize(BATCH_COUNT);

            @Override
            public void invoke(RoleDTO data, AnalysisContext context) {
                saveData(data);
                    // ?????????????????? list
                    //cachedDataList = ListUtils.newArrayListWithExpectedSize(BATCH_COUNT);
            }

            @Override
            public void doAfterAllAnalysed(AnalysisContext context) {
                //saveData();
            }

            private void saveData(RoleDTO data) {
                roleList.add(data);
            }
        }).sheet().doRead();
        return roleList;
    }
    public static List<ResourceDTO> simpleRead2() {
        String fileName = "C:\\Users\\Rick\\Documents\\yaduo\\002-??????\\resource.xlsx";
        List<ResourceDTO> roleList = new ArrayList<>();
        // ??????2???
        // ??????????????? ?????????????????????DemoDataListener
        // ?????? ????????????????????????class??????????????????????????????sheet ????????????????????????
        EasyExcel.read(fileName, ResourceDTO.class, new ReadListener<ResourceDTO>() {
            /**
             * ????????????????????????
             */
            public static final int BATCH_COUNT = 3000;
            /**
             *????????????
             */
            private List<ResourceDTO> cachedDataList = ListUtils.newArrayListWithExpectedSize(BATCH_COUNT);

            @Override
            public void invoke(ResourceDTO data, AnalysisContext context) {
                saveData(data);
                // ?????????????????? list
                //cachedDataList = ListUtils.newArrayListWithExpectedSize(BATCH_COUNT);
            }

            @Override
            public void doAfterAllAnalysed(AnalysisContext context) {
                //saveData();
            }

            private void saveData(ResourceDTO data) {
                roleList.add(data);
            }
        }).sheet().doRead();
        return roleList;
    }

    public static void simpleWrite() {
        // ?????? simpleWrite?????????????????????????????????????????????5000???????????????????????????????????????????????????????????? ??????????????????

        // ??????1 JDK8+
        // since: 3.0.0-beta1
        String fileName = "C:\\Users\\Rick\\Documents\\yaduo\\002-??????\\roleNew.xlsx";
        // ?????? ????????????????????????class??????????????????????????????sheet?????????????????? ??????????????????????????????
        // ?????????????????????03 ??? ??????excelType????????????
        EasyExcel.write(fileName, RoleDTO.class)
            .sheet("??????")
            .doWrite(() -> {
                // ????????????t
                // ??????
                return doBuild();
            });

    }
}
