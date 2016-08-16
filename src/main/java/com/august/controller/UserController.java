package com.august.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.august.service.IUserService;

@Controller
@RequestMapping("/user")
public class UserController {
    private static Logger logger = Logger.getLogger(UserController.class);  

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
}
