package com.mani.visitordatamangement.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mani.visitordatamangement.dao.VisitorLoginImplimentation;
import com.mani.visitordatamangement.dto.VisitorLoginDetails;
@SuppressWarnings("serial")
@WebServlet("/signup")
public class SignUp extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 String email = req.getParameter("email");
		 String pass = req.getParameter("pass");
		 VisitorLoginDetails visitor=new VisitorLoginDetails();
		 visitor.setUsername(email);
		 visitor.setPassword(pass);
 		 VisitorLoginImplimentation v=new VisitorLoginImplimentation();
 		 String register = v.register(visitor);
 		 System.out.println(register);
 		 resp.getWriter().print(register);
 		 
	}
}
