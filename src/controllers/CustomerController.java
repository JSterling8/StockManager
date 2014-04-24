package controllers;

import java.util.ArrayList;

import models.Customer;
import models.Supplier;

public class CustomerController {
	public static ArrayList<Customer> customerList;

	public CustomerController(){
		customerList = new ArrayList<Customer>();

		customerList.add(new Customer("Customer 0", "phone0", "email0", "addr0", 0));
		customerList.add(new Customer("Customer 1", "phone1", "email1", "addr1", 0));
		customerList.add(new Customer("Customer 2", "phone2", "email2", "addr2", 0));
		customerList.add(new Customer("Customer 3", "phone3", "email3", "addr3", 0));
		customerList.add(new Customer("Customer 4", "phone4", "email4", "addr4", 0));
	}

	// TODO Add address and other info as well.
	public static String addCustomer(String name, String phone, String email, String address){
		boolean exists = false;

		// Loop through the customer list and see if the product already exists.
		for(int i = 0; i < customerList.size(); i++){
			if (customerList.get(i).toString().equalsIgnoreCase(name)){
				exists = true;
			}
		}
		// If it doesn't exist in the product list, then add it.
		if (!exists){
			long idToAdd = customerList.get(customerList.size()-1).getId() + 1;
			Customer customerToAdd = new Customer(name, phone, email, address, idToAdd);
			customerList.add(customerToAdd);
			return "Supplier added.";
		}
		else {
			return "This customer is already in the customer list";
		}
	}

	public static void removeCustomer(long id){
		for (Customer customer : customerList){
			if(customer.getId() == id){
				customerList.remove(customer);
			}
		}
	}

}
