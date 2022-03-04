package com.example.demo.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.demo.model.User;
@Component
public class UserDao {
	private EntityManager entityManager;
	
	@Autowired
    public UserDao(EntityManager entityManager){
        this.entityManager = entityManager;
    }
	public void deleteUserById(long id) {
        Query query = (Query) entityManager.createQuery("delete from users where id=:id");
        query.setParameter("id", id);
        query.executeUpdate();
    }
	public User findUserById(long id) {
    	User user = entityManager.find(User.class, id);
        return user;
	}
	public List<User> getAllUsers() {
        Query query= (Query) entityManager.createQuery("from users");
        List<User> user = query.getResultList();
        return user;
    }
    public User saveUser(User user) {
    	User dbUser = entityManager.merge(user);
    	user.setId(dbUser.getId());
        return user;
    }
    
}
