package com.digit.javaTraining.mvc.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class loanModel {
	int lid;
	String ltype;
	int tenure;
	float interest;
	String description;
	private Connection connection;

	public loanModel() {
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

	public int getLid() {
		return lid;
	}

	public void setLid(int lid) {
		this.lid = lid;
	}

	public String getLtype() {
		return ltype;
	}

	public void setLtype(String ltype) {
		this.ltype = ltype;
	}

	public int getTenure() {
		return tenure;
	}

	public void setTenure(int tenure) {
		this.tenure = tenure;
	}

	public float getInterest() {
		return interest;
	}

	public void setInterest(float interest) {
		this.interest = interest;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
	 public boolean loan(int option) {
		 
			try {
			if(option == 1) {
				PreparedStatement prepareStatement = connection
						.prepareStatement("select * from loan where lid = ?");
				prepareStatement.setInt(1, option);
				ResultSet resultSet = prepareStatement.executeQuery();	
				
				if(resultSet.next()==true) {
					this.setLid(resultSet.getInt(1));
					this.setLtype(resultSet.getString(2));
					this.setTenure(resultSet.getInt(3));
					this.setInterest(resultSet.getFloat(4));
					this.setDescription(resultSet.getString(5));
					
					return true;				}
			
				
			}
			
			
			else if(option == 2) {
				PreparedStatement prepareStatement = connection
						.prepareStatement("select * from loan where lid = ?");
				prepareStatement.setInt(1, option);
				prepareStatement.executeQuery();	
				ResultSet resultSet = prepareStatement.executeQuery();	
				if(resultSet.next()==true) {
					this.setLid(resultSet.getInt(1));
					this.setLtype(resultSet.getString(2));
					this.setTenure(resultSet.getInt(3));
					this.setInterest(resultSet.getFloat(4));
					this.setDescription(resultSet.getString(5));
					
					return true;				}
			}
			else if(option == 3) {
				PreparedStatement prepareStatement = connection
						.prepareStatement("select * from loan where lid = ?");
				prepareStatement.setInt(1, option);
				prepareStatement.executeQuery();	
				ResultSet resultSet = prepareStatement.executeQuery();	
				if(resultSet.next()==true) {
					this.setLid(resultSet.getInt(1));
					this.setLtype(resultSet.getString(2));
					this.setTenure(resultSet.getInt(3));
					this.setInterest(resultSet.getFloat(4));
					this.setDescription(resultSet.getString(5));
					
					return true;				}
				
			}
			else if(option == 4) {
				PreparedStatement prepareStatement = connection
						.prepareStatement("select * from loan where lid = ?");
				prepareStatement.setInt(1, option);
				prepareStatement.executeQuery();	
				ResultSet resultSet = prepareStatement.executeQuery();	
				if(resultSet.next()==true) {
					this.setLid(resultSet.getInt(1));
					this.setLtype(resultSet.getString(2));
					this.setTenure(resultSet.getInt(3));
					this.setInterest(resultSet.getFloat(4));
					this.setDescription(resultSet.getString(5));
					
					return true;				}
				
			}
			else if(option == 5) {
				PreparedStatement prepareStatement = connection
						.prepareStatement("select * from loan where lid = ?");
				prepareStatement.setInt(1, option);
				prepareStatement.executeQuery();	
				ResultSet resultSet = prepareStatement.executeQuery();	
				if(resultSet.next()==true) {
					this.setLid(resultSet.getInt(1));
					this.setLtype(resultSet.getString(2));
					this.setTenure(resultSet.getInt(3));
					this.setInterest(resultSet.getFloat(4));
					this.setDescription(resultSet.getString(5));
	return true;
				}
				
			}
			else {
//				resp.sendRedirect("/BankingApplication/loanFail.html");
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
