package com.august.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.august.dao.UserMapper;
import com.august.entity.User;
import com.august.service.IUserService;

@Service("userService")
public class UserServiceImpl implements IUserService {
	@Resource
	private UserMapper userDao;

	@Override
	public User getUserById(int userId) {
		return userDao.selectByPrimaryKey(userId);
	}

}
