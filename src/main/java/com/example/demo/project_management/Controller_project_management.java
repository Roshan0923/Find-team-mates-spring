package com.example.demo.project_management;

import java.security.PublicKey;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/project")
@CrossOrigin("*")
public class Controller_project_management {
	
	@Autowired
	Service_project_management service;
	
	@PostMapping("/create")
	public void create_projec(@RequestBody project_body obj)
	{
		System.out.println("Inside the controller method to create new  project");
		service.create_new_project(obj);
	}
	@GetMapping ("/getUSerCreatedProject/{user_id}")
	public List<project_body> getUSerWrittenProject(@PathVariable Integer user_id)
	{
		System.out.println("user id-->"+user_id);
		System.out.println("Inside the controller method to get project data by USER_ID");
		return service.get_user_created_project(user_id);
		
		
	}

}
