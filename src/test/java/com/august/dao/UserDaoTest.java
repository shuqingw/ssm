package com.august.dao;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.august.entity.User;
import com.august.exception.GlobalExceptionResolver;
import com.august.service.IUserService;

@RunWith(SpringJUnit4ClassRunner.class)  //表示继承了SpringJUnit4ClassRunner类  
@ContextConfiguration("classpath:spring/spring-mybatis.xml")
public class UserDaoTest {
	private static final Logger logger = LoggerFactory.getLogger(UserDaoTest.class);

    @Resource
    private UserMapper userMapper;
    
    @Test
    public void test1(){
    	User user = userMapper.selectByPrimaryKey(1);
    	System.out.println(user);
    	System.out.println("--------------------");
    	logger.info(JSON.toJSONString(user));
    }
	
}
