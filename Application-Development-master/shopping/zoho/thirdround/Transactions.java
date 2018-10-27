package com.shopping.zoho.thirdround;

public class Transactions {
	private int productId;
	private String productName;
	private double productRate;
	private int discount;
	private String Actions;
	private String userName;
	private int productQuantity;
	private double totalAmmount;
	public Transactions(int productId, String productName, double productRate, int discount, String actions,
			String userName, int productQuantity, double totalAmmount) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productRate = productRate;
		this.discount = discount;
		Actions = actions;
		this.userName = userName;
		this.productQuantity = productQuantity;
		this.totalAmmount = totalAmmount;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public double getProductRate() {
		return productRate;
	}
	public void setProductRate(double productRate) {
		this.productRate = productRate;
	}
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	public String getActions() {
		return Actions;
	}
	public void setActions(String actions) {
		Actions = actions;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getProductQuantity() {
		return productQuantity;
	}
	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}
	public double getTotalAmmount() {
		return totalAmmount;
	}
	public void setTotalAmmount(double totalAmmount) {
		this.totalAmmount = totalAmmount;
	}
	
}
