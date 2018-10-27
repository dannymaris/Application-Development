package com.mobilephone.contacts;

import java.util.ArrayList;

public class MobilePhones {
	private String phoneNumber;
	public ArrayList<Contact> myContacts;
	public MobilePhones(String phoneNumber)
	{
		this.phoneNumber=phoneNumber;
		this.myContacts=new ArrayList<Contact>();
	}
	public boolean addNewContact(Contact contact)
	{
		if(findContact(contact.getName())>=0)
		{
			System.out.println("Contact Already Exist");
			return false;
		}
		this.myContacts.add(contact);
		return true;
	}
	public boolean updateContact(Contact oldContact,Contact newContact)
	{
		int position=findContact(oldContact);
		if(position<0)
		{
			System.out.println("Contact not found");
			return false;
		}
		this.myContacts.set(position,newContact);
		return true;
		
	}
	public boolean removeContact(Contact contact)
	{
		int position=findContact(contact);
		if(position<0)
		{
			System.out.println("not found");
			return false;
		}
		this.myContacts.remove(position);
		System.out.println("removed successfully");
		return true;
	}
	public Contact queryContact(String name)
	{
		int position=findContact(name);
		if(position<0)
		{
			System.out.println("not found");
			return null;
		}
		return this.myContacts.get(position);
	}
	public void printContacts()
	{
		System.out.println("Contact list");
		for(int i=0;i<this.myContacts.size();i++)
		{
			System.out.println((i+1)+". "+this.myContacts.get(i).getName()+" --> "+this.myContacts.get(i).getPhoneNumber());
		}
	}
	public int findContact(Contact contact)
	{
		return this.myContacts.indexOf(contact);
	}
	public int findContact(String name)
	{
		for(int i=0;i<this.myContacts.size();i++)
		{
			Contact contact=this.myContacts.get(i);
			if(contact.getName().equals(name))
			{
				return i;
			}
		}
		return -1;
	}
	
}
