/**
 * 
 */
package controllers;

import java.sql.Date;
import java.util.ArrayList;

import views.RemindersGUI;
import models.Company;
import models.Reminder;

/**
 * @author Mindaugas
 *
 */
public class ReminderController {
	// The master reminderList for the application.
	public static ArrayList<Reminder> reminderList;

	/**
	 * This class contains the master reminderList for the application.
	 * This class is initialized in the MainGUI class.
	 */
	public ReminderController() {
		reminderList = new ArrayList<Reminder>(); 

		// This boolean is used to alternate between customer/supplier when adding to the list.
		boolean even = true;
		
		// Initialize the supplierList with 2 suppliers and 2 customers.
		for (int i = 0; i < SupplierController.supplierList.size() && i < CustomerController.customerList.size(); i++){
			Reminder reminder;
			if(even){
				reminder = new Reminder(i, true, false, 100, new Date(System.currentTimeMillis()), SupplierController.supplierList.get(i));
				even = !even;
			}
			else{
				reminder = new Reminder(i, false, true, 100, new Date(System.currentTimeMillis()), CustomerController.customerList.get(i));
				even = !even;
			}
			reminderList.add(reminder);
		}
	}

	/**
	 * Add a reminder to the reminderList
	 * 
	 * @param buy True if it is a buy reminder.  False if it is a sell reminder.
	 * @param sell True if it is a sell reminder.  False if it is a buy reminder.
	 * @param amountToPay The amount outstanding.
	 * @param dueDate The date that the payment is due.
	 * @param company The customer or supplier that is in debt or in credit, respectively.
	 */
	public static void addReminder(long idToAdd, boolean buy, boolean sell, double amountToPay, Date dueDate, Company company) {

		Reminder reminderToAdd = new Reminder(idToAdd, buy, sell, amountToPay, dueDate, company);
		reminderList.add(reminderToAdd);
	}
	
	/**
	 * Pay a supplier an amount that you owe.
	 * 
	 * @param amount The amount that the user wishes to pay the supplier.
	 * @param id The id of the reminder to be paid.
	 */
	public static void payAmountOutstanding(double amount, long id){
		for(int i = reminderList.size()-1; i >= 0 ; i--){
			if (reminderList.get(i).getId() == id){
				reminderList.get(i).pay(amount);
				if (reminderList.get(i).getAmountToPay() <= 0){
					reminderList.remove(i);
				}
				break;
			}
		}
		
		RemindersGUI.updateReminder();
	}
	
	/**
	 * Receive a payment from a customer.
	 * 
	 * @param amount The amount that the customer paid you.
	 * @param id The id of the reminder to collect on.
	 */
	public static void collectAmountOwed(double amount, long id){
		for(int i = reminderList.size()-1; i >= 0 ; i--){
			if (reminderList.get(i).getId() == id){
				reminderList.get(i).pay(amount);
				if (reminderList.get(i).getAmountToPay() <= 0){
					reminderList.remove(i);
				}
				break;
			}
		}
		
		RemindersGUI.updateReminder();
	}
}
