package com.mobilephone.contacts;

import java.util.Scanner;

public class Main{
	private static Scanner scan=new Scanner(System.in);
	private static MobilePhones mobilePhone=new MobilePhones("4668799");
	public static String name;
	public static String phoneNumber;
	
	public static void main(String args[])
	{
		boolean flag=false;
		printActions();
		while(!flag)
		{
			System.out.println("Enter Your Choice:");
			int action=scan.nextInt();
			scan.nextLine();
			switch(action)
			{
				case 0:
					flag=true;
					break;
				case 1:
					printContacts();
					break;
				case 2:
					addNewContact();
					break;
				case 3:
					updateNewContact();
					break;
				case 4:
					removeContact();
					break;
				case 5:
					queryContact();
					break;
				case 6:
					printActions();
					break;
			}
		}
	}
	public static void printActions()
	{
		System.out.println("\nAvailable actions:\npress");
        System.out.println("0  - to shutdown\n" +
                           "1  - to print contacts\n" +
                           "2  - to add a new contact\n" +
                           "3  - to update existing an existing contact\n" +
                           "4  - to remove an existing contact\n" +
                           "5  - query if an existing contact exists\n" +
                           "6  - to print a list of available actions.");
        System.out.println("Choose your action: ");
	}
	public static void printContacts()
	{
		mobilePhone.printContacts();
	}
	public static void addNewContact()
	{
		System.out.println("Enter The Name");
		name=scan.nextLine();
		System.out.println("Enter the phone number");	
		phoneNumber=scan.nextLine();
		Contact newContact=Contact.createContact(name, phoneNumber);
		if(mobilePhone.addNewContact(newContact))
		{
			System.out.println("Contact added sucssesfully");
		}
		else
		{
			System.out.println("failed to add contact");
		}
	}
	public static void updateNewContact()
	{
		System.out.println("Enter the existing name");
		name=scan.nextLine();
		Contact existingContact=mobilePhone.queryContact(name);
		if(existingContact==null)
		{
			System.out.println("Failed to add, contact not found");
		}
		else
		{
			System.out.println("Enter the new Name");
			name=scan.nextLine();
			System.out.println("Enter the phone number");
			phoneNumber=scan.nextLine();
			Contact newContact=Contact.createContact(name, phoneNumber);
			mobilePhone.updateContact(existingContact, newContact);
			System.out.println("Successfully done");
		}
	}
	public static void removeContact()
	{
		System.out.println("enter the name");
		name=scan.nextLine();
		Contact contact=mobilePhone.queryContact(name);
		mobilePhone.removeContact(contact);
		System.out.println("removed");
	}
	public static void queryContact()
	{
		System.out.println("Enter the name");
		name=scan.nextLine();
		Contact contact=mobilePhone.queryContact(name);
		if(contact==null)
		{
			System.out.println("Not found");
		}
		else
		{
			System.out.println("Found 1 , "+contact.getName()); 
		}
	}
}
