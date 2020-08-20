package com.example.demo.projects;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class service_projects {
	
	@Autowired
	Iproject_persistance obj;
	
	public List<project_dao> getAllData()
	{
		return obj.getAll();
	}
	
	public user_info_dao getUserINfo(int user_id)
	{
		return obj.getUserInfo(user_id);
	}
	
	public void store_request_message(request_message_dao obj)
	{
		this.obj.insert_request(obj);
	}
	
	public List<registered_user_list_dao> getList(int project_id)
	{
		return obj.getInfo(project_id);
	}

}
