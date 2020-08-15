package com.example.demo.emailNotification;



public class MailRequest {
	
	private String requested_user_name;
	private String to;
	private String from;
	int num;
	private String subject;
	String project_name;
	int project_id;
	int requested_user_id;
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
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getProject_name() {
		return project_name;
	}
	public void setProject_name(String project_name) {
		this.project_name = project_name;
	}
	

	
	

}
