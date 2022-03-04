package com.example.demo.service;

import java.util.List;
import com.example.demo.model.User;

public interface UserService {
	
	public void deleteUserById(long id);
    
    public List<User> findAllUsers();

    public User findUserById(long id);
    
    public User saveUser(User user);
}