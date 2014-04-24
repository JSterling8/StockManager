package models;

import java.sql.Date;
import java.util.ArrayList;

public class BuyTransaction extends Transaction {

	private Supplier supplier;
	private ArrayList<String> productNames;
	private ArrayList<Double> units;
	private ArrayList<Double> pricePerUnit;
	private ArrayList<Double> price;
	private double totalPrice;
	private Date date;
	private long id;
	
	public BuyTransaction (Supplier supplier, ArrayList<String> productNames, 
			ArrayList<Double> units, ArrayList<Double> pricePerUnit, 
			ArrayList<Double> price, double totalPrice, Date date,
			long id){
				this.supplier = supplier;
				this.productNames = productNames;
				this.units = units;
				this.pricePerUnit = pricePerUnit;
				this.price = price;
				this.totalPrice = totalPrice;
				this.date = date;
				this.id = id;
}
	
	public long getId() {
		
		return id;
		
	}

	public Supplier getSupplier() {
		return supplier;
	}

	public ArrayList<String> getProductNames() {
		return productNames;
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

	public double getTotalPrice() {
		return totalPrice;
	}

	public Date getDate() {
		return date;
	}
}
