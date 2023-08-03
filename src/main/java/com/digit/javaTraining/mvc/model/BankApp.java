package com.digit.javaTraining.mvc.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import com.digit.javaTraining.mvc.controller.checkBalanceController;

public class BankApp {
	public BankApp() {
		String url = "jdbc:mysql://localhost:3306/banking";
		String user = "root";
		String pwd = "root";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(url, user, pwd);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	int bankId;
	String bank_name;
	String IFSC;
	int accno;
	int pin;
	int cust_id;
	String customerName;
	int balance;
	String email;
	long phone;

	public int getBankId() {
		return bankId;
	}

	public void setBankId(int bankId) {
		this.bankId = bankId;
	}

	public String getBank_name() {
		return bank_name;
	}

	public void setBank_name(String bank_name) {
		this.bank_name = bank_name;
	}

	public String getIFSC() {
		return IFSC;
	}

	public void setIFSC(String iFSC) {
		IFSC = iFSC;
	}

	public int getAccno() {
		return accno;
	}

	public void setAccno(int accno) {
		this.accno = accno;
	}

	public int getPin() {
		return pin;
	}

	public void setPin(int pin) {
		this.pin = pin;
	}

	public int getCust_id() {
		return cust_id;
	}

	public void setCust_id(int cust_id) {
		this.cust_id = cust_id;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public static Connection connection;

	public boolean register() {
		try {
			PreparedStatement prepareStatement = connection
					.prepareStatement("insert into bankapp values(?,?,?,?,?,?,?,?,?,?)");
			prepareStatement.setInt(1, bankId);

			prepareStatement.setString(2, bank_name);

			prepareStatement.setString(3, IFSC);

			prepareStatement.setInt(4, accno);

			prepareStatement.setInt(5, pin);

			prepareStatement.setInt(6, cust_id);

			prepareStatement.setString(7, customerName);

			prepareStatement.setInt(8, balance);

			prepareStatement.setString(9, email);

			prepareStatement.setLong(10, phone);

			int x = prepareStatement.executeUpdate();

			if (x > 0) {

				return true;

			}

			else {

				return false;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	
	public boolean login()  {
		PreparedStatement prepareStatement = null;
		try {
			prepareStatement = connection
					.prepareStatement("select * from bankapp where cust_id = ? and pin = ?");
			prepareStatement.setInt(1, cust_id);
			prepareStatement.setInt(2, pin);
			ResultSet resultSet = prepareStatement.executeQuery();
			if(resultSet.next()==true) {
				this.setCustomerName(resultSet.getString("customerName"));
				this.setAccno(resultSet.getInt("acc_no"));
				return true;
			}
			else {
				return false;
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	
	}
	
	public boolean checkBalance(int accno) {
		try {
		PreparedStatement prepareStatement = 
				connection.prepareStatement("Select * from bankapp where acc_no = ?");
		prepareStatement.setInt(1, accno);
		ResultSet resultSet = prepareStatement.executeQuery();
		if(resultSet.next()==true) {
			this.setBalance(resultSet.getInt("balance"));
			return true;

		}
		else {
			return false;

		}
	}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean changePassword(int accno,int confirmPassword) {
		
		try { 
		PreparedStatement prepareStatement = connection
				.prepareStatement("update bankapp set pin = ? where acc_no = ? ");
		prepareStatement.setInt(1, confirmPassword);
		prepareStatement.setInt(2, accno);
		int x =prepareStatement.executeUpdate();   
		if(x>0) {
            return true;

		}
		else {
			return false;

		}
		
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		return false;
		
	}
}
