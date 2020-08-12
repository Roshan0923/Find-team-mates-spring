package com.example.demo.project_management;

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

}
