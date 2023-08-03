package com.digit.javaTraining.mvc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digit.javaTraining.mvc.model.BankApp;

@WebServlet("/Register")
public class registerController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		BankApp bankapp = new BankApp();
		bankapp.setBankId(Integer.parseInt(req.getParameter("bank_id")));
		bankapp.setBank_name(req.getParameter("bank_name"));
		bankapp.setIFSC(req.getParameter("IFSCCode"));
		bankapp.setAccno(Integer.parseInt(req.getParameter("accno")));
		bankapp.setPin(Integer.parseInt(req.getParameter("pin")));
		bankapp.setCust_id(Integer.parseInt(req.getParameter("cust_id")));
		bankapp.setCustomerName(req.getParameter("custname"));
		bankapp.setBalance(Integer.parseInt(req.getParameter("balance")));
		bankapp.setEmail(req.getParameter("email"));
		bankapp.setPhone(Long.parseLong(req.getParameter("phone")));
		boolean x = bankapp.register();
		if (x == true) {
			resp.sendRedirect("registerSuccess.html");
		} else {
			resp.sendRedirect("/BankingApplication/registerFail.html");

		}

	}

}
