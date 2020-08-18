package com.example.demo.logIn.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "registered_user")
public class User {
	
	
	 	@Id
	    private int id;
	    private String name;
	    private String password;
	    public User(int id, String name, String password, String email_id) {
			super();
			this.id = id;
			this.name = name;
			this.password = password;
			this.email_id = email_id;
		}
	    
	    public User() {
			// TODO Auto-generated constructor stub
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
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getEmail_id() {
			return email_id;
		}
		public void setEmail_id(String email_id) {
			this.email_id = email_id;
		}
		private String email_id;

}
