package com.digit.javaTraining.mvc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.digit.javaTraining.mvc.model.loanModel;
@WebServlet("/loan")
public class loanController extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session  = req.getSession();
		int option = Integer.parseInt(req.getParameter("option"));
		loanModel loanCheck =new loanModel();
		boolean x = loanCheck.loan(option);
		if(x==true) {
			session.setAttribute("lid", loanCheck.getLid());
			session.setAttribute("ltype", loanCheck.getLtype());
			session.setAttribute("tenure", loanCheck.getTenure());
			session.setAttribute("interest", loanCheck.getInterest());
			session.setAttribute("description", loanCheck.getDescription());
			resp.sendRedirect("loanDetails.jsp");
		}
		else {
			resp.sendRedirect("loanFail.html");
		}
	}

}
