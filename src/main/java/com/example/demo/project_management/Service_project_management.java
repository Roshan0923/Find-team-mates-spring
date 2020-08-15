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
	
	public void deleteUsereSelectedProject(int user_id,int project_id)
	{
		System.out.println("Inside the service class delete method");
		persistance_obj.deleteProject(user_id, project_id);
	}
	
	public void updateProject(project_body obj,int project_id)
	{
		System.out.println("Calling the service class update project method");
		persistance_obj.updateProjectDetails(obj,project_id);
	}
	
	public List<invitation_dao> getPendingInvitation(int user_id)
	{

		System.out.println("Calling the service class to get the pending list ");
		return persistance_obj.getPendingInvitation(user_id);
	}

}
