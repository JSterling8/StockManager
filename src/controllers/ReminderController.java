/**
 * 
 */
package controllers;

import java.sql.Date;
import java.util.ArrayList;

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
	
}
