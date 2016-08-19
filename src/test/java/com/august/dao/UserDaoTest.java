package com.august.dao;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.august.cache.RedisCache;
import com.august.entity.User;

@RunWith(SpringJUnit4ClassRunner.class)  //表示继承了SpringJUnit4ClassRunner类  
@ContextConfiguration("classpath:spring/applicationContext.xml")
public class UserDaoTest {
	private static final Logger logger = LoggerFactory.getLogger(UserDaoTest.class);

    @Resource
    private UserMapper userMapper;
    @Resource
    private RedisCache redisCache;
    
    @Test
    public void test1(){
    	User user = userMapper.selectByPrimaryKey(1);
    	System.out.println("--------------------");
    	logger.info(JSON.toJSONString(user));
    	System.out.println("--------------------");
    	
    	redisCache.putCache("userCacheTest", user);
    	User cache = redisCache.getCache("userCacheTest", User.class);
    	logger.info(JSON.toJSONString(cache));
    	System.out.println("--------------------");
    	
    	assertNotNull(cache);
    	
    }
	
}
