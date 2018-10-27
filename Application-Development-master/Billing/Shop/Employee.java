package com.Billing.Shop;

public class Employee {
	private int empId;
	private String empName;
	private String password;
	private String empRole;
	private double totalSale;
	public Employee(int empId, String empName, String password, String empRole, double totalSale) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.password = password;
		this.empRole = empRole;
		this.totalSale = totalSale;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmpRole() {
		return empRole;
	}
	public void setEmpRole(String empRole) {
		this.empRole = empRole;
	}
	public double getTotalSale() {
		return totalSale;
	}
	public void setTotalSale(double totalSale) {
		this.totalSale = totalSale;
	}
	
}
