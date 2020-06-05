package com.example.assignments;

public class CandidateStructure {

	private int user_id;
	private int marks;
	private String name;
	private String email;
	
	
	
	public CandidateStructure() {
	}
	public CandidateStructure(int user_id, int marks, String name, String email) {
		super();
		this.user_id = user_id;
		this.marks = marks;
		this.name = name;
		this.email = email;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
}
