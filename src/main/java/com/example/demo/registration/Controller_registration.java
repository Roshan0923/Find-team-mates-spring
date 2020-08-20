package com.example.demo.registration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@CrossOrigin("*")
public class Controller_registration {
	
	@Autowired
	Service_registration serivceRegistration;
	

	@PostMapping("/register")
	public ResponseEntity<String> register_user(@ModelAttribute registration_body obj)
	{
		System.out.println(obj.getEmail());
		System.out.println(obj.getPassword());
		System.out.println(obj.getPic_byte().getSize());
	if(serivceRegistration.checkUserExist(obj))
	{
		System.out.println(serivceRegistration.checkUserExist(obj));
		return new ResponseEntity<>("user already exist", HttpStatus.CONFLICT);
	}
	else {
		serivceRegistration.doRegistration(obj);
		return new ResponseEntity<>("Successfull Registered", HttpStatus.OK);
	}
	
	}
	
	@PostMapping("/updateProfile/{user_id}")
	public ResponseEntity<String> update_profile(@ModelAttribute updateProfile_body obj,@PathVariable int user_id)
	{
		System.out.println("Inside the updae profile method");
		System.out.println(obj.getPic_byte().getSize());
		try {
		serivceRegistration.updateData(obj,user_id);
		return new ResponseEntity<>("Successfull Registered", HttpStatus.OK);
	} catch (Exception e) {
		System.out.println(e);
		return new ResponseEntity<>("Error", HttpStatus.SERVICE_UNAVAILABLE);
	}
		

	
	}
		
	}
	


