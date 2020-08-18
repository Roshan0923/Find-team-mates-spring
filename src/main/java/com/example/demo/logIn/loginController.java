package com.example.demo.logIn;

import org.aspectj.weaver.ast.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.logIn.entity.AuthRequest;

@RestController
@CrossOrigin("*")
public class loginController {
	
	
	 @Autowired
	    private JwtUtil jwtUtil;
	    @Autowired
	    private AuthenticationManager authenticationManager;
	    
	    
	    @GetMapping("/testingMapping")
	    public String Test()
	    {
	    	return "Test is succussfull";
	    }
	    
	    @PostMapping("/authenticate")
	    public String generateToken(@RequestBody AuthRequest obj) throws Exception {
	    	
	        try {
	        	System.out.println(obj.getEmailid());
        	System.out.println(obj.getPassword());

	        	System.out.println(obj.getEmailid());
	            authenticationManager.authenticate(
	                    new UsernamePasswordAuthenticationToken(obj.getEmailid(), obj.getPassword())
	            );
	        } catch (Exception ex) {
	        	System.out.println(ex.getMessage());
	            throw new Exception("inavalid username/password");
	        }
	        return jwtUtil.generateToken(obj.getEmailid());
	    }

}
