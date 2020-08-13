package com.example.demo.project_management;

import java.util.List;

public interface IPeoject_management_persistance {
	
	public void save(project_body obj);
	public List<project_body> find_project_by_user_id(int user_id);

}
