package com.max.learning.mid.fastjson;

/**
 * @program: learning
 * @description:
 * @author: Max.Tu
 * @create: 2021-09-28 20:49
 **/
public class ParseObjectTest {
/*
    public static void main(String[] args) {
        ParseObject p = new ParseObject();
        List<InnObject> list = new ArrayList<>();
        p.setName("张三");
        p.setAge(24);
        InnObject inn = new InnObject();
        inn.setName("语文");
        inn.setScore("100");
        list.add(inn);
        p.setProject(list);
        System.out.println(JSON.toJSONString(p));
        String s = "{'name':'1', 'age': 25, 'project':'01'}";
        String x = "{\"age\":24,\"name\":\"张三\",\"project\":{\"name\":\"语文\",\"score\":\"100\"}}";

        ParseObject parseObject = JSONUtil.toBean(x, ParseObject.class);
        parseObject = JSON.parseObject(x, ParseObject.class);

        System.out.println(parseObject.toString());
    }

    @Data
    public static class ParseObject {
        String name;
        Integer age;
        List<InnObject> project;

        @Data
        public static class InnObject {
            String name;
            String score;
        }
    }*/
}
