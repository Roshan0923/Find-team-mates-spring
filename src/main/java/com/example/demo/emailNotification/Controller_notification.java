package com.example.demo.emailNotification;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class Controller_notification {
	
	@Autowired
	private EmailSerivce service;
	
	@PostMapping("/sendingEmail")
	public MailResponse sendEmail(@RequestBody MailRequest request) {
		System.out.println("First one"+request.getNum());
		Map<String, Object> model = new HashMap<>();
		model.put("Name", request.getRequested_user_name());
		model.put("project_name", request.getProject_name());
		model.put("location", "Halifax,NS");
		MailResponse response=service.sendEmail(request, model);
		if(response.isStatus()==true)
		{
			System.out.println(response);
			if(request.getNum()==1)
			{
				service.update_request_status(request.getProject_id(),request.getRequested_user_id());
				
			}
			else {
				service.delete_request(request.getProject_id(), request.getRequested_user_id());
			}
			
		}
	
		return response;

	}

}
