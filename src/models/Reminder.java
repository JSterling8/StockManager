package models;

import java.sql.Date;
import java.util.ArrayList;

public class Reminder {

	private boolean sell;
	private boolean buy;
	private long id;
	private double amountToPay;
	private double amountPaid;
	private Date dueDate;
	private Company company;

	public Reminder(long id, boolean buy, boolean sell, double amountToPay, Date dueDate, Company company) {
		this.company = company;
		this.id = id;
		this.buy = buy;
		this.sell = sell;
		this.amountToPay = amountToPay;
		this.dueDate = dueDate;

		this.amountPaid = 0;
	}

	public long getId() {
		return id;
	}

	/**
	 * 
	 * @return Buy for buy reminders and sell for sell reminders
	 */

	public String getBuyOrSell() {
		if(sell == true) {
			return "You need to be paid";			
		} else if(buy == true){			
			return "You need to pay";		
		} else {			
			return "Not specified reminder";			
		}	
	}

	/**
	 * This method is used to pay a supplier.
	 */
	public void pay(double amount){
		amountToPay -= amount;
	}

	/**
	 * This method is used to receive payments from customers.
	 */
	public void receive(double amount){
		amountPaid += amount;
	}

	/**
	 * @return the sell
	 */
	public boolean isSell() {
		return sell;
	}

	/**
	 * @return the buy
	 */
	public boolean isBuy() {
		return buy;
	}

	/**
	 * @return the amountToPay
	 */
	public double getAmountToPay() {
		return amountToPay;
	}

	/**
	 * @return the amountPaid
	 */
	public double getAmountPaid() {
		return amountPaid;
	}

	/**
	 * @return the dueDate
	 */
	public Date getDueDate() {
		return dueDate;
	}

	/**
	 * @return the company
	 */
	public Company getCompany() {
		return company;
	}

}
