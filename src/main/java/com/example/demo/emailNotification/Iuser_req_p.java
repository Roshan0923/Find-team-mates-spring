package com.example.demo.emailNotification;

public interface Iuser_req_p {
	
	public void delete_request(int project_id,int requested_user_id);
	
	public void update_request_status(int project_id,int requested_user_id);
	

}
