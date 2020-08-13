package com.example.demo.project_management;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class Service_project_management {
	
	@Autowired
	project_persistance persistance_obj;
	
	public void create_new_project(project_body obj)
	{
		System.out.println("Calling the service class methos to create new object");
		persistance_obj.save(obj);
	}
	
	public List<project_body> get_user_created_project(int user_id)
	{
		System.out.println("Calling the service methos to get all user created project");
		return persistance_obj.find_project_by_user_id(user_id);
	}

}
