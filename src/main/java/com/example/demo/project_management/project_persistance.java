package com.example.demo.project_management;

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

@Repository
public class project_persistance implements IPeoject_management_persistance {

	private Connection connection;
	private PreparedStatement preparedStatement;
	private Statement statement;
	public static final String INSERT = "INSERT INTO projects (deadline,project_name,project_description,team_mate_desctiption,front_end,back_end,type,user_id) VALUES (?,?,?,?,?,?,?,?)";
	public static final String FIND_BY_USER = "SELECT project_id,deadline,project_name,project_description,team_mate_desctiption,front_end,back_end,type FROM projects where user_id=?";

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
			this.preparedStatement.setString(3, obj.getProject_description());
			this.preparedStatement.setString(4, obj.getTeam_mate_desctiption());
			this.preparedStatement.setString(5, obj.getFront_end());
			this.preparedStatement.setString(6, obj.getBack_end());
			this.preparedStatement.setString(7, obj.getType());
			this.preparedStatement.setInt(8, obj.getUser_id());
			int result = this.preparedStatement.executeUpdate();

		} catch (SQLException e) {
			System.out.println("Error while stroing the data");
			// log.error("Error executing insert query on Blog table: {}", e.getMessage());
			// return null;
		} finally {
			this.closePreparedStatement();
			this.cleanConnection();
		}

	}

	@Override
	public List<project_body> find_project_by_user_id(int user_id) {
		
		System.out.println("Inside the persistance class methos to get the project by user_id");
		try {
			this.getConnection();
			this.getPreparedStatement(FIND_BY_USER);
			this.preparedStatement.setInt(1, user_id);
			ResultSet resultSet = this.preparedStatement.executeQuery();
			List<project_body> blogpost = new ArrayList<project_body>();
			while (resultSet.next()) {
				project_body obj = new project_body();
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
		return null;

		
	}

}
