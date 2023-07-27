package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.User;
import com.example.demo.Repository.Login;


@Service
public class LoginService {
	@Autowired
	Login login;
	 public List<User> getAllUsers() {
	        return login.findAll();
	    }

	    public User getUserById(int id) {
	        return login.findById(id).get();
	    }

	    public boolean addUser(User user) {
	        return (login.save(user) != null) ? true : false;
	    }
	
	    public User updateUser(int id, User register) {
	    	User existingUser = login.findById(id).get();
	    	existingUser.setUsername(register.getUsername());
	    	existingUser.setPassword(register.getPassword());
	        return login.saveAndFlush(existingUser);
	    }
	    
	    public boolean deleteUser(int id) {
	        if (login.findById(id).isPresent()) {
	        	login.deleteById(id);
	            return true;
	        }
	        return false;
	    }

		public String checkPassword(String username, String password) {
			return login.findPassword(username);
		}
}
