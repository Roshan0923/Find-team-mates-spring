package com.example.demo.projects;

import java.util.List;

public interface Iproject_persistance {
	
	public List<project_dao> getAll();
	
	public user_info_dao getUserInfo(int user_id);
	public void insert_request(request_message_dao obj);
	
}
