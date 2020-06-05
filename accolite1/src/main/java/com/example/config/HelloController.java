package com.example.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.AuthRequest;
import com.example.model.AuthResonse;
import com.example.user.User;
import com.example.user.UserService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class HelloController {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	
	@GetMapping("/hello")
	public String helloWorld() {
		return "hello";
	}

	@PostMapping("/authenticate")
	public AuthResonse createToken(@RequestBody AuthRequest authRequest) throws Exception {
		
		System.out.println(authRequest.getUsername()+"inside create token");
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
		} catch (AuthenticationException e) {
			// TODO Auto-generated catch block
			throw new Exception("invalid username and password");
		}
		User userDetails = userService.getUserByUsername(authRequest.getUsername());
		System.out.println(userDetails+" userdetails");
		
		final String jwt = jwtUtil.generateToken(userDetails);
		System.out.println(jwt);
		 
		return new AuthResonse(jwt);
		
		
	}
}
