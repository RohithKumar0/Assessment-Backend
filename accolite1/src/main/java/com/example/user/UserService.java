package com.example.user;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.assignments.CandidateStructure;
import com.example.model.AuthResonse;

@Service
public class UserService {
	
	@Autowired
	private JdbcTemplate jdbc;

	private final static Logger LOGGER =  
            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	
	public User getUserByUsername(String userName) {
		LOGGER.log(Level.INFO, "Getting user by username"); 
		System.out.println("getUserByUsername"+userName);
		String query = "select * from users where email ='"+userName+"'";
//		System.out.println(query);
		User currentUser = jdbc.queryForObject(query, new UserRowMapper());
//		System.out.println(currentUser);
		return currentUser;
	}
	
	public List<User> getAllUser(){
		LOGGER.log(Level.INFO, "Get all users"); 
		System.out.println("reached");
		String query = "select * from users";
		List<User> a = jdbc.query(query,new UserRowMapper());
		return a;
	}
	
	public AuthResonse addUser(@RequestBody User currentUser) {
		LOGGER.log(Level.INFO, "add user	"); 
		System.out.println(currentUser);
		String addQuery = "insert into users(name,email,password) " + "values('"+ currentUser.getName()+"','"+currentUser.getEmail()+"','"+currentUser.getPassword()+"')";
		jdbc.execute(addQuery);
		return new AuthResonse("successful");
	}
	
	public User getUserById(@PathVariable("id") int id) {
		LOGGER.log(Level.INFO, "Get user by id"); 
		String query = "select * from users where id ="+id;
		User currentUser = jdbc.queryForObject(query, new UserRowMapper());
		System.out.println(currentUser);
		return currentUser;
		
	}
	
	public String updateUser(@PathVariable("id") int id, @RequestBody User changeUser) {
		LOGGER.log(Level.INFO, "user updating	"); 
		String query = "update users set id="+id+" ,name='"+changeUser.getName()+"' ,email='"+changeUser.getEmail()+"' ,password='"+changeUser.getPassword()+"' where id ="+id;
		jdbc.execute(query);
		return "Update successful";
	}

	public String delUser(@PathVariable("id") int id) {
		LOGGER.log(Level.INFO, "deleting user"); 
		jdbc.execute("delete from users where id="+id);
		return "deleted successfully";
	}

	public List<MyAssignments> getAssignBycandidateID(int id) {
		String query = "select r.assignment_id, r.marks, a.name, a.user_id as author_id, a.expire_time ,a.duration from  results as r join assignments as a on r.user_id=a.id where r.user_id="+id ;
		List<MyAssignments> m = jdbc.query(query, new AssignmentRowMapper());
		return m;
	}

	public AuthResonse makeadmin(int id) {
		LOGGER.log(Level.INFO, "making the surrent user  admin"); 
		System.out.println("iam here");
		// TODO Auto-generated method stub
		String query = "update users \r\n" + 
				"set isAdmin = true\r\n" + 
				"where id ="+id;
		jdbc.execute(query);
		return new AuthResonse("updated successful");
	}
}