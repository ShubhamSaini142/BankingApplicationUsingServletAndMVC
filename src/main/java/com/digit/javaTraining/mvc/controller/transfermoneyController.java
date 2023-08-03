 package com.digit.javaTraining.mvc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.digit.javaTraining.mvc.model.transfermoneyModel;
@WebServlet("/transfermoney")
public class transfermoneyController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		transfermoneyModel tm = new transfermoneyModel();
		tm.setCust_id(Integer.parseInt(req.getParameter("cust_id")));
		tm.setBank_name( req.getParameter("bank_name"));
		tm.setIFSC(req.getParameter("IFSC"));
		tm.setSender_accno(Integer.parseInt(req.getParameter("senderaccno")));
		tm.setReciever_ifsc(req.getParameter("recieverifsc"));
		tm.setReciever_accno(Integer.parseInt(req.getParameter("recieveraccno")));
		tm.setAmount(Integer.parseInt(req.getParameter("amount")));
		int pin = Integer.parseInt(req.getParameter("pin"));
		HttpSession session = req.getSession();
		boolean x = tm.transferData(pin);
		if(x==true) {
			resp.sendRedirect("transferSuccess.html");
		}
		
	}

}
