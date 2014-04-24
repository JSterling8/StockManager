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
	
	public Reminder(long id, boolean buy, boolean sell, double amountToPay, Date dueDate) {
		
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
	
}
