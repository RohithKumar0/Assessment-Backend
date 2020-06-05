package com.example.model;

public class AuthResonse {
	
	private String jwt;

	public AuthResonse() {
		// TODO Auto-generated constructor stub
		}

	public AuthResonse(String jwt) {
		super();
		this.jwt = jwt;
	}

	public String getJwt() {
		return jwt;
	}

	public void setJwt(String jwt) {
		this.jwt = jwt;
	}
	

}
