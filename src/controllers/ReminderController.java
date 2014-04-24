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

	public static ArrayList<Reminder> reminderList;

	public ReminderController() {
		reminderList = new ArrayList<Reminder>(); 
		// (long id, boolean buy, boolean sell, double amountToPay, Date dueDate, Company company) {
		boolean even = true;
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

	public static void addReminder(boolean buy, boolean sell, double amountToPay, Date dueDate, Company company) {
		long idToAdd;

		if(reminderList.size() == 0) {
			idToAdd = 0;
		} else {
			idToAdd = reminderList.get(reminderList.size()-1).getId() + 1;
		}

		Reminder reminderToAdd = new Reminder(idToAdd, buy, sell, amountToPay, dueDate, company);
		reminderList.add(reminderToAdd);
	}
	
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
