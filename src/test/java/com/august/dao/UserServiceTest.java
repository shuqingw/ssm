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
import com.august.service.IUserService;

@RunWith(SpringJUnit4ClassRunner.class)  //表示继承了SpringJUnit4ClassRunner类  
@ContextConfiguration(locations = {"classpath:spring/spring-mybatis.xml", "classpath:spring/spring-service.xml"})
public class UserServiceTest {
	private static final Logger logger = LoggerFactory.getLogger(UserServiceTest.class);

    @Resource
    private IUserService userService;
    
    @Test
    public void test1(){
    	User user = userService.getUserById(1);
    	System.out.println("--------------------");
    	logger.info(JSON.toJSONString(user));
    }
	
   // @Test
//    public void test2(){
//    	User user = new User(2, "user2", "pas2", 25);
//    	userService.addUser(user);
//    	System.out.println("--------------------");
//    	logger.info(JSON.toJSONString(user));
//    }
    
    @Test
    public void test3(){
    	User user = userService.getUserById(2);
    	System.out.println("--------------------");
    	logger.info(JSON.toJSONString(user));
    	
    	user.setAge(120);
    	try {
			userService.updateUser(user);
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
    	
    	User user2 = userService.getUserById(2);
    	System.out.println("--------------------");
    	logger.info(JSON.toJSONString(user2));
    }
    
}
