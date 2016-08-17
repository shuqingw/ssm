package com.august.dao;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.alibaba.fastjson.JSON;
import com.august.entity.User;
import com.august.service.IUserService;

//@RunWith(SpringJUnit4ClassRunner.class)  //表示继承了SpringJUnit4ClassRunner类  
//@ContextConfiguration(locations = {"classpath:spring/spring-mybatis.xml", "classpath:spring/spring-service.xml"})
public class UserServiceTest2 {
	private static final Logger logger = LoggerFactory.getLogger(UserServiceTest2.class);

    private ApplicationContext ac = null;  
    private IUserService userService;//这里不使用注解注入
   
    @Before
    public void before(){
    	ac = new ClassPathXmlApplicationContext(new String[]{"classpath:spring/spring-mybatis.xml", "spring/spring-service.xml"});  
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
