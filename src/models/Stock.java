package models;

public class Stock {
	
	private String productName;
	private Supplier supplier;
	private double quantity;
	private double price;
	private double rrp;
	private long id;
	
	public Stock(String productName, Supplier supplier, double quantity, double price, double rrp, long id) {
		
		this.productName = productName;
		this.supplier = supplier;
		this.quantity = quantity;
		this.price = price;
		this.rrp = rrp;
		this.id = id;
	}

	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * @return the productName
	 */
	public String getProductName() {
		return productName;
	}

	/**
	 * @return the supplier
	 */
	public Supplier getSupplier() {
		return supplier;
	}

	/**
	 * @return the quantity
	 */
	public double getQuantity() {
		return quantity;
	}
	
	public void addProduct(double amount) {
		this.quantity = quantity + amount;
	}
	
	public void removeProduct(double amount) {
		this.quantity = quantity - amount;
	}
	
	public double getRRP(){
		return rrp;
	}
	
	public long getId() {
		return id;
	}

}
