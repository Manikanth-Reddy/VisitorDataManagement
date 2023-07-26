package com.mani.visitordatamangement.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mani.visitordatamangement.VIsitorService.VisitorServiceImp;
import com.mani.visitordatamangement.dao.VisitorLoginImplimentation;
import com.mani.visitordatamangement.dto.Visitor;
import com.mani.visitordatamangement.dto.VisitorLoginDetails;
@WebServlet("/login")
@SuppressWarnings("serial")
public class Login extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String pass = req.getParameter("pass");
		VisitorLoginImplimentation v= new VisitorLoginImplimentation();
		VisitorLoginDetails login = v.login(email, pass);
		HttpSession session = req.getSession();
		session.setAttribute("email", email);
		session.setAttribute("pass", pass);
		if(login !=null) {
			VisitorServiceImp imp = new VisitorServiceImp();
			Visitor visitor = imp.getVisitorByEmail(email);
			if(visitor!=null) {
			session.setAttribute("name", visitor.getName());
			session.setAttribute("contact", visitor.getContact());
			session.setAttribute("gender", visitor.getGender());
			session.setAttribute("address", visitor.getAddress());
			session.setAttribute("degree", visitor.getDegree());
			session.setAttribute("stream", visitor.getStream());
			session.setAttribute("per", visitor.getThroughOutPercentage());
			session.setAttribute("yop", visitor.getYearOfPassOut());
			session.setAttribute("cource", visitor.getCourse());
			resp.sendRedirect("WelcomeUser.jsp");
			}
			else resp.getWriter().print("Contact admin To Update Details");
		}
	}
}
