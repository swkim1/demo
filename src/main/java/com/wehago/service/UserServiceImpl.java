package com.wehago.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wehago.repository.User;
import com.wehago.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
    private UserRepository userRepository;

	
	@Override
	public List<User> userList() {
		// TODO Auto-generated method stub
		
		return (List<User>)userRepository.findAll();
	}


	@Override
	public User insertUser() {
		// TODO Auto-generated method stub
		User user = new User();
		user.setName("김승원");
		user.setPhone("0100000000");
		user.setEmail("aaa@aa.com");
		
		User rtnUser = userRepository.save(user);
		return rtnUser;
	}


	@Override
	public void deleteUser(Long id) {
		// TODO Auto-generated method stub
		userRepository.delete(id);
	}


	@Override
	public User getUser(Long id) {
		// TODO Auto-generated method stub
		return userRepository.findOne(id);
	}

}
