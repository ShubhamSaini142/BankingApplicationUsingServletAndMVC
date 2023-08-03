package com.digit.javaTraining.mvc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.digit.javaTraining.mvc.model.BankApp;
@WebServlet("/Checkbalance")
public class checkBalanceController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
	    int accno = (int) session.getAttribute("accno");
	    BankApp bankapp = new BankApp();
	 boolean checkBalance1 =    bankapp.checkBalance(accno);
	 if(checkBalance1 == true) {
		 session.setAttribute("balance", bankapp.getBalance());
			resp.sendRedirect("balance.jsp");
	 }
	 else {
			resp.sendRedirect("balanceFail.jsp");
	 }
		
	}


}
