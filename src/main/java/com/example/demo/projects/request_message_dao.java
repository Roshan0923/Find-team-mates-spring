package com.example.demo.projects;

import org.springframework.stereotype.Component;

public class request_message_dao {

	
	int user_id;
	int request_user_id;
	int project_id;
	String message;
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getRequest_user_id() {
		return request_user_id;
	}
	public void setRequest_user_id(int request_user_id) {
		this.request_user_id = request_user_id;
	}
	public int getProject_id() {
		return project_id;
	}
	public void setProject_id(int project_id) {
		this.project_id = project_id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
