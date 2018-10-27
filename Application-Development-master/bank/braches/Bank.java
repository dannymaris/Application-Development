package com.bank.braches;

import java.util.ArrayList;

public class Bank {
	private String name;
	private ArrayList<Branches> branch;
	
	public Bank(String name)
	{
		this.name=name;
		this.branch=new ArrayList<Branches>();
	}
	public boolean addNewBranch(String name)
	{
		Branches branch=findBranch(name);
		if(branch==null)
		{
			this.branch.add(new Branches(name));
		}
		return false;
	}
	public boolean addNewCustomer(String branchName,String customerName,double ammount)
	{
		Branches branch=findBranch(branchName);
		if(branch!=null)
		{
			branch.addCustomer(customerName, ammount);
			return true;
		}
		return false;
	}
	public boolean addNewTransaction(String branchName,String customerName,double ammount)
	{
		Branches branch =findBranch(name);
		if(branch!=null)
		{
			branch.addNewTranscation(customerName, ammount);
			return true;
		}
		return false;
	}
	private Branches findBranch(String name)
	{
		for(int i=0;i<this.branch.size();i++)
		{
			Branches checkBranch=this.branch.get(i);
			if(checkBranch.getName().equals(name))
			{
				return checkBranch;
			}
		}
		return null;
	}
	public void listCustomers(String branchName,boolean transactions)
	{
		Branches branch=findBranch(branchName);
		if(branch!=null)
		{
			ArrayList<Customers> branchCustomer=branch.getCustomer();
			for(int i=0;i<branchCustomer.size();i++)
			{
				Customers customer=branchCustomer.get(i);
				System.out.println((i+1)+". "+customer.getName());
				if(transactions)
				{
					ArrayList<Double> transaction=customer.getTransactions();
					for(int j=0;j<transaction.size();j++)
					{
						System.out.println((j+1)+". "+transaction.get(i));
					}
				}
			}
			
		}
	}

}
