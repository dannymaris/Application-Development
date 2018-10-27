package com.shopping.zoho.thirdround;

public class Inventory {
	private int productId;
	private String productName;
	private double productRate;
	private int discount;
	private int productQuantity;
	public Inventory(int productId, String productName, double productRate, int discount, int productQuantity) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productRate = productRate;
		this.discount = discount;
		this.productQuantity = productQuantity;
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
	public int getProductQuantity() {
		return productQuantity;
	}
	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}
	
}
