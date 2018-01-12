package com.lms.cleartrip.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lms.cleartrip.dao.UserDao;
import com.lms.cleartrip.entity.User;
import com.lms.cleartrip.service.UserService;

@Component("UserService")
public class UserServiceImpl implements UserService{

	@Autowired
	UserDao UserDao;
	
	@Override
	public User add(String id, String name) {
		User user = new User();
		user.setName(name);
		user.setId(id);
		
		if(validateUser(user)){
			user = UserDao.add(user);
		}
		return user;
	}

	private boolean validateUser(User user) {
		if(user == null ||
				user.getId() == null || user.getId().isEmpty() ||
				user.getName() == null || user.getName().isEmpty()){
			throw new RuntimeException("user id and name connot be empty");
		}
		return true;
	}

}
