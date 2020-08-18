package com.example.demo.logIn;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.logIn.entity.User;

public interface IuserRepository  extends JpaRepository<User,Integer>{
	
	
	@Query(value = "SELECT name,email_id,password,id FROM `registered_user` WHERE email_id=:email_id",nativeQuery = true)
	User FindByEmailID( @Param("email_id") String email_id);

}
