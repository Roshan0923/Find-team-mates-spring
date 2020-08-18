package com.example.demo.logIn.entity;

public class AuthRequest {
	
	private String emailid;
    private String password;

	

    public AuthRequest() {
		// TODO Auto-generated constructor stub
	}
	    public AuthRequest(String emailid, String password) {
		super();
		this.emailid = emailid;
		this.password = password;
	}
		public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	

}
