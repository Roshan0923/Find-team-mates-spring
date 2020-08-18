package com.example.demo.project_management;

import java.util.List;

public interface IPeoject_management_persistance {
	
	public boolean save(project_body obj);
	public List<project_body> find_project_by_user_id(int user_id);
	public void deleteProject(int user_id,int project_id);
	
	public void updateProjectDetails(project_body obj,int project_id);
	public List<invitation_dao> getPendingInvitation(int user_id);
	

}
