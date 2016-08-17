package com.august.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alibaba.fastjson.JSON;
import com.august.entity.User;
import com.august.service.IUserService;

@Controller
@RequestMapping("/user")
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);  

	@Resource
	private IUserService userService;
	
	@RequestMapping(value="/test",method=RequestMethod.GET)
	public String test(HttpServletRequest request, ModelMap model){
		model.addAttribute("id", "test");
		return "index";
	}
	
	@RequestMapping(value="/test/{id}",method=RequestMethod.GET)
	public String test(@PathVariable("id") String id, HttpServletRequest request, ModelMap model){
		model.addAttribute("id", id);
		model.addAttribute("user", userService.getUserById(Integer.parseInt(id)));
		return "index";
	}
	
	@RequestMapping(value="/test2/{id}",method=RequestMethod.GET)
	public String test2(@PathVariable("id") String id, HttpServletRequest request, ModelMap model){
		model.addAttribute("id", id);
    	User user = userService.getUserById(Integer.parseInt(id));
    	System.out.println("--------------------");
    	logger.info(JSON.toJSONString(user));
    	user.setAge(120);
    	userService.updateUser(user);
		model.addAttribute("user", user);
		return "index";
	}
}
