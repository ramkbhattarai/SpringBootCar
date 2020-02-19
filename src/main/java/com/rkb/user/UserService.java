package com.rkb.user;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	@Autowired
	private UserDao userDao;
	
	public List<User> findAll(){
		return userDao.findAll();
	}
	
	public User findById(int id) {
		Optional<User> user = userDao.findById(id);
		boolean isPresent = user.isPresent();
		if(isPresent) {
		return user.get();
		}else {
			return null;
		}
	}
	
	public void delete(int id) {
		 userDao.deleteById(id);
	}
	
	public void upsert(User u) {
		userDao.save(u);
	}

}
