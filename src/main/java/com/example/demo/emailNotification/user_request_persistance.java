package com.example.demo.emailNotification;

import org.springframework.stereotype.Repository;

import com.example.demo.configuration.DbConfig;

import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.serial.SerialBlob;

import org.springframework.stereotype.Repository;


@Repository
public class user_request_persistance implements Iuser_req_p {
	
	private Connection connection;
	private PreparedStatement preparedStatement;
	private Statement statement;
	
	 public static final String DELETE = "DELETE FROM user_request WHERE project_id = ? and request_user_id=?";
	 private static final String UPDATE = "UPDATE user_request SET isAdded=1 WHERE project_id = ? and request_user_id=?";
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
	public void delete_request(int project_id, int requested_user_id) {
		System.out.println("Inside the delete method of persistance class to delete the user request");
		try {
            this.getConnection();
            this.getPreparedStatement(DELETE);
            this.preparedStatement.setInt(1,project_id);
            this.preparedStatement.setInt(2, requested_user_id);
            this.preparedStatement.executeUpdate();

        } catch (SQLException e) {
           System.out.println("Error While executing the delete query");
        } finally {
            this.closePreparedStatement();
            this.cleanConnection();
        }

		
	}

	@Override
	public void update_request_status(int project_id, int requested_user_id) {
		 try {
	            this.getConnection();
	            this.getPreparedStatement(UPDATE);
	        	this.preparedStatement.setInt(1, project_id);
	        	this.preparedStatement.setInt(2, requested_user_id);
	            int result = this.preparedStatement.executeUpdate();
	            
	        } catch (SQLException e) {
	          
	        } finally {
	            this.closePreparedStatement();
	            this.cleanConnection();
	        
		
	}

	}
}
