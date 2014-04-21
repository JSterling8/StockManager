package controllers;

import java.util.ArrayList;

import models.Customer;

public class CustomerController {
	public static ArrayList<Customer> customerList;
	
	public CustomerController(){
		customerList = new ArrayList<Customer>();
		
		customerList.add(new Customer("Customer 1"));
		customerList.add(new Customer("Customer 2"));
		customerList.add(new Customer("Customer 3"));
		customerList.add(new Customer("Customer 4"));
		customerList.add(new Customer("Customer 5"));
	}
	
	
}
