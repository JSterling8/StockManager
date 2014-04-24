/**
 * 
 */
package controllers;

import java.sql.Date;
import java.util.ArrayList;

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
	
	public void addReminder(boolean buy, boolean sell, double amountToPay, Date dueDate) {
		
		long idToAdd = reminderList.get(reminderList.size()-1).getId() + 1;
		Reminder reminderToAdd = new Reminder(idToAdd, buy, sell, amountToPay, dueDate);
		
	}
	
}
