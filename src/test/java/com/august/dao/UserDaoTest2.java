package com.august.dao;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.august.entity.User;
import com.august.service.IUserService;

@RunWith(SpringJUnit4ClassRunner.class)  //表示继承了SpringJUnit4ClassRunner类  
@ContextConfiguration("classpath:spring/spring-mybatis.xml")
public class UserDaoTest2 {
    private static Logger logger = Logger.getLogger(UserDaoTest2.class);  

    private ApplicationContext ac = null;  
    private IUserService userService;//这里不使用注解注入
   
    @Before
    public void before(){
    	ac = new ClassPathXmlApplicationContext("spring/spring-mybatis.xml");  
        userService = (IUserService) ac.getBean("userService");  
    }
    
    @Test
    public void test1(){
    	User user = userService.getUserById(1);
    	System.out.println(user);
    	System.out.println("--------------------");
    	logger.info(JSON.toJSONString(user));
    }
	
}
