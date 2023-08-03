package com.digit.javaTraining.mvc.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

import javax.servlet.http.HttpSession;

public class transfermoneyModel {
	private Connection connection;

	public transfermoneyModel() {
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

	int cust_id;
	String bank_name;
	String IFSC;
	int sender_accno;
	String reciever_ifsc;
	int reciever_accno;
	int amount;
	int transation_Id;

	public int getCust_id() {
		return cust_id;
	}

	public void setCust_id(int cust_id) {
		this.cust_id = cust_id;
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

	public int getSender_accno() {
		return sender_accno;
	}

	public void setSender_accno(int sender_accno) {
		this.sender_accno = sender_accno;
	}

	public String getReciever_ifsc() {
		return reciever_ifsc;
	}

	public void setReciever_ifsc(String reciever_ifsc) {
		this.reciever_ifsc = reciever_ifsc;
	}

	public int getReciever_accno() {
		return reciever_accno;
	}

	public void setReciever_accno(int reciever_accno) {
		this.reciever_accno = reciever_accno;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getTransation_Id() {
		return transation_Id;
	}

	public void setTransation_Id(int transation_Id) {
		this.transation_Id = transation_Id;
	}

//	BankApp bankapp = new BankApp();

	public boolean transferData(int pin) {

		try {
			PreparedStatement prepareStatement = connection.prepareStatement(
					"select * from bankapp where cust_id = ? and  IFSC = ? and acc_no = ? and pin = ?");
			prepareStatement.setInt(1, cust_id);
			prepareStatement.setString(2, IFSC);
			prepareStatement.setInt(3, sender_accno);
			prepareStatement.setInt(4, pin);
			ResultSet resultSet = prepareStatement.executeQuery();
			if (resultSet.next() == true) {
				prepareStatement = connection.prepareStatement("select * from bankapp where IFSC = ? and acc_no = ?");
			
				prepareStatement.setString(1, reciever_ifsc);
				prepareStatement.setInt(2, reciever_accno);
				ResultSet resultSet2 = prepareStatement.executeQuery();
				if (resultSet2.next() == true) {
					prepareStatement = connection.prepareStatement("select balance from bankapp where acc_no =?");
					prepareStatement.setInt(1, sender_accno);
					ResultSet resultset3 = prepareStatement.executeQuery();
					resultset3.next();
					int bal = resultset3.getInt(1);
					if (bal > amount) {
						prepareStatement = connection
								.prepareStatement("update bankapp set balance = balance - ? where acc_no = ?");
						prepareStatement.setInt(1, amount);
						prepareStatement.setInt(2, sender_accno);
						int x = prepareStatement.executeUpdate();
						if (x > 0) {
							prepareStatement = connection
									.prepareStatement("update bankapp set balance = balance + ? where acc_no = ?");
							prepareStatement.setInt(1, amount);
							prepareStatement.setInt(2, reciever_accno);
							int x1 = prepareStatement.executeUpdate();
							if (x1 > 0) {
								prepareStatement = connection
										.prepareStatement("insert into  transferdata values(?,?,?,?,?,?,?,?);");
								prepareStatement.setInt(1, cust_id);
								prepareStatement.setString(2, bank_name);
								prepareStatement.setString(3, IFSC);
								prepareStatement.setInt(4, sender_accno);
								prepareStatement.setString(5, reciever_ifsc);
								prepareStatement.setInt(6, reciever_accno);
								prepareStatement.setInt(7, amount);
								Random i = new Random();
								int z = i.nextInt(900) + 100;
								prepareStatement.setInt(8, z);
								int x2 = prepareStatement.executeUpdate();
								if (x2 > 0) {
									return true;
//									
								}
								else {
									System.out.println("in insert");
								}
							}
							else {
							System.out.println("in update recieevr");
							}
							
						}
						else {
						System.out.println("in update sender");
						}
						
					}
					else {
					System.out.println("in balance");
					}
					
				}
				else {
				System.out.println("in  recieevr auth");
				}
			
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block

			e.printStackTrace();
			return false;
		}

		return false;

	}

}
