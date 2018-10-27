package com.bank.braches;
import java.util.ArrayList;
public class Branches {
	private String name;
	private ArrayList<Customers> customer;
	
	public Branches(String name)
	{
		this.name=name;
		this.customer=new ArrayList<Customers>();
	}

	public String getName() {
		return name;
	}

	public ArrayList<Customers> getCustomer() {
		return customer;
	}
	
	public boolean addCustomer(String name,double ammount)
	{
		Customers customer=findCustomer(name);
		if(customer!=null)
		{
			this.customer.add(new Customers(name,ammount));
			return true;
		}
		return false;
		
	}
	public boolean addNewTranscation(String name,double ammount)
	{
		Customers customer=findCustomer(name);
		if(customer!=null)
		{
			customer.addTransactions(ammount);
		}
		return false;
	}
	private Customers findCustomer(String name)
	{
		for(int i=0;i<this.customer.size();i++)
		{
			Customers checkCustomer=this.customer.get(i);
			if(checkCustomer.getName().equals(name))
			{
				return checkCustomer;
			}
		}
		return null;
	}
}
