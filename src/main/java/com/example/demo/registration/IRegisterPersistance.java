package com.example.demo.registration;

public interface IRegisterPersistance {
	
	public void save(registration_body obj);
	
	public boolean isUserExist(registration_body obj);
	
	
	public void update(updateProfile_body obj,int user_id);
	

}
