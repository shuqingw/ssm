package com.august.service;

import com.august.entity.User;

public interface IUserService {

	User getUserById(int userId);

	void updateUser(User user);

	void addUser(User user);  
}
