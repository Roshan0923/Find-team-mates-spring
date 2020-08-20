package com.example.demo.projects;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.registration.registration_body;

@RestController
@CrossOrigin("*")
@RequestMapping("/allProject")
public class controller_projects {
	
	@Autowired
	service_projects service;
	
	@GetMapping("/")
	public List<project_dao> getAllProjects()
	{
		return service.getAllData();
	}
	
	@GetMapping("/getUserInfo/{user_id}")
	public user_info_dao getUSerInfo(@PathVariable int user_id)
	{
		System.out.println("Inside the get user infor method");
		return service.getUserINfo(user_id);
	}
	
	@GetMapping("getRegisteredUserList/{project_id}")
	public List<registered_user_list_dao> getRegisteredUserList(@PathVariable int project_id)
	{
		System.out.println("Inside the getRegisteredUserList method for project id"+project_id);
		return service.getList(project_id);
	}
	
	
	@PostMapping("/insertRequest")
	public boolean register_user(@RequestBody request_message_dao obj)
	{
		System.out.println(obj.getMessage());
		System.out.println("Inside the controller to save the user request to join");
		service.store_request_message(obj);
		return true;
	}
	

}
