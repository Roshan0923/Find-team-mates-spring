package com.example.demo.logIn.entity;

public class responseData {
	
	String token;
	int user_id;
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public responseData(String token, int user_id) {
		super();
		this.token = token;
		this.user_id = user_id;
	}
	public responseData() {
		// TODO Auto-generated constructor stub
	}

}
