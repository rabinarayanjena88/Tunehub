package com.kodnest.tunehub.service;

import java.util.List;

import com.kodnest.tunehub.entity.User;

public interface UserService {
	
	List<User> getUser();

	void addUser(User user);

	User emailExists(String email);

	User emailExists(User user);

	boolean isUserAdmin(String email);

	boolean isUserCustomer(String email);
	
	User getUser(String mail);

	void updateUser(User user);

	boolean isPremium(String email, String password);

}
