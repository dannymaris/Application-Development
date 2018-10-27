package com.employee.main;

public class Employee {
	private String empId;
	private String name;
	private int age;
	private String designation;
	private String sex;
	private String phno;
	private String mailId;
	private double salary;
	
	public Employee(String empId,String name, int age, String designation,String sex, String phno, String mailId, double salary) {
		this.empId=empId;
		this.name = name;
		this.age = age;
		this.designation=designation;
		this.sex = sex;
		this.phno = phno;
		this.mailId = mailId;
		this.salary = salary;
	}
	
	
	public String getEmpId() {
		return empId;
	}
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	public String getSex() {
		return sex;
	}
	public String getPhno() {
		return phno;
	}
	public String getMailId() {
		return mailId;
	}
	public double getSalary() {
		return salary;
	}
	
	

}
