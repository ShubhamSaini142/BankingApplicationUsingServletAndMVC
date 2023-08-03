package com.digit.javaTraining.mvc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.digit.javaTraining.mvc.model.BankApp;
@WebServlet("/changePassword")
public class changePasswordController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session =  req.getSession();
		int accno = (int) session.getAttribute("accno");
		BankApp bankapp = new BankApp();
		int oldPassword = Integer.parseInt(req.getParameter("oldpassword"));
		int newPassword = Integer.parseInt(req.getParameter("newpassword"));
		int confirmPassword = Integer.parseInt(req.getParameter("confirmpassword"));
if(newPassword == confirmPassword) {
	boolean x = bankapp.changePassword(accno, confirmPassword);
	if(x==true) {
		resp.sendRedirect("passwordchangedSuccess.html");
	}
	else {
		resp.sendRedirect("passwordNotChanged.html");
	}
}
		
	}

}
