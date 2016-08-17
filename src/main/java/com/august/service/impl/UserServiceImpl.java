package com.august.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.august.dao.UserMapper;
import com.august.entity.User;
import com.august.enums.ResultEnum;
import com.august.exception.BizException;
import com.august.service.IUserService;

@Service("userService")
public class UserServiceImpl implements IUserService {
	@Resource
	private UserMapper userDao;

	@Override
	public User getUserById(int userId) {
		return userDao.selectByPrimaryKey(userId);
	}
	
	@Transactional
	@Override
	public void updateUser(User user){
		userDao.updateByPrimaryKey(user);
		if(user.getAge() > 100){//回滚
			throw new BizException(ResultEnum.ROLLBACK_EXCEPTION.getMsg());
		}
	}
	
	@Override
	public void addUser(User user){
		userDao.insert(user);
	}
}
