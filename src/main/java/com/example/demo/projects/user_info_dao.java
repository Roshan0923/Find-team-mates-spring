package com.example.demo.projects;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class user_info_dao {
	
	
	
	String email;
	// String password;
	 String name;
	 String linkedIn_url;
	 String description;
		String technology;
		 String language;
		    private byte[] image;

		  public byte[] getImage() {
				return image;
			}
			public void setImage(byte[] image) {
				this.image = image;
			}
		private MultipartFile pic_byte;
	 
	 public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
	public MultipartFile getPic_byte() {
		return pic_byte;
	}
	public void setPic_byte(MultipartFile pic_byte) {
		this.pic_byte = pic_byte;
	}


}
