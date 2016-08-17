package com.august.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.august.controller.UserController;

/**
 * 对未处理的错误信息做统一处理
 * @author tian
 */
//在配置文件已配置bean的情况下，该注解扫描也可不要
//@Component
public class GlobalExceptionResolver implements HandlerExceptionResolver {
	private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionResolver.class);

    @Override  
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {   
    	logger.error("访问" + request.getRequestURI() + " 发生错误, 错误信息:" + ex.getMessage());
    	ModelAndView model =  new ModelAndView("exception");
    	model.addObject("message", ex.getMessage());
        return model;   
    }   
}
