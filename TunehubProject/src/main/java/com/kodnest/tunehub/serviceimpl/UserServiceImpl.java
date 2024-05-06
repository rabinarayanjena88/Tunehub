package com.kodnest.tunehub.serviceimpl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodnest.tunehub.entity.User;
import com.kodnest.tunehub.repository.UserRepository;
import com.kodnest.tunehub.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserRepository userRepository;

	@Override
	public List<User> getUser() {
	
		return userRepository.findAll();
	}

	 @Override
	    public void addUser(User user) {
	        userRepository.save(user);
	    }

	 @Override
	 public User emailExists(User user) {
	     User existingUser = userRepository.findByEmail(user.getEmail());
	     if (existingUser != null) {
	         System.out.println("User with this email already exists");
	         return existingUser; // Returning the existing user object
	     } else {
	         System.out.println("User with this email does not exist");
	         return null; // No existing user found
	     }
	 }
	 
//.......................
	 
	 @Override
	    public boolean isUserAdmin(String email) {
	        User user = userRepository.findByEmail(email);
	        return user != null && "admin".equals(user.getRole());
	    }

	    @Override
	    public boolean isUserCustomer(String email) {
	        User user = userRepository.findByEmail(email);
	        return user != null && "customer".equals(user.getRole());
	    }

	    @Override
	    public User emailExists(String email) {
	        return userRepository.findByEmail(email);
	    }

		@Override
		public User getUser(String mail) {
			return userRepository.findByEmail(mail);
			
		}

		@Override
		public void updateUser(User user) {
			userRepository.save(user);
		}

		@Override
		public boolean isPremium(String email, String password) {
			  User user = userRepository.findByEmail(email);
			return user.isPremium();
		}
	    
	   
	    

}
