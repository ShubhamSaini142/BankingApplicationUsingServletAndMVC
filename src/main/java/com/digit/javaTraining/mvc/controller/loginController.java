package com.digit.javaTraining.mvc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.digit.javaTraining.mvc.model.BankApp;
@WebServlet("/login")
public class loginController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		BankApp bankapp = new BankApp();
		bankapp.setCust_id(Integer.parseInt(req.getParameter("cust_Id")));
		bankapp.setPin(Integer.parseInt(req.getParameter("pin")));
		HttpSession session  =  req.getSession(true); 
		boolean checkLogin = bankapp.login();
		if(checkLogin == true) {
			session.setAttribute("accno" , bankapp.getAccno());
			session.setAttribute("cust_name", bankapp.getCustomerName());
			resp.sendRedirect("/BankingApplicationUsingMVC/HomePage.jsp");	
		}
		
		
	}

}
