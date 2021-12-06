package com.max.design.behavioral.mediator.mybatis;

import com.alibaba.fastjson.JSON;
import com.max.design.behavioral.mediator.po.Activity;
import com.max.design.behavioral.mediator.po.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.io.Reader;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Rick
 * @date 2021-12-03 19:54
 */
@Slf4j
class SqlSessionFactoryBuilderTest {

    @Test
    public void test_queryUserInfoById() {
        String resource = "mybatis-config-datasource.xml";
        Reader reader;
        try {
            reader = Resources.getResourceAsReader(resource);
            SqlSessionFactory sqlMapper = new SqlSessionFactoryBuilder().build(reader);

            SqlSession session = sqlMapper.openSession();
            try {
                Activity activity = session.selectOne("com.max.design.behavioral.mediator.dao.IActivityDao.queryActivityById", 100001);
                log.info("测试结果：{}", JSON.toJSONString(activity));
            } finally {
                session.close();
                reader.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void test_queryUserList() {
        String resource = "mybatis-config-datasource.xml";
        Reader reader;
        try {
            reader = Resources.getResourceAsReader(resource);
            SqlSessionFactory sqlMapper = new SqlSessionFactoryBuilder().build(reader);

            SqlSession session = sqlMapper.openSession();
            try {
                User req = new User();
                req.setAge(18);
                List<User> userList = session.selectList("org.itstack.demo.design.dao.IUserDao.queryUserList", req);
                log.info("测试结果：{}", JSON.toJSONString(userList));
            } finally {
                session.close();
                reader.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}