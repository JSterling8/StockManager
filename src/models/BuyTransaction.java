package models;

import java.sql.Date;
import java.util.ArrayList;

public class BuyTransaction extends Transaction {

	private Supplier supplier;
	private ArrayList<Product> products;
	private ArrayList<Double> units;
	private ArrayList<Double> pricePerUnit;
	private ArrayList<Double> price;
	private double totalPrice;
	private Date date;
	private long id;
	private long stockId;
	private long reminderId;
	
	public BuyTransaction (Supplier supplier, ArrayList<Product> productList, 
			ArrayList<Double> units, ArrayList<Double> pricePerUnit, 
			ArrayList<Double> price, double totalPrice, Date date,
			long id, long stockId, long reminderId){
				this.supplier = supplier;
				this.products = productList;
				this.units = units;
				this.pricePerUnit = pricePerUnit;
				this.price = price;
				this.totalPrice = totalPrice;
				this.date = date;
				this.id = id;
				this.stockId = stockId;
				this.reminderId = reminderId;
}
	
	public long getId() {
		return id;
	}

	public Supplier getSupplier() {
		return supplier;
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

	public double getTotalPrice() {
		return totalPrice;
	}

	public Date getDate() {
		return date;
	}
	
	public long getStockId() {
		return stockId;
		}
	
	public long getReminderId() {
		return reminderId;
	}

}
