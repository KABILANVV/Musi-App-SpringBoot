package com.example.demo.Service;

import com.example.demo.Entity.Registration;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.RegistrationRepository;

@Service
public class Registry  {
	@Autowired
	RegistrationRepository reg;
	
	 public List<Registration> getAllUsers() {
	        return reg.findAll();
	    }

	    public Registration getUserById(int id) {
	        return reg.findById(id).get();
	    }

	    public boolean addUser(Registration user) {
	        return (reg.save(user) != null) ? true : false;
	    }
	
	    public Registration updateUser(int id, Registration register) {
	    	Registration existingUser = reg.findById(id).get();
	    	existingUser.setUser(register.getUser());
	    	existingUser.setEmail(register.getEmail());
	    	existingUser.setPhone(register.getPhone());
	    	existingUser.setDob(register.getDob());
	        return reg.saveAndFlush(existingUser);
	    }
	    
	    public boolean deleteUser(int id) {
	        if (reg.findById(id).isPresent()) {
	            reg.deleteById(id);
	            return true;
	        }
	        return false;
	    }
}







