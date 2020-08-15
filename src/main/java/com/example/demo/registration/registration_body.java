package com.example.demo.registration;

import java.sql.Timestamp;

import org.springframework.web.multipart.MultipartFile;

public class registration_body {
	
	
	String email;
	 String password;
	 String name;
	 String linkedIn_url;
	 String description;
	 String technology;
	 String language;
	 int user_id;
	  public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	private MultipartFile pic_byte;
	// byte[] pic_byte;
	 
	  private Timestamp createdAt;
	    private Timestamp updatedAt;
	   // private MultipartFile blogImage;
	    private String type;
	    private String fileName;

	 
	public Timestamp getCreatedAt() {
			return createdAt;
		}
		public void setCreatedAt(Timestamp createdAt) {
			this.createdAt = createdAt;
		}
		public Timestamp getUpdatedAt() {
			return updatedAt;
		}
		public void setUpdatedAt(Timestamp updatedAt) {
			this.updatedAt = updatedAt;
		}

		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
		public String getFileName() {
			return fileName;
		}
		public void setFileName(String fileName) {
			this.fileName = fileName;
		}

	public MultipartFile getPic_byte() {
			return pic_byte;
		}
		public void setPic_byte(MultipartFile pic_byte) {
			this.pic_byte = pic_byte;
		}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLinkedIn_url() {
		return linkedIn_url;
	}
	public void setLinkedIn_url(String linkedIn_url) {
		this.linkedIn_url = linkedIn_url;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getTechnology() {
		return technology;
	}
	public void setTechnology(String technology) {
		this.technology = technology;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}

	 

}
