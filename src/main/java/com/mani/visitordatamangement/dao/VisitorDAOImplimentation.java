package com.mani.visitordatamangement.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.mani.visitordatamangement.dto.Visitor;
import com.mani.visitordatamangement.util.ConnectionUtil;

public class VisitorDAOImplimentation implements VisitorDAO {
	private static Connection connection = ConnectionUtil.connectionGiver();

	public String saveVisitor(Visitor visitor) {
		if (connection != null) {
			String query = "INSERT INTO visitor (`name`, `contact`, `email`, `degree`, `stream`, `throughOutPercentage`, `yearOfPassOut`, `gender`, `course`, `address`) VALUES (?,?,?,?,?,?,?,?,?,?)";
			try {
				PreparedStatement ps = connection.prepareStatement(query);
				ps.setString(1, visitor.getName());
				ps.setString(2, visitor.getContact());
				ps.setString(3, visitor.getEmail());
				ps.setString(4, visitor.getDegree());
				ps.setString(5, visitor.getStream());
				ps.setString(6, visitor.getThroughOutPercentage());
				ps.setInt(7, visitor.getYearOfPassOut());
				ps.setString(8, visitor.getGender());
				ps.setString(9, visitor.getCourse());
				ps.setString(10, visitor.getAddress());
				ps.executeUpdate();
				return "Visitor Added SuccesFully ";
			} catch (SQLException e) {

			}
		}
		return "Oh Nooooo You made a mistake 😒😒😒😒";
	}

	public String updateVisitor(Visitor visitor) {
		String query = "UPDATE Visitor SET name=?,contact =?,email =?,degree =?,stream =?,throughOutPercentage =?,yearOfPassOut =?,gender=?,course=?,address=? WHERE id=?";
		if (connection != null) {
			try {
				PreparedStatement ps = connection.prepareStatement(query);
				ps.setString(1, visitor.getName());
				ps.setString(2, visitor.getContact());
				ps.setString(3, visitor.getEmail());
				ps.setString(4, visitor.getDegree());
				ps.setString(5, visitor.getStream());
				ps.setString(6, visitor.getThroughOutPercentage());
				ps.setInt(7, visitor.getYearOfPassOut());
				ps.setString(8, visitor.getGender());
				ps.setString(9, visitor.getCourse());
				ps.setString(10, visitor.getAddress());
				ps.setInt(11, visitor.getId());
				boolean ex = ps.execute();
				if (!ex)
					return "Updated Succesfully";
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return "Some thing Went Worng";

	}

	@Override
	public Visitor getVisitorById(int id) {
		String query = "SELECT * FROM Visitor WHERE id=?";
		if (connection != null) {
			try {
				Visitor v = new Visitor();
				PreparedStatement ps = connection.prepareStatement(query);
				ps.setInt(1, id);
				ResultSet res = ps.executeQuery();
				if (res.next()) {
					v.setId(res.getInt(1));
					v.setName(res.getString(2));
					v.setContact(res.getString(3));
					v.setEmail(res.getString(4));
					v.setDegree(res.getString(5));
					v.setStream(res.getString(6));
					v.setThroughOutPercentage(res.getString(7));
					v.setYearOfPassOut(res.getInt(8));
					v.setGender(res.getString(9));
					v.setCourse(res.getString(10));
					v.setAddress(res.getString(11));
					return v;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public List<Visitor> getAllVisitorByDegree() {
		List<Visitor> visitors = getAllVisitor();
		return visitors.stream().sorted((e1, e2) -> {
			return e1.getDegree().compareToIgnoreCase(e2.getDegree());
		}).collect(Collectors.toList());
	}

	@Override
	public Visitor getVisitorByContact(String Contact) {
		String query = "SELECT * FROM Visitor WHERE contact=?";
		if (connection != null) {
			try {
				Visitor v = new Visitor();
				PreparedStatement ps = connection.prepareStatement(query);
				ps.setString(1, Contact);
				ResultSet res = ps.executeQuery();
				if (res.next()) {
					v.setId(res.getInt(1));
					v.setName(res.getString(2));
					v.setContact(res.getString(3));
					v.setEmail(res.getString(4));
					v.setDegree(res.getString(5));
					v.setStream(res.getString(6));
					v.setThroughOutPercentage(res.getString(7));
					v.setYearOfPassOut(res.getInt(8));
					v.setGender(res.getString(9));
					v.setCourse(res.getString(10));
					v.setAddress(res.getString(11));
					return v;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public Visitor deleteVisitor(int id) {
		String query = "DELETE  FROM Visitor WHERE id=?";
		if (connection != null) {
			try {
				Visitor visitorById = getVisitorById(id);
				PreparedStatement ps = connection.prepareStatement(query);
				ps.setInt(1, id);
				ps.execute();
				return visitorById;

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public Visitor getVisitorByEmail(String email) {
		String query = "SELECT * FROM Visitor WHERE email=?";
		if (connection != null) {
			try {
				Visitor v = new Visitor();
				PreparedStatement ps = connection.prepareStatement(query);
				ps.setString(1, email);
				ResultSet res = ps.executeQuery();
				if (res.next()) {
					v.setId(res.getInt(1));
					v.setName(res.getString(2));
					v.setContact(res.getString(3));
					v.setEmail(res.getString(4));
					v.setDegree(res.getString(5));
					v.setStream(res.getString(6));
					v.setThroughOutPercentage(res.getString(7));
					v.setYearOfPassOut(res.getInt(8));
					v.setGender(res.getString(9));
					v.setCourse(res.getString(10));
					v.setAddress(res.getString(11));
					
					return v;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public List<Visitor> getAllVisitor() {
		String query = "SELECT * FROM Visitor";
		if (connection != null) {
			try {
				List<Visitor> l = new ArrayList<>();
				PreparedStatement ps = connection.prepareStatement(query);
				ResultSet res = ps.executeQuery();
				while (res.next()) {
					Visitor v = new Visitor();
					v.setId(res.getInt(1));
					v.setName(res.getString(2));
					v.setContact(res.getString(3));
					v.setEmail(res.getString(4));
					v.setDegree(res.getString(5));
					v.setStream(res.getString(6));
					v.setThroughOutPercentage(res.getString(7));
					v.setYearOfPassOut(res.getInt(8));
					v.setGender(res.getString(9));
					v.setCourse(res.getString(10));
					v.setAddress(res.getString(11));
					
					l.add(v);
				}
				return l;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

}
