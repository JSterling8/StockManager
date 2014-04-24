package controllers;

import java.util.ArrayList;

import models.Customer;

public class CustomerController {
	public static ArrayList<Customer> customerList;				// The master ArrayList of customers used throughout the application.

	/**
	 * Initializes the customerList.
	 * This is only called from the MainGUI.
	 */
	public CustomerController(){
		customerList = new ArrayList<Customer>();

		customerList.add(new Customer("Customer 0", "phone0", "email0", "addr0", 0));
		customerList.add(new Customer("Customer 1", "phone1", "email1", "addr1", 0));
		customerList.add(new Customer("Customer 2", "phone2", "email2", "addr2", 0));
		customerList.add(new Customer("Customer 3", "phone3", "email3", "addr3", 0));
		customerList.add(new Customer("Customer 4", "phone4", "email4", "addr4", 0));
	}

	/**
	 * Adds a customer to the master customerList.
	 * 
	 * @param name The customer's name.
	 * @param phone The customer's phone number.
	 * @param email The customer's email address.
	 * @param address The customer's postal address.
	 * @return
	 */
	public static String addCustomer(String name, String phone, String email, String address){
		// A boolean variable for seeing if the customer being added already exists.
		boolean exists = false;

		// Loop through the customer list and see if the customer already exists.
		for(int i = 0; i < customerList.size(); i++){
			if (customerList.get(i).toString().equalsIgnoreCase(name)){
				exists = true;
			}
		}
		// If this person doesn't exist in the customer list, then add him/her.
		if (!exists){
			// Generate an id that is one bigger than the current largest id.
			long idToAdd = customerList.get(customerList.size()-1).getId() + 1;
			
			// Create the Customer and add it to the list.
			Customer customerToAdd = new Customer(name, phone, email, address, idToAdd);
			customerList.add(customerToAdd);
			
			// Return a success message.
			return "Supplier added.";
		}
		else {
			// Let's the user know that the customer was not added.
			return "This customer is already in the customer list";
		}
	}

	/**
	 * This method is used for removing customers from the customer list.
	 * Its complexity is O(n).
	 * 
	 * @param id The unique id of the Customer to remove.
	 */
	public static void removeCustomer(long id){
		for (Customer customer : customerList){
			if(customer.getId() == id){
				customerList.remove(customer);
			}
		}
	}

}
