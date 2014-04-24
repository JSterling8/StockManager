package controllers;

import java.util.ArrayList;

import models.Customer;
import models.Supplier;

public class CustomerController {
	public static ArrayList<Customer> customerList;
	
	public CustomerController(){
		customerList = new ArrayList<Customer>();
		
		customerList.add(new Customer("Customer 0", 0));
		customerList.add(new Customer("Customer 1", 1));
		customerList.add(new Customer("Customer 2", 2));
		customerList.add(new Customer("Customer 3", 3));
		customerList.add(new Customer("Customer 4", 4));
	}
	
	// TODO Add address and other info as well.
		public static String addCustomer(String customerName){
			boolean exists = false;
			
			// Loop through the customer list and see if the product already exists.
			for(int i = 0; i < customerList.size(); i++){
				if (customerList.get(i).toString().equalsIgnoreCase(customerName)){
					exists = true;
				}
			}
			// If it doesn't exist in the product list, then add it.
			if (!exists){
				long idToAdd = customerList.get(customerList.size()-1).getId() + 1;
				Customer customerToAdd = new Customer(customerName, idToAdd);
				customerList.add(customerToAdd);
				return "Supplier added.";
			}
			else {
				return "This customer is already in the customer list";
			}
		}
}
