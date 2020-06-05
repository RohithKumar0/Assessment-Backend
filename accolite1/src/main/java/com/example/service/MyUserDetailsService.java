package com.example.service;
//import com.example.user.*;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.user.UserService;

@Service
public class MyUserDetailsService implements UserDetailsService{

	@Autowired
	private UserService userServide;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("Myuserdetail service");
		// TODO Auto-generated method stub
		return userServide.getUserByUsername(username);
//		return new User("r@gmil.com","saf", new ArrayList<>());
	}

}
