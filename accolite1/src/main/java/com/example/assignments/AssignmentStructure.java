package com.example.assignments;

import java.sql.Time;

import org.springframework.format.annotation.DateTimeFormat;

public class AssignmentStructure {

	private int id;
	private String name;
	private int user_id;
	private Time expire_time;
	private Time duration;
	
	
	public AssignmentStructure() {
	}
	
	public AssignmentStructure(int id, String name, int user_id, Time expire_time, Time duration) {
		super();
		this.id = id;
		this.name = name;
		this.user_id = user_id;
		this.expire_time = expire_time;
		this.duration = duration;
	}


	@Override
	public String toString() {
		return "AssignmentStructure [id=" + id + ", name=" + name + ", user_id=" + user_id + ", expire_time="
				+ expire_time + ", duration=" + duration + "]";
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	
	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
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
