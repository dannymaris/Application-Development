package com.shopping.zoho.thirdround;

public class Administrators {
	private String userName;
	private String userRole;
	private String password;
	private double totalSale;
	public Administrators(String userName, String userRole, String password, double totalSale) {
		super();
		this.userName = userName;
		this.userRole = userRole;
		this.password = password;
		this.totalSale = totalSale;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserRole() {
		return userRole;
	}
	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public double getTotalSale() {
		return totalSale;
	}
	public void setTotalSale(double totalSale) {
		this.totalSale = totalSale;
	}

}
