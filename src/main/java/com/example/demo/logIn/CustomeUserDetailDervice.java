package com.example.demo.logIn;

import org.springframework.security.core.userdetails.UserDetailsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.logIn.entity.User;

import java.util.ArrayList;


@Service
public class CustomeUserDetailDervice implements UserDetailsService  {
	
	 @Autowired
	    private IuserRepository repository;

	    
	    public UserDetails loadUserByUsername(String Email) throws UsernameNotFoundException {
	    	System.out.println(Email);
	        User user = repository.FindByEmailID(Email);
	        System.out.println("Logged in user id is"+user.getId());
	        return new org.springframework.security.core.userdetails.User(user.getEmail_id(), user.getPassword(), new ArrayList<>());
	    }
	    
	    
	    public int getUserID(String email) throws UsernameNotFoundException
	    {
	    	 int id = repository.GetID(email);
	    	 return id;
	    }
	    

}
