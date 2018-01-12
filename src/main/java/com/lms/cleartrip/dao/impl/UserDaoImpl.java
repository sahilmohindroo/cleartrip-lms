package com.lms.cleartrip.dao.impl;

import org.springframework.stereotype.Repository;

import com.lms.cleartrip.dao.UserDao;
import com.lms.cleartrip.databse.Database;
import com.lms.cleartrip.entity.User;

@Repository
public class UserDaoImpl implements UserDao{

	@Override
	public User add(User user) {
			return Database.addUser(user);
	}


}
