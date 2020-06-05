package com.example.user;

import java.sql.Time;

public class MyAssignments {
	
	private int assignment_id;
	private int marks;
	private String name;
	private String author_id;
	private Time expire_time;
	private Time duration;
	
	
	
	public MyAssignments() {
		super();
	}
	public MyAssignments(int assignment_id, int marks, String name, String author_id, Time expire_time, Time duration) {
		super();
		this.assignment_id = assignment_id;
		this.marks = marks;
		this.name = name;
		this.author_id = author_id;
		this.expire_time = expire_time;
		this.duration = duration;
	}
	public int getAssignment_id() {
		return assignment_id;
	}
	public void setAssignment_id(int assignment_id) {
		this.assignment_id = assignment_id;
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
	public String getAuthor_id() {
		return author_id;
	}
	public void setAuthor_id(String author_id) {
		this.author_id = author_id;
	}
	public Time getExpire_time() {
		return expire_time;
	}
	public void setExpire_time(Time expire_time) {
		this.expire_time = expire_time;
	}
	public Time getDuration() {
		return duration;
	}
	public void setDuration(Time duration) {
		this.duration = duration;
	}
	
	

}
