package com.mani.visitordatamangement.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mani.visitordatamangement.dao.AdminDAO;
import com.mani.visitordatamangement.dao.AdminDAOImp;
import com.mani.visitordatamangement.dto.Admin;

@WebServlet("/adminlogin")
@SuppressWarnings("serial")
public class AdminLogin extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String email = req.getParameter("email");
	String pass = req.getParameter("pass");
		AdminDAO admindao=new AdminDAOImp();
		Admin admin = admindao.adminLogin(email, pass);
		if(admin !=null) {
			resp.sendRedirect("WelcomeAdmin.jsp");
		}
		else {
			resp.getWriter().print("Access Denined");
		}
		
	}
}
