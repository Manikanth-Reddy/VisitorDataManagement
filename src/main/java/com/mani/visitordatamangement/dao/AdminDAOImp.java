package com.mani.visitordatamangement.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mani.visitordatamangement.dto.Admin;
import com.mani.visitordatamangement.util.ConnectionUtil;

public class AdminDAOImp
implements AdminDAO {
	private static Connection connection=ConnectionUtil.connectionGiver();
	@Override
	public String saveAdmin(Admin admin) {
		if(connection!=null) {
			String query="INSERT INTO admin (`user_name`, `password`) VALUES (?,?)";
			try {
				PreparedStatement ps = connection.prepareStatement(query);
				ps.setString(1, admin.getUsername());
				ps.setString(2, admin.getPassword());
				int res = ps.executeUpdate();
				return "No of rows added are "+res;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}return null;
	}
	@Override
	public Admin adminLogin(String user, String Pass) {
		if(connection!=null) {
			String query="SELECT password FROM admin WHERE user_name =?";
			try {
				PreparedStatement ps = connection.prepareStatement(query);
				ps.setString(1, user);
				ResultSet res = ps.executeQuery();
				if(res.next()) {
					Admin admin = new Admin();
					admin.setPassword(Pass);
					admin.setUsername(user);
					if(res.getString(1).equals(Pass)) return admin;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}return null;
	}

}
