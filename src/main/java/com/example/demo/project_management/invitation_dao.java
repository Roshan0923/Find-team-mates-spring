package com.example.demo.project_management;

public class invitation_dao {
	
	String project_name;
	int project_id;
	int requested_user_id;
	String requested_user_name;
	String message;
	String request_user_email;
	public String getRequest_user_email() {
		return request_user_email;
	}
	public void setRequest_user_email(String request_user_email) {
		this.request_user_email = request_user_email;
	}
	public String getProject_name() {
		return project_name;
	}
	public void setProject_name(String project_name) {
		this.project_name = project_name;
	}
	public int getProject_id() {
		return project_id;
	}
	public void setProject_id(int project_id) {
		this.project_id = project_id;
	}
	public int getRequested_user_id() {
		return requested_user_id;
	}
	public void setRequested_user_id(int requested_user_id) {
		this.requested_user_id = requested_user_id;
	}
	public String getRequested_user_name() {
		return requested_user_name;
	}
	public void setRequested_user_name(String requested_user_name) {
		this.requested_user_name = requested_user_name;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	

}
