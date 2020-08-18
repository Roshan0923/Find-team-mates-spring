package com.example.demo.registration;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.rowset.serial.SerialBlob;

import org.springframework.stereotype.Repository;

import com.example.demo.configuration.DbConfig;


@Repository
public class registration_persistance implements IRegisterPersistance {
    private Connection connection;
    private PreparedStatement preparedStatement;
    private Statement statement;
    public static final String INSERT = "INSERT INTO registered_user (name,email_id,password,linked_in_url,description,language,technology,pic_byte,id) VALUES (?,?,?,?,?,?,?,?,?)";
    public static final String IS_EXI_STRING ="Select COUNT(*) from registered_user where email_id=?";

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
    public void save(registration_body obj) {
        try {
            this.getConnection();
            this.getPreparedStatement(INSERT);
            this.preparedStatement.setString(1, obj.getName());
            this.preparedStatement.setString(2, obj.getEmail());
            this.preparedStatement.setString(3,obj.getPassword());
            this.preparedStatement.setString(4, obj.getLinkedIn_url());
            this.preparedStatement.setString(5, obj.getDescription());
            this.preparedStatement.setString(6, obj.getLanguage());
            this.preparedStatement.setString(7, obj.getTechnology());
            this.preparedStatement.setBlob(8, new SerialBlob( obj.getPic_byte().getBytes()));
            this.preparedStatement.setInt(9, obj.getUser_id());

            int result = this.preparedStatement.executeUpdate();
            if (result == 1) {

            }
            
        } catch (SQLException | IOException e) {
        	System.out.println("Error while stroing the data");
            //log.error("Error executing insert query on Blog table: {}", e.getMessage());
            //return null;
        } finally {
            this.closePreparedStatement();
            this.cleanConnection();
        }
    }

	@Override
	public boolean isUserExist(registration_body obj) {
		System.out.println("Inside isuser exist cmethod");
		try {
			this.getConnection();
	         this.getPreparedStatement(IS_EXI_STRING);
	         this.preparedStatement.setString(1, obj.getEmail());
	         ResultSet result = this.preparedStatement.executeQuery();
	         int rowCount=0;
	         if(result!=null)
	         {
	        	 while(result.next()) {
	        		    rowCount = Integer.parseInt(result.getString("count(*)"));
	        		  //  System.out.println(Integer.parseInt(result.getString("count(*)")));
	        		}
	        	 
	        	 if(rowCount==0)
	        	 {
	        		 return false;
	        	 }
	        	 else {
					return true;
				}
	         }
	         else {
				return true;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return true;
	}
}
