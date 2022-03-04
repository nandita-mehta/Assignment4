package com.example.demo.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.dao.UserDao;
import com.example.demo.model.User;
import com.example.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
    public UserServiceImpl(UserDao userDao) {
    	super();
    	this.userDao = userDao;
    }

    @Override
    public void deleteUserById(long id) {
    	userDao.findUserById(id);
    	userDao.deleteUserById(id);
    }
    
    @Override
    public List<User> findAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    public User findUserById(long id) {
        return userDao.findUserById(id);
    }
    
    @Override
    public User saveUser(User user) {
    	return userDao.saveUser(user);
    }
}