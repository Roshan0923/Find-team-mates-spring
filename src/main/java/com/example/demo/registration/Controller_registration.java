package com.example.demo.registration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
	
	
	
	@GetMapping ("/")
	public String hello()
	{
		System.out.println("hello");
		return "helloo";
	}
	
	@PostMapping("/register")
	public boolean register_user(@ModelAttribute registration_body obj)
	{
		System.out.println(obj.getEmail());
		System.out.println(obj.getPassword());
		System.out.println(obj.getPic_byte().getSize());
	//	System.out.println(obj.email);
		serivceRegistration.doRegistration(obj);
		return true;
	}
	

}
