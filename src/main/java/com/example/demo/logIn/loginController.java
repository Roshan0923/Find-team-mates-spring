package com.example.demo.logIn;

import org.aspectj.weaver.ast.Test;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.logIn.entity.AuthRequest;
import com.example.demo.logIn.entity.User;
import com.example.demo.logIn.entity.responseData;

@RestController
@CrossOrigin("*")
public class loginController {
	
	
	 @Autowired
	    private JwtUtil jwtUtil;
	    @Autowired
	    private AuthenticationManager authenticationManager;
	    
	@Autowired
	CustomeUserDetailDervice serviceObj;
	
	int user_id;
	    @GetMapping("/testingMapping")
	    public String Test()
	    {
	    	return "Test is succussfull";
	    }
	    
	    @PostMapping("/authenticate")
	    public responseData generateToken(@RequestBody AuthRequest obj) throws Exception {
	    	
	        try {

	            authenticationManager.authenticate(
	                    new UsernamePasswordAuthenticationToken(obj.getEmailid(), obj.getPassword())
	            );
	            
	           user_id=serviceObj.getUserID(obj.getEmailid());
	        } catch (Exception ex) {
	        	System.out.println(ex.getMessage());
	            throw new Exception("inavalid username/password");
	        }
	        
	        responseData response=new responseData();
	        response.setUser_id(user_id);
	        response.setToken(jwtUtil.generateToken(obj.getEmailid()));
	    
	      return response;
//	        System.out.println("Logged in user id from controller "+user_data.getId());
//	        return jwtUtil.generateToken(obj.getEmailid());
	    }

}
