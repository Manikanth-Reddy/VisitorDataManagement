package com.mani.visitordatamangement.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mani.visitordatamangement.dto.VisitorLoginDetails;
import com.mani.visitordatamangement.util.ConnectionUtil;

public class VisitorLoginImplimentation implements VisitorLogin {
	private static Connection connection = ConnectionUtil.connectionGiver();

	@Override
	public String register(VisitorLoginDetails visitor) {
		if (connection != null) {
			String query = "INSERT INTO visitorlogin (`user_name`, `password`) VALUES (?,?)";
			try {
				PreparedStatement ps = connection.prepareStatement(query);
				ps.setString(1, visitor.getUsername());
				ps.setString(2, visitor.getPassword());
				ps.executeUpdate();
				return "User Added Successfully";
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return "Something Went Wrong";
	}

	@Override
	public VisitorLoginDetails login(String user, String Pass) {
		if (connection != null) {
			String query = "SELECT id,password FROM visitorlogin WHERE user_name =?";
			try {
				PreparedStatement ps = connection.prepareStatement(query);
				ps.setString(1, user);
				ResultSet res = ps.executeQuery();
				if (res.next()) {
					VisitorLoginDetails login = new VisitorLoginDetails();
					login.setPassword(Pass);
					login.setUsername(user);
					login.setId(res.getInt(1));
					if (res.getString(2).equals(Pass))
						return login;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

}
