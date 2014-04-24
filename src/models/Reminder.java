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
		amountPaid = 0;
		this.dueDate = dueDate;
		
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
