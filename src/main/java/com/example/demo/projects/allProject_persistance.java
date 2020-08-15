package com.example.demo.projects;

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

import com.example.demo.configuration.DbConfig;
import com.example.demo.project_management.project_body;



@Repository
public class allProject_persistance implements Iproject_persistance {
	
	private Connection connection;
	private PreparedStatement preparedStatement;
	private Statement statement;
	 public static final String GET_ALL = "Select * FROM projects";
	 public static final String GET_USER_INFO = "Select name,email_id,linked_in_url,description,language,technology,pic_byte FROM registered_user WHERE id= ?";
	    public static final String INSERT = "INSERT INTO user_request (project_id,user_id,request_user_id,message) VALUES (?,?,?,?)";

	 
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
	public List<project_dao> getAll() {
		System.out.println("Inside the persistance class method to get all the project");
		try {
			this.getConnection();
			this.getPreparedStatement(GET_ALL);
			ResultSet resultSet = this.preparedStatement.executeQuery();
			List<project_dao> blogpost = new ArrayList<project_dao>();
			while (resultSet.next()) {
				project_dao obj = new project_dao();
				obj.setProject_id(resultSet.getInt(1));
				obj.setDeadline(resultSet.getTimestamp(2));
				obj.setProject_name(resultSet.getString(3));
				obj.setProject_description(resultSet.getString(4));
				obj.setTeam_mate_desctiption(resultSet.getString(5));
				obj.setFront_end(resultSet.getString(6));
				obj.setBack_end(resultSet.getString(7));
				obj.setType(resultSet.getString(8));

				blogpost.add(obj);
			}
			return blogpost;
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return null;	}

	@Override
	public user_info_dao getUserInfo(int user_id) {
		System.out.println("Inside the persistance class method to get all the userInfo");
	try {
		this.getConnection();
		this.getPreparedStatement(GET_USER_INFO);
		this.preparedStatement.setInt(1, user_id);
		ResultSet resultSet = this.preparedStatement.executeQuery();
		while (resultSet.next()) {
			user_info_dao obj = new user_info_dao();
			obj.setName(resultSet.getString(1));
			obj.setEmail(resultSet.getString(2));
			obj.setLinkedIn_url(resultSet.getString(3));
			obj.setDescription(resultSet.getString(4));
			obj.setLanguage(resultSet.getString(5));
			obj.setTechnology(resultSet.getString(6));
			
			Blob blob = resultSet.getBlob(7);
            if(blob != null) {
                obj.setImage(blob.getBytes(1, (int) blob.length()));
            }

		return obj;
		}
		
	} catch (SQLException e) {

		e.printStackTrace();
	}
	return null;	
		
	}

	@Override
	public void insert_request(request_message_dao obj) {
		  try {
			  System.out.println(obj.getMessage());
	            this.getConnection();
	            this.getPreparedStatement(INSERT);
	            this.preparedStatement.setInt(1, obj.getProject_id());
	            this.preparedStatement.setInt(2, obj.getUser_id());
	            this.preparedStatement.setInt(3,obj.getRequest_user_id());
	            this.preparedStatement.setString(4, obj.getMessage());
	            int result = this.preparedStatement.executeUpdate();
	            if (result == 1) {
//	                this.statement = this.connection.createStatement();
//	                ResultSet rs = this.statement.executeQuery("SELECT LAST_INSERT_ID()");
//	                if (rs.next()) {
//	                    Long id = rs.getLong(1);
//	                    return findById(id);
//	                }
	            }
	            
	        } catch (SQLException e) {
	        	System.out.println("Error while stroing the data"+e);
	            //log.error("Error executing insert query on Blog table: {}", e.getMessage());
	            //return null;
	        } finally {
	            this.closePreparedStatement();
	            this.cleanConnection();
	        }
	    }
		
		
	}


