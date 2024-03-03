package com.company.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.Util.DBUtil;


public class UserDaoImpl implements UserDao {
	public boolean isValidUser(String username, String password) {
        String query = "SELECT * FROM users WHERE username = ? AND password = ?";
    	 try (Connection connection = DBUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);

            ResultSet resultSet = preparedStatement.executeQuery();

            return resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
	 @Override
	    public boolean addUser(User user) {
		 System.out.println(user.getUsername()+user.getEmail()+user.getPassword()+"Welcome Adil");
	        String query = "INSERT INTO users (username, email, password) VALUES (?, ?, ?)";

	        try (Connection connection = DBUtil.getConnection();
	             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

	            preparedStatement.setString(1, user.getUsername());
	            preparedStatement.setString(2, user.getEmail());
	            preparedStatement.setString(3, user.getPassword());

	            int rowsAffected = preparedStatement.executeUpdate();
	            System.out.println(rowsAffected+"Welcome Adil");

	            return rowsAffected > 0;
	        } catch (SQLException e) {
	        	 System.out.println("Try block fail");
	            e.printStackTrace();
	            return false;
	        }
	    }

	    
	}