package com.example.user;

import java.util.List;

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

	public User getUserByUsername(String userName) {
		System.out.println("getUserByUsername"+userName);
		String query = "select * from users where email ='"+userName+"'";
//		System.out.println(query);
		User currentUser = jdbc.queryForObject(query, new UserRowMapper());
//		System.out.println(currentUser);
		return currentUser;
	}
	
	public List<User> getAllUser(){
		System.out.println("reached");
		String query = "select * from users";
		List<User> a = jdbc.query(query,new UserRowMapper());
		return a;
	}
	
	public AuthResonse addUser(@RequestBody User currentUser) {
		System.out.println(currentUser);
		String addQuery = "insert into users(name,email,password) " + "values('"+ currentUser.getName()+"','"+currentUser.getEmail()+"','"+currentUser.getPassword()+"')";
		jdbc.execute(addQuery);
		return new AuthResonse("successful");
	}
	
	public User getUserById(@PathVariable("id") int id) {
		String query = "select * from users where id ="+id;
		User currentUser = jdbc.queryForObject(query, new UserRowMapper());
		System.out.println(currentUser);
		return currentUser;
		
	}
	
	public String updateUser(@PathVariable("id") int id, @RequestBody User changeUser) {
		String query = "update users set id="+id+" ,name='"+changeUser.getName()+"' ,email='"+changeUser.getEmail()+"' ,password='"+changeUser.getPassword()+"' where id ="+id;
		jdbc.execute(query);
		return "Update successful";
	}

	public String delUser(@PathVariable("id") int id) {
		jdbc.execute("delete from users where id="+id);
		return "deleted successfully";
	}

	public List<MyAssignments> getAssignBycandidateID(int id) {
		String query = "select r.assignment_id, r.marks, a.name, a.user_id as author_id, a.expire_time ,a.duration from  results as r join assignments as a on r.user_id=a.id where r.user_id="+id ;
		List<MyAssignments> m = jdbc.query(query, new AssignmentRowMapper());
		return m;
	}
}