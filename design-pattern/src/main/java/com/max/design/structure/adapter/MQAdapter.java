package com.max.design.structure.adapter;

import com.alibaba.fastjson.JSON;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * @author Max.Tu
 * @program learning
 * @description
 * @create 2021-11-22 00:14
 **/
public class MQAdapter {
    public static RebateInfo filter(String jsonStr, Map<String, String> link) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        return filter(JSON.parseObject(jsonStr, Map.class), link);
    }

    public static RebateInfo filter(Map obj, Map<String, String> link)
        throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        RebateInfo result = new RebateInfo();
        for (String key : link.keySet()) {
            Object val = obj.get(link.get(key));
            RebateInfo.class.getMethod("set" + key.substring(0, 1).toUpperCase() + key.substring(1), String.class).invoke(result, val.toString());
        }
        return result;
    }
}
