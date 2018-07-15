package com.wehago.service;

import java.util.List;

import com.wehago.repository.User;

public interface UserService {
	public List<User> userList();
	public User getUser(Long id);
	public User insertUser();
	public void deleteUser(Long id);
}
