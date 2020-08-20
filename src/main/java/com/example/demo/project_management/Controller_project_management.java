package com.example.demo.project_management;

import java.security.PublicKey;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	public ResponseEntity<String> create_projec(@RequestBody project_body obj)
	{
		System.out.println("Inside the controller method to create new  project");
		if(service.create_new_project(obj)) {
			return new ResponseEntity<>("Successfully created new project", HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>("Error", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	@GetMapping ("/getUSerCreatedProject/{user_id}")
	public List<project_body> getUSerWrittenProject(@PathVariable int user_id)
	{
		// int teamp_user_id=Integer.parseInt(user_id);
		System.out.println("user id-->"+user_id);
		System.out.println("Inside the controller method to get project data by USER_ID");
		return service.get_user_created_project(user_id);	
	}
	
	@DeleteMapping ("/deleteProject/{user_id}/{project_id}")
	public void deleteProject(@PathVariable int user_id,@PathVariable int project_id)
	{
		System.out.println("Inside Controller method to delete project with project id-->"+project_id);
		service.deleteUsereSelectedProject(user_id, project_id);
	}
	
	@PutMapping("/updateProject/{project_id}")
	public void updateProject(@PathVariable int project_id,@RequestBody project_body obj)
	{
		System.out.println("---------------------------------------------------------------");
		System.out.println("user id id"+obj.getUser_id());
		System.out.println("Project id is"+project_id);
		System.out.println(obj.getBack_end());
		System.out.println(obj.getFront_end());
		System.out.println("Inside Controller method to update project with project id-->"+project_id);
		service.updateProject(obj, project_id);
	}
	
	
	@GetMapping("/getInvitation/{user_id}")
	public List<invitation_dao> getPendingInvitation(@PathVariable int user_id)
	{
		System.out.println("Inside the controller to get the pending invitation for the user-->"+user_id);
		return service.getPendingInvitation(user_id);
		
	}

}
