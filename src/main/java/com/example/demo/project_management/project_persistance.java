package com.example.demo.project_management;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.rowset.serial.SerialBlob;

import org.springframework.stereotype.Repository;

import com.example.demo.configuration.DbConfig;

@Repository
public class project_persistance implements IPeoject_management_persistance {

	private Connection connection;
	private PreparedStatement preparedStatement;
	private Statement statement;
	public static final String INSERT = "INSERT INTO projects (deadline,project_name,project_description,team_mate_desctiption,front_end,back_end,type,user_id) VALUES (?,?,?,?,?,?,?,?)";

	public void getPreparedStatement(String query) throws SQLException {
		this.preparedStatement = this.connection.prepareStatement(query);
	}

	public void closePreparedStatement() {
		try {
			if (null != this.preparedStatement) {
				this.preparedStatement.close();
			}
		} catch (SQLException e) {

		}

	}

	public void getConnection() throws SQLException {
		this.connection = DbConfig.instance().getDBConnection();
	}

	public void cleanConnection() {
		try {
			if (this.connection != null) {
				if (!this.connection.isClosed()) {
					this.connection.close();
				}
			}
		} catch (SQLException e) {

		}
	}

	@Override
	public void save(project_body obj) {
		System.out.println("Inside the persistance class method to create new project");
		  try {
	            this.getConnection();
	            this.getPreparedStatement(INSERT);
	            this.preparedStatement.setTimestamp(1, obj.getDeadline());
	            this.preparedStatement.setString(2, obj.getProject_name());
	            this.preparedStatement.setString(3,obj.project_description);
	            this.preparedStatement.setString(4, obj.getTeam_mate_desctiption());
	            this.preparedStatement.setString(5, obj.getFront_end());
	            this.preparedStatement.setString(6, obj.getBack_end());
	            this.preparedStatement.setString(7, obj.getType());
	            this.preparedStatement.setInt(8, obj.getUser_id());
	            int result = this.preparedStatement.executeUpdate();
	            
	            
	            
	        } catch (SQLException e) {
	        	System.out.println("Error while stroing the data");
	            //log.error("Error executing insert query on Blog table: {}", e.getMessage());
	            //return null;
	        } finally {
	            this.closePreparedStatement();
	            this.cleanConnection();
	        }

	}

}
