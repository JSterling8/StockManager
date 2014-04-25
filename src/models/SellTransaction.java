package models;

import java.sql.Date;
import java.util.ArrayList;

public class SellTransaction extends Transaction {

	private Customer customer;
	private ArrayList<Product> products;
	private ArrayList<Double> units;
	private ArrayList<Double> pricePerUnit;
	private ArrayList<Double> price;
	private double profit;
	private Date date;
	private long id;
	
	public SellTransaction (Customer customer, ArrayList<Product> products, 
							ArrayList<Double> units, ArrayList<Double> pricePerUnit, 
							ArrayList<Double> price, double profit, Date date,
							long id){
		this.customer = customer;
		this.products = products;
		this.units = units;
		this.pricePerUnit = pricePerUnit;
		this.price = price;
		this.profit = profit;
		this.date = date;
		this.id = id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public ArrayList<Product> getProductNames() {
		return products;
	}

	public ArrayList<Double> getUnits() {
		return units;
	}

	public ArrayList<Double> getPricePerUnit() {
		return pricePerUnit;
	}

	public ArrayList<Double> getPrice() {
		return price;
	}

	public double getProfit() {
		return profit;
	}

	public Date getDate() {
		return date;
	}

	public long getId() {
		return id;
	}
	
}
