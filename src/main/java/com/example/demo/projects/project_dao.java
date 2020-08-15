package com.example.demo.projects;

import java.sql.Timestamp;

import org.springframework.stereotype.Component;

@Component
public class project_dao {
	Timestamp deadline;
	String project_name;
	 String project_description;
	 String team_mate_desctiption;
	 String front_end;
	 String back_end;
	 String type;
	 int user_id;
	 int project_id;
	public int getProject_id() {
		return project_id;
	}
	public void setProject_id(int project_id) {
		this.project_id = project_id;
	}
	public Timestamp getDeadline() {
		return deadline;
	}
	public void setDeadline(Timestamp deadline) {
		this.deadline = deadline;
	}
	public String getProject_name() {
		return project_name;
	}
	public void setProject_name(String project_name) {
		this.project_name = project_name;
	}
	public String getProject_description() {
		return project_description;
	}
	public void setProject_description(String project_description) {
		this.project_description = project_description;
	}
	public String getTeam_mate_desctiption() {
		return team_mate_desctiption;
	}
	public void setTeam_mate_desctiption(String team_mate_desctiption) {
		this.team_mate_desctiption = team_mate_desctiption;
	}
	public String getFront_end() {
		return front_end;
	}
	public void setFront_end(String front_end) {
		this.front_end = front_end;
	}
	public String getBack_end() {
		return back_end;
	}
	public void setBack_end(String back_end) {
		this.back_end = back_end;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}


}
